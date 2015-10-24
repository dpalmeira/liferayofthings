package com.lrexperts.liferay.liferayofthings.portlet.fitbit.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.lrexperts.liferay.liferayofthings.portlet.fitbit.util.FitbitSyncUtil;

/**
 * @author Diego A. Palmeira
 */
public class FitbitSyncMessageListener extends BaseMessageListener {
	
	@Override
	protected void doReceive(Message message) throws Exception {

		FitbitSyncUtil.syncData();

	}

}