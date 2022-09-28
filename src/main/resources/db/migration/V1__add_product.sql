CREATE TABLE product
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255),
    "desc"   VARCHAR(255),
    quantity INTEGER,
    price    DECIMAL(19, 2),
    CONSTRAINT pk_product PRIMARY KEY (id)
);
