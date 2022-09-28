CREATE TABLE item
(
    id         BIGINT NOT NULL,
    product_id BIGINT,
    name       VARCHAR(255),
    CONSTRAINT pk_item PRIMARY KEY (id)
);

ALTER TABLE item
    ADD CONSTRAINT FK_ITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);
