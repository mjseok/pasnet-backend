package com.pasnet.backend.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthId;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;


    public Member(String oauthId, String name, String email, Role role){
        this.oauthId=oauthId;
        this.name=name;
        this.email=email;
        this.role=role;
    }
    public Member update(String name,String email){
        this.name=name;
        this.email=email;
        return this;
    }
    public String getRoleKey(){
        return this.role.getKey();
    }
    public Role getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public String getOauthId() {
        return oauthId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
