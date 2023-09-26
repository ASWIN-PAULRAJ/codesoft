DROP TABLE if exists public.course;

CREATE TABLE public.course (
	course_id int primary key,
	course_code varchar null ,
	course_title varchar NULL,
	description varchar NULL,
	capacity int4 NULL,
	schedule varchar NULL
);

INSERT INTO course (course_id,course_code,course_title,description,capacity,schedule) VALUES
	 (1,'CR01','Basic Java Programming','Learn the basics of Java Programmung Language',49,'Sept 11 to Sept 15'),
	 (2,'CR02','Advance Java','Learn the advance topics of Java Programming Language',49,'Sept 18 to Sept 30'),
	 (3,'CR03','Basic PostgreSql','Learn the topics in PostgreSql database',50,'Oct 3 to Oct 9');


DROP TABLE if exists public.student;

CREATE TABLE public.student (
	student_id int primary key,
	student_roll varchar null,
	student_name varchar NULL,
	student_pwd varchar NULL
);

INSERT INTO public.student (student_id,student_roll,student_name,student_pwd) VALUES
	 (1,'SKCT1','Aswin','Login@123'),
	 (2,'SKCT2','Avinash','Login@456'),
	 (3,'SKCT3','Kishore','Login@789');
	 
DROP TABLE if exists public.student_courses;

CREATE TABLE public.student_courses (
	reg_id int4 NOT NULL,
	studentid int4 NULL,
	courseid int4 NULL,
	CONSTRAINT student_courses_pkey PRIMARY KEY (reg_id),
	CONSTRAINT student_courses_courseid_fkey FOREIGN KEY (courseid) REFERENCES public.course(course_id),
	CONSTRAINT student_courses_studentid_fkey FOREIGN KEY (studentid) REFERENCES public.student(student_id)
);

INSERT INTO student_courses (reg_id,studentid,courseid) VALUES
	 (1,1,1),
	 (2,1,2);
