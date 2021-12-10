package com.example.blogProject.service;


import com.example.blogProject.entity.ArticleEntity;
import com.example.blogProject.entity.Member;
import com.example.blogProject.repository.ArticleEntityRepository;
import com.example.blogProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements BlogService{



    //생성자 주입
    /*private final ArticleEntityRepository repository;

    private final MemberRepository mrepository;

    public BlogServiceImpl( ArticleEntityRepository repository,MemberRepository mrepository) {
        this.repository = repository;
        this.mrepository = mrepository;
    }*/



    @Autowired
    ArticleEntityRepository repository;
    
    @Autowired
    MemberRepository mrepository;


    //맴버 검색
    @Override
    public List<Member> search(String keyword){

        List<Member> searchResult =mrepository.allSearch(keyword);

        return searchResult;
    }



    //글등록
    @Override
    public void register(ArticleEntity articleEntity) {

        repository.save(articleEntity);

    }




    //글 목록 전체조회
    @Override
    public List<ArticleEntity> registerResult() {

        List<ArticleEntity> all = repository.findAll();

        return all;
    }

    //urgent 게시글 검색
    @Override
    public List<ArticleEntity> urgentSearch(String urgentKeyword) {

        List<ArticleEntity> result= repository.urgentSearch(urgentKeyword);

        return result;
    }
}
