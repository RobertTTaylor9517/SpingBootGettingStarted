CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE people
(
    id UUID,
    first_name VARCHAR(3000),
    last_name VARCHAR(3000),
    PRIMARY KEY (id)
);

INSERT INTO people
(
    id,
    first_name,
    last_name
)
VALUES(
    uuid_generate_v1(),
    'Robert',
    'Taylor'
);