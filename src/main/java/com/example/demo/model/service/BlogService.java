package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 생성자 자동 생성(부분)
public class BlogService {
    // @Autowired // 객체 주입 자동화, 생성자 1개면 생략 가능
    // private final BlogRepository blogRepository; // 리포지토리 선언
    private final BoardRepository blogRepository; // 리포지토리 선언

    /*
     * public List<Article> findAll() { // 게시판 전체 목록 조회
     * return blogRepository.findAll();
     * }
     */

    // public Board save(AddArticleRequest request) {
    // return blogRepository.save(request.toEntity());
    // }

    /*
     * public Optional<Article> findById(Long id) { // 게시판 특정 글 조회
     * return blogRepository.findById(id);
     * }
     */

    // public void update(Long id, AddArticleRequest request) {
    // Optional<Board> optionalArticle = blogRepository.findById(id); // 단일 글 조회
    // optionalArticle.ifPresent(board -> { // 값이 있으면
    // board.update(request.getTitle(), request.getContent()); // 값을 수정
    // blogRepository.save(board); // Board 객체에 저장
    // });
    // }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    public List<Board> findAll() { // 게시판 전체 목록 조회
        return blogRepository.findAll();
    }

    public Optional<Board> findById(Long id) { // 게시판 특정 글 조회
        return blogRepository.findById(id);
    }

    public Board save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public Page<Board> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public Page<Board> searchByKeyword(String keyword, Pageable pageable) {
        return blogRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

    public void update(Long id, AddArticleRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    } // LIKE 검색 제공(대소문자 무시)
}