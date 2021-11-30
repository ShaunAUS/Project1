package com.example.blogProject.repository;

import com.example.blogProject.entity.ArticleEntity;
import com.example.blogProject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ListRepository extends JpaRepository<ArticleEntity,Long> {



    //index  통합검색
    @Query(value ="Select m Member m where m.name Like %?1%")
    List<Member> allSearch(@Param(value="keyword")String keyword);



}
