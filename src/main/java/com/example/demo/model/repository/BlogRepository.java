package com.example.demo.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.domain.Article;

@Repository // 리포지토리 등록
public interface BlogRepository extends JpaRepository<Article, Long> {
    Article findByTitle(String title);

    
}