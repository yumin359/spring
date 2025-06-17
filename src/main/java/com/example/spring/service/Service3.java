package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity17;
import com.example.spring.entity.Entity18;
import com.example.spring.entity.Entity19;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity17Repository;
import com.example.spring.repository.Entity18Repository;
import com.example.spring.repository.Entity19Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Service3 {

    private final Entity16Repository entity16Repository;
    private final Entity17Repository entity17Repository;
    private final Entity18Repository entity18Repository;
    private final Entity19Repository entity19Repository;

    public void action1() {
        // findById() : PK로 하나의 레코드 조회
        Entity16 entity16 = entity16Repository.findById(1).get();
        System.out.println(entity16);
    }

    public void action2() {
        // findAll() : 모든 레코드 조회 -> 리턴은 리스트
        List<Entity16> list = entity16Repository.findAll();
        System.out.println(list.size());
    }

    public void action3() {
        List<Entity17> list = entity17Repository.findAll();
        System.out.println(list.size());

        for (Entity17 entity17 : list) {
            System.out.println(entity17);
        }
    }

    public void action4(String country) {
        /*
        SELECT *
        FROM customer
        WHERE country = 'usa';
         */
        List<Entity16> data = entity16Repository.query1(country);
        System.out.println(data.size());
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action5(String city) {
        List<Entity16> data = entity16Repository.query2(city);
        System.out.println("data.size() = " + data.size());
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action6(String city1, String city2) {
        List<Entity16> data = entity16Repository.query3(city1, city2);
        System.out.println("data.size() = " + data.size());
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action7(LocalDate start, LocalDate end) {
        List<Entity17> data = entity17Repository.query1(start, end);
        System.out.println("data.size() = " + data.size());
        for (Entity17 entity17 : data) {
            System.out.println(entity17);
        }
    }

    public void action8(String keyword) {
        List<Entity16> list = entity16Repository.query4("%" + keyword + "%");
        for (Entity16 entity16 : list) {
            System.out.println(entity16);
        }
    }

    public void action9(String keyword) {
        List<Entity17> list = entity17Repository.query2("%" + keyword + "%");
        for (Entity17 entity17 : list) {
            System.out.println(entity17);
        }
    }


    public void action10(String country) {
        List<Entity16> data = entity16Repository.query5(country);
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action11(String city) {
        List<Entity16> data = entity16Repository.query6(city);
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action12(String keyword) {
        List<Entity16> data = entity16Repository.query7("%" + keyword + "%");
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action13(String keyword) {
        List<Entity17> data = entity17Repository.query3("%" + keyword + "%");
        for (Entity17 entity17 : data) {
            System.out.println(entity17);
        }
    }

    public void action14(String country) {
        // 직접 만든 메소드
        List<Entity16> data = entity16Repository.findByCountry(country);
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action15(String city) {
        List<Entity16> list = entity16Repository.findByCity(city);
        for (Entity16 entity16 : list) {
            System.out.println(entity16);
        }
    }

    public void action16(LocalDate start, LocalDate end) {
        List<Entity17> list = entity17Repository.findByBirthDateBetween(start, end);
        for (Entity17 entity17 : list) {
            System.out.println(entity17);
        }
    }

    public void action17() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
        List<Entity18> uk = entity18Repository.findByCountry("uk");
        for (Entity18 entity18 : uk) {
            System.out.println(entity18);
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
        List<Entity18> osaka = entity18Repository.findByCity("osaka");
        for (Entity18 entity18 : osaka) {
            System.out.println(entity18);
        }

        System.out.println("#################################");
        List<Entity18> byCountryIn = entity18Repository.findByCountryIn(List.of("usa", "japan"));
        for (Entity18 entity18 : byCountryIn) {
            System.out.println(entity18);
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        List<Entity18> list4 = entity18Repository.findBySupplierNameLike("%an%");
        for (Entity18 entity18 : list4) {
            System.out.println(entity18);
        }

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        List<Entity18> list5 = entity18Repository.findBySupplierNameContains("an");
        for (Entity18 entity18 : list5) {
            System.out.println(entity18);
        }

    }

    public void action18() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Entity19> list1 = entity19Repository.findByCategoryId(3);
        for (Entity19 entity19 : list1) {
            System.out.println(entity19);
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        List<Entity19> list2 = entity19Repository.findBySupplierId(3);
        for (Entity19 entity19 : list2) {
            System.out.println(entity19);
        }

        System.out.println("#############################");
        List<Entity19> list3 = entity19Repository.findByPriceBetween(50.00, 100.00);
        for (Entity19 entity19 : list3) {
            System.out.println(entity19);
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        List<Entity19> list4 = entity19Repository.findByPriceGreaterThanEqualAndPriceLessThanEqual(100.00, 200.00);
        for (Entity19 entity19 : list4) {
            System.out.println(entity19);
        }

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        List<Entity19> list5 = entity19Repository.findByPriceGreaterThanEqual(200.00);
        for (Entity19 entity19 : list5) {
            System.out.println(entity19);
        }

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        List<Entity19> list6 = entity19Repository.findByCategoryIdIn(List.of(6, 7));
        for (Entity19 entity19 : list6) {
            System.out.println(entity19);
        }

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        List<Entity19> list7 = entity19Repository.findByProductNameLike("%an%");
        for (Entity19 entity19 : list7) {
            System.out.println(entity19);
        }

        System.out.println("*********************************");
        List<Entity19> list8 = entity19Repository.findByProductNameContaining("an");
        for (Entity19 entity19 : list8) {
            System.out.println(entity19);
        }
    }

    public void action19() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Entity19> list1 = entity19Repository.query1(6);
        for (Entity19 entity19 : list1) {
            System.out.println(entity19);
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        List<Entity19> list2 = entity19Repository.query2(5);
        for (Entity19 entity19 : list2) {
            System.out.println(entity19);
        }

        System.out.println("############################");
        List<Entity19> list3 = entity19Repository.findByCategoryIdOrderByPrice(4);
        for (Entity19 entity19 : list3) {
            System.out.println(entity19);
        }

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        List<Entity19> list4 = entity19Repository.findByCategoryIdOrderByPriceAsc(3);
        for (Entity19 entity19 : list4) {
            System.out.println(entity19);
        }

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        List<Entity19> list5 = entity19Repository.findByCategoryIdOrderByPriceDesc(2);
        for (Entity19 entity19 : list5) {
            System.out.println(entity19);
        }
    }

    public void action20() {
        List<Entity18> list1 = entity18Repository.findByCountryInOrderBySupplierName(List.of("japan", "uk"));
        for (Entity18 entity18 : list1) {
            System.out.println(entity18);
        }
        System.out.println();
        List<Entity18> list2 = entity18Repository.findBySupplierNameContainingOrderBySupplierNameDesc("er");
        for (Entity18 entity18 : list2) {
            System.out.println(entity18);
        }
    }
}
