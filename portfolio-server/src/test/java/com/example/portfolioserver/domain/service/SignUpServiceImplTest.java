package com.example.portfolioserver.domain.service;

import com.example.portfolioserver.domain.member.entity.Member;
import com.example.portfolioserver.domain.member.service.SignUpService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SignUpServiceImplTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Member member ;

    @BeforeAll
    void setUp(){
        member = member.builder()
                    .email("test@gmail.com")
                    .password(passwordEncoder.encode("1234"))
                    .name("test")
                    .build();

        signUpService.register(member);
    }

    @Test
    @DisplayName("패스워드 암호화 테스트")
    void passwordEncode() {

        String rawPassword = "1234";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        assertAll(
                () -> assertNotEquals(rawPassword, encodedPassword),
                () -> assertTrue(passwordEncoder.matches(rawPassword, encodedPassword))
        );
    }


    @Test
     void 사용자를_이메일로_조회한다() {
        Member member = signUpService.findMemberByEmail("test@gmail.com").orElse(null);
        assertThat(member, is(notNullValue()));

        log.info("memberInfo {} : ", member);

    }
}