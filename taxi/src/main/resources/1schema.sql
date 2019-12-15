create table if not exists customer (
    customer_id bigint generated by default as identity,
    first_name varchar(255),
    last_name varchar(255),
    primary key (customer_id)
);
create table if not exists unicorn (
    unicorn_id bigint generated by default as identity,
    is_rented BOOLEAN DEFAULT false,
    rest_duration tinyint default 15,
    unicorn_name varchar(50),
    primary key (unicorn_id)
);
create table if not exists rental (
    rental_id bigint generated by default as identity,
    renting_date_time timestamp,
    customer_id bigint not null,
    unicorn_id bigint not null,
    primary key (rental_id));

create table if not exists returned_rental (
    rental_id bigint not null,
    renting_date_time timestamp,
    return_date_time timestamp,
    customer_id bigint not null,
    unicorn_id bigint not null,
    primary key (rental_id));

alter table rental add constraint rental_customer_id foreign key (customer_id) references customer;
alter table rental add constraint rental_unicorn_id foreign key (unicorn_id) references unicorn;
alter table returned_rental add constraint returned_rental_customer_id foreign key (customer_id) references customer;
alter table returned_rental add constraint returned_rental_unicorn_id foreign key (unicorn_id) references unicorn

