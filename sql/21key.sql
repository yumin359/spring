USE mydatabase;
# Key : 각 레코드를 구분하는 컬럼(들)
# Primary Key : 대표키, 주요키, 주키, PK
## UNIQUE
## NOT NULL
## 변경되지 말아야 함
## Insert 할 때 결정되어야 함.

# -> 대부분의 테이블에 의미없는 id 컬럼 (INT PRIMARY KEY AUTO_INCREMENT)으로 추가됨

CREATE TABLE table30
(
    name    VARCHAR(20),
    address VARCHAR(20),
#     phone   VARCHAR(20) UNIQUE NOT NULL
    phone   VARCHAR(20) PRIMARY KEY # 둘 다 같은 의미
);
DROP TABLE table30;
DESC table30;

CREATE TABLE table31
(
    name    VARCHAR(20),
    address VARCHAR(20),
    phone   VARCHAR(20),
    PRIMARY KEY (phone)
);
DESC table31;

CREATE TABLE table32
(
    name    VARCHAR(20),
    address VARCHAR(20),
    notes   VARCHAR(20),
    PRIMARY KEY (name, address)
); # 가능은 한데 흔한 일은 아니다
DESC table32;

CREATE TABLE table33
(
    id      INT PRIMARY KEY AUTO_INCREMENT, # 변하지 않을 의미없는 프라이머리키를 추가함
    number  VARCHAR(13) NOT NULL UNIQUE,    # 확률은 낮지만 변경될 가능성이 있기 때문에
    name    VARCHAR(20),
    address VARCHAR(30)
);
INSERT INTO table33
    (number, name, address)
VALUES ('3-3', 'son', 'seoul');
INSERT INTO table33
    (number, name, address)
VALUES ('4-4', 'lee', 'seoul');
INSERT INTO table33
    (number, name, address)
VALUES ('5-5', 'lee', 'seoul');

SELECT *
FROM table33;

DROP TABLE table33;
