package com.example.blogProject.entity;

import com.example.blogProject.entity.ArticleEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import com.example.blogProject.repository.ListRepository;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional

class ArticleEntityTest {


    @Autowired
    ListRepository repository;


    @Test
    public void testArticle(){

        ArticleEntity ar = new ArticleEntity("helloWorld");
        ArticleEntity ar2 = new ArticleEntity("helloWorld");

        ArticleEntity result = repository.save(ar);
        ArticleEntity result2 = repository.save(ar2);

       assertThat(result.getTitle()).isEqualTo(result2.getTitle());

    }



}