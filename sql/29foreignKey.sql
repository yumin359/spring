USE mydatabase;

# 게시물
# 제목, 본문, 작성일시
CREATE TABLE table43
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(255),
    content          VARCHAR(10000),
    create_at        DATETIME,
    table44_username VARCHAR(20),
    FOREIGN KEY (table44_username) REFERENCES table44 (username)
);
DROP TABLE table43;

# 회원
# ID, PW, 자기소개
CREATE TABLE table44
(
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    notes    VARCHAR(5000)
);

# 1대1, N대1

# 1대1 (잘 보이진 않음)
# 직원정보
CREATE TABLE table45
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(20),
    hire_date DATE,
    school    VARCHAR(20)
);
# 위 아래 1대1 관계가 됨
# 직원연봉
CREATE TABLE table46
(
    id     INT PRIMARY KEY,
    salary INT,
    FOREIGN KEY (id) REFERENCES table45 (id)
);

# N대N -> 중간 테이블이 필요함
# 학생정보
CREATE TABLE table48
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    info VARCHAR(20)
);
# 수업정보
CREATE TABLE table47
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(20),
    schedule VARCHAR(20),
    info     VARCHAR(20)
);
# 학생수업(중간테이블)(연결, 조인, 중간 테이블)
CREATE TABLE table49
(
    table48_id INT,
    table47_id INT,
    # 부가적인 정보들을 써야하면 여기서도 인위적인 PK를 새로 추가하는게 좋다.

    PRIMARY KEY (table48_id, table47_id),
    FOREIGN KEY (table48_id) REFERENCES table48 (id),
    FOREIGN KEY (table47_id) REFERENCES table47 (id)
);

# 연습
# 다대다 테이블 만들어 보기
# movie
CREATE TABLE table50
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    date DATE,
    info VARCHAR(100)
);
# actor
CREATE TABLE table51
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    old  INT,
    info VARCHAR(100)
);
# middle table
CREATE TABLE table52
(
    # 이렇게 새로운 PK를 만들어 주는게 좋음
    id         INT AUTO_INCREMENT PRIMARY KEY,
    table50_id INT,
    table51_id INT,
    # 이렇게 기타 정보가 있으면
    money      INT,
    info       VARCHAR(30),

    # 이거 말고
#     PRIMARY KEY (table50_id, table51_id),
    FOREIGN KEY (table50_id) REFERENCES table50 (id),
    FOREIGN KEY (table51_id) REFERENCES table51 (id)
);



























