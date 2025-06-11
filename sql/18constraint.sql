use mydatabase;
# 제약사항(Constraint) : 컬럼에 입력 가능한 값을 제한

# NOT NULL : null 허용 안 함
# UNIQUE : 중복 허용 안 함
# DEFAULT : 값 안 주면 기본값

# NOT NULL
CREATE TABLE table14
(
    col1 INT,
    col2 INT NOT NULL # null 허용 안 됨.
);

INSERT INTO table14
    (col1, col2)
VALUES (5, 1);

INSERT INTO table14
    (col1, col2)
VALUES (null, 1);

INSERT INTO table14
    (col2)
VALUES (11);

# 안 되는 거
INSERT INTO table14
    (col1, col2)
VALUES (11, null);

INSERT INTO table14
    (col1)
VALUES (11);

SELECT *
FROM table14;

# 연습
# (name varchar not null), (address varchar) table15 만들기
CREATE TABLE table15
(
    name    VARCHAR(20) NOT NULL,
    address varchar(10)
);
INSERT INTO table15
    (name, address)
VALUES ('hong', 'seoul');
INSERT INTO table15
    (name)
VALUES ('kim');
# X
INSERT INTO table15
    (address)
VALUES ('seoul');

SELECT *
FROM table15;

# DEFAULT : 값 안 주면 기본값
CREATE TABLE table16
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) DEFAULT 'anonymous'
);
INSERT INTO table16
    (col1, col2)
VALUES ('abc', 'def');
INSERT INTO table16
    (col2)
VALUES ('abc');
INSERT INTO table16
    (col1)
VALUES ('def');
# 명시적으로 null을 넣음
INSERT INTO table16
    (col1, col2)
VALUES ('qwe', NULL);
SELECT *
FROM table16;

CREATE TABLE table17
(
    col1 VARCHAR(10)          DEFAULT 'val1',
    col2 VARCHAR(10) NOT NULL DEFAULT 'val2'
);
INSERT INTO table17
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO table17
    (col1, col2)
VALUES (null, 'def');

# X
INSERT INTO table17
    (col1, col2)
VALUES ('abc', null);
#

INSERT INTO table17
    (col2)
VALUES ('zxc');

INSERT INTO table17
    (col1)
VALUES ('iop');

SELECT *
FROM table17;

#연습
# (name varchar not null), (score int not null default 0) table18 만들기
CREATE TABLE table18
(
    name  VARCHAR(10) NOT NULL,
    score INT         NOT NULL DEFAULT 0
);
INSERT INTO table18
    (name, score)
VALUES ('kim', 3);
INSERT INTO table18
    (name)
VALUES ('kim');

SELECT *
FROM table18;

# UNIQUE : 중복 허용 안 함
CREATE TABLE table19
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) UNIQUE
);
INSERT INTO table19
    (col1, col2)
VALUES ('abc', 'def');
INSERT INTO table19
    (col1, col2)
VALUES ('abc', 'qwe');
INSERT INTO table19
    (col1, col2)
VALUES ('iop', 'qwe');
# Dup났다고 얘기 한대용
INSERT INTO table19
    (col1)
VALUES ('iop');
INSERT INTO table19
    (col1)
VALUES ('asd');
# null은 중복요소가 아님. 값이 없다는 것

SELECT *
FROM table19;

CREATE TABLE table20
(
    col1 VARCHAR(3),
    col2 VARCHAR(3) UNIQUE NOT NULL
);
INSERT INTO table20
    (col1, col2)
VALUES ('abc', 'def');
INSERT INTO table20
    (col1, col2)
VALUES ('abc', 'qwe');
INSERT INTO table20
    (col2)
VALUES ('asd');
# X
INSERT INTO table20
    (col1)
VALUES ('dd');
INSERT INTO table20
    (col2)
VALUES ('qwe');
SELECT *
FROM table20;

# 연습
# (name varchar not null unique), (score int not null default 0) table21
CREATE TABLE table21
(
    name  VARCHAR(10) NOT NULL UNIQUE,
    score INT         NOT NULL DEFAULT 0
);
INSERT INTO table21
    (name, score)
VALUES ('son', 100);
INSERT INTO table21
    (name, score)
VALUES ('kim', 100);
SELECT *
FROM table21;

# 테이블의 구조 보기
DESCRIBE table21;
DESCRIBE table19;
DESC table19;

SHOW CREATE TABLE table19;

CREATE TABLE `table19`
(
    `col1` varchar(10) DEFAULT NULL,
    `col2` varchar(10) DEFAULT NULL,
    UNIQUE KEY `col2` (`col2`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

create table mydatabase.table21
(
    name  varchar(10)   not null,
    score int default 0 not null,
    constraint name
        unique (name)
);


# 연습
# w3schools.Products 테이블 구조보기
# DESC, SHOW CREATE TABLE, generate DDL
DESC w3schools.Products;
SHOW CREATE TABLE w3schools.Products;
CREATE TABLE `Products`
(
    `ProductID`   int NOT NULL AUTO_INCREMENT,
    `ProductName` varchar(255)   DEFAULT NULL,
    `SupplierID`  int            DEFAULT NULL,
    `CategoryID`  int            DEFAULT NULL,
    `Unit`        varchar(255)   DEFAULT NULL,
    `Price`       decimal(10, 2) DEFAULT NULL,
    PRIMARY KEY (`ProductID`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 78
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null
);



# Primary Key : 주키(PK), 키
# Foreign Key : 외래키(FK), 참조키
