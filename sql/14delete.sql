# DELETE : 특정 행(row, record)을 삭제
DELETE
FROM Customers
WHERE CustomerID = 109;

DELETE
FROM Customers
WHERE CustomerID = 107;

SELECT *
FROM Customers
WHERE Country IS NULL;

DELETE
FROM Customers
WHERE Country IS NULL;
# 명심 : 지우기 전에 꼭 같은 WHERE 절로 SELECT 해보기 -> 지우면 되돌릴 수 없으니까
SELECT *
FROM Customers
WHERE CustomerID = 100;

DELETE
FROM Customers
WHERE CustomerID = 100;

# WHERE 없이 삭제하면 모든 레코드가 삭제됨.
SELECT *
FROM Customers;

DELETE
FROM Customers;


SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# 연습
# 공급자 테이블에서 28, 29번 공급자 삭제하기
SELECT *
FROM Suppliers
WHERE SupplierID = 28
   OR SupplierID = 29;

DELETE
FROM Suppliers
WHERE SupplierID = 28
   OR SupplierID = 29;

SELECT *
FROM Suppliers
ORDER BY SupplierID DESC;

# 공급자 테이블의 모든 레코드 삭제하기.
SELECT *
FROM Suppliers;
DELETE
FROM Suppliers;