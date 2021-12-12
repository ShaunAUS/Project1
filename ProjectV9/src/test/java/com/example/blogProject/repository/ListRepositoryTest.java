package com.example.blogProject.repository;

import com.example.blogProject.entity.ArticleEntity;
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

     //urgent 게시글 검색 테스트(내용)
     @Test
     void searchUrgent(){

         List<ArticleEntity> urgentSearchResult = repository.urgentSearch("내용2");

         for (ArticleEntity articleEntity : urgentSearchResult) {
             System.out.println("articleEntity.getContent() = " + articleEntity.getContent());
         }
         
     }






}