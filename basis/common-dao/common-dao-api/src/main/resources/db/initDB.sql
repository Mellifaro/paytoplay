DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS user_update_data;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS server_serverTypes;
DROP TABLE IF EXISTS servers;
DROP TABLE IF EXISTS server_types;
DROP TABLE IF EXISTS games;

DROP SEQUENCE IF EXISTS user_update_data_seq;
DROP SEQUENCE IF EXISTS user_seq;
DROP SEQUENCE IF EXISTS server_seq;
DROP SEQUENCE IF EXISTS server_types_seq;
DROP SEQUENCE IF EXISTS game_seq;

CREATE SEQUENCE user_seq START 100;
CREATE SEQUENCE user_update_data_seq START 100;
CREATE SEQUENCE server_seq START 100;
CREATE SEQUENCE server_types_seq START 100;
CREATE SEQUENCE game_seq START 100;

CREATE TABLE users
(
  id           INTEGER PRIMARY KEY DEFAULT nextval('user_seq'),
  name         VARCHAR UNIQUE NOT NULL,
  first_name   VARCHAR NOT NULL,
  last_name    VARCHAR NOT NULL,
  phone        VARCHAR UNIQUE NOT NULL,
  email        VARCHAR UNIQUE NOT NULL,
  password     VARCHAR NOT NULL,
  created_time TIMESTAMP DEFAULT now(),
  updated_time TIMESTAMP DEFAULT now(),
  enabled_buy  BOOL DEFAULT TRUE,
  enabled_sell BOOL DEFAULT TRUE
);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE user_update_data(
  id           INTEGER PRIMARY KEY DEFAULT nextval('user_update_data_seq'),
  phone        VARCHAR,
  email        VARCHAR,
  password     VARCHAR,
  updated_time TIMESTAMP DEFAULT now(),
  user_id      INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE games
(
  id           INTEGER PRIMARY KEY DEFAULT nextval('game_seq'),
  name         VARCHAR UNIQUE NOT NULL,
  imageURL     VARCHAR,
  description  VARCHAR
);

CREATE TABLE servers
(
  id           INTEGER PRIMARY KEY DEFAULT nextval('server_seq'),
  name         VARCHAR NOT NULL,
  description  VARCHAR,
  game_id      INTEGER NOT NULL,
  FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
  CONSTRAINT server_name_gameid_idx UNIQUE (name, game_id)
);

CREATE TABLE server_types
(
  id           INTEGER PRIMARY KEY DEFAULT nextval('server_types_seq'),
  server_type         VARCHAR UNIQUE NOT NULL
);

CREATE TABLE server_serverTypes
(
  server_id         INTEGER NOT NULL,
  server_type_id    INTEGER NOT NULL,
  CONSTRAINT server_servertypeid_idx UNIQUE (server_id, server_type_id)
);


