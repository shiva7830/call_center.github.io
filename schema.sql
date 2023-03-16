CREATE DATABASE IF NOT EXISTS CallCenterDb;
USE CallCenterDb ;

CREATE TABLE CallCenter (
 id bigint NOT NULL AUTO_INCREMENT,
 from_number VARCHAR(10) NOT NULL,
 start_time datetime NOT NULL,
 end_time datetime NOT NULL,
 duration bigint NOT NULL,
 PRIMARY KEY (id));