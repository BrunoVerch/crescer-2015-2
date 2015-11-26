/*
drop table authorities;
drop table users;
*/

CREATE TABLE users
  (
     username VARCHAR2(100) PRIMARY KEY,
     password VARCHAR2(32) NOT NULL,
     enabled  NUMBER(1) NOT NULL
  );

CREATE TABLE authorities
  (
     username  VARCHAR2(100) NOT NULL,
     authority VARCHAR2(30) NOT NULL,
     CONSTRAINT pk_authorities PRIMARY KEY (username, authority),
     CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(
     username)
  );

INSERT INTO users
            (username,
             password,
             enabled)
VALUES      ('user',
             'ee11cbb19052e40b07aac0ca060c23ee',
             1);

INSERT INTO authorities
            (username,
             authority)
VALUES      ('user',
             'ROLE_USER');

INSERT INTO users
            (username,
             password,
             enabled)
VALUES      ('admin',
             '21232f297a57a5a743894a0e4a801fc3',
             1);

INSERT INTO authorities
            (username,
             authority)
VALUES      ('admin',
             'ROLE_ADMIN');

COMMIT;
