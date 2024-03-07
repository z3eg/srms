INSERT INTO course
VALUES ('Web Application Scripting'),
       ('Database Management');

INSERT INTO student (FIRST_NAME, FAMILY_NAME, DATE_OF_BIRTH, EMAIL_ADDRESS)
VALUES ('John', 'Smith', '12/24/1999', 'js@google.com'),
       ('John', 'Doe', '01/07/1997', 'jdoe@yahoo.com'),
       ('John', 'Dow', '07/04/2003', 'jdow@gmail.com'),
       ('John', 'Die', '02/29/2000', 'jd@amazon.com');

INSERT INTO result (COURSE_NAME, STUDENT_NAME, SCORE)
VALUES ('Web Application Scripting', 'John Smith', 'A'),
       ('Database Management', 'John Doe', 'B'),
       ('Web Application Scripting', 'John Dow', 'C'),
       ('Database Management', 'John Smith', 'F');
