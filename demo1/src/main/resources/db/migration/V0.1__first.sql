DROP TABLE IF EXISTS shape;

CREATE TABLE shape
(
    id             SERIAL PRIMARY KEY,
    title          VARCHAR(100) NOT NULL,
    primary_dev    INTEGER
);
