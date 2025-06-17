package com.example.spring.repository;

import com.example.spring.entity.Entity19;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Entity19Repository extends JpaRepository<Entity19, Integer> {

    // 연습
    // SELECT * FROM product WHERE category_id = :categoryId
//    Optional<Entity19> findByCategoryId(Integer id);
    List<Entity19> findByCategoryId(Integer id); // 강사님

    // SELECT * FROM product WHERE supplier_id = :supplierId
//    Optional<Entity19> findBySupplierId(Integer id);
    List<Entity19> findBySupplierId(Integer id); // 강사님

    // SELECT * FROM product WHERE price BETWEEN :p1 AND :p2
    List<Entity19> findByPriceBetween(Double p1, Double p2);

    // SELECT * FROM product WHERE price >= :p1 AND <= :p2
    List<Entity19> findByPriceGreaterThanEqualAndPriceLessThanEqual(Double p1, Double p2);

    // SELECT * FROM product WHERE price >= :price
    List<Entity19> findByPriceGreaterThanEqual(Double price);

    // SELECT * FROM product WHERE category_id IN (?, ?, ...?)
    List<Entity19> findByCategoryIdIn(List<Integer> id);

    // SELECT * FROM product WHERE product_name LIKE :keyword
    // with wildcard
    List<Entity19> findByProductNameLike(String keyword);

    // without wildcard
    List<Entity19> findByProductNameContaining(String keyword);

    /*
    SELECT *
    FROM product
    WHERE category_id = :id
    ORDER BY price DESC
     */
    @Query(value = """
            SELECT *
            FROM product
            WHERE category_id = :id
            ORDER BY price DESC           
            """, nativeQuery = true)
    List<Entity19> query1(Integer id);

    @Query(value = """
            SELECT e
            FROM Entity19 e
            WHERE e.categoryId = :id
            ORDER BY e.price DESC            
            """)
    List<Entity19> query2(Integer id);

    // ORDER BY price ASC
    List<Entity19> findByCategoryIdOrderByPrice(Integer id);

    List<Entity19> findByCategoryIdOrderByPriceAsc(Integer id);

    // ORDER BY price DESC
    List<Entity19> findByCategoryIdOrderByPriceDesc(Integer id);

}