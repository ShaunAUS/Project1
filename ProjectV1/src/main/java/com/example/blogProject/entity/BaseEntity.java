package com.example.blogProject.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {


    @CreatedDate
    @Column(name = "regdate")
    private LocalDateTime regDate;

    @LastModifiedBy
    @Column(name="moddate")
    private LocalDateTime modDate;




}
