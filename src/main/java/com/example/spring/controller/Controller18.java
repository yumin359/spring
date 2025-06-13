package com.example.spring.controller;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main18")
public class Controller18 {

    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table53
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", resultSet.getString("user"));
            map.put("money", resultSet.getInt("money"));
            list.add(map);
        }
        model.addAttribute("list", list);

        return "main18/sub1";
    }

    @PostMapping("sub2")
    public String success1(Model model) throws Exception {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;

        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
            
        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.executeUpdate();

        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement1.executeUpdate();

        return "redirect:/main18/sub1";
    }

    @PostMapping("sub3")
    public String fail1(Model model) throws Exception {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;

        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.executeUpdate();

        if (true) {
            throw new Exception("네트워크 연결 끊어짐");
        }

        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement1.executeUpdate();

        return "redirect:/main18/sub1";
    }

    @PostMapping("sub4")
    public String success2(Model model) throws Exception {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;

        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);

        PreparedStatement statement = connection.prepareStatement(sql1);
        statement.executeUpdate();

        PreparedStatement statement1 = connection.prepareStatement(sql2);
        statement1.executeUpdate();

        connection.commit();

        return "redirect:/main18/sub1";
    }

    @PostMapping("sub5")
    public String fail2(Model model) {
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'a'
                """;

        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            try (connection) { // 얘는 try-with-resources로 자원 자동 정리용임 말그대로 자원을 자동으로 닫기 위한 것
                // 그래서 .close 이런거 안 해줘도 됨.
                connection.setAutoCommit(false);
                try {
                    PreparedStatement statement = connection.prepareStatement(sql1);
                    PreparedStatement statement1 = connection.prepareStatement(sql2);

                    try (statement1; statement) { // 얘도 try-with-resources
                        statement.executeUpdate();

                        if (true) {
                            // sql1만 실행하고 일부로 오류를 발생시킴
                            throw new Exception("네트워크 오류!!");
                        }
                        // 그래서 얘는 안 일어나고
                        statement1.executeUpdate();
                    }
                    // 얘도 안 일어나고
                    connection.commit();
                } catch (Exception e) {
                    // 그래서 sql1이 실행되기 전으로 되돌림
                    connection.rollback();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/main18/sub1";
    }


    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table53
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", resultSet.getString("user"));
            map.put("money", resultSet.getInt("money"));
            list.add(map);
        }
        model.addAttribute("list", list);

        return "main18/sub6";
    }

    @PostMapping("sub7")
    public String sub7(Model model, RedirectAttributes rttr) {
        // b -> a(500원)
        // 50% 확률로 성공/실패
        String sql1 = """
                UPDATE table53
                SET money = money - 500
                WHERE user = 'b'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'a'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            try (connection) { // 자원 닫기 라서 catch 필요 X
                connection.setAutoCommit(false);

                try {
                    PreparedStatement statement1 = connection.prepareStatement(sql1);
                    PreparedStatement statement2 = connection.prepareStatement(sql2);

                    try (statement2; statement1) { // 자원 닫기 라서 catch 필요 X
                        // b의 돈 500원 차감
                        statement1.executeUpdate();

                        double random = Math.random();
                        if (random < 0.5) { // 절반 확률로 오류 일어남
                            throw new Exception("네트워크 오류");
                        }
                        // a의 돈 500원 더함
                        statement2.executeUpdate();
                        connection.commit(); // 문제 없으면 일어남
                        rttr.addFlashAttribute("message", "(b->a) 500원 송금 성공😁");
                    }
                } catch (Exception e) {
                    // 위에서 오류 일어나면 rollback 실행
                    connection.rollback();
                    rttr.addFlashAttribute("message", "(b->a) 500원 송금 실패😥");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        강사님 코드
//        try {
//
//            Connection connection = DriverManager.getConnection(url, username, password);
//            connection.setAutoCommit(false);
//            try (connection) {
//                PreparedStatement statement1 = connection.prepareStatement(sql1);
//                PreparedStatement statement2 = connection.prepareStatement(sql2);
//
//                try (statement1; statement2) {
//                    // b의 돈 500원 차감
//                    try {
//                        statement1.executeUpdate();
//
//                        double random = Math.random();
//                        if (random < 0.5) {
//                            throw new Exception("네트워크 오류");
//                        }
//
//                        // a의 돈 500원 더함
//                        statement2.executeUpdate();
//
//                        connection.commit();
//                        rttr.addFlashAttribute("message", "(b -> a) 500원 송금 성공");
//                    } catch (Exception e) {
//                        connection.rollback();
//                        rttr.addFlashAttribute("message", "(b -> a) 500원 송금 실패");
//                    }
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "redirect:/main18/sub6";
    }

    // 트랜잭션이 이런거구낭 의미를 알면 된대여 이렇게어렵게 코드를 짜진 않는대여


}











