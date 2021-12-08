package com.example.blogProject.service;


import com.example.blogProject.entity.ArticleEntity;
import com.example.blogProject.entity.Member;
import com.example.blogProject.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {


    @Autowired
    ListRepository repository;


    //검색
    public List<Member> search(String keyword){


        List<Member> searchResult =repository.allSearch(keyword);


        return searchResult;
    }


    //글등록
    public void register(ArticleEntity articleEntity) {

        repository.save(articleEntity);

    }




    //글 목록 전체조회
    public List<ArticleEntity> registerResult() {

        List<ArticleEntity> all = repository.findAll();

        return all;
    }
}
