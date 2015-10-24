package com.lrexperts.liferay.liferayofthings.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.lrexperts.liferay.liferayofthings.impl.iot.manager.exception.IoTException;
import com.lrexperts.liferay.liferayofthings.impl.iot.manager.util.IoTManagerUtil;

import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Diego A. Palmeira
 */
public class Activator implements BundleActivator {

	private static Log _log = LogFactoryUtil.getLog(Activator.class);

	@Override
	public void start(BundleContext context) throws Exception {
		_log.info("Bundle com.lrexperts.liferay.liferayofthings.impl starting!");

    	IoTManagerUtil ioTManagerUtil = IoTManagerUtil.getInstance();
    	
    	List<Company> companies = CompanyLocalServiceUtil.getCompanies();
    	
    	for (Company company : companies) {
            try {
            	ioTManagerUtil.connect(company.getCompanyId());

            } catch (IoTException iote) {
				_log.error("Error connecting IoT Server", iote);
			}
        }

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		_log.info("Bundle com.lrexperts.liferay.liferayofthings.impl stopping!");

		List<Company> companies = CompanyLocalServiceUtil.getCompanies();
    	
    	for (Company company : companies) {
			try {
				if (_log.isDebugEnabled()) {
					_log.debug("Destroying channel hub " + company.getCompanyId());
				}

				IoTManagerUtil ioTManagerUtil = IoTManagerUtil.getInstance();
		    	ioTManagerUtil.disconnect(company.getCompanyId());
		    	
			} catch (IoTException iote) {
				_log.error("Error disconnecting IoT Server for companyId: " + company.getCompanyId(), iote);
			}
    	}
	}

}
