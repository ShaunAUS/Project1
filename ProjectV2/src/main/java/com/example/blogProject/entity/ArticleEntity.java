package com.example.blogProject.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost", length =30)
    private int cost;


    @Column(name = "title", length =50)
    private String title;

    @Column(name = "writer", length =30)
    private String writer;

    @Column(name="contents", length = 10000)
    private String content;

    @ManyToOne
    @JoinColumn(name ="MEMBER_ID")
    private Member members;


}
