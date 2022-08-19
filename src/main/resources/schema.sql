create table if not exists users (
    id serial primary key,
    username varchar(48) unique not null,
    email varchar(96) unique not null,
    gender varchar(6) not null,
    password text not null,
    age int not null
    );