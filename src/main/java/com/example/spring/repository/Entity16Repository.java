package com.example.spring.repository;

import com.example.spring.entity.Entity16;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity16Repository extends JpaRepository<Entity16, Integer> {
    // findById
    // save
    // deleteById

    // 직접 만드는 쿼리
    @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE country = :country
            """, nativeQuery = true)
    List<Entity16> query1(String country);

    @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE city = :city
            """, nativeQuery = true)
    List<Entity16> query2(String city);

    @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE city = :city1
            OR city = :city2;
            """, nativeQuery = true)
    List<Entity16> query3(String city1, String city2);

    @Query(value = """
            SELECT *
            FROM customer
            WHERE customer_name LIKE :keyword
            """, nativeQuery = true)
    List<Entity16> query4(String keyword);

    /*
    SQL : table 대상
    @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE country = :country
            """, nativeQuery = true)
     */
    // 위아래 하는 일은 같음
    // JPQL : Entity 대상
    // 별칭이 꼭 필요
    // nativeQuery = false -> JPQL인데 기본값이 false라 안 쓸거임
    @Query(value = """
            SELECT e 
            FROM Entity16 e
            WHERE e.country = :country
            """)
    List<Entity16> query5(String country);

    // 연습
    // 도시 이름으로 고객 조회하는 쿼리 JPQL로 작성
    @Query(value = """
            SELECT e
            FROM Entity16 e
            WHERE e.city = :city
            """)
    List<Entity16> query6(String city);

    @Query(value = """
            SELECT a
            FROM Entity16 a
            WHERE a.customerName LIKE :keyword
            """)
    List<Entity16> query7(String keyword);

    /*
    JPQL
    @Query(value = """
            SELECT e
            FROM Entity16 e
            WHERE e.country = :country
            """)
     */
    List<Entity16> findByCountry(String country);

    // sql, jpql 안 써도 됨
    // SELECT * FROM customer WHERE city = :city
    List<Entity16> findByCity(String city);

    // 같은 이름의 메소드인데 리턴타입이랑 파라미터가 다름
    Page<Entity16> findByCountry(String country, PageRequest pageRequest);

    Page<Entity16> findByCustomerNameContainsOrContactNameContains(String k1, String k2, PageRequest pageRequest);
    // PageRequest나 Pageable 이나 상관 없음

    void deleteByCountry(String country);


    @Modifying // update, delete, insert 에 붙이는 어노테이션
    @Query(value = """
            DELETE FROM Entity16 e 
            WHERE e.country = :country
            """)
    void bulkDeleteByCountry(String country);

}
