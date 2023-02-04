create table book
(
    id bigint not null auto_increment,
    author varchar(255) not null,
    brand varchar(255) not null,
    description varchar(1000) not null,
    finishing varchar(255) not null,
    inventory integer not null,
    isbn varchar(255) not null,
    language varchar(255) not null,
    name varchar(255) not null,
    number_of_pages integer not null,
    offer decimal(38,2),
    original_title varchar(255) not null,
    price decimal(38,2) not null,
    publishing_company varchar(255) not null,
    year varchar(255) not null,
    primary key (id)
) engine=InnoDB;

create table category (
    id bigint not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine=InnoDB;

create table sub_category (
    id bigint not null auto_increment,
    name varchar(255) not null,
    primary key (id)
) engine=InnoDB;

create table book_category (
    category_id bigint,
    book_id bigint not null,
    primary key (book_id),
    foreign key (category_id) references category (id),
    foreign key (book_id) references book (id)
) engine=InnoDB;

create table book_sub_category (
    sub_category_id bigint,
    book_id bigint not null,
    primary key (book_id),
    foreign key (sub_category_id) references sub_category (id),
    foreign key (book_id) references book (id)
) engine=InnoDB;