package com.greengrow.backend.service.impl;

import com.greengrow.backend.model.Article;
import com.greengrow.backend.repository.ArticleRepository;
import com.greengrow.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the ArticleService interface that interacts with the ArticleRepository.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }
}

