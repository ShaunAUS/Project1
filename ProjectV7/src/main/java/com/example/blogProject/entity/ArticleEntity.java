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

    //단가
    @Column(name = "cost", length =30)
    private int cost;

    //기간
    @Column(name = "date", length =30)
    private int date;


    @Column(name = "title", length =50)
    private String title;

    @Column(name = "writer", length =30)
    private String writer;

    @Column(name = "area", length =30)
    private String area;

    @Column(name="contents", length = 10000)
    private String content;

    //인원수
    @Column(name = "memberNum", length =30)
    private String memberNum;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name ="MEMBER_ID")
    private Member members;


}
