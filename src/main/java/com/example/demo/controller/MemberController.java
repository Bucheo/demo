package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.example.demo.model.domain.Member;
import com.example.demo.model.service.AddMemberRequest;
import com.example.demo.model.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/join_new")
    public String join_new() {
        return "join_new";
    }

    @GetMapping("/join_end")
    public String join_end() {
        return "join_end";
    }

    @PostMapping("/api/members")
    public String addmembers(@ModelAttribute AddMemberRequest request) {
        memberService.saveMember(request);
        return "join_end";
    }

    @GetMapping("/member_login")
    public String member_login() {
        return "login";
    }

    @PostMapping("/api/login_check")
    public String checkMembers(@ModelAttribute AddMemberRequest request, Model model, 
                              HttpServletRequest request2, HttpServletResponse response) {
        try {
            HttpSession session = request2.getSession(false);
            if (session != null) {
                session.invalidate();
                Cookie cookie = new Cookie("JSESSIONID", null);
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            session = request2.getSession(true);

            Member member = memberService.loginCheck(request.getEmail(), request.getPassword());
            
            String email = member.getEmail();
            String userName = member.getName(); // Member 객체에서 이름 가져오기
            
            session.setAttribute("userId", email); // 이메일을 userId로 저장
            session.setAttribute("email", email); // 이메일 저장
            session.setAttribute("userName", userName); // 이름 저장
            
            model.addAttribute("member", member);

            System.out.println("로그인 성공 - 이메일: " + email + ", 이름: " + userName);

            return "redirect:/board_list";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/api/logout")
    public String member_logout(Model model, HttpServletRequest request2, HttpServletResponse response) {
        try {
            HttpSession session = request2.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            Cookie cookie = new Cookie("JSESSIONID", null);
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            
            System.out.println("로그아웃 완료");
            return "redirect:/member_login";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }
}