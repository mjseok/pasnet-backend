package com.pasnet.backend.domain.user.repository;

import com.pasnet.backend.domain.user.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("Member 생성")
    @Test
    void createTest() {
        //given
        String name = "이름";
        String email = "pasnet@pasnet.com";
        String password = "password";

        // when
        // TODO: security 도입 후에는 PasswordEncoder 사용해야 함.
        Member member = new Member(name, email, password);
        memberRepository.save(member);

        // then
        Optional<Member> byEmail = memberRepository.findByEmail(member.getEmail());
        assertThat(byEmail).isNotEmpty();

        Member found = byEmail.get();
        assertThat(found).isEqualTo(member);
        assertThat(found.getEmail()).isEqualTo(email);
        assertThat(found.getName()).isEqualTo(name);
        assertThat(found.getPassword()).isEqualTo(password);
    }
}