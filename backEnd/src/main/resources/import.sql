-- Modifications To user_type
INSERT INTO user_type (user_type) VALUES ('USER'), ('ADMIN'), ('SELLER');
-- Poner el usuario que va a conectarse a la base de datos
--REVOKE INSERT, UPDATE, DELETE ON user_type FROM 'username'@'hostname';

INSERT INTO image (id, url) VALUES ("uno", "https://www.pinterest.com/pin/7177618778483663");
INSERT INTO image (id, url) VALUES ("dos", "https://www.pinterest.com/pin/7177618778483663");
INSERT INTO image (id, url) VALUES ("tres", "https://www.pinterest.com/pin/7177618778483663");


INSERT INTO user (name, last_name, email, password, address) VALUES ("Jhon", "Mackenze", "jmackenze@mail.com", "1234", "Av greenDay 123");
INSERT INTO user (name, last_name, email, password, address, user_type_id) VALUES ("Joe", "Biden", "jbiden@mail.com", "1234", "Av greenDay 123", 2);

--INSERT INTO user (email, password) VALUES ('admin@gmail.com', '1234');

INSERT INTO product_category (name) VALUES ('Vasos');
INSERT INTO product_category (name) VALUES ('Afiches');
INSERT INTO product_category (name) VALUES ('Stikers');
INSERT INTO product_category (name) VALUES ('Juegos');
INSERT INTO product_category (name) VALUES ('Muñecos');

INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('pikachu', 1000, 10,'lorem ipsu', 'Pokemon', 1,"uno");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2, "dos");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3, "tres");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('pikachu', 1000, 10,'lorem ipsu', 'Pokemon', 1,"uno");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2, "dos");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3, "tres");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('pikachu', 1000, 10,'lorem ipsu', 'Pokemon', 1,"uno");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2, "dos");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3, "tres");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('pikachu', 1000, 10,'lorem ipsu', 'Pokemon', 1,"uno");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2, "dos");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3, "tres");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('pikachu', 1000, 10,'lorem ipsu', 'Pokemon', 1,"uno");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2, "dos");
INSERT INTO product (name, price, stock, description, brand, product_category_id, image_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3, "tres");


