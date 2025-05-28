package com.example.spring.controller;

import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.StandardServletAsyncWebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class Controller02 {

    // /main2/sub1?name
    @RequestMapping(value = "/main2/sub1", params = "name")
    public void sub1(WebRequest request) {
        // header 정보 얻기
        request.getHeader("User-Agent");

        System.out.println("Controller02.sub1");
    } // ?name 없으면 메소드 제대로 실행 안 됨
    // 실행 쿼리? 라고 한다는데 ? 뒤에 나오는 거

    // /main2/sub2?name&address
    // ? : query string
    // query string : name1=value&name2=value2 <=> name&address
    @RequestMapping(value = "/main2/sub2", params = {"name", "address"})
    public void sub2(WebRequest request) {

        System.out.println("Controller02.sub2");
    }

    // /main2/sub3?name
    // /main2/sub3?name=musk -> 콘솔창에 musk 출력됨
    // /main2/sub3?name=donald -> 콘솔창에 donald 출력됨
    @RequestMapping(value = "/main2/sub3", params = "name")
    public void sub3(WebRequest request) {
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        System.out.println("Controller02.sub3");
    }

    // /main2/sub3?address
    // /main2/sub3?address=seoul -> 콘솔창에 seoul 출력
    // /main2/sub3?address=jeju -> 콘솔창에 jeju 출력
    @RequestMapping(value = "/main2/sub3", params = "address")
    public void sub4(WebRequest request) { // 옆에 WebRequest request -> 메소드 파라미터
        String address = request.getParameter("address");
        System.out.println("address = " + address);
        System.out.println("Controller02.sub4");
    }

    // @RequestParam : 해당 이름의 request parameter를 method parameter 에 binding 해줌

    // /main2/sub5?email=gmail
    @RequestMapping(value = "/main2/sub5", params = "email")
    public void sub5(@RequestParam("email") String str) {
        System.out.println("str = " + str);
        System.out.println("Controller02.sub5");
    }

    // /main2/sub6?email=gmail&age=55
    @RequestMapping(value = "/main2/sub6", params = {"email", "age"})
    public void sub6(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    // /main2/sub7?email=gmail&age=55
    @RequestMapping(value = "/main2/sub7")
    public void sub7(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    // 연습 :
    // /main2/sub7?address=jeju&country=korea&city=gangnam
    @RequestMapping(value = "/main2/sub7", params = {"address", "country", "city"})
    public void method77(@RequestParam("address") String address,
                         @RequestParam("country") String country,
                         @RequestParam("city") String city) {
        System.out.println("address = " + address);
        System.out.println("country = " + country);
        System.out.println("city = " + city);
    }

    // 위에서는 경로가 같은 메소드가 있어서 뒤에 params을 넣어줘야하는데
    // 아래는 경로 달라서 3개 이상이라도 params 생략 가능함

    // /main2/sub8?address=jeju&country=korea&city=gangnam
    @RequestMapping(value = "/main2/sub8")
    public void method8(@RequestParam("address") String address,
                        @RequestParam("country") String country,
                        @RequestParam("city") String city) {
        System.out.println("address = " + address);
        System.out.println("country = " + country);
        System.out.println("city = " + city);
    }

    // /main2/sub9?city=seoul&age=44
    @RequestMapping("/main2/sub9")
    public void method9(@RequestParam("city") String city,
                        @RequestParam("age") String age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
        int i = Integer.parseInt(age);
        System.out.println("i = " + i);
    }

    // /main2/sub10?city=seoul&age=44
    @RequestMapping("/main2/sub10")
    public void method10(@RequestParam("city") String city,
                         @RequestParam("age") int age) { // 선언을 int로 하면 알아서 파싱되어 들어간다.
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // request parameter의 이름이 method parameter와 같으면
    // @RequestParam의 value 속성을 생략해도 됨
    // /main2/sub11?city=seoul&age=44
    @RequestMapping("/main2/sub11")
    public void method11(@RequestParam String city,
                         @RequestParam int age) { // 선언을 int로 하면 알아서 파싱되어 들어간다.
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // request parameter의 이름이 method parameter와 같으면
    // @RequestParam의 value 속성을 생략해도 됨
    // @RequestParam을 생략해도 됨
    // /main2/sub12?city=seoul&age=44
    @RequestMapping("/main2/sub12")
    public void method12(String city, int age) { // 선언을 int로 하면 알아서 파싱되어 들어간다.
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // 연습 : 아래 URL로 요청올 때 적절히 처리하는 메소드 작성
    // /main2/sub13?email=gmail&score=88.8&married=true
    // /main2/sub13?score=88.8&married=true -> email 값이 null 인 상태로 출력됨
    @RequestMapping("/main2/sub13")
    public void method13(String email, double score, boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // /main2/sub14?email=gmail&score=88.8&married=true
    // /main2/sub14?score=88.8&married=true -> 동작 안 됨. email이 누락됐다고 콘솔창에 WARN(warning)하고 뜸
    @RequestMapping("/main2/sub14")// 바로 아래 (required = false) 이거 추가하면 metho13과 같게 동작함.
    public void method14(@RequestParam(required = false) String email, // 생략하면 (required = true)인 상태
                         @RequestParam(required = false) Double score, Boolean married) {
        // double이나 boolean말고 wrraper로 해야 null값을 받을 수 있어서 보통 wrraper타입으로 한대여
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // 값이 존재하지 않을 때 기본값을 줄 수 있음
    @RequestMapping("/main2/sub15")
    public void method15(@RequestParam(required = false, defaultValue = "") String email,
                         @RequestParam(required = false, defaultValue = "0.0") Double score,
                         @RequestParam(required = false, defaultValue = "false") Boolean married) {
        // 없으면 null로 들어가는 상태임 셋다. 근데 없을 때 디폴트값을 넣고 싶은 거
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // 값이 존재하지 않을 때 기본값을 줄 수 있음
    // 생략해도 -> required 는 자동으로 false로 세팅됨 // 원래는 true가 기본 값임!
    @RequestMapping("/main2/sub16")
    public void method16(@RequestParam(defaultValue = "") String email,
                         @RequestParam(defaultValue = "0.0") Double score,
                         @RequestParam(defaultValue = "false") Boolean married) {
        // 없으면 null로 들어가는 상태임 셋다. 근데 없을 때 디폴트값을 넣고 싶은 거
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // 연습 :
    // /main2/sub17?city=seoul&home=jeju&age=33
    // /main2/sub17?city=seoul&home=jeju
    // /main2/sub17?city=seoul&&age=33
    // /main2/sub17?home=jeju&age=33

    // city 기본값 ""
    // home 기본값 ""
    // age 기본값 "0"
    @RequestMapping("/main2/sub17")
    public void method17(@RequestParam(defaultValue = "") String city,
                         @RequestParam(defaultValue = "") String home,
                         @RequestParam(defaultValue = "0") Integer age) {
        System.out.println("city = " + city);
        System.out.println("home = " + home);
        System.out.println("age = " + age);
    }

    // 하나의 request parameter(요청 파라미터, 요청 변수)가 여러 값일 때 -> 배열로 받기
    // /main2/sub18?city=seoul&city=jeju&city=busan -> 3개 받아짐
    // /main2/sub18?city=seoul&city=jeju -> 2개 받아짐
    // /main2/sub18?city=seoul -> 1개 받아짐
    // /main2/sub18 -> null
    @RequestMapping("/main2/sub18")
    public void method18(String[] city) {
        System.out.println("Arrays.toString(city) = " + Arrays.toString(city));
    }

    // 하나의 request parameter(요청 파라미터, 요청 변수)가 여러 값일 때 -> 리스트로도 받을 수 있음
    // 리스트로 받을 땐 @RequestParam 필요하네용
    @RequestMapping("/main2/sub19")
    public void method19(@RequestParam(value = "city", defaultValue = "") ArrayList<String> city) {
        System.out.println("city = " + city);
    }

    // 연습 : 아래 URL로 요청올 때 일하는 메소드 완성
    // /main2/sub20?country=korean&score=90&score=80&score=70
    @RequestMapping("/main2/sub20")
    public void method20(String country, Integer[] score) {
        System.out.println("country = " + country);
        System.out.println("score = " + Arrays.toString(score));
    }

    // /main2/sub21?city=서울&email=gmail&address=신촌&age=88&score=98&married=true
    @RequestMapping("/main2/sub21")
    public void method21(
            String city,
            String email,
            String address,
            Integer age,
            Double score,
            Boolean married) {
        System.out.println("city = " + city);
        System.out.println("email = " + email);
        System.out.println("address = " + address);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // 위 아래 결과 같음!!

    // /main2/sub22?city=서울&email=gmail&address=신촌&age=88&score=98&married=true
    @RequestMapping("/main2/sub22")
    public void method22(@RequestParam Map<String, Object> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // /main2/sub23?city=서울&email=gmail&address=신촌&age=88&score=98&score=97&score=76&&married=true
    // 여러 개 값을 받고 싶을 때
    @RequestMapping("/main2/sub23")
    public void method23(@RequestParam MultiValueMap<String, Object[]> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // 다 외우는 것이 아니라 .. api 보면서 적절히 쓰면 된대여

    // 요 아래 코드는 보고 잊어도 됨요
    @RequestMapping("/main2/sub24")
    public void method24(WebRequest request) {
        Class<? extends WebRequest> a = request.getClass();
        if (request instanceof StandardServletAsyncWebRequest b) {
            Object c = b.getNativeRequest();
            System.out.println("c.getClass() = " + c.getClass());
            if (c instanceof RequestFacade d) {
                String method = d.getMethod();
                String servletPath = d.getServletPath();
                System.out.println("method = " + method);
                System.out.println("servletPath = " + servletPath);
            }

        }
        System.out.println("a = " + a);
    }
}
