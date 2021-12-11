package com.example.blogProject.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",length =100)
    private String name;

    @Column(name="age")
    private int age;

    @Column(name = "cost", length =30)
    private int cost;

    //기술
    @Column(name="skills")
    private String skills;

    //경력
    @Column (name = "experience")
    private int experience;

    //멤버 하나가 여러개의 글을 쓴다
    @OneToMany(mappedBy = "members")
    private List<ArticleEntity> articles = new ArrayList<ArticleEntity>();

}
