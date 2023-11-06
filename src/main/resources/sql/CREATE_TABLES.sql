

create table disc (
disc_id integer not null 
, colour varchar(255) 
, disc_type varchar(255) 
, fade integer not null
, glide integer not null
, manufacturer varchar(255)
, name varchar(255)
, speed integer not null
, turn integer not null 
, primary key (disc_id)
);

create table profile (
id integer not null
, email varchar(255)
, name varchar(255)
, password varchar(255)
, phone integer not null
, primary key (id)
);
create sequence disc_seq start with 1 increment by 5;
create sequence profile_seq start with 1 increment by 5;


insert into disc (
colour
,disc_type
,fade
,glide
,manufacturer
,name
,speed
,turn
,disc_id
) 
values (?,?,?,?,?,?,?,?,nextval('disc_seq'));


insert into disc (
colour
,disc_type
,fade
,glide
,manufacturer
,name
,speed
,turn
,disc_id
) 
values (?,?,?,?,?,?,?,?,nextval('disc_seq'));


insert into disc (
colour
,disc_type
,fade
,glide
,manufacturer
,name
,speed
,turn
,disc_id
) 
values (?,?,?,?,?,?,?,?,nextval('disc_seq'));


insert into disc (
colour
,disc_type
,fade
,glide
,manufacturer
,name
,speed
,turn
,disc_id
) 
values (?,?,?,?,?,?,?,?,nextval('disc_seq'));


insert into disc (
colour
,disc_type
,fade
,glide
,manufacturer
,name
,speed
,turn
,disc_id
) 
values (?,?,?,?,?,?,?,?,nextval('disc_seq'));



insert into profile (
email
,name
,password
,phone
,id
) 
values (?,?,?,?,nextval('profile_seq'));