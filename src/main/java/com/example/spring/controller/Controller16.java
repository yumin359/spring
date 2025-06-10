package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @GetMapping("sub1")
    public String form1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerId DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        while (resultSet.next()) {
            CustomerDto customerDto = new CustomerDto();

            customerDto.setId(resultSet.getInt("CustomerId"));
            customerDto.setName(resultSet.getString("CustomerName"));
            customerDto.setAddress(resultSet.getString("Address"));
            customerDto.setCity(resultSet.getString("City"));
            customerDto.setCountry(resultSet.getString("Country"));
            customerDto.setPostalCode(resultSet.getString("PostalCode"));
            customerDto.setContactName(resultSet.getString("ContactName"));

            customerDtoList.add(customerDto);
        }
        model.addAttribute("customerDtoList", customerDtoList);

        return "main16/sub1";
    }

    @PostMapping("sub1")
    public String process(CustomerDto customer) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

//        System.out.println(customer);
        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getCity());
        statement.setString(5, customer.getPostalCode());
        statement.setString(6, customer.getCountry());

//        statement.executeQuery(); // select // 조회
        statement.executeUpdate(); // insert, delete, update

        return "redirect:/main16/sub1"; // redirect으로 두번입력되지 않도록 함
    }

    // 연습 :
    // 새 공급자 등록 로직 작성
    // handler method 2개 (get, post)
    // html 1개.
    // 새 공급자 등록 폼과 목록 조회
    @GetMapping("sub2")
    public String form2(Model model) throws Exception {
        // DB 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 공급자 목록 조회 (최근 등록순)
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierID DESC
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<SupplierDto> supplierDtoList = new ArrayList<>();
        while (resultSet.next()) {
            SupplierDto supplierDto = new SupplierDto();

            supplierDto.setId(resultSet.getInt("SupplierId"));
            supplierDto.setName(resultSet.getString("SupplierName"));
            supplierDto.setContact(resultSet.getString("ContactName"));
            supplierDto.setAddress(resultSet.getString("Address"));
            supplierDto.setCity(resultSet.getString("City"));
            supplierDto.setPostalCode(resultSet.getString("PostalCode"));
            supplierDto.setCountry(resultSet.getString("Country"));
            supplierDto.setPhone(resultSet.getString("Phone"));

            supplierDtoList.add(supplierDto);
        }
        model.addAttribute("supplierDtoList", supplierDtoList);

        return "main16/sub2";
    }

    // 공급자 등록 처리
    @PostMapping("sub2")
    public String process2(SupplierDto supplier) throws Exception {
        // DB 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 공급자 정보 DB에 삽입
        String sql = """
                INSERT INTO Suppliers
                (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, supplier.getName());
        statement.setString(2, supplier.getContact());
        statement.setString(3, supplier.getAddress());
        statement.setString(4, supplier.getCity());
        statement.setString(5, supplier.getPostalCode());
        statement.setString(6, supplier.getCountry());
        statement.setString(7, supplier.getPhone());

        statement.executeUpdate(); // delete, update, insert 에서 사용

        return "redirect:/main16/sub2";
        // 홈페이지로 리다이렉트 -> 중복 전송 방지
        // 서버가 사용자에세 이제 GET요청으로 /main16/sub2를 다시 요청하라고 보내는 것
        // 서버가 DB에 저장한 후 그대로 return "main16/sub2";로 페이지를 보여주면
        // 사용자가 새로고침(F5)하면 POST가 다시 실행되어 같은 데이터가 또 저장됨.
        // 결론적으로 중복 저장을 방지하기 위해 대부분의 post방식에서 redirect를 쓴다로 이해하면 될 듯.
        // 단순히 조회할 때는 안 써도 됨
    }

    @GetMapping("sub3")
    public String form3(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery(); // select
            if (resultSet.next()) { // 조회결과가 있을 때만
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("CustomerId"));
                customerDto.setName(resultSet.getString("CustomerName"));
                customerDto.setAddress(resultSet.getString("Address"));
                customerDto.setCity(resultSet.getString("City"));
                customerDto.setCountry(resultSet.getString("Country"));
                customerDto.setPostalCode(resultSet.getString("PostalCode"));
                customerDto.setContactName(resultSet.getString("ContactName"));

                model.addAttribute("customerDto", customerDto);
            }
        }
        return "main16/sub3";
    }

    @PostMapping("sub3")
    public String process3(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE 
                FROM Customers 
                WHERE CustomerId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate(); // delete, update, insert

        rttr.addAttribute("id", id); // query string에 붙임

        return "redirect:/main16/sub3"; // redirect : 2번째 요청을 Get방식으로 바꿈
    }

    // 연습:
    // request handler method 2개, html 1개.
    // 공급자 조회 후 삭제 로직 완성
    @GetMapping("sub4")
    public String form4(Integer id, Model model) throws Exception {
        if (id != null) {
            // 조회 후 모델 추가 -> 브라우저에 보이게 할 모델
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                SupplierDto supplierDto = new SupplierDto();

                supplierDto.setId(resultSet.getInt("SupplierID"));
                supplierDto.setName(resultSet.getString("SupplierName"));
                supplierDto.setContact(resultSet.getString("ContactName"));
                supplierDto.setAddress(resultSet.getString("Address"));
                supplierDto.setCity(resultSet.getString("City"));
                supplierDto.setPostalCode(resultSet.getString("PostalCode"));
                supplierDto.setCountry(resultSet.getString("Country"));
                supplierDto.setPhone(resultSet.getString("Phone"));

                model.addAttribute("supplierDto", supplierDto);
            }
        }
        return "main16/sub4";
    }

    // 삭제 처리
    @PostMapping("sub4")
    public String delete(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE
                FROM Suppliers
                WHERE SupplierId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        statement.executeUpdate();

        rttr.addAttribute("id", id);
        // 리다이렉트 시 데이터 전달
        // 실제 이동 URL은 /main16/sub4?id=삭제한id값 이렇게 됨
        // 삭제 작업이 끝난 후, 어떤 데이터를 삭제했는지 또는 삭제 결과를 보여주기 위해 사용

        return "redirect:/main16/sub4";
    }

    // update
    // get
    @GetMapping("sub5")
    public String form5(Model model, Integer id) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("CustomerId"));
                customerDto.setName(resultSet.getString("CustomerName"));
                customerDto.setContactName(resultSet.getString("ContactName"));
                customerDto.setAddress(resultSet.getString("Address"));
                customerDto.setCity(resultSet.getString("City"));
                customerDto.setPostalCode(resultSet.getString("PostalCode"));
                customerDto.setContactName(resultSet.getString("ContactName"));
                customerDto.setCountry(resultSet.getString("Country"));
                model.addAttribute("customerDto", customerDto);
            }
        }
        return "main16/sub5";
    }

    // post
    @PostMapping("sub5")
    public String process5(CustomerDto customerDto,
                           RedirectAttributes rttr) throws Exception {
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?
                WHERE CustomerId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customerDto.getName());
        statement.setString(2, customerDto.getContactName());
        statement.setString(3, customerDto.getAddress());
        statement.setString(4, customerDto.getCity());
        statement.setString(5, customerDto.getPostalCode());
        statement.setString(6, customerDto.getCountry());
        statement.setInt(7, customerDto.getId());
        statement.executeUpdate();

        rttr.addAttribute("id", customerDto.getId());

        return "redirect:/main16/sub5";
    }

    // 연습 :
    // request handler method 2개, html 1개
    // 공급자 정보 조회/ 수정
    @GetMapping("sub6")
    public String form6(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery(); // select에서 사용
            if (resultSet.next()) {
                SupplierDto supplierDto = new SupplierDto();

                supplierDto.setId(resultSet.getInt("SupplierId"));
                supplierDto.setName(resultSet.getString("SupplierName"));
                supplierDto.setContact(resultSet.getString("ContactName"));
                supplierDto.setAddress(resultSet.getString("Address"));
                supplierDto.setCity(resultSet.getString("City"));
                supplierDto.setPostalCode(resultSet.getString("PostalCode"));
                supplierDto.setCountry(resultSet.getString("Country"));
                supplierDto.setPhone(resultSet.getString("Phone"));

                model.addAttribute("supplierDto", supplierDto);
            }
        }
        return "main16/sub6";
    }

    @PostMapping("sub6")
    public String update(SupplierDto supplierDto, RedirectAttributes rttr) throws Exception {
        String sql = """
                UPDATE Suppliers
                SET SupplierName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?,
                    Phone = ?
                WHERE SupplierId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplierDto.getName());
        statement.setString(2, supplierDto.getContact());
        statement.setString(3, supplierDto.getAddress());
        statement.setString(4, supplierDto.getCity());
        statement.setString(5, supplierDto.getPostalCode());
        statement.setString(6, supplierDto.getCountry());
        statement.setString(7, supplierDto.getPhone());
        statement.setInt(8, supplierDto.getId());

        statement.executeUpdate(); // delete, update, insert에서 사용

        rttr.addAttribute("id", supplierDto.getId());

        return "redirect:/main16/sub6";
    }


}
