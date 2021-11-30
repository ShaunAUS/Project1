package com.example.blogProject.repository;

import com.example.blogProject.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class ListRepositoryTest {

    @Autowired
    private ListRepository repository;

    @Test
     void searchTest(){

        String keyword= "minjae";

        List<Member> members = repository.allSearch(keyword);

        for (Member member : members) {
            System.out.println("member = " + member.getName());
        }




    }




}