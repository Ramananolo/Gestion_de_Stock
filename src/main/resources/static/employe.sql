create database stok_manage;
\c;

-- create table employe

create table employe(
    id serial primary key,
    email varchar(100),
    password varchar(100)
);

--exemple insert 
insert into employe values(1,'hei.bonarson@gmail.com','motdepasse');
