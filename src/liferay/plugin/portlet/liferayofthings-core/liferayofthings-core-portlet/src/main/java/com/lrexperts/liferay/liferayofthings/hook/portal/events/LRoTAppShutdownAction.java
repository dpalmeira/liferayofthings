package com.lrexperts.liferay.liferayofthings.hook.portal.events;

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
public class LRoTAppShutdownAction extends SimpleAction {

	private static Log _log = LogFactoryUtil.getLog(LRoTAppShutdownAction.class);

	@Override
	public void run(String[] ids) {
		
		_log.info("Stopping IoT Brokers");

		LRoTManagerUtil lRoTManagerUtil = LRoTManagerUtil.getInstance();
    	
    	List<Company> companies;
		try {
			companies = CompanyLocalServiceUtil.getCompanies();

	    	for (Company company : companies) {
	            try {
					if (_log.isDebugEnabled()) {
						_log.debug("Destroying channel hub for companyId: " + company.getCompanyId());
					}

					lRoTManagerUtil.disconnect(company.getCompanyId());

	            } catch (LRoTException lrot) {
	            	_log.error("Error disconnecting IoT Server for companyId: " + company.getCompanyId(), lrot);
				}
	        }

		} catch (SystemException e) {
			_log.error("Error getting companies!", e);
		}

	}

}
