DELETE FROM notes;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO notes (subject, text)
VALUES ('',         'текст'),
       ('subject1', 'текст1'),
       ('дом', 'текст2'),
       ('subject3', 'дом'),
       ('subject4', 'текст4'),
       ('subject5', 'дом и квартира'),
       ('subject6', 'текст6'),
       ('',         'текст7'),
       ('',         'текст8');