DROP TABLE IF EXISTS notes;
DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE notes
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    subject VARCHAR,
    text    VARCHAR                           NOT NULL UNIQUE,
    date    TIMESTAMP           DEFAULT now() NOT NULL
);
