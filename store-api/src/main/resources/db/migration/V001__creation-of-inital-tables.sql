create table user
(
    id       bigint not null auto_increment,
    email    varchar(255),
    name     varchar(255),
    password varchar(255),
    primary key (id)
) engine=InnoDB;

create table address
(
    id           bigint not null auto_increment,
    cep          varchar(255),
    city         varchar(255),
    complement   varchar(255),
    neighborhood varchar(255),
    number       varchar(255),
    state        varchar(255),
    street       varchar(255),
    user_id      bigint not null,
    primary key (id),
    foreign key (user_id) references user (id)
) engine=InnoDB;

create table department
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine=InnoDB;

create table product
(
    id           bigint not null auto_increment,
    brand        varchar(255),
    category     varchar(255),
    description  varchar(255),
    inventory    integer,
    name         varchar(255),
    offer        decimal(19, 2),
    price        decimal(19, 2),
    product_type varchar(255),
    primary key (id)
) engine=InnoDB;

create table product_department
(
    department_id bigint,
    product_id    bigint not null,
    primary key (product_id),
    foreign key (department_id) references department (id),
    foreign key (product_id) references product (id)
) engine=InnoDB;