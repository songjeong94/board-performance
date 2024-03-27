create database boardserver;

create table user
(
    id         int auto_increment
        primary key,
    userId     varchar(45)  null,
    password   varchar(255) null,
    nickName   varchar(45)  null,
    isAdmin    tinyint(1)   null,
    createTime datetime     null,
    isWithDraw tinyint(1)   null,
    status     varchar(45)  null
);
