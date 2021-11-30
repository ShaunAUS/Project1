package com.example.blogProject.contorller;


import com.example.blogProject.entity.Member;
import com.example.blogProject.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListController {

    @Autowired
     private ListRepository repository;

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


    // index 통합 검색
    @GetMapping("index/search")
    public String search(@RequestParam(value ="keyword")String keyword, Model model){


        List<Member> result =repository.allSearch(keyword);

        model.addAllAttributes(result);

        return "searchResult";
    }


    //게시판
    @GetMapping("/urgent")
    public String urgent(){

        return "urgent";
    }


    //결과 list
    @GetMapping("/list")
    public String list(){

        return "list";
    }


    //글등록
    @GetMapping("/register")
    public String register(){

        return "geulRegister";
    }

    //가입




}
