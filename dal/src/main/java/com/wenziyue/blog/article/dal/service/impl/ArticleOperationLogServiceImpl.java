package com.wenziyue.blog.article.dal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenziyue.blog.article.dal.entity.ArticleOperationLogEntity;
import com.wenziyue.blog.article.dal.mapper.ArticleOperationLogMapper;
import com.wenziyue.blog.article.dal.service.ArticleOperationLogService;
import org.springframework.stereotype.Service;

/**
 * @author wenziyue
 */
@Service
public class ArticleOperationLogServiceImpl extends ServiceImpl<ArticleOperationLogMapper, ArticleOperationLogEntity> implements ArticleOperationLogService {
}
