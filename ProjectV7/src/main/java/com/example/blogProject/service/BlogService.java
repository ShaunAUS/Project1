package com.example.blogProject.service;


import com.example.blogProject.entity.ArticleEntity;
import com.example.blogProject.entity.Member;
import com.example.blogProject.repository.ArticleEntityRepository;
import com.example.blogProject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface BlogService {


    //맴버 검색
    List<Member> search(String keyword);


    //글등록
    void register(ArticleEntity articleEntity);

    //글 목록 전체조회
    List<ArticleEntity> registerResult();


    //urgent 게시글 검색
    List<ArticleEntity> urgentSearch(String urgentKeyword);





}
