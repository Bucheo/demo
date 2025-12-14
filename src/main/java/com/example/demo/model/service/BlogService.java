package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BoardRepository blogRepository;

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    public List<Board> findAll() {
        return blogRepository.findAll();
    }

    public Optional<Board> findById(Long id) {
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

    @Transactional
    public Board update(Long id, AddArticleRequest request) {
        Board board = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        
        // 제목과 내용만 수정하고, 나머지 정보는 유지
        board.update(
            request.getTitle(),      // 새 제목
            request.getContent(),    // 새 내용
            board.getUser(),         // 기존 작성자 유지
            board.getNewdate(),      // 기존 작성일 유지
            board.getCount(),        // 기존 조회수 유지
            board.getLikec()         // 기존 좋아요 유지
        );
        
        return board;
    }
}