package com.example.blogProject.contorller;


import com.example.blogProject.entity.ArticleEntity;
import com.example.blogProject.entity.Member;
import com.example.blogProject.repository.ListRepository;
import com.example.blogProject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListController {

    @Autowired
     private ListRepository repository;


    @Autowired
    Service service;

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
    @GetMapping("/search")
    public String search(@RequestParam(value ="keyword")String keyword, Model model){


        List<Member> result =service.search(keyword);



        model.addAttribute("searchResult",result);

        return "list";
    }







    //게시판 index
    @GetMapping("/urgent")
    public String urgent(Model model){

        //전체 목록조회
        List<ArticleEntity> regResult = service.registerResult();

        model.addAttribute("regResult",regResult);

        return "urgent";
    }




    //글등록 index
    @GetMapping("/register")
    public String register(){

        return "geulRegister";
    }


    //글등록
    @PostMapping("/geulRegister")
    public String geulRegister(@ModelAttribute ArticleEntity articleEntity,Model model){

        service.register(articleEntity);

        //등록후 다시 전체 목록조회
        List<ArticleEntity> regResult = service.registerResult();

        model.addAttribute("regResult2",regResult);

        return "urgent2";

    }

    //가입




}
