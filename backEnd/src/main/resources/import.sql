-- Modifications To user_type
INSERT INTO user_type (user_type) VALUES ('USER'), ('ADMIN'), ('SELLER');
-- Poner el usuario que va a conectarse a la base de datos
--REVOKE INSERT, UPDATE, DELETE ON user_type FROM 'username'@'hostname';

INSERT INTO user (email, password) VALUES ('admin@gmail.com', '1234');

INSERT INTO product_category (name) VALUES ('Vasos');
INSERT INTO product_category (name) VALUES ('Afiches');
INSERT INTO product_category (name) VALUES ('Stikers');
INSERT INTO product_category (name) VALUES ('Juegos');
INSERT INTO product_category (name) VALUES ('Muñecos');

INSERT INTO product (name, price, stock, brand, product_category_id, user_id) VALUES ('pikachu', 1000, 10, 'Pokemon', 1, 1);
INSERT INTO product (name, price, stock, brand, product_category_id, user_id) VALUES ('Volvasor', 2000, 10, 'Pokemon', 2, 1);
INSERT INTO product (name, price, stock, brand, product_category_id, user_id) VALUES ('Charizar', 3000, 10, 'Pokemon', 3, 1);

INSERT INTO user_type (user_type) VALUES ('USER');
INSERT INTO user_type (user_type) VALUES ('ADMIN');

