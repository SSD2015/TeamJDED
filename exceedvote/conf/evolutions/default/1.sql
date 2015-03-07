# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table vote_model (
  id                        integer primary key AUTOINCREMENT,
  score                     integer,
  name                      varchar(255))
;




# --- !Downs

PRAGMA foreign_keys = OFF;

drop table vote_model;

PRAGMA foreign_keys = ON;

