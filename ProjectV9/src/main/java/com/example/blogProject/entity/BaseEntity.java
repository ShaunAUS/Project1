package com.example.blogProject.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EntityListeners(value={AuditingEntityListener.class})
abstract class BaseEntity {


    @CreatedDate
    @Column(name ="regdate")
    private LocalDateTime regDate;

    @LastModifiedBy
    @Column(name="moddate")
    private LocalDateTime modDate;




}
