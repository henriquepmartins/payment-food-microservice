CREATE TABLE payment
(
    id                BIGSERIAL PRIMARY KEY,
    amount            NUMERIC(19, 2) NOT NULL,
    name              VARCHAR(100),
    card_number       VARCHAR(19),
    expiration_date   VARCHAR(3),
    security_code     VARCHAR(3),
    status            VARCHAR(255)   NOT NULL,
    payment_method_id BIGINT         NOT NULL,
    order_id          BIGINT         NOT NULL
);
