create index IX_F20B43D5 on LRoT_Actuator (actuatorTypeId);
create index IX_720A3FB5 on LRoT_Actuator (companyId);
create index IX_A67F1095 on LRoT_Actuator (companyId, groupId);
create unique index IX_F4429E53 on LRoT_Actuator (companyId, groupId, endpoint, enabled);
create index IX_D281EA7B on LRoT_Actuator (companyId, groupId, status);
create unique index IX_5D4FC61C on LRoT_Actuator (endpoint);
create unique index IX_4BE42902 on LRoT_Actuator (endpoint, status);
create index IX_8D192F77 on LRoT_Actuator (groupId);
create index IX_BBF0EE66 on LRoT_Actuator (thingId);
create index IX_70D233C1 on LRoT_Actuator (uuid_);
create index IX_46479DC7 on LRoT_Actuator (uuid_, companyId);
create unique index IX_CADAEA09 on LRoT_Actuator (uuid_, groupId);

create index IX_4F503D1B on LRoT_ActuatorType (companyId);
create index IX_D0E8C5EF on LRoT_ActuatorType (companyId, groupId);
create index IX_766B4E5D on LRoT_ActuatorType (groupId);
create index IX_B5CAD427 on LRoT_ActuatorType (uuid_);
create index IX_CE72E1A1 on LRoT_ActuatorType (uuid_, companyId);
create unique index IX_D8D95C63 on LRoT_ActuatorType (uuid_, groupId);

create index IX_A99B6294 on LRoT_Sensor (companyId);
create index IX_EF0DB896 on LRoT_Sensor (companyId, groupId);
create unique index IX_B144CCB2 on LRoT_Sensor (companyId, groupId, endpoint, enabled);
create index IX_2A2D017C on LRoT_Sensor (companyId, groupId, status);
create unique index IX_B1AF4B5D on LRoT_Sensor (endpoint);
create unique index IX_44EDD43 on LRoT_Sensor (endpoint, status);
create index IX_56037E16 on LRoT_Sensor (groupId);
create index IX_98F7CA97 on LRoT_Sensor (sensorTypeId);
create index IX_84DB3D05 on LRoT_Sensor (thingId);
create index IX_52ED9E20 on LRoT_Sensor (uuid_);
create index IX_FEB25208 on LRoT_Sensor (uuid_, companyId);
create unique index IX_2737BA8A on LRoT_Sensor (uuid_, groupId);

create index IX_41C6D87A on LRoT_SensorType (companyId);
create index IX_61F18570 on LRoT_SensorType (companyId, groupId);
create index IX_E3F357C on LRoT_SensorType (groupId);
create index IX_ED5BF706 on LRoT_SensorType (uuid_);
create index IX_2DF78D62 on LRoT_SensorType (uuid_, companyId);
create unique index IX_21680464 on LRoT_SensorType (uuid_, groupId);

create index IX_35D9E03F on LRoT_SensorValue (companyId);
create index IX_51DA6B4B on LRoT_SensorValue (companyId, groupId);
create index IX_7249F587 on LRoT_SensorValue (createDate);
create index IX_648B6A81 on LRoT_SensorValue (groupId);
create index IX_47AD6D32 on LRoT_SensorValue (sensorId);
create index IX_60CBA94B on LRoT_SensorValue (uuid_);
create index IX_27062DFD on LRoT_SensorValue (uuid_, companyId);
create unique index IX_34C0FBF on LRoT_SensorValue (uuid_, groupId);

create index IX_133E8988 on LRoT_Thing (companyId);
create index IX_69952422 on LRoT_Thing (companyId, groupId);
create index IX_DD862108 on LRoT_Thing (companyId, groupId, status);
create index IX_B86BD20A on LRoT_Thing (groupId);
create index IX_F35EF4C0 on LRoT_Thing (thingGroupId);
create index IX_87825F14 on LRoT_Thing (uuid_);
create index IX_76F73094 on LRoT_Thing (uuid_, companyId);
create unique index IX_C3FACC16 on LRoT_Thing (uuid_, groupId);

create index IX_295B37D on LRoT_ThingGroup (companyId);
create index IX_59855DCD on LRoT_ThingGroup (companyId, groupId);
create index IX_3FFEF53F on LRoT_ThingGroup (groupId);
create index IX_5C7ECB89 on LRoT_ThingGroup (uuid_);
create index IX_626FD8FF on LRoT_ThingGroup (uuid_, companyId);
create unique index IX_6BC89341 on LRoT_ThingGroup (uuid_, groupId);