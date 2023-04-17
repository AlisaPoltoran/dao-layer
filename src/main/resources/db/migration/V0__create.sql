create schema if not exists homework;

create table if not exists homework.customers
(
    id           SERIAL primary key,
    name         varchar(255) not null,
    surname      varchar(255) not null,
    age          int          not null,
    phone_number varchar(255) not null
);

create table if not exists homework.orders
(
    id SERIAL primary key,
    date DATE not null,
    customer_id int,
    product_name varchar(255),
    amount numeric
);

alter table homework.orders drop CONSTRAINT if exists orders_connection;

alter table homework.orders
    add constraint orders_connection foreign key (customer_id)
        references homework.customers (id);