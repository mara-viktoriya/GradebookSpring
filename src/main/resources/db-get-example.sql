select value from mark join subject s on mark.subject_id = s.id where student_id = (select id from student where surname = 'Nikolay') and subject_id = (select id from subject where name = 'Math');

select value, name
from mark join subject s on mark.subject_id = s.id
where student_id = (select id from student where surname = 'Nikolay');