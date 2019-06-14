----------------ADMIN LOGIN --------------------------
CREATE TABLE public.admin_logins
(
    admin_id character varying(50),
    admin_password character varying(50)
);

insert into admin_logins values ('test@gmail.com', 'test');


----------------ADMIN LOGIN --------------------------

----------------USER LOGIN --------------------------
CREATE TABLE public.user_logins
(
    user_id varchar(50),
    user_email varchar(50) PRIMARY KEY NOT NULL,
    user_password varchar(50) NOT NULL
);

insert into user_logins values ('person@gmail.com', 'person@gmail.com','person');

Flight Data:

insert into flight_details values('001','Air Canada','2019-06-28','11:32','2019-06-25','13:30','Victoria-YYJ','2','430','Vancouver-YVR','120'); 
insert into flight_details values('002','Air Transat','2019-06-28','11:30','2019-06-25','15:30','Victoria-YYJ','2','500','Edmonton-YEG','80'); 
insert into flight_details values('003','WestJet','2019-06-29','9:13','2019-06-26','12:30','Ottawa-YOW','2','350','Toronto-YYZ','50'); 
insert into flight_details values('004','Air Transat','2019-06-28','11:30','2019-06-26','13:30','Montreal-YUL','2','500','Ottawa-YOW','80'); 
insert into flight_details values('005','WestJet','2019-06-29','9:13','2019-06-26','12:30','Halifax-YHZ','2','350','Toronto-YYZ','50'); 
insert into flight_details values('006','Air Transat','2019-06-30','9:13','2019-06-29','12:30','Ottawa-YOW','2','350','Montreal-YUL','50'); 

