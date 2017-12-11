DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS user_seq;

CREATE SEQUENCE user_seq START 100000;

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
