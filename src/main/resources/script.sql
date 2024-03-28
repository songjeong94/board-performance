create database boardserver;

## create user table
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

## create category table
create table category
(
    id                int auto_increment
        primary key,
    name              varchar(45) null,
    sortStatus        varchar(45) null,
    searchCount       int         null,
    pagingStartOffset int         null
);

