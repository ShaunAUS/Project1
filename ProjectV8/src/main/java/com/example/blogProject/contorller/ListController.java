package com.example.blogProject.contorller;


import com.example.blogProject.entity.ArticleEntity;
import com.example.blogProject.entity.Member;
import com.example.blogProject.service.BlogService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ListController {


    //생성자 주입
    /*private  BlogService service;


    public ListController( BlogService service) {
        this.service = service;
    }*/

    private final BlogService service;

    //인덱스
    @GetMapping("/")
    public String pageIndex(Model model){

        List<Member> members = service.indexSearch();
        model.addAttribute("memberIndex",members);


        return "index";
    }



    //디테일 페이지 테스트
    @GetMapping("/detail")
    public String detail(@RequestParam(value = "memberId")String memberId , Model model){


        System.out.println(memberId);


        return "detailIndex/index";
    }






    // index 통합  멤버 검색
    @GetMapping("/search")
    public String search(@RequestParam(value ="keyword")String keyword, Model model){


        List<Member> result =service.search(keyword);

        model.addAttribute("searchResult",result);

        return "memberResult";
    }


    //urgent 게시글 검색
    @GetMapping("/urgentSearch")
    public String urgentSearch(@RequestParam("urgentKeyword")String urgentKeyword,Model model){

        List<ArticleEntity> urgentSearchResult =service.urgentSearch(urgentKeyword);

        model.addAttribute("usr",urgentSearchResult);

        return "urgentSearchResult";

    }














    //게시판 index
    @GetMapping("/urgent")
    public String urgent(@NotNull Model model){

        //전체 목록조회
        List<ArticleEntity> regResult = service.registerResult();

        model.addAttribute("regResult",regResult);

        return "urgent";
    }


    //글등록 index
    @GetMapping("/register")  //url
    public String register(){

        return "geulRegister"; //화면
    }


    //글등록
    @PostMapping("/geulRegister")
    public String geulRegister(@ModelAttribute ArticleEntity articleEntity, @NotNull Model model){

        service.register(articleEntity);

        //등록후 다시 전체 목록조회
        List<ArticleEntity> regResult = service.registerResult();

        model.addAttribute("regResult",regResult);

        return "redirect:/urgent";   //리다이렉트??

    }

    //가입




}
