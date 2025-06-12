USE mydatabase;
CREATE TABLE table38
(
    id INT
);
INSERT INTO table38
    (id)
VALUES (9),
       (8),
       (7);

SELECT *
FROM table34;
SELECT *
FROM table35;
SELECT *
FROM table38;

# 5 * 5 * 3 = 75 rows
SELECT *
FROM table34 t34
         JOIN table35 t35
         JOIN table38 t38;

# 77 * 8 * 29 = 17,864 rows, 6+3+8 = 17 column
# 77 rows
SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID;
# 위 아래 같은데 위에처럼 거의 쓴대여
SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
         JOIN w3schools.Suppliers s
WHERE p.CategoryID = c.CategoryID
  AND p.SupplierID = s.SupplierID;

# 카테고리별 공급자 정보
SELECT c.CategoryName, s.SupplierName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
ORDER BY c.CategoryName;

# 공급자별 공급하는 상품 카테고리
SELECT DISTINCT s.SupplierName, c.CategoryName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
ORDER BY s.SupplierName;

SELECT DISTINCT s.ShipperName, c.CustomerName
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
         JOIN w3schools.Shippers s
              ON o.ShipperID = s.ShipperID
ORDER BY s.ShipperName, c.CustomerName;

# 연습
# 1996-07-05에 주문된 상품명 목록
# Orders, OrderDetails, Products
SELECT o.OrderDate, p.ProductName
FROM w3schools.OrderDetails od
         JOIN w3schools.Orders o
              ON od.OrderID = o.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE o.OrderDate = '1996-07-05';

# 연습
# Tofu 상품을 어떤 고객이 언제 주문했는지 조회
# Orders, Products, Customers, OrderDetails
SELECT o.OrderDate, c.CustomerName
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
         JOIN w3schools.Customers c
              ON c.CustomerID = o.CustomerID
# WHERE p.ProductName = 'Tofu'
# 조건에 사용되는 컬럼들은 PK 사용할수록 성능이 좋음
WHERE p.ProductID = 14 # 이게 속도가 더 빠르대여
ORDER BY o.OrderDate, c.CustomerName;

# 우수 고객 선정 조회
# 고객별 주문 금액
# Orders, OrderDetails, Products, Customers
SELECT c.CustomerName, SUM(od.Quantity * p.Price) 합의합
FROM w3schools.OrderDetails od
         JOIN w3schools.Orders o
              ON od.OrderID = o.OrderID
         JOIN w3schools.Products p
              ON p.ProductID = od.ProductID
         JOIN w3schools.Customers c
              ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID
ORDER BY 합의합 DESC;

# 연습
# 1997-09 월에 가장 많은 주문(가격 기준, 주문 건수 X)을 처리한 직원 조회
# Employees, Orders, OrderDetails, Products
SELECT e.FirstName, e.LastName, SUM(p.Price * od.Quantity) sum
FROM w3schools.Employees e
         JOIN w3schools.Orders o ON e.EmployeeID = o.EmployeeID
         JOIN w3schools.OrderDetails od ON od.OrderID = o.OrderID
         JOIN w3schools.Products p ON p.ProductID = od.ProductID
WHERE o.OrderDate BETWEEN '1997-09-01' AND '1997-09-30'
GROUP BY e.EmployeeID
ORDER BY sum DESC;
