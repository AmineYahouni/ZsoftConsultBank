create table transaction
(
    id         bigserial           not null
        constraint transaction_pkey
            primary key,
    amount     double precision not null,
    balance    double precision not null,
    date       timestamp,
    account_id bigint
        constraint ac_id
            references account,
    state      boolean default false
);

create table client_transactions
(
    client_id       bigint not null
        constraint c_id
            references client,
    transactions_id bigint not null
        constraint t_u_id
            unique
        constraint t_id
            references transaction
);
ALTER SEQUENCE transaction_id_seq RESTART 100000 INCREMENT BY 50;
