package com.example.blogProject.repository;

import com.example.blogProject.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
class ListRepositoryTest {

    @Autowired
    ArticleEntityRepository repository;

    @Autowired
    MemberRepository mrepository;


    //검색 테스트
    //이름으로 검색
    @Test
     void searchTest(){

        String keyword= "minjae";

        List<Member> members = mrepository.allSearch(keyword);

        for (Member member : members) {
            System.out.println("member = " + member.getName());
        }

    }

    //검색 테스트
    //기술로 검색
     @Test
     void searchTestbyTech(){

            List<Member> result = mrepository.allSearch("kotlyn");

            for (Member member : result) {
                System.out.println("result = " + member.getSkills());
            }


        }









}