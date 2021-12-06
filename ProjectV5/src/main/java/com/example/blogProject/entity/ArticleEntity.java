package com.example.blogProject.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

    @Column(name = "memberNum", length =30)
    private String memberNum;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name ="MEMBER_ID")
    private Member members;


}
