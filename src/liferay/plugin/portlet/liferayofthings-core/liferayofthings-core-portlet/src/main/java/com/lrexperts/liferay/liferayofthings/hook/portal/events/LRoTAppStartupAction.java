package com.lrexperts.liferay.liferayofthings.hook.portal.events;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.manager.exception.LRoTException;
import com.lrexperts.liferay.liferayofthings.manager.util.LRoTManagerUtil;

import java.util.List;

/**
 * @author Diego A. Palmeira
 */
public class LRoTAppStartupAction extends SimpleAction {

	private static Log _log = LogFactoryUtil.getLog(LRoTAppStartupAction.class);

    @Override
    public void run(final String[] ids) throws ActionException {

		_log.info("Starting IoT Brokers");

    	LRoTManagerUtil lRoTManagerUtil = LRoTManagerUtil.getInstance();
    	
    	List<Company> companies;
		try {
			companies = CompanyLocalServiceUtil.getCompanies();

	    	for (Company company : companies) {
	            try {
					if (_log.isDebugEnabled()) {
						_log.debug("Creating channel hub for companyId: " + company.getCompanyId());
					}

	            	lRoTManagerUtil.connect(company.getCompanyId());

	            } catch (LRoTException lrot) {
					_log.error("Error connecting Broker Server", lrot);
				}
	        }

		} catch (SystemException e) {
			_log.error("Error getting companies!", e);
		}
    }
}
