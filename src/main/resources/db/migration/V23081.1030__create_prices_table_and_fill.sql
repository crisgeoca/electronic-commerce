--Script to create prices table
CREATE TABLE prices
(
    id             BIGINT PRIMARY KEY auto_increment,
    brand_id       NUMERIC,
    start_date     TIMESTAMP,
    end_date       TIMESTAMP,
    price_list     NUMERIC,
    product_id     NUMERIC,
    priority       NUMERIC,
    price          NUMERIC(20, 2),
    curr           TEXT
);

-- Mock data to run tests
INSERT INTO prices VALUES (DEFAULT, 1, TIMESTAMP '2020-06-14 00.00.00', TIMESTAMP '2020-12-31 23.59.59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO prices VALUES (DEFAULT, 1, TIMESTAMP '2020-06-14 15.00.00', TIMESTAMP '2020-06-14 18.30.00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO prices VALUES (DEFAULT, 1, TIMESTAMP '2020-06-15 00.00.00', TIMESTAMP '2020-06-15 11.00.00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO prices VALUES (DEFAULT, 1, TIMESTAMP '2020-06-15 16.00.00', TIMESTAMP '2020-12-31 23.59.59', 4, 35455, 1, 38.95, 'EUR');

