package com.example.blogProject.repository;

import com.example.blogProject.entity.ArticleEntity;
import com.example.blogProject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ArticleEntityRepository extends JpaRepository<ArticleEntity,Long> {


    // urgent 검색(내용)
    @Query(value="select a from ArticleEntity a where a.content Like %:urgentKeyword% ")
    List<ArticleEntity> urgentSearch(@Param(value="urgentKeyword")String urgentKeyword);

}
