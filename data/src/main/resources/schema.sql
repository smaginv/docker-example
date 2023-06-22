DROP TABLE IF EXISTS persons;
DROP SEQUENCE IF EXISTS person_seq;

CREATE TABLE persons
(
    person_id  INT PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    email      VARCHAR NOT NULL UNIQUE
);
CREATE SEQUENCE person_seq INCREMENT 10 START 20;
ALTER SEQUENCE person_seq OWNED BY persons.person_id;
ALTER TABLE persons
    ALTER COLUMN person_id SET DEFAULT nextval('person_seq')