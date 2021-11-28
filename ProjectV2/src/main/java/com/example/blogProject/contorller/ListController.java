package com.example.blogProject.contorller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    //인덱스
    @GetMapping("/")
    public String pageIndex(){

        return "index";
    }



    //디테일 페이지 테스트
    @GetMapping("/detail")
    public String detail(){

        return "detailIndex/index";
    }


    // 검색
    @GetMapping("/searchResult")
    public String search(){

        return "searchResult";
    }


    @GetMapping("/urgent")
    public String urgent(){

        return "urgent";
    }

    @GetMapping("/list")
    public String list(){

        return "list";
    }

    @GetMapping("/register")
    public String register(){

        return "geulRegister";
    }





}
