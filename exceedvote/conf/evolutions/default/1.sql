# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table vote_model (
  id                        bigint auto_increment not null,
  score                     integer,
  name                      varchar(255),
  constraint pk_vote_model primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table vote_model;

SET FOREIGN_KEY_CHECKS=1;

