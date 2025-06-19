USE jpa;

# 고객 테이블
CREATE TABLE my_table31
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30),
    country VARCHAR(30)
);
# 고객 : 주문 = 1:N 관계
# 주문 테이블
CREATE TABLE my_table32
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    order_date  DATE,
    info        VARCHAR(30),
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES my_table31 (id),
    FOREIGN KEY (employee_id) REFERENCES my_table33 (id)
);
DROP TABLE my_table32;
# 주문 : 직원 = N:1 관계
# 직원 테이블
CREATE TABLE my_table33
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    birth_date DATE,
    info       VARCHAR(50)
);
# 고객 : 직원 = N:M 관계


# 학생 테이블
CREATE TABLE my_table34
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(30),
    birth_date DATE,
    info       VARCHAR(50)
);
# 강의 테이블
CREATE TABLE my_table35
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    lecture_title VARCHAR(30),
    info          VARCHAR(50),
    place         VARCHAR(30)
);
# 학생 - 수강 테이블 - 강의
# 학생 - 수강 = 1:N
# 수강 - 강의 = N:1
# 학생 - 수강 = N:M
CREATE TABLE my_table36
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    registered_at DATE,
    enable        VARCHAR(1),
    money         VARCHAR(1),
    student_id    INT NOT NULL,
    lecture_id    INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES my_table34 (id),
    FOREIGN KEY (lecture_id) REFERENCES my_table35 (id)
);
# 연습
# 34, 35, 36 Entity 만들기
# 1. intellij 도움으로 만들기
# 2. 지우고, 직접 만들기


#
CREATE TABLE my_table37
(
    email       VARCHAR(30) PRIMARY KEY,
    password    VARCHAR(30) NOT NULL,
    info        VARCHAR(30) NOT NULL,
    inserted_at DATETIME    NOT NULL DEFAULT NOW()
);
CREATE TABLE my_table38
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(30) NOT NULL,
    content     VARCHAR(50) NOT NULL,
    author      VARCHAR(30) NOT NULL,
    inserted_at DATETIME    NOT NULL DEFAULT NOW(),
    FOREIGN KEY (author) references my_table37 (email)
);

# 상품
CREATE TABLE my_table39
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(30),
    unit        VARCHAR(30),
    price       INT,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES my_table40 (id)
);
# 카테고리
CREATE TABLE my_table40
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(40),
    description VARCHAR(50)
);

SELECT p.id, p.name product_name, p.price, c.name category_name
FROM my_table39 p
         JOIN my_table40 c on p.category_id = c.id;
SELECT *
FROM my_table39;
SELECT *
FROM my_table40;

INSERT INTO my_table40
    (name, description)
SELECT CategoryName, SUBSTR(Description, 1, 10)
FROM w3schools.Categories;
INSERT INTO my_table39
    (name, unit, price, category_id)
SELECT ProductName, Unit, ROUND(Price, 0), CategoryID
FROM w3schools.Products
LIMIT 5;

# 연습
# projection

# OrderInfo interface * 1
# Entity41 * 1
# Entity41Repository * 1
# Entity41Repository.query1() * 1
# service.action() * 1
# controller.sub() * 1

# 주문 테이블
CREATE TABLE my_table41
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    order_date DATE,
    product_id INT,
    quantity   INT,
    FOREIGN KEY (product_id) REFERENCES my_table39 (id)
);
INSERT INTO my_table41
    (order_date, product_id, quantity)
VALUES ('1998-01-01', 2, 12),
       ('1999-02-02', 2, 2),
       ('2000-03-03', 4, 34),
       ('2001-04-04', 5, 42),
       ('2002-05-05', 3, 5),
       ('2003-06-06', 3, 6);
SELECT o.order_date, p.name product_name, p.price, o.quantity, c.name category_name
FROM my_table39 p
         JOIN my_table40 c ON p.category_id = c.id
         JOIN my_table41 o on p.id = o.product_id;
