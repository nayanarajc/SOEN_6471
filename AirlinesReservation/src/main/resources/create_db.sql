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

// Adding the flight details to database

insert into flight_details values('001','Air Transat','2019-06-21','15:30','2019-06-21','12:30','Ottawa-YOW','3','270','Montreal-YUL','110');
insert into flight_details values('002','Air Transat','2019-06-24','13:30','2019-06-24','10:30','Montreal-YUL','3','270','Ottawa-YOW','110');
insert into flight_details values('003','Air Canada','2019-06-22','13:30','2019-06-22','09:30','Calgary-YYC','4','410','Edmonton-YEG','90');
insert into flight_details values('004','Air Canada','2019-06-25','02:30','2019-06-25','22:30','Edmonton-YEG','3','410','Calgary-YYC','90');
insert into flight_details values('005','WestJet','2019-06-24','14:00','2019-06-24','10:30','Calgary-YYC','2.30','280','Gander-YQX','70');
insert into flight_details values('006','WestJet','2019-06-26','18:00','2019-06-26','15:30','Gander-YQX','2.30','280','Calgary-YYC','70');
insert into flight_details values('007','WestJet','2019-06-23','10:00','2019-06-23','6:00','Calgary-YYC','4.00','350','Moncton-YQM','120');
insert into flight_details values('008','WestJet','2019-06-27','12:00','2019-06-27','8:00','Moncton-YQM','4.00','350','Calgary-YYC','120');
insert into flight_details values('009','Air Inuit','2019-06-23','10:00','2019-06-23','7:00','Calgary-YYC','3.00','550','Halifax-YHZ','90');
insert into flight_details values('010','Air Inuit','2019-06-27','11:00','2019-06-27','8:00','Halifax-YHZ','3.00','550','Calgary-YYC','90');
insert into flight_details values('011','Air Inuit','2019-06-22','15:00','2019-06-22','13:00','Calgary-YYC','2.00','450','Hamilton-YHM','100');
insert into flight_details values('0012','Air Inuit','2019-06-25','18:00','2019-06-25','16:00','Hamilton-YHM','2.00','450','Calgary-YYC','100');
insert into flight_details values('013','Air North','2019-06-24','19:00','2019-06-24','17:00','Calgary-YYC','2.00','250','London-YXU','120');
insert into flight_details values('014','Air North','2019-06-27','18:00','2019-06-27','16:00','London-YXU','2.00','250','Calgary-YYC','120');
insert into flight_details values('015','Air North','2019-06-24','21:30','2019-06-24','18:00','Calgary-YYC','3.30','250','Montreal-YUL','120');
insert into flight_details values('016','Air North','2019-06-26','19:30','2019-06-26','16:00','Montreal-YUL','3.30','250','Calgary-YYC','120');



