create table if not exists users
(
    user_id   int auto_increment primary key,
    username  varchar(50)  not null,
    password  varchar(100) not null,
    device_id varchar(400) null,
    token     text         null,
    constraint username
    unique (username),
    constraint users_pk
    unique (username),
    constraint users_pk_2
    unique (device_id)
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
