create table category
(
    active tinyint      not null,
    id     int auto_increment
        primary key,
    name   varchar(255) not null
);

create table product
(
    active      tinyint       not null,
    categoryid  int           not null,
    price       float         not null,
    stock       int           not null,
    id          bigint auto_increment
        primary key,
    description mediumtext    not null,
    image       varchar(1000) not null,
    name        varchar(500)  not null,
    sku         varchar(100)  not null,
    constraint FK4ort9abhumpx4t2mlngljr1vi
        foreign key (categoryid) references category (id)
);

create table users
(
    active          tinyint       not null,
    id              int auto_increment
        primary key,
    is_admin        tinyint       not null,
    address         varchar(50)   not null,
    email           varchar(80)   not null,
    first_name      varchar(50)   not null,
    last_name       varchar(50)   not null,
    password        varchar(70)   not null,
    profile_picture varchar(1000) not null,
    username        varchar(50)   not null
);

