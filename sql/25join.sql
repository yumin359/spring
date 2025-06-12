USE mydatabase;
CREATE TABLE table39
(
    col1 INT
);
CREATE TABLE table40
(
    col_a INT
);

INSERT INTO table39
    (col1)
VALUES (1),
       (2),
       (3),
       (4),
       (5);
INSERT INTO table40
    (col_a)
VALUES (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9);

# cartesian product
SELECT *
FROM table39
         JOIN table40;

# inner join (교집합, 둘 다 있는거)
SELECT *
FROM table39
         JOIN table40 ON table39.col1 = table40.col_a;

# left (outer) join
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = table40.col_a;

# right (outer) join
SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = table40.col_a;

ALTER TABLE table39
    ADD COLUMN name VARCHAR(10);
SELECT *
FROM table39;
ALTER TABLE table40
    ADD COLUMN toy VARCHAR(10);
SELECT *
FROM table40;

# 장난감이 있는 사람들
# inner join

# 장난감이 없는 사람들
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = table40.col_a
WHERE table40.col_a IS NULL;

# 주인이 없는 장난감들
SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = table40.col_a
WHERE col1 IS NULL;

# 주문한 적 없는 고객들
SELECT *
FROM w3schools.Customers c
         LEFT JOIN w3schools.Orders o ON c.CustomerID = o.CustomerID
WHERE OrderID IS NULL;
# PK는 NULL이 아니니 이걸 써준거

# 주문을 처리한 적 없는 직원들 조회
DELETE
FROM w3schools.Orders
WHERE EmployeeID IN (2, 3);

# LEFT RIGHT 순서 바뀌면 답 안나옴 왜지,, 졸려서 지금 이해 안된다
SELECT e.LastName
FROM w3schools.Employees e
         LEFT JOIN w3schools.Orders o on e.EmployeeID = o.EmployeeID
WHERE o.OrderID IS NULL;
# 위 아래 같은 거
SELECT e.LastName
FROM w3schools.Orders o
         RIGHT JOIN w3schools.Employees e ON o.EmployeeID = e.EmployeeID
WHERE o.OrderID IS NULL;

# UNION (합집합)
SELECT col1
FROM table39
UNION
SELECT col_a
FROM table40;

# FULL OUTER JOIN
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = col_a
UNION
SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = col_a;

# 연습
DELETE
FROM w3schools.OrderDetails
WHERE ProductID IN (10, 20, 30, 40, 50);
# 한 번도 주문된 적 없는 상품들 이름 조회
SELECT p.ProductName, p.ProductID
FROM w3schools.OrderDetails od
         RIGHT JOIN w3schools.Products p ON od.ProductID = p.ProductID
# Products table이 오른쪽에 있어서 RIGHT JOIN
# 왼쪽에 있었으면 LEFT JOIN 하면됨
WHERE od.OrderDetailID IS NULL
# WHERE od.ProductID IS NULL
# 얘도 됨. 하지만 정확한 의미와 성능을 위해 PK인 OrderDetailID를 써주는 게 좋아여
ORDER BY p.ProductID;
# WHERE p.ProductID IS NULL
## 이건 안 됨. 왜냐면 PK니까 NULL값이 될 수가 없음 애초에
