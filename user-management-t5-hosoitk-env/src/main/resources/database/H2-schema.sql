CREATE TABLE t_user(
    user_id varchar(128),
    username varchar(128),
    birthday date,
    address varchar(128),
    tel_num varchar(128),
    roles varchar(128),
    password varchar(128),
    status varchar(128),
    last_update date,
    constraint pk_t_user primary key (user_id)
);