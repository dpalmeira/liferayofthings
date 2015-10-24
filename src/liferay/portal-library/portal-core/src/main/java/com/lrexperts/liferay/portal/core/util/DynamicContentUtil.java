package com.lrexperts.liferay.portal.core.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portlet.journal.model.JournalArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class DynamicContentUtil.
 * 
 * @author Diego A. Palmeira
 */
public class DynamicContentUtil {

	/** The log. */
	private static Log log = LogFactoryUtil.getLog(DynamicContentUtil.class);

	/**
	 * Gets the value.
	 *
	 * @param ja the ja
	 * @param name the name
	 * @return the value
	 */
	public static final String getValue(JournalArticle ja, String name) {
		return DynamicContentUtil.getValue(ja, name, ja.getDefaultLocale());
	}

	/**
	 * Gets the value.
	 *
	 * @param ja the ja
	 * @param name the name
	 * @param locale the locale
	 * @return the value
	 */
	public static final String getValue(JournalArticle ja, String name, String locale) {
		String value = null;
		try {
			Document document = SAXReaderUtil.read(ja.getContentByLocale(locale));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='" + name + "']/dynamic-content");
			value = node.getText();
		} catch(NullPointerException nullPointerException) {
			/**
			 * Just do nothing!
			 * The element doesn't exist!
			 */
		} catch(DocumentException documentException) {
			log.error(documentException);
		}
		return value;
	}

	/**
	 * Gets the values.
	 *
	 * @param ja the ja
	 * @param name the name
	 * @return the values
	 */
	public static final List<String> getValues(JournalArticle ja, String name) {
		return DynamicContentUtil.getValues(ja, name, ja.getDefaultLocale());
	}

	/**
	 * Gets the values.
	 *
	 * @param ja the ja
	 * @param name the name
	 * @param locale the locale
	 * @return the values
	 */
	public static final List<String> getValues(JournalArticle ja, String name, String locale) {
		List<String> values = new ArrayList<String>();
		try {
			Document document = SAXReaderUtil.read(ja.getContentByLocale(locale));
			List<Node> nodes = document.selectNodes("/root/dynamic-element[@name='" + name + "']/dynamic-content");
			for(int i = 0; i < nodes.size(); i++) {
				values.add(nodes.get(i).getText());
			}
		} catch(NullPointerException nullPointerException) {
			/**
			 * Just do nothing!
			 * The elements don't exist!
			 */
		} catch(DocumentException documentException) {
			log.error(documentException);
		}
		return values;
	}
}