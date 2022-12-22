CREATE TABLE orders
(
    code BIGINT NOT NULL AUTO_INCREMENT,
    subtotal DECIMAL(19, 2) NOT NULL,
    freightRate DECIMAL(19, 2) NOT NULL,
    totalPrice DECIMAL(19, 2) NOT NULL,
    creation_date DATETIME NOT NULL,
    confirmation_date DATETIME,
    delivered_date DATETIME,
    cancelled_date DATETIME,
    primary key (code)
) engine=InnoDB;

CREATE TABLE order_item
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    quantity INT NOT NULL,
    unit_price DECIMAL(19, 2) NOT NULL,
    total_price DECIMAL(19, 2) NOT NULL,
    rate INT,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    primary key (id),
    foreign key (order_id) references orders (code),
    foreign key (product_id) references product (id)
) engine=InnoDB