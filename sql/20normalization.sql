USE mydatabase;

# NORMALIZATION : 정규화(형)

# FIRST NORMAL FORM (1NF) : 제 1정규화(형)
# SECOND NORMAL FORM (2NF) : 2정규화
# THIRD NORMAL FORM (3NF) : 3정규형

# 1NF
# 모든 레코드가 유일해야하고
#   -> PRIMARY KEY(NOT NULL UNIQUE)컬럼이 적어도 하나 이상 있어야 함.
# 모든 데이터는 atomic(원자적) 해야한다.

CREATE TABLE table25
(
    name  VARCHAR(10),
    phone VARCHAR(200)
);
INSERT INTO table25
    (name, phone)
VALUES ('son', '01099998888');
INSERT INTO table25
    (name, phone)
VALUES ('lee', '01099997777, 01088886666'); # 얜 원자적이지 않음
SELECT *
FROM table25;
CREATE TABLE table26
(
    name   VARCHAR(10),
    phone1 VARCHAR(11),
    phone2 VARCHAR(11)
);
INSERT INTO table26
    (name, phone1)
VALUES ('son', '01099998888');
INSERT INTO table26
    (name, phone1, phone2)
VALUES ('son', '01088887777', '01011112222'); # 얘도 원자적이라고 할 수 없음
SELECT *
FROM table26;

ALTER TABLE table26
    ADD COLUMN address VARCHAR(10) AFTER name;

UPDATE table26
SET address='seoul'
WHERE name = 'son';
UPDATE table26
SET address='busan'
WHERE name = 'kim';

CREATE TABLE table27
(
    name  VARCHAR(10),
    phone VARCHAR(11)
);
INSERT INTO table27
    (name, phone)
VALUES ('son', '01099998888'),
       ('kim', '01077776666'),
       ('kim', '01011112222');

ALTER TABLE table26
    DROP COLUMN phone1;
ALTER TABLE table26
    DROP COLUMN phone2;
SELECT *
FROM table26; # 이제
SELECT *
FROM table27;
# 원자적인것

##
CREATE TABLE table28
(
    name    VARCHAR(10),
    address VARCHAR(10),
    work    VARCHAR(10)
);
INSERT INTO table28
    (name, address, work)
VALUES ('kim', 'seoul', 'intel');
INSERT INTO table28
    (name, address, work)
VALUES ('lee', 'busan', 'intel');
INSERT INTO table28
    (name, address, work)
VALUES ('choi', 'seoul', 'tesla');
INSERT INTO table28
    (name, address, work)
VALUES ('kim', 'jeju', 'google');
INSERT INTO table28
    (name, address, work)
VALUES ('kim', 'jeju', 'google');
ALTER TABLE table28
    ADD COLUMN id INT UNIQUE NOT NULL; # 얘는 나중에 추가 불가능 처음부터 만들어야함.
SELECT *
FROM table28;

CREATE TABLE table29
(
    id      INT NOT NULL UNIQUE,
    name    VARCHAR(20),
    address VARCHAR(20),
    work    VARCHAR(20)
);
DESC table29;
