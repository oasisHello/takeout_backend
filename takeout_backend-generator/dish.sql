-- Create table: tb_dish
CREATE TABLE tb_dish (
    id BIGINT PRIMARY KEY, -- Primary key
    name VARCHAR(32) NOT NULL, -- Dish name
    price DECIMAL(10,2) NOT NULL, -- Dish price
    image VARCHAR(255), -- Picture
    description VARCHAR(255), -- Product information
    status INT NOT NULL, -- 0: Salable, 1: Sold out
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Creating time
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- Update time
);

-- Create table: tb_dish_flavor
CREATE TABLE tb_dish_flavor (
    id BIGINT PRIMARY KEY, -- Primary key
    dish_id BIGINT NOT NULL, -- Foreign key to tb_dish
    name VARCHAR(32) NOT NULL, -- Flavor name
    value VARCHAR(255), -- Flavor value
    FOREIGN KEY (dish_id) REFERENCES tb_dish(id) ON DELETE CASCADE -- Cascade delete
);

-- Insert mock data into tb_dish
INSERT INTO tb_dish (id, name, price, image, description, status, create_time, update_time)
VALUES
(1, 'Margherita Pizza', 8.99, 'margherita.jpg', 'Classic Italian pizza with tomatoes and mozzarella', 0, NOW(), NOW()),
(2, 'Cheeseburger', 5.49, 'cheeseburger.jpg', 'Juicy burger with cheddar cheese', 0, NOW(), NOW()),
(3, 'Sushi Platter', 15.99, 'sushi.jpg', 'Assorted sushi with fresh ingredients', 1, NOW(), NOW()),
(4, 'Caesar Salad', 6.99, 'caesar_salad.jpg', 'Crispy romaine lettuce with Caesar dressing', 0, NOW(), NOW());

-- Insert mock data into tb_dish_flavor
INSERT INTO tb_dish_flavor (id, dish_id, name, value)
VALUES
(1, 1, 'Size', 'Large'),
(2, 1, 'Crust', 'Thin'),
(3, 2, 'Cheese Type', 'Cheddar'),
(4, 3, 'Soy Sauce', 'Light'),
(5, 3, 'Wasabi', 'Extra'),
(6, 4, 'Dressing', 'Low-fat');

-- Query to confirm data
SELECT * FROM tb_dish;
SELECT * FROM tb_dish_flavor;
