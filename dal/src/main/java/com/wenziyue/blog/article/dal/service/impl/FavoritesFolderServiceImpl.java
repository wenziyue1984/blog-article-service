package com.wenziyue.blog.article.dal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenziyue.blog.article.dal.entity.FavoritesFolderEntity;
import com.wenziyue.blog.article.dal.mapper.FavoritesFolderMapper;
import com.wenziyue.blog.article.dal.service.FavoritesFolderService;
import org.springframework.stereotype.Service;

/**
 * @author wenziyue
 */
@Service
public class FavoritesFolderServiceImpl extends ServiceImpl<FavoritesFolderMapper, FavoritesFolderEntity> implements FavoritesFolderService {
}
