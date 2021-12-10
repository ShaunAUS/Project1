package com.example.blogProject.service;

import com.example.blogProject.entity.Member;
import com.example.blogProject.repository.ArticleEntityRepository;
import com.example.blogProject.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class BlogServiceTest {


    @Autowired
    ArticleEntityRepository repository;

    @Autowired
    MemberRepository mrepository;




    //맴버 검색 테스트
    @Test
    public void serviceTest(){

        List<Member> minjae = mrepository.allSearch("minjae");

        for (Member member : minjae) {
            System.out.println("member.getName() = " + member.getName());
        }

    }

}