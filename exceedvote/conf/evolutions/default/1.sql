# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table criteria_model (
  id                        bigint auto_increment not null,
  cri_name                  varchar(255),
  constraint pk_criteria_model primary key (id))
;

create table rate_model (
  id                        bigint auto_increment not null,
  team_name                 varchar(255),
  rate                      integer,
  constraint pk_rate_model primary key (id))
;

create table team_model (
  id                        bigint auto_increment not null,
  teamname                  varchar(255),
  teamdetail                varchar(255),
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
  user_id                   bigint,
  criteria_id               bigint,
  team_id                   bigint,
  constraint pk_vote_model primary key (id))
;

alter table vote_model add constraint fk_vote_model_user_1 foreign key (user_id) references user_model (id) on delete restrict on update restrict;
create index ix_vote_model_user_1 on vote_model (user_id);
alter table vote_model add constraint fk_vote_model_criteria_2 foreign key (criteria_id) references criteria_model (id) on delete restrict on update restrict;
create index ix_vote_model_criteria_2 on vote_model (criteria_id);
alter table vote_model add constraint fk_vote_model_team_3 foreign key (team_id) references team_model (id) on delete restrict on update restrict;
create index ix_vote_model_team_3 on vote_model (team_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table criteria_model;

drop table rate_model;

drop table team_model;

drop table user_model;

drop table vote_model;

SET FOREIGN_KEY_CHECKS=1;

