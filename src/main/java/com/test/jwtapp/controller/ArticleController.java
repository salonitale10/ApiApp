package com.test.jwtapp.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.RestController;

import com.test.jwtapp.model.Article;
import com.test.jwtapp.repository.ArticleRepository;

@RestController
public class ArticleController {

	
	final
    private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/article")
    public List<Article> index(){
    
       return articleRepository.findAll();
    	 }

    @GetMapping("/article/{id}")
    public Article show(@PathVariable String id){
        int articleId = Integer.parseInt(id);
        return articleRepository.findById(articleId).orElse(new Article());
    }

    
    @PostMapping("/article")
    public ResponseEntity<String> create(@RequestBody Map<String, String> body){
        String title = body.get("title");
        String content = body.get("content");
        String author =body.get("author");
        
        articleRepository.save(new Article(title, content,author));
        
        return new ResponseEntity<>("new article created",HttpStatus.CREATED);
        }

	
}
