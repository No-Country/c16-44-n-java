-- Modifications To user_type
INSERT INTO user_type (user_type) VALUES ('USER'), ('ADMIN'), ('SELLER');
-- Poner el usuario que va a conectarse a la base de datos
--REVOKE INSERT, UPDATE, DELETE ON user_type FROM 'username'@'hostname';

INSERT INTO user (email, password) VALUES ('admin@gmail.com', '1234');