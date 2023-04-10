create schema homework

create table homework.customers
(
    id           SERIAL primary key,
    name         varchar(255) not null,
    surname      varchar(255) not null,
    age          int          not null,
    phone_number varchar(255) not null
);

insert into homework.customers
(name, surname, age, phone_number)
values ('Alisa', 'Poltoran', 25, '2929'),
       ('Paval', 'Pavlov', 55, '1111'),
       ('Ivan', 'Ivanov', 12, '2222'),
       ('Grisha', 'Grishin', 16, '3333'),
       ('Gena', 'Privet', 88, '4444');

create table homework.orders
(
    id SERIAL primary key,
    date DATE not null,
    customer_id int,
    product_name varchar(255),
    amount numeric
);

insert into homework.orders
(date, customer_id, product_name, amount)
values ('2022-02-12', 1, 'Potato', 2),
       ('2022-01-13', 2, 'Carrot', 5),
       ('2022-05-01', 3, 'Banana', 10),
       ('2022-06-14', 4, 'Candies', 100500),
       ('2022-09-08', 5, 'Vine', 1);

alter table homework.orders
    add constraint orders_connection foreign key (customer_id)
        references homework.customers (id);