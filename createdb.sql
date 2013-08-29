create table building
(
building_id varchar2(30) primary key,
building_name varchar2(30),
building_vertices integer, 
shape MDSYS.SDO_GEOMETRY
)
;
insert into user_sdo_geom_metadata values
(
'BUILDING', 
'SHAPE',
mdsys.sdo_dim_array
(
mdsys.sdo_dim_element('X',0,900,0.05),
mdsys.sdo_dim_element('Y',0,600,0.05)
),
NULL
)
;
create table people
(
people_id varchar2(30) primary key,
shape MDSYS.SDO_GEOMETRY
)
;
insert into user_sdo_geom_metadata values
(
'PEOPLE', 
'SHAPE',
mdsys.sdo_dim_array
(
mdsys.sdo_dim_element('X',0,900,0.05),
mdsys.sdo_dim_element('Y',0,600,0.05)
),
NULL
)
;
create table ap
(
ap_id varchar2(30) primary key,
ap_radius integer, 
shape MDSYS.SDO_GEOMETRY
)
;
insert into user_sdo_geom_metadata values
(
'AP', 
'SHAPE',
mdsys.sdo_dim_array
(
mdsys.sdo_dim_element('X',0,900,0.05),
mdsys.sdo_dim_element('Y',0,600,0.05)
),
NULL
)
;

CREATE INDEX bd_idx ON BUILDING (SHAPE)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE INDEX pl_idx ON PEOPLE (SHAPE)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE INDEX ap_idx ON AP (SHAPE)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;