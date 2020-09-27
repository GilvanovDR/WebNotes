DELETE FROM notes;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO notes (subject, text)
VALUES ('',         'текст1'),
       ('subject1', 'текст2'),
       ('subject2', 'текст3'),
       ('subject3', 'текст4'),
       ('subject4', 'текст5'),
       ('subject5', 'текст6'),
       ('subject6', 'текст7'),
       ('',         'текст8'),
       ('',         'текст9');