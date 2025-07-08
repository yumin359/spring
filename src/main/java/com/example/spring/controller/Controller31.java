package com.example.spring.controller;

import com.example.spring.dto.MyBean311;
import com.example.spring.dto.MyBean312;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@ResponseBody
@RequestMapping("/api/main31")
public class Controller31 {

    @PostMapping("sub1")
    public String sub1(
            @RequestParam("name") String name, // RP 생략 가능, 이름 같아서
            @RequestParam("age") Integer age,
            @RequestParam("myFiles[]") MultipartFile[] file) { // 얜 이름 달라서 생략하면 안됨
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        if (file != null && file.length > 0) {
            for (MultipartFile file1 : file) {
                System.out.println("file1.getOriginalFilename() = " + file1.getOriginalFilename());
                System.out.println("file1.getSize() = " + file1.getSize());
            }
        }
        return null;
    }

    @PostMapping("sub2")
    public String sub2(String address, Double score,
                       @RequestParam("yourFiles[]") MultipartFile[] files) {
        System.out.println("address = " + address);
        System.out.println("score = " + score);
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
                System.out.println("file.getSize() = " + file.getSize());
            }
        }
        return null;
    }

    // 연습 : react 에 세번째 버튼 클릭 시 이 request handler method가 실행되도록 코드 작성
    // multiple file 전손
    @PostMapping("sub3")
    public String sub3(String city,
                       @RequestParam("uploadFiles[]") MultipartFile[] files) {
        System.out.println("city = " + city);
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
                System.out.println("file.getSize() = " + file.getSize());
            }
        }
        return null;
    }

    @PostMapping("sub4")
    public String sub4(MyBean311 dto) {
        System.out.println("dto.getId() = " + dto.getId());
        System.out.println("dto.getAddress() = " + dto.getAddress());
        System.out.println("dto.getUserName() = " + dto.getUserName());
        MultipartFile[] uploadFiles = dto.getUploadFiles();
        if (uploadFiles != null && uploadFiles.length > 0) {
            for (MultipartFile file : uploadFiles) {
                System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
                System.out.println("file.getSize() = " + file.getSize());
            }
        }
        return null;
    }

    // 연습 : post /api/main31/sub5의 요청을 다루는 메소드 만들기
    // request parameters 는 dto(MyBean312) 받기
    @PostMapping("sub5")
    public String sub5(MyBean312 dto) {
        System.out.println("dto.getScore() = " + dto.getScore());
        System.out.println("dto.getClassName() = " + dto.getClassName());
        System.out.println("dto.getLocation() = " + dto.getLocation());
        MultipartFile[] uploadFiles = dto.getUploads();
        if (uploadFiles != null && uploadFiles.length > 0) {
            for (MultipartFile file : uploadFiles) {
                System.out.println("file.getOriginalFilename() = " + file.getOriginalFilename());
                System.out.println("file.getSize() = " + file.getSize());
            }
        }
        return null;
    }
}
