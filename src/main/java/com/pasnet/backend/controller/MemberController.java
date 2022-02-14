package com.pasnet.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;

public class MemberController {
    @PostMapping("/members/new")
    public String create(SignupForm form){

    }
}
