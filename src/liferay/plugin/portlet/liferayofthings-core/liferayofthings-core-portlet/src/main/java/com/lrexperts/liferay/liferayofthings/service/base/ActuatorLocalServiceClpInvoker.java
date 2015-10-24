package com.lrexperts.liferay.liferayofthings.service.base;

import com.lrexperts.liferay.liferayofthings.service.ActuatorLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActuatorLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName74;
    private String[] _methodParameterTypes74;
    private String _methodName75;
    private String[] _methodParameterTypes75;
    private String _methodName80;
    private String[] _methodParameterTypes80;
    private String _methodName81;
    private String[] _methodParameterTypes81;
    private String _methodName82;
    private String[] _methodParameterTypes82;
    private String _methodName83;
    private String[] _methodParameterTypes83;
    private String _methodName84;
    private String[] _methodParameterTypes84;
    private String _methodName85;
    private String[] _methodParameterTypes85;

    public ActuatorLocalServiceClpInvoker() {
        _methodName0 = "addActuator";

        _methodParameterTypes0 = new String[] {
                "com.lrexperts.liferay.liferayofthings.model.Actuator"
            };

        _methodName1 = "createActuator";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteActuator";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteActuator";

        _methodParameterTypes3 = new String[] {
                "com.lrexperts.liferay.liferayofthings.model.Actuator"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchActuator";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "fetchActuatorByUuidAndCompanyId";

        _methodParameterTypes11 = new String[] { "java.lang.String", "long" };

        _methodName12 = "fetchActuatorByUuidAndGroupId";

        _methodParameterTypes12 = new String[] { "java.lang.String", "long" };

        _methodName13 = "getActuator";

        _methodParameterTypes13 = new String[] { "long" };

        _methodName14 = "getPersistedModel";

        _methodParameterTypes14 = new String[] { "java.io.Serializable" };

        _methodName15 = "getActuatorByUuidAndCompanyId";

        _methodParameterTypes15 = new String[] { "java.lang.String", "long" };

        _methodName16 = "getActuatorByUuidAndGroupId";

        _methodParameterTypes16 = new String[] { "java.lang.String", "long" };

        _methodName17 = "getActuators";

        _methodParameterTypes17 = new String[] { "int", "int" };

        _methodName18 = "getActuatorsCount";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "updateActuator";

        _methodParameterTypes19 = new String[] {
                "com.lrexperts.liferay.liferayofthings.model.Actuator"
            };

        _methodName74 = "getBeanIdentifier";

        _methodParameterTypes74 = new String[] {  };

        _methodName75 = "setBeanIdentifier";

        _methodParameterTypes75 = new String[] { "java.lang.String" };

        _methodName80 = "getActuatorsCount";

        _methodParameterTypes80 = new String[] { "long" };

        _methodName81 = "getActuators";

        _methodParameterTypes81 = new String[] { "long" };

        _methodName82 = "getActuators";

        _methodParameterTypes82 = new String[] { "long", "int", "int" };

        _methodName83 = "getActuatorByEndpoint";

        _methodParameterTypes83 = new String[] { "java.lang.String" };

        _methodName84 = "addActuator";

        _methodParameterTypes84 = new String[] {
                "long", "long", "java.util.Map", "java.util.Map",
                "java.lang.String", "boolean", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName85 = "updateActuator";

        _methodParameterTypes85 = new String[] {
                "long", "long", "java.util.Map", "java.util.Map",
                "java.lang.String", "boolean", "int",
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return ActuatorLocalServiceUtil.addActuator((com.lrexperts.liferay.liferayofthings.model.Actuator) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return ActuatorLocalServiceUtil.createActuator(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return ActuatorLocalServiceUtil.deleteActuator(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return ActuatorLocalServiceUtil.deleteActuator((com.lrexperts.liferay.liferayofthings.model.Actuator) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return ActuatorLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return ActuatorLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return ActuatorLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return ActuatorLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return ActuatorLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return ActuatorLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return ActuatorLocalServiceUtil.fetchActuator(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return ActuatorLocalServiceUtil.fetchActuatorByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return ActuatorLocalServiceUtil.fetchActuatorByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return ActuatorLocalServiceUtil.getActuator(((Long) arguments[0]).longValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return ActuatorLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return ActuatorLocalServiceUtil.getActuatorByUuidAndCompanyId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            return ActuatorLocalServiceUtil.getActuatorByUuidAndGroupId((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue());
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            return ActuatorLocalServiceUtil.getActuators(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return ActuatorLocalServiceUtil.getActuatorsCount();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            return ActuatorLocalServiceUtil.updateActuator((com.lrexperts.liferay.liferayofthings.model.Actuator) arguments[0]);
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return ActuatorLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            ActuatorLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            return ActuatorLocalServiceUtil.getActuatorsCount(((Long) arguments[0]).longValue());
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            return ActuatorLocalServiceUtil.getActuators(((Long) arguments[0]).longValue());
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return ActuatorLocalServiceUtil.getActuators(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return ActuatorLocalServiceUtil.getActuatorByEndpoint((java.lang.String) arguments[0]);
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return ActuatorLocalServiceUtil.addActuator(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[2],
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[3],
                (java.lang.String) arguments[4],
                ((Boolean) arguments[5]).booleanValue(),
                ((Integer) arguments[6]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[7]);
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return ActuatorLocalServiceUtil.updateActuator(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[2],
                (java.util.Map<java.util.Locale, java.lang.String>) arguments[3],
                (java.lang.String) arguments[4],
                ((Boolean) arguments[5]).booleanValue(),
                ((Integer) arguments[6]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[7]);
        }

        throw new UnsupportedOperationException();
    }
}
