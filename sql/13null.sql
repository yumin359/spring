# NULL : 값이 없다.

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# SUM, COUNT, MIN, MAX, AVG
# 집계 합수는 NULL을 집계에 포함하지 않음
SELECT COUNT(CustomerName)
FROM Customers;

SELECT COUNT(CustomerID)
FROM Customers;

SELECT COUNT(ContactName)
FROM Customers;

SELECT COUNT(Address)
FROM Customers;

# 2252.71
SELECT SUM(Price)
FROM Products;
# 28.515316
SELECT AVG(Price)
FROM Products;

INSERT INTO Products
    (ProductName)
VALUES ('커피');

INSERT INTO Products
    (ProductName)
VALUES ('컴퓨터');

# NULL인 컬럼 조회
SELECT *
FROM Customers
# WHERE ContactName = NULL
WHERE ContactName IS NULL
ORDER BY CustomerID DESC;

# NULL이 아닌 컬럼 조회
SELECT *
FROM Customers
WHERE ContactName IS NOT NULL
ORDER BY CustomerID DESC;

# 연습
# 카테고리에서 Description이 null인 레코드 조회
SELECT *
FROM Categories
WHERE Description IS NULL;
# 카테고리에서 Description이 null이 아닌 레코드 조회
SELECT *
FROM Categories
WHERE Description IS NOT NULL
ORDER BY CategoryID DESC;

#
SELECT *
FROM Products
ORDER BY ProductID DESC;

SELECT SUM(Price)
FROM Products;
# 28.158875 -> 조금 작아짐
SELECT AVG(IFNULL(Price, 0))
FROM Products;

# IFNULL : NULL인 경우 다른 값으로 조회
SELECT ProductID,
       ProductName,
       SupplierID,
       IFNULL(CategoryID, '미정') CategoryID,
       IFNULL(Unit, '없다')       Unit,
       IFNULL(Price, 0)         Price
FROM Products
ORDER BY ProductID DESC;

# 연습
# 카테고리 테이블 조회, description이 null이면 '정해지지 않음'으로 조회
SELECT CategoryID, CategoryName, IFNULL(Description, '정해지지 않음') Description
FROM Categories
ORDER BY CategoryID DESC;

# description 컬럼으로 COUNT() 함수 결과 조회, NULL도 count에 포함되도록
SELECT COUNT(IFNULL(Description, '')) count
FROM Categories;