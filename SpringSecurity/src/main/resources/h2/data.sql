INSERT INTO users(username,password,enabled) VALUES ('marian','{noop}marian12345', true);
INSERT INTO users(username,password,enabled) VALUES ('mariola','{noop}mariola123', true);
INSERT INTO users(username,password,enabled) VALUES ('admin','{noop}admin', true);

INSERT INTO authorities (username, authority) VALUES ('marian', 'USER');
INSERT INTO authorities (username, authority) VALUES ('mariola', 'USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ADMIN');
