-- Run this in SQL Developer with an account that has full permissions
-- to setup the magic-store user.

drop user mstore cascade;

create user mstore

identified by p4ssw0rd
default tablespace users
temporary tablespace temp
quota 10m on users;


grant connect to mstore;
grant resource to mstore;
grant create session to mstore;
grant create table to mstore;
grant create view to mstore;