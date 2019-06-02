----------------ADMIN LOGIN --------------------------
CREATE TABLE public.admin_logins
(
    admin_id character varying(50),
    admin_password character varying(50)
);

insert into admin_logins
values ('admin01', 'admin1111');

----------------ADMIN LOGIN --------------------------

----------------USER LOGIN --------------------------
CREATE TABLE public.user_logins
(
    user_id varchar(50),
    user_email varchar(50) PRIMARY KEY NOT NULL,
    user_password varchar(50) NOT NULL
);