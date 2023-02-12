CREATE TABLE demo_table
(
    id        bigint NOT NULL,
    name      varchar(128),
    full_name varchar(256)
);

CREATE TABLE user_table
(
    id         bigint       NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name  varchar(255) NOT NULL,
    age        integer      NOT NULL,
    login      varchar(255) NOT NULL,
    password   varchar(255) NOT NULL
);