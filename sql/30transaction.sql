# Transaction : 업무 단위
## 세부 업무들은 모두 실패하거나 모두 성공해야함. -> 일부분만 성공하면 안 됨

## rollback; 되돌리기
## commit; 반영하기

# a가 b에게 500원 송금
## a의 돈에서 500원 차감
UPDATE 계좌_table
SET money = money - 500
WHERE user = 'a';

## b의 돈에 500원 더함
UPDATE 계좌_table
SET money = money + 500
WHERE user = 'b';

USE mydatabase;
CREATE TABLE table53
(
    user  VARCHAR(10),
    money INT
);

INSERT INTO table53
    (user, money)
VALUES ('a', 10000),
       ('b', 10000);

UPDATE table53
SET money = money - 500
WHERE user = 'a';
UPDATE table53
SET money = money + 500
WHERE user = 'b';

# 현재 트랜잭션을 되돌림(마지막 커밋 상태로 돌림)
ROLLBACK;
# 현재 트랜잭션 적용(반영)
COMMIT;

SELECT *
FROM table53;

# 위쪽에 Tx: Auto랑 Manual