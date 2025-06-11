USE mydatabase;

# STRING
# VARCHAR(길이)
CREATE TABLE table4
(
    col1 VARCHAR(1),
    col2 VARCHAR(3),
    col3 VARCHAR(5)
);
INSERT INTO table4
    (col1, col2, col3)
VALUES ('a', 'abc', 'abcde');

INSERT INTO table4
    (col1, col2, col3)
VALUES ('한', 'abc', 'abcde');

# 얘넨 안 들어감
INSERT INTO table4
    (col1, col2, col3)
VALUES ('ab', 'abc', 'abcde');

INSERT INTO table4
    (col1, col2, col3)
VALUES ('한글', 'abc', 'abcde');

SELECT *
FROM table4;

# 연습
# id(최대 8글자), name(최대 20글자) 컬럼이 있는 table5 만들기
# 두개의 레코드 입력(성공)
# 실패하는 레코드 입력 시도
CREATE TABLE table5
(
    id   VARCHAR(8),
    name VARCHAR(20)
);
INSERT INTO table5
    (id, name)
VALUES ('12345678', 'hong');
INSERT INTO table5
    (id, name)
VALUES ('87654321', 'kim');
INSERT INTO table5
    (id, name)
VALUES ('123456789', 'hong');
INSERT INTO table5
    (id, name)
VALUES ('12345678', 'hongghongghongghonggi');
# 이모지는 두글자 차지
SELECT *
FROM table5;

# NUMBER
# INTEGER (소숫점 없는)
# DECIMAL (소숫점 있는)
CREATE TABLE table6
(
    col1 INT,
    col2 BIGINT # 2^63-1 long 타입 최대값
);
INSERT INTO table6
    (col1, col2)
VALUES (324234, 34234234);
INSERT INTO table6
    (col1, col2)
VALUES (2147483647, 2147483647);
# 얜 안 됨
INSERT INTO table6
    (col1, col2)
VALUES (2147483648, 2147483647);

SELECT *
FROM table6;

# 연습
# score(정수), length(큰정수) 컬럼이 있는 table7번 만들기
# 두 개의 레코드 입력(성공)
# 한 개의 레코드 입력 실패
CREATE TABLE table7
(
    score  INT,
    length BIGINT
);
INSERT INTO table7
    (score, length)
VALUES (2147483647, 2147483647);
INSERT INTO table7
    (score, length)
VALUES (2147483647, 2147483647123456);
# 얘넨 안 됨
INSERT INTO table7
    (score, length)
VALUES (214748364766, 2147483647123456);
SELECT *
FROM table7;

# DECIMAL(총길이, 소숫점이하길이)
CREATE TABLE table8
(
    col1 INT,
    col2 DECIMAL(5, 1),
    col3 DECIMAL(10, 3),
    col4 DEC(5, 1),
    col5 DEC(10, 3)
);
INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 1234.5, 1234567.123, null, null);
# 자릿수 넘어가면 반올림해서 넣어짐
INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 1234.56, 1234567.1234, null, null);
# 얘는 길이가 넘어가서 안 들어감
INSERT INTO table8
    (col1, col2, col3, col4, col5)
VALUES (2342, 12345.56, 12345678.1234, null, null);
SELECT *
FROM table8;

# 연습
# score(총길이 4, 소숫점이하 2), money(총길이 10, 소숫점이하 3) table9
# 두 개의 레코드 입력 성공
# 한 개의 레코드 입력 실패
CREATE TABLE table9
(
    score DEC(4, 2),
    money DEC(10, 3)
);
INSERT INTO table9
    (score, money)
VALUES (12.34, 12345.678);
INSERT INTO table9
    (score, money)
VALUES (5.6, 987.32);
INSERT INTO table9
    (score, money)
VALUES (789.8999, 9876.32);
SELECT *
FROM table9;


# DATE, TIME
# DATE : 날짜
# TIME : 시간
# DATETIME : 날짜 시간
CREATE TABLE table10
(
    col1 DATE,
    col2 TIME,
    col3 DATETIME
);
INSERT INTO table10
    (col1, col2, col3)
VALUES ('2025-06-11', '10:26:15', '2025-06-11 10:26:15');
INSERT INTO table10
    (col1, col2, col3)
VALUES ('2025-06-11', '23:26:15', '2025-06-11 10:26:15');
SELECT *
FROM table10;

# 연습
# birth_date(날짜), work_time(시간), born(날짜시간) table11
CREATE TABLE table11
(
    birth_date DATE,
    work_time  TIME,
    born       DATETIME
);
INSERT INTO table11
    (birth_date, work_time, born)
VALUES ('2020-02-02', '10:30:30', '2020-02-02 02:20:02');
INSERT INTO table11
    (birth_date, work_time, born)
VALUES ('1988-12-15', '20:50:30', '1930-05-27 15:50:58');
SELECT *
FROM table11;

# STRING : VARCHAR(길이)
# NUMBER : INT, BIGINT, DEC(총길이, 소수점이하길이)
# 날짜시간 : DATE, TIME, DATETIME

CREATE TABLE table12
(
    col1 VARCHAR(10),
    col2 INT,
    col3 BIGINT,
    col4 DEC(10, 2),
    col5 DATE,
    col6 TIME,
    col7 DATETIME
);
INSERT INTO table12
    (col1, col2, col3, col4, col5, col6, col7)
VALUES ();
SELECT *
FROM table12;

CREATE TABLE table13
(
    name       VARCHAR(50),
    birth_date DATE,
    score      DEC(5, 2),
    born_at    DATETIME
);
