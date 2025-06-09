package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.ProductDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {

    // paging

    @GetMapping("sub1")
    public String sub1(@RequestParam(defaultValue = "1") Integer page,
                       Model model) throws SQLException {
        // 한 페이지에 10개씩
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, ? 
                """;
        // 총 고객수를 구하는 하위쿼리가 필요함.
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        // offset : (page - 1) * 10
//        statement.setInt(1, 0); // 1page
//        statement.setInt(1, 10); // 2page
//        statement.setInt(1, 20); // 3page
        int offset = (page - 1) * 10;
        statement.setInt(1, offset);
        statement.setInt(2, 10);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count"); // 총 고객수
        int lastPage = (count - 1) / 10 + 1; // 마지막 페이지 번호

        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs.next()) {
            CustomerDto customer = new CustomerDto();
            customer.setId(rs.getInt("CustomerID"));
            customer.setName(rs.getString("CustomerName"));
            customer.setAddress(rs.getString("Address"));
            customer.setCountry(rs.getString("Country"));
            customer.setCity(rs.getString("City"));
            customer.setPostalCode(rs.getString("PostalCode"));
            customer.setContactName(rs.getString("ContactName"));
            list.add(customer);
        }
        model.addAttribute("customerList", list);

        return "main15/sub1";
    }

    // 연습 :
    // 한 페이지에 5개의 공급자가 출력되도록 코드 작성(정렬은 공급자 번호순)
    // request handler method, html
    @GetMapping("sub2")
    public String sub2(@RequestParam(defaultValue = "1") Integer page,
                       Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierID
                LIMIT ?, ?
                """;

        String countSql = """
                SELECT COUNT(*) AS count
                FROM Suppliers
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        int offset = (page - 1) * 5;
        statement.setInt(1, offset);
        statement.setInt(2, 5);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count");
        int lastPage = (count - 1) / 5 + 1;
        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<SupplierDto> list = new ArrayList<>();
        while (rs.next()) {
            SupplierDto supplier = new SupplierDto();

            supplier.setId(rs.getInt("SupplierID"));
            supplier.setName(rs.getString("SupplierName"));
            supplier.setAddress(rs.getString("Address"));
            supplier.setCountry(rs.getString("Country"));
            supplier.setCity(rs.getString("City"));
            supplier.setPostalCode(rs.getString("PostalCode"));
            supplier.setPhone(rs.getString("Phone"));
            supplier.setContact(rs.getString("ContactName"));

            list.add(supplier);
        }
        model.addAttribute("supplierList", list);

        return "main15/sub2";
    }

    // 검색 + 페이징
    @GetMapping("sub3")
    public String sub3(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "") String keyword,
            Model model) throws Exception {

        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                WHERE CustomerName LIKE ? 
                    OR ContactName LIKE ?
                """;

        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ? 
                    OR ContactName LIKE ?
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement countStatement = connection.prepareStatement(countSql);
        countStatement.setString(1, "%" + keyword + "%");
        countStatement.setString(2, "%" + keyword + "%");

        PreparedStatement selectStatement = connection.prepareStatement(sql);
        selectStatement.setString(1, "%" + keyword + "%");
        selectStatement.setString(2, "%" + keyword + "%");

        int offset = (page - 1) * 5;
        selectStatement.setInt(3, offset);
        selectStatement.setInt(4, 5);

        ResultSet rs1 = countStatement.executeQuery();
        rs1.next();
        int count = rs1.getInt("count");
        int lastPage = (count - 1) / 5 + 1; // 마지막 페이지
        int rightPage = ((page - 1) / 10 + 1) * 10; // 오른쪽 페이지 // 2330이 마지막
        int leftPage = rightPage - 9; // 왼쪽 페이지

        int prevPage = leftPage - 10;
        int nextPage = rightPage + 1;

        rightPage = Math.min(rightPage, lastPage); // 오른쪽 페이지번호는 마지막보다 클 수 없음

        model.addAttribute("lastPage", lastPage);
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);

        ResultSet rs2 = selectStatement.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs2.next()) {
            CustomerDto customer = new CustomerDto();

            customer.setId(rs2.getInt("CustomerID"));
            customer.setName(rs2.getString("CustomerName"));
            customer.setContactName(rs2.getString("ContactName"));
            customer.setAddress(rs2.getString("Address"));
            customer.setCity(rs2.getString("City"));
            customer.setPostalCode(rs2.getString("PostalCode"));
            customer.setCountry(rs2.getString("Country"));

            list.add(customer);
        }
        model.addAttribute("customerList", list);

        return "main15/sub3";
    }

    // 연습
    // 상품명 조회 로직 작성 (w/ paging)
    @GetMapping("sub4")
    public String sub4(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "") String keyword,
                       Model model) throws Exception {
        // 데이터 베이스 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 총 데이터 개수 조회 쿼리
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Products
                WHERE ProductName LIKE ?
                """;
        PreparedStatement countStatement = connection.prepareStatement(countSql);
        countStatement.setString(1, "%" + keyword + "%");
        ResultSet rs1 = countStatement.executeQuery();
        rs1.next();
        int count = rs1.getInt("count"); // 총 레코드 수

        // 페이징 정보 계산
        int lastPage = (count - 1) / 5 + 1; // 마지막 페이지 // 493이 마지막
        int rightPage = ((page - 1) / 10 + 1) * 10; // 오른쪽 페이지번호
        int leftPage = rightPage - 9; // 왼쪽 페이지 번호
        int prevPage = leftPage - 10; // 이전 누르면 이동할 페이지 번호
        int nextPage = rightPage + 1; // 다음 누르면 이동할 페이지 번호
        rightPage = Math.min(rightPage, lastPage); // 오른쪽 페이지 번호는 마지막보다 클 수 없음.

        // 첫번째 페이지는 그냥 1로 설정하면 될듯
        // 마지막 페이지는 lastPage로 이동하면 될듯

        // 페이징 관련 정보 모델에 담기
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);

        // 실제 데이터 조회 쿼리 (물음표 인덱스는 위에부터 왼->오 순으로 오른차순)
        String sql = """
                SELECT *
                FROM Products
                WHERE ProductName LIKE ?
                ORDER BY ProductID
                LIMIT ?, ?
                """;
        PreparedStatement selectStatement = connection.prepareStatement(sql);
        selectStatement.setString(1, "%" + keyword + "%");
        int offset = (page - 1) * 5; // 시작 인덱스
        selectStatement.setInt(2, offset);
        selectStatement.setInt(3, 5); // 한 페이지에 5개씩 조회

        // 결과 처리
        ResultSet rs2 = selectStatement.executeQuery();
        List<ProductDto> list = new ArrayList<>();
        while (rs2.next()) {
            ProductDto product = new ProductDto();

            product.setId(rs2.getInt("ProductID"));
            product.setName(rs2.getString("ProductName"));
            product.setSupplierId(rs2.getInt("SupplierID"));
            product.setCategoryId(rs2.getInt("CategoryID"));
            product.setUnit(rs2.getString("Unit"));
            product.setPrice(rs2.getDouble("Price"));

            list.add(product);
        }
        // 조회된 데이터 모델에 담기
        model.addAttribute("productList", list);
        // 뷰 반환
        return "main15/sub4";
    }
}
