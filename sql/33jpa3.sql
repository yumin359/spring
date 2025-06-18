USE jpa;

SELECT *
FROM customer;

INSERT INTO customer
    (customer_name, contact_name, address, city, postal_code, country)
SELECT customer_name, contact_name, address, city, postal_code, country
FROM customer;
SELECT COUNT(*)
FROM customer;

# transactional annotation 실습에서 사용
CREATE TABLE my_table20
(
    name  VARCHAR(30),
    money INT,
    PRIMARY KEY (name)
);
INSERT INTO my_table20
    (name, money)
VALUES ('a', 10000),
       ('b', 10000);

SELECT *
FROM my_table20;

CREATE TABLE my_table21
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(20),
    address     VARCHAR(20),
    inserted_at DATETIME NOT NULL DEFAULT NOW()
);
INSERT INTO my_table21
    (name, address)
VALUES ('lee', 'seoul');

INSERT INTO my_table21
    (name, address)
VALUES ('kim', 'busan');

SELECT *
FROM my_table21;

# 기본키가 하나인 테이블 pk 2개랑 비교하려고 그냥 만든 듯
CREATE TABLE my_table22
(
    name    VARCHAR(20),
    address VARCHAR(20),
    country VARCHAR(20),
    primary key (name)
);
INSERT INTO my_table22
    (name, address, country)
VALUES ('kim', 'seoul', 'korea');

# 기본키가 두개인 테이블 ->
# 복합키에 대한 설명
# 복합키는 여러 컬럼이 합쳐져서 하나의 PK 역할을 하는 것
CREATE TABLE my_table23
(
    name    VARCHAR(30),
    address VARCHAR(30),
    country VARCHAR(30),
    info    VARCHAR(30),
    PRIMARY KEY (name, address)
);
CREATE TABLE my_table24
(
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(50)  NOT NULL,
    score    INT          NULL,
    name     VARCHAR(20)  NOT NULL,
    address  VARCHAR(200) NOT NULL,
    CONSTRAINT pk_my_table24 PRIMARY KEY (name, address)
);
# 복합키가 있는 my_table25 테이블 만들고 entity 만들어보기
CREATE TABLE my_table25
(
    name  VARCHAR(30),
    phone INT,
    info  VARCHAR(200),
    PRIMARY KEY (name, phone)
);

# 복합키가 있는 Entity26 만들고 my_table26 만들어보기
CREATE TABLE my_table26
(
    user     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NULL,
    age      INT          NULL,
    id       INT          NOT NULL,
    CONSTRAINT pk_my_table26 PRIMARY KEY (user, id)
);


# foreign key (외래키, 참조키, FK)
CREATE TABLE my_table27
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(30),
    info          VARCHAR(1000)
);

CREATE TABLE my_table28
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(30),
    price        INT,
    unit         VARCHAR(30),
    category_id  INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES my_table27 (id)
);


# 직원 정보 -> 그냥 해도 됨
CREATE TABLE my_table29
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(10),
    last_name  VARCHAR(10),
    birth_date DATE
);

# 주문정보 -> 컬럼 부분 만들 때 명시해야할것이 있음
CREATE TABLE my_table30
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    order_date  DATE,
    info        VARCHAR(20),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES my_table29 (id)
);
DROP TABLE my_table30;
# 연습 : 29, 30 Entity 만들기
# repository * 2 만들기

# insert 해보기
# select 해보기

# request handler method * 4
# service method * 4










