CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE item
(
    id         BIGINT NOT NULL,
    product_id BIGINT,
    name       VARCHAR(255),
    CONSTRAINT pk_item PRIMARY KEY (id)
);

CREATE TABLE product
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255),
    description VARCHAR(255),
    quantity INTEGER,
    price      DECIMAL(19, 2),
    epic_id    VARCHAR(255),
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE item
    ADD CONSTRAINT FK_ITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);
