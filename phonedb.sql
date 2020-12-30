/******아이디 생성*************/
CREATE USER phonedb IDENTIFIED BY phonedb;
GRANT CONNECT,RESOURCE,DBA TO phonedb;

/******DROP******************/
DROP TABLE person;
DROP SEQUENCE seq_person_id;

/******CREATE****************/
CREATE TABLE person(
    person_id number(5),
    name varchar2(30) not null,
    hp varchar2(20),
    company varchar(20),
    primary key(person_id)
);

CREATE SEQUENCE seq_person_id
INCREMENT BY 1
START WITH 1;

-------------------------------------------------
/******INSERT****************/
INSERT INTO person
VALUES(seq_person_id.nextval,'이효리','010-1111-1111','02-1111-1111');

INSERT INTO person
VALUES(seq_person_id.nextval,'정우성','010-2222-2222','02-2222-2222');    

INSERT INTO person
VALUES(seq_person_id.nextval,'유재석','010-3333-3333','02-3333-3333');    

INSERT INTO person
VALUES(seq_person_id.nextval,'이정재','010-4444-4444','02-4444-4444');    

INSERT INTO person
VALUES(seq_person_id.nextval,'서장훈','010-5555-5555','02-5555-5555');    

ROLLBACK;
COMMIT;

/******SELECT****************/
SELECT person_id,
       name,
       hp,
       company
FROM person;

/******UPDATE****************/
UPDATE person
SET name = '유정재',
    hp = '010-9999-9999',
    company = '02-9999-9999'
WHERE person_id = 4;

ROLLBACK;
COMMIT;

/******DELETE*****************/
DELETE FROM person
WHERE person_id = 5;

ROLLBACK;
COMMIT;

/******LIKE*******************/
/******유********/
SELECT person_id,
       name,
       hp,
       company
FROM person
WHERE name like '%유%'
or hp like '%유%'
or company like '%유%';
/*****3**********/
SELECT person_id,
       name,
       hp,
       company
FROM person
WHERE name like '%3%'
or hp like '%3%'
or company like '%3%';
/****123*********/
SELECT person_id,
       name,
       hp,
       company
FROM person
WHERE name like '%123%'
or hp like '%123%'
or company like '%123%';
