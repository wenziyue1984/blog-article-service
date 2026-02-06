package com.wenziyue.blog.article.dal.service;

import com.wenziyue.blog.article.dal.dto.ArticleDTO;
import com.wenziyue.blog.article.dal.dto.ArticlePageDTO;
import com.wenziyue.blog.article.dal.dto.FeedPageDTO;
import com.wenziyue.blog.article.dal.entity.ArticleEntity;
import com.wenziyue.mybatisplus.base.PageExtendService;
import com.wenziyue.mybatisplus.page.PageResult;

/**
 * @author wenziyue
 */
public interface ArticleService extends PageExtendService<ArticleEntity> {

    PageResult<ArticleDTO> page(ArticlePageDTO dto);

    PageResult<ArticlePageDTO> feed(FeedPageDTO dto, Long id);
}
