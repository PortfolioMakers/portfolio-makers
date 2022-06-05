package com.example.portfolioserver.domain.member.entity;
import com.example.portfolioserver.domain.common.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Member extends BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true, length = 50, nullable = false)
    private String email;

    @Column(length = 200)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(length = 250)
    private String refreshToken;

    private LocalDateTime tokenExpirationTime;

    //TODO - 포트폴리오 테이블 ID 매핑해야함
    //TODO - Member Role 필요할지?


    @Builder
    public Member(String email, String password, String name) {
        this.email=email;
        this.password=password;
        this.name = name;
    }

    public static Member createMember(Member member){
        return Member.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .name(member.getPassword())
                .build();
    }


}
