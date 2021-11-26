package com.example.blogProject.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name",length =100)
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="location")
    private String location;

    @Column (name = "sex")
    private String sex;

    @OneToMany(mappedBy = "members")
    private List<ArticleEntity> articles = new ArrayList<ArticleEntity>();

}
