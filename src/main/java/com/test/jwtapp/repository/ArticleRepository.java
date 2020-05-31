package com.test.jwtapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.jwtapp.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>{

	List<Article> findByTitleContainingOrContentContaining(String text, String textAgain);

	
}
