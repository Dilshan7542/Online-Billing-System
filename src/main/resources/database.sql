CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL
);

CREATE TABLE customers (
                           account_no INT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL,
                           address TEXT,
                           phone VARCHAR(20),
                           units_consumed INT DEFAULT 0
);

CREATE TABLE items (
                       item_id INT AUTO_INCREMENT PRIMARY KEY,
                       item_name VARCHAR(100) NOT NULL,
                       price_per_unit DECIMAL(10, 2) NOT NULL
);

CREATE TABLE bills (
                       bill_id INT AUTO_INCREMENT PRIMARY KEY,
                       account_no INT,
                       bill_date DATE NOT NULL,
                       units_consumed INT NOT NULL,
                       amount DECIMAL(10, 2) NOT NULL,
                       FOREIGN KEY (account_no) REFERENCES customers(account_no)
);

CREATE TABLE bill_items (
                            bill_item_id INT AUTO_INCREMENT PRIMARY KEY,
                            bill_id INT,
                            item_id INT,
                            quantity INT,
                            total_price DECIMAL(10,2),
                            FOREIGN KEY (bill_id) REFERENCES bills(bill_id),
                            FOREIGN KEY (item_id) REFERENCES items(item_id)
);
