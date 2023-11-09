CREATE TABLE IF NOT EXISTS mark
(
    id         uuid PRIMARY KEY,
    value      INT,
    student_id uuid,
    subject_id uuid

);

CREATE TABLE IF NOT EXISTS student
(
    id         uuid PRIMARY KEY,
    surname    VARCHAR

);

CREATE TABLE IF NOT EXISTS subject
(
    id         uuid PRIMARY KEY,
    name       VARCHAR

);

ALTER TABLE mark
    ADD FOREIGN KEY (student_id) REFERENCES student (id) ON UPDATE CASCADE ON DELETE CASCADE,
    ADD FOREIGN KEY (subject_id) REFERENCES subject (id) ON UPDATE CASCADE ON DELETE CASCADE;


