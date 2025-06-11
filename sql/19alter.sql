USE mydatabase;
CREATE TABLE table22
(
    col1 INT         NOT NULL,
    col2 VARCHAR(10) NOT NULL
);
INSERT INTO table22
    (col1, col2)
VALUES (3, 'son');
INSERT INTO table22
    (col1, col2)
VALUES (5, 'lee');

# ALTER TABLE : 테이블 수정
# 컬럼 추가
# 컬럼 TYPE 제약사항 변경
# 컬럼명 변경

ALTER TABLE table22
    ADD COLUMN col3 DATETIME NOT NULL DEFAULT NOW();
DESC table22;
SELECT *
FROM table22;
ALTER TABLE table22
    ADD COLUMN col4 INT;
ALTER TABLE table22
    ADD COLUMN col5 INT NOT NULL;
ALTER TABLE table22
    ADD COLUMN col6 VARCHAR(10) NOT NULL;
# 아래는 제약사항 위반으로 추가 안 됨
ALTER TABLE table22
    ADD COLUMN col7 VARCHAR(10) NOT NULL UNIQUE;

ALTER TABLE table22
    ADD COLUMN col8 INT;
ALTER TABLE table22
    ADD COLUMN col9 INT
        AFTER col1;
ALTER TABLE table22
    ADD COLUMN col10 INT
        FIRST;

# 연습
# table22에 새로운 컬럼 2개 추가
ALTER TABLE table22
    ADD COLUMN col11 VARCHAR(10) NOT NULL DEFAULT '없음';
ALTER TABLE table22
    ADD COLUMN col12 INT NOT NULL DEFAULT 100;


# 컬럼명 변경
CREATE TABLE table23
(
    col1 INT,
    col2 VARCHAR(10)
);
ALTER TABLE table23
    CHANGE COLUMN col1 col11 INT;
DESC table23;

ALTER TABLE table23
    CHANGE COLUMN col11 col21 INT NOT NULL;

ALTER TABLE table23
    CHANGE COLUMN col21 col31 VARCHAR(10) NOT NULL;


# 컬럼 TYPE 제약사항 변경
ALTER TABLE table23
    MODIFY COLUMN col31 INT NOT NULL UNIQUE;

DESC table23;
# ctrl alt shift G ? -> 뭐지 강의 봐야할듯 ㅠ
# 연습
# table23 col2 의 타입을 DEC(10, 2), NOT NULL, UNIQUE 변경
ALTER TABLE table23
    MODIFY COLUMN col2 DEC(10, 2) NOT NULL UNIQUE;

CREATE TABLE table24
(
    col1 VARCHAR(5),
    col2 BIGINT
);
INSERT INTO table24
    (col1, col2)
VALUES ('abcde', 4000000000);
INSERT INTO table24
    (col1, col2)
VALUES ('abcde', 4000000000);
SELECT *
FROM table24;
# 데이터가 짤릴 수 있어서 불가능
ALTER TABLE table24
    MODIFY COLUMN col1 VARCHAR(3);
# 얘는 기존보다 크기가 커서 가능
ALTER TABLE table24
    MODIFY COLUMN col1 VARCHAR(10);
DESC table24;
# 이미 있는 데이터가 같은 값이라서 불가능
ALTER TABLE table24
    MODIFY COLUMN col1 VARCHAR(10) UNIQUE;

# BIGINT > INT 이므로 불가능
ALTER TABLE table24
    MODIFY COLUMN col2 INT;

# 이미 같은 값이 들어가 있으므로 불가능
ALTER TABLE table24
    MODIFY COLUMN col2 BIGINT UNIQUE;