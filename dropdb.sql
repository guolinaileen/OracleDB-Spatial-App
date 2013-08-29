drop INDEX bd_idx;
drop INDEX pl_idx;
drop INDEX ap_idx;

delete from user_sdo_geom_metadata
where table_name='BUILDING'
;
delete from user_sdo_geom_metadata
where table_name='PEOPLE'
;
delete from user_sdo_geom_metadata
where table_name='AP'
;

drop table building; 
drop table people; 
drop table ap; 
