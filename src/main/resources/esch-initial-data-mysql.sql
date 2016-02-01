-- instructor
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (1,'Daphne','Jarvis','Kimberley');
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (2,'Dahlia','Rowland','Kiona');
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (3,'Melinda','Mcguire','Maggy');
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (4,'Cullen','Dillard','Yasir');
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (5,'Shoshana','Flynn','Robert');
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (6,'Barrett','Alvarez','Armando');
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (7,'Simone','Gilmore','Brenna');
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (8,'Hanae','Snider','Faith');
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (9,'Lance','Allen','Alice');
INSERT INTO instructor (id,first_name,last_name,nickname) VALUES (10,'Kamal','Yates','Kaden');

-- esch_user
INSERT INTO esch_user (id,login,password,first_name,last_name,email,registration_date,lastactivity_date,locked,instructor_id) VALUES (1,'Randall','8F4DE7CB-68B0-18D0-FCCF-ED4095835DAD','Yeo','Rowe','sed.turpis.nec@eratSednunc.org','2016-04-19','2016-10-16',0,1);
INSERT INTO esch_user (id,login,password,first_name,last_name,email,registration_date,lastactivity_date,locked,instructor_id) VALUES (2,'Maxwell','A3C66759-8DCD-4544-1DDA-FA587C582BD3','Abigail','Craig','ullamcorper.magna@Proinnislsem.edu','2016-02-06','2015-09-01',1,2);
INSERT INTO esch_user (id,login,password,first_name,last_name,email,registration_date,lastactivity_date,locked,instructor_id) VALUES (3,'Gabriel','A1D1720F-A6F2-EE59-74F8-C2101302FC84','Wynne','Simpson','cursus@pedeet.net','2016-03-06','2015-09-17',0,3);
INSERT INTO esch_user (id,login,password,first_name,last_name,email,registration_date,lastactivity_date,locked,instructor_id) VALUES (4,'Noble','AC956DC5-1655-B71F-FA86-0C679EF54CCA','Harlan','Delaney','massa.rutrum.magna@nulla.edu','2015-12-14','2015-12-28',0,4);
INSERT INTO esch_user (id,login,password,first_name,last_name,email,registration_date,lastactivity_date,locked,instructor_id) VALUES (5,'Solomon','79F2CAB0-782C-F3F0-1796-3259B5F48C5F','Gretchen','Wolf','elit.fermentum@rhoncusDonec.net','2016-01-09','2016-04-12',0,5);
INSERT INTO esch_user (id,login,password,first_name,last_name,email,registration_date,lastactivity_date,locked,instructor_id) VALUES (6,'Neil','FA7C6B1D-F86C-43E6-1D6B-458B86D4F9EF','Wynter','Thompson','arcu.Vivamus@felis.co.uk','2015-08-02','2016-08-22',1,6);

-- events
INSERT INTO event (id,name,start_date,end_date,created,esch_user_id) VALUES (1,'mollis non, cursus','2016-05-20','2016-09-22','2016-02-26',4);
INSERT INTO event (id,name,start_date,end_date,created,esch_user_id) VALUES (2,'tempor diam','2016-08-23','2016-04-11','2016-04-03',5);
INSERT INTO event (id,name,start_date,end_date,created,esch_user_id) VALUES (3,'tellus justo sit','2015-12-07','2015-10-07','2015-10-01',3);
INSERT INTO event (id,name,start_date,end_date,created,esch_user_id) VALUES (4,'scelerisque, lorem','2016-08-19','2016-08-25','2016-02-15',6);

-- event_instructors
INSERT INTO event_instructors (event_id,instructor_id) VALUES (2,1);
INSERT INTO event_instructors (event_id,instructor_id) VALUES (3,3);

-- event_configuration
INSERT INTO event_configuration (id,event_id,base_time_interval,layout) VALUES (1,1,5,'lacus');
INSERT INTO event_configuration (id,event_id,base_time_interval,layout) VALUES (2,2,5,'Sed');
INSERT INTO event_configuration (id,event_id,base_time_interval,layout) VALUES (3,3,5,'nonummy');
INSERT INTO event_configuration (id,event_id,base_time_interval,layout) VALUES (4,4,5,'leo.');

-- program_category
INSERT INTO program_category (id,name) VALUES (1,'camp');
INSERT INTO program_category (id,name) VALUES (2,'course');

-- program_block
INSERT INTO program_block (id,name,start_time,end_time,event_id,instructor_id,program_category_id) VALUES (1,'blokA','13:30','14:30',1,2,2);
INSERT INTO program_block (id,name,start_time,end_time,event_id,instructor_id,program_category_id) VALUES (2,'blokB','08:00','10:00',2,1,2);
INSERT INTO program_block (id,name,start_time,end_time,event_id,instructor_id,program_category_id) VALUES (3,'blokC','22:00','23:03',3,3,2);

-- program_day
INSERT INTO program_day (id,event_id,ordinal_number) VALUES (1,1,1);
INSERT INTO program_day (id,event_id,ordinal_number) VALUES (2,1,2);
INSERT INTO program_day (id,event_id,ordinal_number) VALUES (3,2,1);
INSERT INTO program_day (id,event_id,ordinal_number) VALUES (4,2,2);
INSERT INTO program_day (id,event_id,ordinal_number) VALUES (5,2,3);
