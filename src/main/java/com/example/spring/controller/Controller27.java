package com.example.spring.controller;

import com.example.spring.service.Service9;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("main27")
@RequiredArgsConstructor
public class Controller27 {

    private final Service9 service9;

    @GetMapping("sub1")
    public String sub1() { // sub1.html 보이는 거당
        return "main27/sub1";
    }

    @PostMapping("sub1")
    public String post1(String username, MultipartFile upload) {
        service9.action1(username, upload);

        return "main27/sub1";
    }


    @PostMapping("sub2")
    public String post2(String username,
                        @RequestParam(name = "uploadFile", required = false)
                        MultipartFile upload) {
        service9.action2(username, upload);
        return "main27/sub2";
    }

    @PostMapping("sub3")
    public String post3(MultipartFile[] upload) {
        service9.action3(upload);
        return "main27/sub3";
    }

}
