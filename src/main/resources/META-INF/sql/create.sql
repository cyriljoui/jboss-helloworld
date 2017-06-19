use bookds;

create table if not exists  Books (
	
    bk_id INT AUTO_INCREMENT,
	bk_name VARCHAR(32) NOT NULL,
	bk_creation_date TIMESTAMP default now(),
	auth_id int not null,
    primary key (bk_id)
);

create table if not exists Authors (
	
	auth_id int auto_increment,
	auth_name varchar(32) not null,
	auth_create_date timestamp default now(),
    primary key (auth_id)
);

create table if not exists Users (
	
    usr_id int auto_increment,
    usr_login varchar(32) not null,
    usr_password varchar(32) not null,
	primary key (usr_id)
);

create table if not exists User_Books (
	usr_bk_id int auto_increment,
	usr_id int not null,
    bk_id int not null,
    primary key(usr_bk_id)
);
