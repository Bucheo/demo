package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.domain.Board;
import com.example.demo.model.service.AddArticleRequest;
import com.example.demo.model.service.BlogService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/article_list")
    public String article_list(Model model) {
        List<Board> list = blogService.findAll();
        model.addAttribute("articles", list);
        return "/article_list";
    }

    @GetMapping("/article_edit/{id}")
    public String article_edit(Model model, @PathVariable Long id) {
        Optional<Board> list = blogService.findById(id);
        if (list.isPresent()) {
            model.addAttribute("article", list.get());
        } else {
            return "/error_page/article_error";
        }
        return "article_edit";
    }

    @DeleteMapping("/api/article_delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/board_list";
    }

    @GetMapping("/board_list")
    public String board_list(Model model, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "") String keyword, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String email = (String) session.getAttribute("email");
        String userName = (String) session.getAttribute("userName");

        if (userId == null) {
            return "redirect:/member_login";
        }

        System.out.println("세션 userId: " + userId);
        System.out.println("세션 email: " + email);
        System.out.println("세션 userName: " + userName);

        int pageSize = 10;
        PageRequest pageable = PageRequest.of(page, pageSize);
        Page<Board> list;

        if (keyword.isEmpty()) {
            list = blogService.findAll(pageable);
        } else {
            list = blogService.searchByKeyword(keyword, pageable);
        }

        // 현재 페이지의 시작 번호를 1부터 시작하도록 수정
        int startNum = (page * pageSize) + 1;

        model.addAttribute("boards", list);
        model.addAttribute("totalPages", list.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("startNum", startNum);
        model.addAttribute("email", email);
        model.addAttribute("userName", userName);

        return "board_list";
    }

    @GetMapping("/board_write")
    public String board_write(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        String email = (String) session.getAttribute("email");
        String userName = (String) session.getAttribute("userName");

        if (userId == null) {
            return "redirect:/member_login";
        }

        model.addAttribute("email", email);
        model.addAttribute("userName", userName);

        return "board_write";
    }

    @PostMapping("/api/boards")
    public String addboards(@ModelAttribute AddArticleRequest request, HttpSession session) {
        String userName = (String) session.getAttribute("userName");

        // 현재 날짜와 시간을 "yyyy-MM-dd HH:mm" 형식으로 생성
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String currentDate = now.format(formatter);

        // 작성자와 작성일 설정
        request.setUser(userName);
        request.setNewdate(currentDate);

        System.out.println("게시글 작성 - 작성자: " + userName + ", 작성일: " + currentDate);

        blogService.save(request);
        return "redirect:/board_list";
    }

    @GetMapping("/board_view/{id}")
    public String board_view(Model model, @PathVariable Long id, HttpSession session) {
        String email = (String) session.getAttribute("email");

        Optional<Board> list = blogService.findById(id);
        if (list.isPresent()) {
            model.addAttribute("boards", list.get());
            model.addAttribute("email", email);
        } else {
            return "/error_page/article_error";
        }
        return "board_view";
    }

    @GetMapping("/board_edit/{id}")
    public String board_edit(Model model, @PathVariable Long id, HttpSession session) {
        String email = (String) session.getAttribute("email");

        Optional<Board> list = blogService.findById(id);
        if (list.isPresent()) {
            model.addAttribute("article", list.get());
            model.addAttribute("email", email);
        } else {
            return "/error_page/article_error";
        }
        return "board_edit";
    }

    @PostMapping("/api/board_edit/{id}") // PUT 대신 POST 사용
    public String updateArticle(@PathVariable Long id, @ModelAttribute AddArticleRequest request) {
        blogService.update(id, request);
        return "redirect:/board_list";
    }
}