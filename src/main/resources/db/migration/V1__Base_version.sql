
CREATE TABLE IF NOT EXISTS public.account
(
     id      bigserial not null
         constraint account_pkey
             primary key,
     balance double precision    not null,
     type varchar(50)
 );


CREATE TABLE IF NOT EXISTS public.client
(
    id         bigserial not null
        constraint client_pkey
            primary key,
    birth_date varchar(255),
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255)
);


create table public.client_accounts
(
    client_id  bigint not null
        constraint cl_id
            references client,
    accounts_id bigint not null
        constraint ac_id
            unique
        constraint ac_cl_id
            references account
);




ALTER SEQUENCE client_id_seq RESTART 100000 INCREMENT BY 50;
ALTER SEQUENCE account_id_seq RESTART 100000 INCREMENT BY 50;


