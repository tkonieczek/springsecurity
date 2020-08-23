INSERT INTO users(username,password,enabled) VALUES ('marian','$2a$10$cJjRJjX.8dNQXks4fXPoCOqpfd345NL/S3iiViSQprpi5FkwPM6nm', true);
INSERT INTO users(username,password,enabled) VALUES ('mariola','$2a$10$VE5CRqy4yWluBg1dHF15ruZlh7rOixsje5rWB92dR1khQknBIu2q6', true);
INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$h1QhvyDUYrucItxnY0SD5OOytmHvBHkn56AQfr6YJa4nw8JErWLgu', true);


INSERT INTO authorities (username, authority) VALUES ('marian', 'USER');
INSERT INTO authorities (username, authority) VALUES ('mariola', 'USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ADMIN');
