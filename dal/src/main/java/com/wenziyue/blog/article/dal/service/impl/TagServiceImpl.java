package com.wenziyue.blog.article.dal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenziyue.blog.article.dal.entity.TagEntity;
import com.wenziyue.blog.article.dal.mapper.TagMapper;
import com.wenziyue.blog.article.dal.service.TagService;
import org.springframework.stereotype.Service;

/**
 * @author wenziyue
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, TagEntity> implements TagService {
}
