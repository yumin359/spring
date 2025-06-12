USE mydatabase;

CREATE TABLE table34
(
    name VARCHAR(1)
);

CREATE TABLE table35
(
    score INT
);

INSERT INTO table34
    (name)
VALUES ('a'),
       ('b'),
       ('c'),
       ('d'),
       ('c');

INSERT INTO table35
    (score)
VALUES (5),
       (4),
       (3),
       (3),
       (5);

SELECT *
FROM table34;
SELECT *
FROM table35;

# 행 25개, 열 2개
SELECT *
FROM table34,
     table35;


# 행 77 * 8 = 616, 열 9
SELECT *
FROM w3schools.Products,
     w3schools.Categories;
SELECT *
FROM w3schools.Products
         JOIN
     w3schools.Categories;

# Cartesian Product (카테시안 곱)
CREATE TABLE table36
(
    `대회`  VARCHAR(20),
    `연도`  INT,
    `우승자` VARCHAR(30),
    PRIMARY KEY (`대회`, `연도`)
);
CREATE TABLE table37
(
    `우승자`  VARCHAR(30),
    `생년월일` VARCHAR(100),
    PRIMARY KEY (`우승자`)
);
INSERT INTO table36
    (대회, 연도, 우승자)
VALUES ('D', '1998', 'chip'),
       ('I', '1998', 'al'),
       ('C', '1999', 'bob'),
       ('D', '1999', 'al'),
       ('I', '1999', 'chip');
INSERT INTO table37
    (우승자, 생년월일)
VALUES ('chip', '77-3-14'),
       ('al', '75-7-21'),
       ('bob', '68-9-28');

SELECT *
FROM table36;
SELECT *
FROM table37;

# 카테시안 곱
SELECT *
FROM table36
         JOIN table37;

# 카테시안 곱 과 WHERE
SELECT *
FROM table36
         JOIN table37
WHERE table36.우승자 = table37.우승자;

# 더 많이 쓰는 것 : ON
SELECT *
FROM table36
         JOIN table37
              ON table36.우승자 = table37.우승자;

SELECT `대회`, `연도`, table36.`우승자`, `생년월일`
FROM table36
         JOIN table37
              ON table36.우승자 = table37.우승자;

# ALIAS : 별칭
SELECT `대회` AS congress,
       `연도`    year,
       t7.`우승자`,
       `생년월일`
FROM table36 AS t6
         JOIN table37 t7
              ON t6.우승자 = t7.우승자;

#
SELECT *
FROM w3schools.Products;
SELECT *
FROM w3schools.Categories;

SELECT c.CategoryName, p.ProductName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
ORDER BY c.CategoryName, p.ProductName;

# 연습
# 공급자별 공급하는 상품 목록 조회
SELECT s.SupplierName, p.ProductName
FROM w3schools.Suppliers s
         JOIN w3schools.Products p
              ON s.SupplierID = p.SupplierID
ORDER BY s.SupplierName, p.ProductName;


# 주문별 처리 직원
SELECT o.OrderDate, o.OrderID, e.FirstName, e.LastName
FROM w3schools.Orders o
         JOIN w3schools.Employees e ON o.EmployeeID = e.EmployeeID
WHERE e.EmployeeID = 3;

# 연습
# 1번 고객이 주문한 날짜들 조회
SELECT c.CustomerName, o.OrderDate
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
WHERE o.CustomerID = 1
ORDER BY o.OrderDate;

# 고객별 주문 건수
SELECT c.CustomerID, c.ContactName, COUNT(*)
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY c.CustomerID;

# 주문이 20건 이상인 고객들
SELECT c.CustomerID, c.ContactName, COUNT(*)
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
HAVING COUNT(*) >= 20
ORDER BY c.CustomerID;

# 조인 순서는 상관없어용
# 연습
# 카테고리별 상품의 평균 가격
SELECT c.CategoryID, c.CategoryName, AVG(p.Price)
FROM w3schools.Categories c
         JOIN w3schools.Products p ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID
ORDER BY c.CategoryID;

# 직원별 주문 처리 건수
SELECT e.EmployeeID, e.LastName, COUNT(*) count
FROM w3schools.Employees e
         JOIN w3schools.Orders o
              ON e.EmployeeID = o.EmployeeID
GROUP BY e.EmployeeID
ORDER BY count DESC;

# 98년도 승진을 결정하기 위해 당시년도의 주문 처리수가 가장 높은 사원
SELECT e.EmployeeID, e.LastName, COUNT(*) count
FROM w3schools.Employees e
         JOIN w3schools.Orders o
              ON e.EmployeeID = o.EmployeeID
WHERE OrderDate BETWEEN '1997-01-01' AND '1997-12-31'
GROUP BY e.EmployeeID
ORDER BY count DESC;




















