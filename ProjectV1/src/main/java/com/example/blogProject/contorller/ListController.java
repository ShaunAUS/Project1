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



    //디테일 페이지
    @GetMapping("/detail")
    public String detail(){

        return "detailIndex/index";
    }




}
