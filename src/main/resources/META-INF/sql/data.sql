use bookds;

insert into Authors (auth_name) values ('Albert Einstein');
insert into Authors (auth_name) values ('Antonio Goncalves');

insert into Books (bk_name, auth_id) values ('Relativity theory', (select auth_id from Authors where auth_name = 'Albert Einstein'));
insert into Books (bk_name, auth_id) values ('Begnining Java EE 7', (select auth_id from Authors where auth_name = 'Antonio Goncalves'));

insert into Users (usr_login, usr_password) values ('mic', 'pwd');