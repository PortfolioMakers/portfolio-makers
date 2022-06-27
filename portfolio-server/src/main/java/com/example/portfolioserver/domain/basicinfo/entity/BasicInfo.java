package com.example.portfolioserver.domain.basicinfo.entity;

import com.example.portfolioserver.domain.base.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class BasicInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String mobile;

    @Builder
    public BasicInfo(Long id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public void edit(String email, String mobile, String name) {
        this.email = email;
        this.mobile = mobile;
        this.name = name;
    }
}
