<<<<<<< HEAD
# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups


create table team_model (
  id                        integer auto_increment not null,
  teamname                  varchar(255),
  teamdescription           varchar(255),
  pic                       varchar(255),
  constraint pk_team_model primary key (id))
;

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

drop table team_model;

drop table user_model;

drop table vote_model;

SET FOREIGN_KEY_CHECKS=1;

=======
# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table team_model (
  id                        integer auto_increment not null,
  teamname                  varchar(255),
  teamdescription           varchar(255),
  pic                       varchar(255),
  constraint pk_team_model primary key (id))
;

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

drop table team_model;

drop table user_model;

drop table vote_model;

SET FOREIGN_KEY_CHECKS=1;

>>>>>>> 6f097164d12c12c433b86d8ed60632dd6f15330b
