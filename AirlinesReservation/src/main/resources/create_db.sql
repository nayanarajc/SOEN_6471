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

insert into flight_details values('001','Air Canada','2019-06-28','11:30 AM','2019-06-25','1:30 PM','Victoria-YYJ','2','430','Vancouver-YVR','120'); 

