# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user_model (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  name                      varchar(255),
  is_admin                  tinyint(1) default 0,
  constraint pk_user_model primary key (id))
;

create table vote_model (
  id                        bigint auto_increment not null,
  score                     integer,
  name                      varchar(255),
  constraint pk_vote_model primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table user_model;

drop table vote_model;

SET FOREIGN_KEY_CHECKS=1;

