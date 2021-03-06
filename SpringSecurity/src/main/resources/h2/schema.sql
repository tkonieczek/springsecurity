create table users (
      username VARCHAR(45) NOT NULL,
      password VARCHAR(45) NOT NULL,
      enabled TINYINT NOT NULL,
      PRIMARY KEY (username)
  );


create table authorities (
      username VARCHAR(45) NOT NULL,
      authority VARCHAR(45) NOT NULL,
      FOREIGN KEY(username) REFERENCES users(username)

  );

ALTER TABLE authorities
ADD CONSTRAINT TEST_UNIQUE UNIQUE ( username, authority )
