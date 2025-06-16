USE jpa;
# db의 table 명과 컬럼명은 lower_snake_case
CREATE TABLE my_table1
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30),
    city    VARCHAR(30),
    address VARCHAR(30)
);
INSERT INTO my_table1
    (name, city, address)
VALUES ('kim', 'seoul', '강남'),
       ('lee', 'busan', '신촌'),
       ('park', 'jeju', '명동'),
       ('cho', 'suwon', '마포'),
       ('son', 'dokdo', '홍대');
SELECT *
FROM my_table1;


CREATE TABLE my_table2
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30),
    city    VARCHAR(30),
    address VARCHAR(30)
);
INSERT INTO my_table2 (name, city, address)
SELECT name, city, address
FROM my_table1;
SELECT *
FROM my_table2;


CREATE TABLE my_table3
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(30),
    info  VARCHAR(30),
    nick  VARCHAR(30)
);
INSERT INTO my_table3
    (email, info, nick)
VALUES ('gamil', '어쩌구 저쩌구', 'trump');
SELECT *
FROM my_table3;

ALTER TABLE my_table3
    ADD COLUMN country VARCHAR(30);

# 테이블명, 컬럼명은 lower_snake_case 관습
ALTER TABLE my_table3
    ADD COLUMN home_address VARCHAR(30);

ALTER TABLE my_table3
    ADD COLUMN work_address VARCHAR(30);

#
CREATE TABLE my_table4
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(30),
    score      DEC(10, 2),
    birth_date DATE,
    start_at   TIME,
    created_at DATETIME
);
INSERT INTO my_table4
    (name, score, birth_date, start_at, created_at)
VALUES ('trump', 33.12, '1999-09-09', '14:12:11', '1988-03-03 12:10:10');

SELECT *
FROM my_table4;

CREATE TABLE my_table5
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    address     VARCHAR(30),
    hired_date  DATE,
    inserted_at DATETIME,
    height      DEC(10, 2),
    score       INT
);
INSERT INTO my_table5
    (id)
VALUES (1);
SELECT *
FROM my_table5;

CREATE TABLE my_table6
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    city        VARCHAR(30),
    score       DEC(10, 2),
    weight      BIGINT,
    birth_date  DATE,
    started_at  TIME,
    inserted_at DATETIME
);


# 연습
# my_table7과
# 매핑되는 Entity7을 만들어 보세요.
CREATE TABLE my_table7
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(20),
    today_time DATETIME
);
INSERT INTO my_table7
    (name, today_time)
VALUES ('y', '2025-06-16 12:14:25');
SELECT *
FROM my_table7;

CREATE TABLE my_table8
(
    id          INT AUTO_INCREMENT NOT NULL,
    address     VARCHAR(255)       NULL,
    salary      DEC(10, 2)         NULL,
    inserted_at datetime           NULL,
    hire_date   date               NULL,
    CONSTRAINT pk_my_table8 PRIMARY KEY (id)
);

# 연습
# Entity9 먼저 만들고
# my_table9 만들어보기
CREATE TABLE my_table9
(
    id       INT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)       NULL,
    salary   DEC(10, 2)         NULL,
    birthday datetime           NULL,
    info     VARCHAR(255)       NULL,
    CONSTRAINT pk_my_table9 PRIMARY KEY (id)
);

CREATE TABLE my_table10
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(30),
    city       VARCHAR(30),
    birth_date DATE
);
select e1_0.id,
       e1_0.birth_date,
       e1_0.city,
       e1_0.name
from my_table10 e1_0
where e1_0.id = ?;
SELECT *
FROM my_table10
WHERE id = 1;
INSERT INTO my_table10
    (name, city, birth_date)
VALUES ('son', 'seoul', '1981-12-13');

CREATE TABLE my_table11
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    address     VARCHAR(30),
    score       DEC(10, 2),
    inserted_at DATETIME
);

CREATE TABLE my_table14
(
    id    INT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)       NULL,
    score DEC(10, 2)         NULL,
    city  VARCHAR(255)       NULL,
    CONSTRAINT pk_my_table14 PRIMARY KEY (id)
);

INSERT INTO my_table14
    (name, score, city)
VALUES ('kim', 88.8, 'seoul'),
       ('lee', 77.7, 'jeju'),
       ('park', 33.3, 'busan');

SELECT *
FROM my_table14;

CREATE TABLE my_table15
(
    id          INT AUTO_INCREMENT NOT NULL,
    address     VARCHAR(255)       NULL,
    price       INT                NULL,
    inserted_at datetime           NULL,
    CONSTRAINT pk_my_table15 PRIMARY KEY (id)
);