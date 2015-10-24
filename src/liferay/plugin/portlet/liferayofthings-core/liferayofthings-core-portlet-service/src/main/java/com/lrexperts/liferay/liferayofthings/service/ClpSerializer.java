package com.lrexperts.liferay.liferayofthings.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.lrexperts.liferay.liferayofthings.model.ActuatorClp;
import com.lrexperts.liferay.liferayofthings.model.ActuatorTypeClp;
import com.lrexperts.liferay.liferayofthings.model.SensorClp;
import com.lrexperts.liferay.liferayofthings.model.SensorTypeClp;
import com.lrexperts.liferay.liferayofthings.model.SensorValueClp;
import com.lrexperts.liferay.liferayofthings.model.ThingClp;
import com.lrexperts.liferay.liferayofthings.model.ThingGroupClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "liferayofthings-core-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "liferayofthings-core-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "liferayofthings-core-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(ActuatorClp.class.getName())) {
            return translateInputActuator(oldModel);
        }

        if (oldModelClassName.equals(ActuatorTypeClp.class.getName())) {
            return translateInputActuatorType(oldModel);
        }

        if (oldModelClassName.equals(SensorClp.class.getName())) {
            return translateInputSensor(oldModel);
        }

        if (oldModelClassName.equals(SensorTypeClp.class.getName())) {
            return translateInputSensorType(oldModel);
        }

        if (oldModelClassName.equals(SensorValueClp.class.getName())) {
            return translateInputSensorValue(oldModel);
        }

        if (oldModelClassName.equals(ThingClp.class.getName())) {
            return translateInputThing(oldModel);
        }

        if (oldModelClassName.equals(ThingGroupClp.class.getName())) {
            return translateInputThingGroup(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputActuator(BaseModel<?> oldModel) {
        ActuatorClp oldClpModel = (ActuatorClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getActuatorRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputActuatorType(BaseModel<?> oldModel) {
        ActuatorTypeClp oldClpModel = (ActuatorTypeClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getActuatorTypeRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSensor(BaseModel<?> oldModel) {
        SensorClp oldClpModel = (SensorClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSensorRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSensorType(BaseModel<?> oldModel) {
        SensorTypeClp oldClpModel = (SensorTypeClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSensorTypeRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSensorValue(BaseModel<?> oldModel) {
        SensorValueClp oldClpModel = (SensorValueClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSensorValueRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputThing(BaseModel<?> oldModel) {
        ThingClp oldClpModel = (ThingClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getThingRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputThingGroup(BaseModel<?> oldModel) {
        ThingGroupClp oldClpModel = (ThingGroupClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getThingGroupRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.lrexperts.liferay.liferayofthings.model.impl.ActuatorImpl")) {
            return translateOutputActuator(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.lrexperts.liferay.liferayofthings.model.impl.ActuatorTypeImpl")) {
            return translateOutputActuatorType(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.lrexperts.liferay.liferayofthings.model.impl.SensorImpl")) {
            return translateOutputSensor(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.lrexperts.liferay.liferayofthings.model.impl.SensorTypeImpl")) {
            return translateOutputSensorType(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.lrexperts.liferay.liferayofthings.model.impl.SensorValueImpl")) {
            return translateOutputSensorValue(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.lrexperts.liferay.liferayofthings.model.impl.ThingImpl")) {
            return translateOutputThing(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "com.lrexperts.liferay.liferayofthings.model.impl.ThingGroupImpl")) {
            return translateOutputThingGroup(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals(
                    "com.lrexperts.liferay.liferayofthings.NoSuchActuatorException")) {
            return new com.lrexperts.liferay.liferayofthings.NoSuchActuatorException();
        }

        if (className.equals(
                    "com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException")) {
            return new com.lrexperts.liferay.liferayofthings.NoSuchActuatorTypeException();
        }

        if (className.equals(
                    "com.lrexperts.liferay.liferayofthings.NoSuchSensorException")) {
            return new com.lrexperts.liferay.liferayofthings.NoSuchSensorException();
        }

        if (className.equals(
                    "com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException")) {
            return new com.lrexperts.liferay.liferayofthings.NoSuchSensorTypeException();
        }

        if (className.equals(
                    "com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException")) {
            return new com.lrexperts.liferay.liferayofthings.NoSuchSensorValueException();
        }

        if (className.equals(
                    "com.lrexperts.liferay.liferayofthings.NoSuchThingException")) {
            return new com.lrexperts.liferay.liferayofthings.NoSuchThingException();
        }

        if (className.equals(
                    "com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException")) {
            return new com.lrexperts.liferay.liferayofthings.NoSuchThingGroupException();
        }

        return throwable;
    }

    public static Object translateOutputActuator(BaseModel<?> oldModel) {
        ActuatorClp newModel = new ActuatorClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setActuatorRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputActuatorType(BaseModel<?> oldModel) {
        ActuatorTypeClp newModel = new ActuatorTypeClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setActuatorTypeRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSensor(BaseModel<?> oldModel) {
        SensorClp newModel = new SensorClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSensorRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSensorType(BaseModel<?> oldModel) {
        SensorTypeClp newModel = new SensorTypeClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSensorTypeRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSensorValue(BaseModel<?> oldModel) {
        SensorValueClp newModel = new SensorValueClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSensorValueRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputThing(BaseModel<?> oldModel) {
        ThingClp newModel = new ThingClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setThingRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputThingGroup(BaseModel<?> oldModel) {
        ThingGroupClp newModel = new ThingGroupClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setThingGroupRemoteModel(oldModel);

        return newModel;
    }
}
