package com.wenziyue.blog.article.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenziyue.blog.article.dal.dto.TagDTO;
import com.wenziyue.blog.article.dal.entity.ArticleTagEntity;

import java.util.List;

/**
 * @author wenziyue
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTagEntity> {

    List<TagDTO> getEnabledTags(Long id);
}
