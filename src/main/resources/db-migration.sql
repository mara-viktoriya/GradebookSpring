CREATE TABLE IF NOT EXISTS mark
(
    id         INT PRIMARY KEY,
    value      INT,
    student_id INT REFERENCES student (id) ON DELETE CASCADE,
    subject_id INT REFERENCES subject (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS student
(
    id         INT PRIMARY KEY,
    surname    VARCHAR(30),
    subject_id INT REFERENCES subject (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS subject
(
    id         INT PRIMARY KEY,
    name       VARCHAR,
    student_id INT REFERENCES student (id) ON DELETE CASCADE
);
