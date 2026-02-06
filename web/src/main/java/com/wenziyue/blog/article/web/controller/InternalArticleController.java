package com.wenziyue.blog.article.web.controller;

import com.wenziyue.blog.article.biz.service.BizArticleService;
import com.wenziyue.blog.article.dal.dto.ArticleDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenziyue
 */
@Slf4j
@RestController
@RequestMapping("/internal/articles")
@RequiredArgsConstructor
public class InternalArticleController {

    private final BizArticleService bizArticleService;

    @GetMapping("/getArticleById/{id}")
    ArticleDTO getArticleById(@PathVariable("id") Long id) {
        try {
            return bizArticleService.getArticleDetail(id);
        } catch (Exception e) {
            log.error("获取文章{}失败", id, e);
            return null;
        }
    }

}
