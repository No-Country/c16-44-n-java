-- Modifications To user_type
INSERT INTO user_type (id, user_type) VALUES (1, 'USER');
INSERT INTO user_type (id, user_type) VALUES (2, 'ADMIN');
INSERT INTO user_type (id, user_type) VALUES (3, 'SELLER');

INSERT INTO product_category (name) VALUES ('Manga');
INSERT INTO product_category (name) VALUES ('Indumentaria');
INSERT INTO product_category (name) VALUES ('Accesorios');
INSERT INTO product_category (name) VALUES ('Figuras');
-- Poner el usuario que va a conectarse a la base de datos
-- REVOKE INSERT, UPDATE, DELETE ON user_type FROM 'username'@'hostname';



-- INSERT INTO user (name, last_name, email, password, address) VALUES ("Jhon", "Mackenze", "jmackenze@mail.com", "1234", "Av greenDay 123");
-- INSERT INTO user (name, last_name, email, password, address, user_type_id) VALUES ('Joe', 'Biden', 'jbiden@mail.com', '1234', 'Av greenDay 123', 2);

-- INSERT INTO user (email, password) VALUES ('admin@gmail.com', '1234');




-- INSERT INTO image(url, id) VALUES ('https://res.cloudinary.com/dvckhdihm/image/upload/v1709646506/NCproducts/h767tybicr6d0dxcypfx.jpg', 'NCproducts/h767tybicr6d0dxcypfx');

-- INSERT INTO product (name, price, stock, description, brand, product_category_id, user_id, main_image_id) VALUES ('Seiya', 10, 10,'Figura Coleccionable', 'Generica', 2,1,'NCproducts/rw0bmhtr21bkyzp6hf5e');
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('pikachu', 1000, 10,'lorem ipsu', 'Pokemon', 1);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('pikachu', 1000, 10,'lorem ipsu', 'Pokemon', 1);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('pikachu', 1000, 10,'lorem ipsu', 'Pokemon', 1);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('pikachu', 1000, 10,'lorem ipsu', 'Pokemon', 1);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Volvasor', 2000, 10,'lorem ipsu', 'Pokemon', 2);
-- INSERT INTO product (name, price, stock, description, brand, product_category_id) VALUES ('Charizar', 3000, 10,'lorem ipsu', 'Pokemon', 3);


