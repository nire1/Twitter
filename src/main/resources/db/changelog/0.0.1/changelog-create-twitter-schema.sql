--liquibase formatted sql

--changeset DenisTsai:create-twitter-schema
--comment create new schema
create schema twitter;
--rollback drop schema twitter;

