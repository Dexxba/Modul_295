INSERT INTO users (first_name, last_name, username, email, address, profile_picture, password, active, is_admin)
VALUES ('Daniel', 'Bogdanov', 'Dex', 'Daniel.bogdanov@example.com', 'Nobstarsse', 'profile.jpg', '$2a$10$AZ.f37dXibuWQsU.y2GpYuoPhF0TG/CP9sGoM5YgS4h.3X.YipNcS', 1, 1);
INSERT INTO users (first_name, last_name, username, email, address, profile_picture, password, active, is_admin)
VALUES ('Lilla', 'Bogdanov', 'Lillica', 'Lilla.bogdanov@example.com', 'Nobstarsse', 'profile.jpg', '$2a$10$6xH.hvIdeC1QI2dKd33QtO6SwkNdug8y7nte0ipokX4DoJlHfLlx6', 1, 0);
INSERT INTO users (first_name, last_name, username, email, address, profile_picture, password, active, is_admin)
VALUES ('Daniela', 'Bogdanov', 'dakica', 'dani.bogdanov@example.com', 'Nobstarsse', 'profile.jpg', '$2a$10$yCSGGuD4wjBFsNpX49K.9.9806LQw4JbnU1msQSdEqI6HKBtYiocK', 1, 0);
INSERT INTO users (first_name, last_name, username, email, address, profile_picture, password, active, is_admin)
VALUES ('John', 'Doe', 'Johdex', 'johndoe.doe@example.com', 'Amunisum', 'profile.jpg', '$2a$10$Fe.nM4mOmSio4owPHmmWauHqTdX8XpYk61YW/s1MkTzx0asEi0v4y', 1, 0);
INSERT INTO users (first_name, last_name, username, email, address, profile_picture, password, active, is_admin)
VALUES ('Lokir', 'Stumer', 'saki', 'lokir.doe@stumer.com', 'iponsum', 'profile.jpg', '$2a$10$jBj2zHJ4vEPjH4crBV/exu48VJZpw/sgY2c/B4LCatWtAWiQ5/eRS', 1, 0);

INSERT INTO category (active, name)
VALUES (1, 'Nintendo');
INSERT INTO category (active, name)
VALUES (1, 'Sony');
INSERT INTO category (active, name)
VALUES (1, 'Samsung');
INSERT INTO category (active, name)
VALUES (1, 'Apple');

INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (1, 'SKU12345', 1, 'Mario Party', 'mario.jpg', 'Brod Game - 4 players Max', 59.99, 100);
INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (1, 'SKU12346', 1, 'Pokemon - Sword', 'pokemon.jpg', 'RPG - 1 Player', 59.99, 50);
INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (1, 'SKU12347', 1, 'Pokemon - Shield', 'pokemon.jpg', 'RPG - 1 Player', 59.99, 50);
INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (2, 'SKU12348', 1, 'Good of War - Ragnarok', 'Good.jpg', 'RPG - 1 Player', 79.99, 200);
INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (2, 'SKU12349', 1, 'Spider-Man 2', 'Spider.jpg', 'RPG - 1 Player', 99.99, 20);
INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (3, 'SKU12350', 1, 'Samsung galaxy s23 ultra', 'Samsung.jpg', 'Mobil', 1299.99, 45);
INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (3, 'SKU12351', 1, 'Samsung galaxy s24 ultra', 'Samsung.jpg', 'Mobil', 1599.99, 25);
INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (3, 'SKU12352', 1, 'Samsung galaxy s24', 'Samsung.jpg', 'Mobil', 1050.99, 32);
INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (4, 'SKU12353', 1, 'IPhone 15 Pro Max 5G APPLE', 'IPhone.jpg', 'Mobil', 1250.99, 40);
INSERT INTO product (categoryid, sku, active, name, image, description, price, stock)
VALUES (4, 'SKU12354', 1, 'IPhone 15 Pro 5G APPLE', 'IPhone.jpg', 'Mobil', 1099.99, 100);




