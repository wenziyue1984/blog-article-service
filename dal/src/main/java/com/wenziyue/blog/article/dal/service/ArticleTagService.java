package com.wenziyue.blog.article.dal.service;

import com.wenziyue.blog.article.dal.dto.TagDTO;
import com.wenziyue.blog.article.dal.entity.ArticleTagEntity;
import com.wenziyue.mybatisplus.base.PageExtendService;

import java.util.List;

/**
 * @author wenziyue
 */
public interface ArticleTagService extends PageExtendService<ArticleTagEntity> {
    List<TagDTO> getEnabledTags(Long id);
}
