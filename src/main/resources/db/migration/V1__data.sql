insert into homework.customers
(id, name, surname, age, phone_number)
values (1, 'Alisa', 'Poltoran', 25, '2929'),
       (2, 'Paval', 'Pavlov', 55, '1111'),
       (3, 'Ivan', 'Ivanov', 12, '2222'),
       (4, 'Grisha', 'Grishin', 16, '3333'),
       (5,'Gena', 'Privet', 88, '4444')
on conflict(id)do nothing;

insert into homework.orders
(id, date, customer_id, product_name, amount)
values (1, '2022-02-12', 1, 'Potato', 2),
       (2, '2022-01-13', 2, 'Carrot', 5),
       (3, '2022-05-01', 3, 'Banana', 10),
       (4, '2022-06-14', 4, 'Candies', 100500),
       (5, '2022-09-08', 5, 'Vine', 1)
on conflict(id)do nothing;