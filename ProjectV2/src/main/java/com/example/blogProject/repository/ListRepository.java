package com.example.blogProject.repository;

import com.example.blogProject.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ListRepository extends JpaRepository<ArticleEntity,Long> {



}
