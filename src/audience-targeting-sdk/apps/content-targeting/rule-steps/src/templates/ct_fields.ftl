<#assign aui = PortletJspTagLibs["/META-INF/aui.tld"] />
<#assign liferay_ui = PortletJspTagLibs["/META-INF/liferay-ui.tld"] />

<#setting number_format="computer">

<@aui["input"] cssClass="input" inlineField=true name="moreStepsThan" size="6" maxlength="6" value=moreStepsThan />
