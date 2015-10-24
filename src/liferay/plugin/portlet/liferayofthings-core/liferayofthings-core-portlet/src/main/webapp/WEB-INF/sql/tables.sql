create table LRoT_Actuator (
	uuid_ VARCHAR(75) null,
	actuatorId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	thingId LONG,
	actuatorTypeId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	endpoint VARCHAR(255) null,
	enabled BOOLEAN,
	status INTEGER
);

create table LRoT_ActuatorType (
	uuid_ VARCHAR(75) null,
	actuatorTypeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	icon VARCHAR(75) null
);

create table LRoT_Sensor (
	uuid_ VARCHAR(75) null,
	sensorId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	thingId LONG,
	sensorTypeId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	endpoint VARCHAR(255) null,
	enabled BOOLEAN,
	status INTEGER
);

create table LRoT_SensorType (
	uuid_ VARCHAR(75) null,
	sensorTypeId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	icon VARCHAR(75) null
);

create table LRoT_SensorValue (
	uuid_ VARCHAR(75) null,
	sensorValueId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	sensorId LONG,
	value VARCHAR(75) null,
	createDate DATE null
);

create table LRoT_Thing (
	uuid_ VARCHAR(75) null,
	thingId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	thingGroupId LONG,
	name STRING null,
	description STRING null,
	endpoint VARCHAR(255) null,
	enabled BOOLEAN,
	status INTEGER
);

create table LRoT_ThingGroup (
	uuid_ VARCHAR(75) null,
	thingGroupId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	description STRING null,
	enabled BOOLEAN
);