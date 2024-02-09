drop table if exists rule CASCADE;

drop table if exists rule_users CASCADE;

drop table if exists user CASCADE;

drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 2 increment by 1;
create table rule (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );
insert into rule (id, name) values (1,'admininstrador');
insert into rule (id, name) values (2,'comum');

create table rule_users (
       rule_id bigint not null,
        users_id bigint not null
    );

create table user (
       id bigint not null,
        active boolean,
        dt_born date,
        name varchar(255),
        password varchar(255),
        username varchar(255),
        rule_id bigint,
        primary key (id)
    );

insert into user (id, name, dt_born, password, username, rule_id) values (1,'admin', '2022-02-12', '123', 'ADMIN', 1);

alter table rule_users
       add constraint UK_cbvw4yq15glcik044yq2rsh1e unique (users_id);

       alter table rule_users
              add constraint FKlhqas75if3l0cvpm01e3vg8al
              foreign key (users_id)
              references user;


alter table rule_users
       add constraint FKfvuh8svuu4na57xbhs2j8xs5l
       foreign key (rule_id)
       references rule;

alter table user
       add constraint FKla8ptv96y8jf5ok7w48pb9gs2
       foreign key (rule_id)
       references rule;

insert into rule_users (rule_id,users_id) values (1,1);


drop table if exists maria CASCADE;

create table maria (
       id bigint not null,
        active boolean,
        dt_born date,
        nome varchar(255),
        password varchar(255),
        username varchar(255),
        rule_id bigint,
        primary key (id)
    );