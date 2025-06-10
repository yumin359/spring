SELECT COUNT(*)
FROM Customers;
# INSERT INTO : 새 데이터(record, row) 입력
INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('92', 'donald', 'trump', 'new york', 'CA', '1234', 'usa');

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, PostalCode, Country, City)
VALUES ('93', 'elon', 'musk', 'la', 'TA', '5678', 'usa');

# 숫자는 따옴표 안 써도 됨
INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES (94, 'park', 'jisung', 'suwon', 'suwon', '9090', 'korea');

# 기본키는 작성하지 않아도 자동 증가
INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('son', 'hm', '강남', '강남', '8080', 'korea');

INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('cha', 'bum', '수원', '서울', '3030', 'korea');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# 연습
# Categories 테이블에 새 레코드 2개 입력해보기
INSERT INTO Categories
    (CategoryName, Description)
VALUES ('korean food', '쌀');

INSERT INTO Categories
    (CategoryName, Description)
VALUES ('desert', 'cookie');

SELECT *
FROM Categories
ORDER BY CategoryID DESC;

# Products 테이블에 새 레코드 2개 입력해보기
INSERT INTO Products
    (ProductName, SupplierID, CategoryID, Unit, Price)
VALUES ('note', '1234', '1234', '15 X 15', '10.00');

INSERT INTO Products
    (ProductName, SupplierID, CategoryID, Unit, Price)
VALUES ('뇸', 5678, 5678, 'ㅎ', 20.00);

SELECT *
FROM Products
ORDER BY ProductID DESC;

###
INSERT INTO Customers
    (CustomerName)
VALUES ('손흥민');

# 의도적으로 null로 남김
INSERT INTO Customers
    (CustomerName, ContactName)
VALUES ('트럼프', NULL);

# NULL과 ''은 다름
INSERT INTO Customers
    (CustomerName, ContactName, Address)
VALUES ('트럼프', NULL, '');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# null : 값이 없다

# 연습
# 카테고리 테이블에 새 데이터 넣기(Description은 null로 남기기).
INSERT INTO Categories
    (CategoryName)
VALUES ('coffee');
INSERT INTO Categories
    (CategoryName, Description)
VALUES ('book', NULL);
SELECT *
FROM Categories
ORDER BY CategoryID DESC;
# 카테고리 테이블에 새 데이터 넣기(Description은 ''로 넣기).
INSERT INTO Categories
    (CategoryName, Description)
VALUES ('coffee', '');


# DELETE : 기존 데이터(record, row) 삭제

# UPDATE : 기존 데이터 수정
