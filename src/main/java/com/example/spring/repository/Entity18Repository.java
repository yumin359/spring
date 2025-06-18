package com.example.spring.repository;

import com.example.spring.entity.Entity18;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity18Repository extends JpaRepository<Entity18, Integer> {
    // 만들지 않아도 있는 메소드들 : findById, save, deleteById

    // 쿼리 직접 만드는 방법들
    // SQL
    // JPQL

    // 메소드 이름으로 쿼리 만들기
  /*
  SELECT * FROM supplier WHERE country = :country
   */
    List<Entity18> findByCountry(String country);

    // 연습
    // SELECT * FROM supplier WHERE city = :city
    List<Entity18> findByCity(String city);

    // SELECT * FROM supplier WHERE supplier_name LIKE :keyword
    // service 에서 호출할 때 % 붙여줘야함
    List<Entity18> findBySupplierNameLike(String keyword);

    // SELECT * FROM supplier WHERE supplier_name LIKE :keyword
    // keyword에 % 안 붙여서 호출
    List<Entity18> findBySupplierNameContaining(String keyword);

    List<Entity18> findBySupplierNameContains(String keyword);

    // SELECT * FROM supplier WHERE country IN (?, ?, ?)
    List<Entity18> findByCountryIn(List<String> country);

    // 연습
    // query method 만들기
    // SELECT * FROM supplier WHERE county IN (?, ?, ?) ORDER BY supplier_name
    List<Entity18> findByCountryInOrderBySupplierName(List<String> country);

    // SELECT * FROM supplier WHERE supplier_name LIKE :keyword ORDER BY supplier_name DESC
    List<Entity18> findBySupplierNameContainingOrderBySupplierNameDesc(String keyword);


    void deleteByCountry(String country);


    @Modifying
    @Query(value = """
            DELETE FROM Entity18 a 
            WHERE a.country = :country
            """)
    void totaldelete(String country);
}