# ALIAS (AS) : 컬럼이나 테이블에 별칭 주기
SELECT CustomerName, ContactName
From Customers;

SELECT CustomerName AS Name, ContactName AS Contact
From Customers;

# AS : 생략 가능
SELECT CustomerName Name, ContactName Contact
From Customers;

#
SELECT AVG(Price)
FROM Products;

SELECT AVG(Price) AS 평균가격
FROM Products;

SELECT AVG(Price) 평균가격
FROM Products;

SELECT AVG(Price) '평균 가격'
FROM Products;

SELECT AVG(Price) `평균 가격`
FROM Products;

# 테이블에 별칭 주기
SELECT p.ProductName, c.CategoryName
FROM Products AS p,
     Categories AS c;

SELECT p.ProductName, c.CategoryName
FROM Products p,
     Categories c;

##########################
# 페이징 연습용 쿼리
##########################
# 대량의 고객 정보 입력
INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
SELECT CustomerName, ContactName, Address, City, PostalCode, Country
FROM Customers;
SELECT COUNT(*)
FROM Customers;
# 강사님 5000몇개 만드심, 나는 11648개 만듦 ㅎ

# 대량의 상품 정보 입력
INSERT INTO Products
    (ProductName, SupplierID, CategoryID, Unit, Price)
SELECT ProductName, SupplierID, CategoryID, Unit, Price
FROM Products;
# 1232개 만드심 나는 2464 만들었다 ,,
SELECT COUNT(*)
FROM Products















