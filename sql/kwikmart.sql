DROP SCHEMA IF EXISTS kwikmart2;

CREATE SCHEMA kwikmart2;

USE kwikmart2;

CREATE TABLE purchase_order(
    order_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    email varchar(64),
    PRIMARY KEY (order_id)
);


CREATE TABLE line_item(
    item_id INT NOT NULL AUTO_INCREMENT,
    quantity INT,
    unit_price decimal(14,4),
    description varchar(64),
    -- foreign keys
    order_id int,
    PRIMARY KEY (item_id),
    constraint fk_order_id foreign key (order_id) references purchase_order(order_id)
);