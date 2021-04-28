--liquibase formatted sql
--changeset k_nizamiev:2020-04-28-initial
--comment Таблица books


create table books (
	id bigint primary key,
	name varchar(32) not null,
	author varchar(32) not null,
	price bigint not null

);
create sequence books_seq;