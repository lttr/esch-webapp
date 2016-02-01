DROP DATABASE IF EXISTS esch;
CREATE DATABASE IF NOT EXISTS esch;
USE esch;

DROP TABLE IF EXISTS event ;
DROP TABLE IF EXISTS event_configuration ;
DROP TABLE IF EXISTS event_instructors ;
DROP TABLE IF EXISTS instructor ;
DROP TABLE IF EXISTS program_block ;
DROP TABLE IF EXISTS program_day ;
DROP TABLE IF EXISTS program_category ;
DROP TABLE IF EXISTS esch_user ;


CREATE TABLE event (
    id           INT NOT NULL AUTO_INCREMENT ,
    name         VARCHAR (40) UNIQUE ,
    start_date   DATE ,
    end_date     DATE ,
    created      DATETIME NOT NULL ,
    esch_user_id INT ,
    PRIMARY KEY ( id )
) ENGINE=INNODB ;

CREATE TABLE event_configuration (
    id                 INT NOT NULL ,
    event_id           INT NOT NULL ,
    base_time_interval INT ,
    layout             VARCHAR (10) ,
    PRIMARY KEY ( id )
) ENGINE=INNODB ;

CREATE TABLE event_instructors (
    event_id      INT NOT NULL ,
    instructor_id INT NOT NULL ,
    PRIMARY KEY ( event_id, instructor_id )
) ENGINE=INNODB ;

CREATE TABLE instructor (
    id         INT NOT NULL ,
    first_name VARCHAR (30) ,
    last_name  VARCHAR (30) ,
    nickname   VARCHAR (30) ,
    PRIMARY KEY ( id )
) ENGINE=INNODB ;

CREATE TABLE program_block (
    id                  INT NOT NULL ,
    name                VARCHAR (30) ,
    start_time          TIME ,
    end_time            TIME ,
    event_id            INT NOT NULL ,
    instructor_id       INT ,
    program_category_id INT ,
    program_day_id      INT ,
    PRIMARY KEY ( id )
) ENGINE=INNODB ;

CREATE TABLE program_day (
    id             INT NOT NULL ,
    event_id       INT NOT NULL ,
    ordinal_number INT NOT NULL ,
    PRIMARY KEY ( id )
) ENGINE=INNODB ;

CREATE TABLE program_category (
    id   INT NOT NULL ,
    name VARCHAR (30) ,
    PRIMARY KEY ( id )
) ENGINE=INNODB ;

CREATE TABLE esch_user (
    id                INT NOT NULL ,
    login             VARCHAR (30) NOT NULL UNIQUE ,
    password          VARCHAR (50) ,
    first_name        VARCHAR (30) ,
    last_name         VARCHAR (30) ,
    email             VARCHAR (50) NOT NULL UNIQUE ,
    registration_date DATETIME ,
    lastactivity_date DATETIME ,
    locked            CHAR (1) ,
    instructor_id     INT ,
    PRIMARY KEY ( id )
) ENGINE=INNODB ;


ALTER TABLE event ADD FOREIGN KEY (esch_user_id) REFERENCES esch_user(id);
ALTER TABLE event_configuration ADD FOREIGN KEY (event_id) REFERENCES event(id);
ALTER TABLE event_instructors ADD FOREIGN KEY (event_id) REFERENCES event(id);
ALTER TABLE event_instructors ADD FOREIGN KEY (instructor_id) REFERENCES instructor(id);
ALTER TABLE program_block ADD FOREIGN KEY (instructor_id) REFERENCES instructor(id);
ALTER TABLE program_block ADD FOREIGN KEY (program_category_id) REFERENCES program_category(id);
ALTER TABLE program_block ADD FOREIGN KEY (program_day_id) REFERENCES program_day(id);
ALTER TABLE program_day ADD FOREIGN KEY (event_id) REFERENCES event(id);
ALTER TABLE esch_user ADD FOREIGN KEY (instructor_id) REFERENCES instructor(id);
