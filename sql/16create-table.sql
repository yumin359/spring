# DATABASE : 테이블을 모아놓은 공간
# CREATE DATABASE : 데이터베이스 만들기
CREATE DATABASE mydatabase;
# CREATE SCHEMA 테이블명; 도 가능

# database(schema) 사용하기
USE mydatabase;

# CREATE TABLE : 테이블 만들기
CREATE TABLE table1
(
    id int
);

# DROP TABLE : 테이블 삭제하기 (매우 주의 !!!!!)
DROP TABLE table1;

#
# USE w3schools;
# SELECT *
# FROM Customers;

USE mydatabase;
SELECT *
FROM w3schools.Customers;

#
CREATE TABLE table2 # 테이블명
( # 둥근 괄호 안에서 [컬럼명 타입] 나열
    name    varchar(255),
    country varchar(255),
    phone   varchar(255)
);
INSERT INTO table2
    (name, country, phone)
VALUES ('트럼프', '미국', '2323');
SELECT *
FROM table2;

# 테이블명, 컬럼명 작성 규칙
# 소문자, _ (lower_snake_case)
CREATE TABLE my_table1
(
    name            VARCHAR(255),
    address         VARCHAR(255),
    last_name       VARCHAR(255),
    nick_name       VARCHAR(255),
    home_address    VARCHAR(255),
    my_work_address VARCHAR(255)
);

# 연습
# id, name, address, team 컬럼이 있는 table3 만들기
# 2개의 레코드 입력(insert) 하기
CREATE TABLE table3
(
    id      VARCHAR(255),
    name    VARCHAR(255),
    address VARCHAR(255),
    team    VARCHAR(255)
);
INSERT INTO table3
    (id, name, address, team)
VALUES ('1', '홍길동', '서울', '중앙');

INSERT INTO table3
    (id, name, address, team)
VALUES ('2', 'SQL', '마포', '정보');

SELECT *
FROM table3;

# DROP TABLE : 테이블 삭제하기
DROP TABLE my_table1;

# 연습
# table3 삭제하기
DROP TABLE table3;