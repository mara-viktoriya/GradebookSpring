CREATE TABLE IF NOT EXISTS mark
(
    id         VARCHAR PRIMARY KEY,
    value      INT,
    student_id VARCHAR,
    subject_id VARCHAR
    -- FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE,
    --FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS student
(
    id         VARCHAR PRIMARY KEY,
    surname    VARCHAR
    --subject_id VARCHAR
    --FOREIGN KEY (subject_id) REFERENCES subject (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS subject
(
    id         VARCHAR PRIMARY KEY,
    name       VARCHAR
    --student_id VARCHAR,
    --mark_id    VARCHAR
    --FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE
);

ALTER TABLE mark
    ADD FOREIGN KEY (student_id) REFERENCES student (id) ON UPDATE CASCADE ON DELETE CASCADE,
    ADD FOREIGN KEY (subject_id) REFERENCES subject (id) ON UPDATE CASCADE ON DELETE CASCADE;

--ALTER TABLE student
--ADD FOREIGN KEY (subject_id) REFERENCES subject (id) ON UPDATE CASCADE ON DELETE CASCADE;

--ALTER TABLE subject
--ADD FOREIGN KEY (student_id) REFERENCES student (id) ON UPDATE CASCADE ON DELETE CASCADE,
--ADD FOREIGN KEY (mark_id) REFERENCES mark (id) ON UPDATE CASCADE ON DELETE CASCADE;

