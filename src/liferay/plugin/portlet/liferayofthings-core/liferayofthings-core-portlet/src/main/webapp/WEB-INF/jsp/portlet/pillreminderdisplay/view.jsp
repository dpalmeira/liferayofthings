<%@ include file="/WEB-INF/jsp/portlet/pillreminderdisplay/init.jsp"%>

<c:choose>
	<c:when test="<%= Validator.isNull(sensorEndpoint) %>">
		<div class="alert alert-info portlet-configuration">
			<a href="<%= portletDisplay.getURLConfiguration() %>" onClick="<%= portletDisplay.getURLConfigurationJS() %>">
				<liferay-ui:message key="pillreminderdisplay.please-configure-this-portlet-to-select-the-sensor-topic-to-show" />
			</a>
		</div>
	</c:when>
	<c:otherwise>
		<%
		List<SensorValue> sensorValueList = (List<SensorValue>)renderRequest.getAttribute(LRoTWebKeys.LROT_THING_PILL_TAKEN_GRAPH_DATA);
		%>
		<script>
			var chartData = [];
			
			<% for (SensorValue sensorValue : sensorValueList) { %>
				chartData.push({
				          date: new Date ('<%=sensorValue.getCreateDate()%>'),
				          value: 1
				});					
			<% } %>
		
			var chart = AmCharts.makeChart("chartdiv", {
			    "type": "serial",
			    "theme": "light",
			    "marginRight": 80,
			    "dataProvider": chartData,
			    "valueAxes": [{
			    "position": "left",
			    "title": "Pill Taken"
			    }],
			    "graphs": [{
			        "id": "g1",
			        "fillAlphas": 0.9,
			        "lineAlpha": 0.2,
			        "type": "column",
			        "valueField": "value",
			        "balloonText": "<div style='margin:5px; font-size:19px;'>Date: <b>[[value]]</b></div>"
			    }],
			    "chartScrollbar": {
			        "graph": "g1",
			        "scrollbarHeight": 80,
			        "backgroundAlpha": 0,
			        "selectedBackgroundAlpha": 0.1,
			        "selectedBackgroundColor": "#888888",
			        "graphFillAlpha": 0,
			        "graphLineAlpha": 0.5,
			        "selectedGraphFillAlpha": 0,
			        "selectedGraphLineAlpha": 1,
			        "autoGridCount": true,
			        "color": "#AAAAAA"
			    },
			    "chartCursor": {
			        "categoryBalloonDateFormat": "JJ:NN, DD MMMM",
			        "cursorPosition": "mouse"
			    },
			    "categoryField": "date",
			    "categoryAxis": {
			        "minPeriod": "mm",
			        "parseDates": true
			    },
			    "export": {
			        "enabled": true
			    }
			});
	
			chart.addListener("dataUpdated", zoomChart);
			// when we apply theme, the dataUpdated event is fired even before we add listener, so
			// we need to call zoomChart here
			zoomChart();
			// this method is called when chart is first inited as we listen for "dataUpdated" event
			function zoomChart() {
			    // different zoom methods can be used - zoomToIndexes, zoomToDates, zoomToCategoryValues
			    chart.zoomToIndexes(chartData.length - 50, chartData.length - 1);
			}
		</script>

		<div id="chartdiv"></div>

	</c:otherwise>
</c:choose>
	