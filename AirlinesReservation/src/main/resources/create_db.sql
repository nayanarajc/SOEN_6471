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

insert into flight_details values('AT001','Air Transat','2019-06-21','15:30','2019-06-21','12:30','Ottawa-YOW','3','270','Montreal-YUL','1','110');
insert into flight_details values('AT002','Air Transat','2019-06-24','13:30','2019-06-24','10:30','Montreal-YUL','3','270','Ottawa-YOW','1','110');
insert into flight_details values('AC003','Air Canada','2019-06-22','13:30','2019-06-22','09:30','Calgary-YYC','4','410','Edmonton-YEG','2','90');
insert into flight_details values('AC004','Air Canada','2019-06-25','02:30','2019-06-25','22:30','Edmonton-YEG','3','410','Calgary-YYC','2','90');
insert into flight_details values('WJ005','WestJet','2019-06-24','14:00','2019-06-24','10:00','Calgary-YYC','2','280','Gander-YQX','1','70');
insert into flight_details values('WJ006','WestJet','2019-06-26','18:00','2019-06-26','15:00','Gander-YQX','2','280','Calgary-YYC','1','70');
insert into flight_details values('WJ007','WestJet','2019-06-23','10:00','2019-06-23','6:00','Calgary-YYC','4','350','Moncton-YQM','1','120');
insert into flight_details values('WJ008','WestJet','2019-06-27','12:00','2019-06-27','8:00','Moncton-YQM','4','350','Calgary-YYC','1','120');
insert into flight_details values('AI009','Air Inuit','2019-06-23','10:00','2019-06-23','7:00','Calgary-YYC','3','550','Halifax-YHZ','2','90');
insert into flight_details values('AI010','Air Inuit','2019-06-27','11:00','2019-06-27','8:00','Halifax-YHZ','3','550','Calgary-YYC','2','90');
insert into flight_details values('AN011','Air Inuit','2019-06-22','15:00','2019-06-22','13:00','Calgary-YYC','2','450','Hamilton-YHM','2','100');
insert into flight_details values('AN012','Air Inuit','2019-06-25','18:00','2019-06-25','16:00','Hamilton-YHM','2','450','Calgary-YYC','2','100');
insert into flight_details values('AN013','Air North','2019-06-24','19:00','2019-06-24','17:00','Calgary-YYC','2','250','London-YXU','2','120');
insert into flight_details values('AN014','Air North','2019-06-27','18:00','2019-06-27','16:00','London-YXU','2','250','Calgary-YYC','2','120');
insert into flight_details values('AN015','Air North','2019-06-24','22:0','2019-06-24','18:00','Calgary-YYC','4','250','Montreal-YUL','2','120');
insert into flight_details values('AN016','Air North','2019-06-26','19:00','2019-06-26','16:00','Montreal-YUL','3','250','Calgary-YYC','2','120');
insert into flight_details values('AN017','Air North','2019-06-25','02:00','2019-06-24','20:00','Calgary-YYC','4','450','Ottawa-YOW','2','70');
insert into flight_details values('AN018','Air North','2019-06-27','00:00','2019-06-26','18:00','Ottawa-YOW','4','450','Calgary-YYC','2','70');
insert into flight_details values('ATI019','Air Tindi','2019-06-24','6:00','2019-06-24','4:00','Calgary-YYC','2','200','Quebec City-YQB','2','60');
insert into flight_details values('ATI020','Air Tindi','2019-06-26','8:00','2019-06-26','6:00','Quebec City-YQB','2','200','Calgary-YYC','2','60');
insert into flight_details values('AC021','Air Canada','2019-06-25','11:00','2019-06-25','7:00','Calgary-YYC','4','350','Regina-YQR','2','90');
insert into flight_details values('AC022','Air Canada','2019-06-26','14:00','2019-06-26','10:00','Regina-YQR','4','350','Calgary-YYC','2','90');
insert into flight_details values('ATI023','Air Tindi','2019-06-22','15:00','2019-06-22','10:00','Calgary-YYC','5','350','Saskatoon-YXE','2','110');
insert into flight_details values('ATI024','Air Tindi','2019-06-26','17:00','2019-06-26','12:00','Saskatoon-YXE','5','350','Calgary-YYC','2','110');
insert into flight_details values('WJ027','WestJet','2019-06-22','14:30','2019-06-22','11:00','Calgary-YYC','3','230','Toronto-YYZ','1','70');
insert into flight_details values('WJ028','WestJet','2019-06-24','18:00','2019-06-24','15:00','Toronto-YYZ','3','230','Calgary-YYC','1','70');
insert into flight_details values('WJ029','WestJet','2019-06-22','17:00','2019-06-22','12:00','Calgary-YYC','5','450','Vancouver-YVR','1','96');
insert into flight_details values('WJ030','WestJet','2019-06-24','1:00','2019-06-23','18:00','Vancouver-YVR','5','450','Calgary-YYC','1','96');
insert into flight_details values('AC031','Air Canada','2019-06-22','16:00','2019-06-22','13:00','Calgary-YYC','3','260','Victoria-YYJ','2','96');
insert into flight_details values('WJ032','WestJet','2019-06-24','18:00','2019-06-23','15:00','Victoria-YYJ','3','260','Calgary-YYC','1','96');
insert into flight_details values('WJ033','WestJet','2019-06-22','16:00','2019-06-22','13:00','Calgary-YYC','3','260','Victoria-YYJ','1','96');
insert into flight_details values('AC034','Air Canada','2019-06-24','18:00','2019-06-23','15:00','Victoria-YYJ','3','260','Calgary-YYC','2','96');
insert into flight_details values('AC035','Air Canada','2019-06-22','14:00','2019-06-22','11:00','Calgary-YYC','3','290','Winnipeg-YWG','2','96');
insert into flight_details values('WJ036','WestJet','2019-06-24','18:00','2019-06-23','15:00','Winnipeg-YWG','3','290','Calgary-YYC','1','96');
insert into flight_details values('WJ037','WestJet','2019-06-24','18:00','2019-06-23','15:00','Winnipeg-YWG','3','300','Calgary-YYC','1','85');
insert into flight_details values('WJ038','WestJet','2019-06-24','18:00','2019-06-23','15:00','Winnipeg-YWG','3','250','Calgary-YYC','1','120');
insert into flight_details values('WJ039','WestJet','2019-06-24','18:00','2019-06-23','15:00','Winnipeg-YWG','3','300','Calgary-YYC','1','68');
insert into flight_details values('WJ040','WestJet','2019-06-24','18:00','2019-06-23','15:00','Winnipeg-YWG','3','380','Calgary-YYC','1','67');
insert into flight_details values('AC041','Air Canada','2019-06-22','16:00','2019-06-22','13:00','Calgary-YYC','3','410','Victoria-YYJ','2','98');
insert into flight_details values('AC042','Air Canada','2019-06-22','16:00','2019-06-22','13:00','Calgary-YYC','3','420','Victoria-YYJ','2','120');
insert into flight_details values('WJ043','WestJet','2019-06-24','18:00','2019-06-23','15:00','Winnipeg-YWG','3','310','Calgary-YYC','1','89');
insert into flight_details values('WJ044','WestJet','2019-06-24','18:00','2019-06-23','15:00','Winnipeg-YWG','3','250','Calgary-YYC','1','88');
insert into flight_details values('ATI045','Air Tindi','2019-06-24','6:00','2019-06-24','4:00','Calgary-YYC','2','210','Quebec City-YQB','2','76');
insert into flight_details values('ATI046','Air Tindi','2019-06-24','6:00','2019-06-24','4:00','Calgary-YYC','2','200','Quebec City-YQB','2','86');
insert into flight_details values('AT047','Air Transat','2019-06-21','15:30','2019-06-21','12:30','Ottawa-YOW','3','270','Montreal-YUL','1','100');
insert into flight_details values('AT048','Air Transat','2019-06-21','15:30','2019-06-21','12:30','Ottawa-YOW','3','210','Montreal-YUL','1','90');
insert into flight_details values('AI049','Air Inuit','2019-06-23','10:00','2019-06-23','7:00','Calgary-YYC','3','650','Halifax-YHZ','2','120');
insert into flight_details values('AN050','Air North','2019-06-24','19:00','2019-06-24','17:00','Calgary-YYC','2','340','London-YXU','2','80');
insert into flight_details values('AN051','Air North','2019-06-24','19:00','2019-06-24','17:00','Calgary-YYC','2','320','London-YXU','2','89');
insert into flight_details values('AT052','Air Transat','2019-06-21','15:30','2019-06-21','12:30','Ottawa-YOW','3','370','Montreal-YUL','1','180');
insert into flight_details values('AI053','Air Inuit','2019-06-23','10:00','2019-06-23','7:00','Calgary-YYC','3','250','Halifax-YHZ','2','92');
insert into flight_details values('AN054','Air North','2019-06-24','19:00','2019-06-24','17:00','Calgary-YYC','2','220','London-YXU','2','78');
insert into flight_details values('AI055','Air Inuit','2019-06-23','10:00','2019-06-23','7:00','Calgary-YYC','3','380','Halifax-YHZ','2','68');
insert into flight_details values('AT056','Air Transat','2019-06-21','15:30','2019-06-21','12:30','Ottawa-YOW','3','280','Montreal-YUL','1','79');
---------------------- ALTER USER lOGIN AND ADMIN LOGIN TABLE -----------------------------

alter table user_logins
add column is_logged_in boolean default false;

alter table admin_logins
add column is_logged_in boolean default false;

