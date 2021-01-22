create database if not exists blog;
use blog;
create table if not exists todo
(
    id    int auto_increment
        primary key,
    text  text      not null,
    state int       not null,
    time  timestamp not null on update CURRENT_TIMESTAMP
);


