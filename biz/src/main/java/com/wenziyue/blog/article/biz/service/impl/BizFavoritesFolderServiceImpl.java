package com.wenziyue.blog.article.biz.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenziyue.auth.starter.helper.AuthHelper;
import com.wenziyue.blog.article.biz.service.BizFavoritesFolderService;
import com.wenziyue.blog.article.biz.utils.IdUtils;
import com.wenziyue.blog.article.common.enums.FavoritesFolderAuthEnum;
import com.wenziyue.blog.article.common.exception.BlogResultCode;
import com.wenziyue.blog.article.common.utils.BlogUtils;
import com.wenziyue.blog.article.dal.dto.ArticleDTO;
import com.wenziyue.blog.article.dal.dto.FavoritesArticlePageDTO;
import com.wenziyue.blog.article.dal.dto.FavoritesFolderDTO;
import com.wenziyue.blog.article.dal.dto.FavoritesFolderPageDTO;
import com.wenziyue.blog.article.dal.entity.FavoritesFolderEntity;
import com.wenziyue.blog.article.dal.service.FavoritesArticleService;
import com.wenziyue.blog.article.dal.service.FavoritesFolderService;
import com.wenziyue.framework.common.CommonCode;
import com.wenziyue.framework.exception.ApiException;
import com.wenziyue.framework.utils.EnumUtils;
import com.wenziyue.mybatisplus.page.PageResult;
import com.wenziyue.uid.core.IdGen;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

/**
 * @author wenziyue
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BizFavoritesFolderServiceImpl implements BizFavoritesFolderService {

    private final FavoritesFolderService ffService;
    private final FavoritesArticleService faService;
    private final IdGen idGen;
    @Override
    public String createFavoritesFolder(FavoritesFolderDTO dto) {
        val name = BlogUtils.safeTrimEmptyIsNull(dto.getName());
        val coverUrl = BlogUtils.safeTrimEmptyIsNull(dto.getCoverUrl());
        if (name == null) {
            throw new ApiException(CommonCode.ILLEGAL_PARAMS);
        }
        val list = ffService.list(Wrappers.<FavoritesFolderEntity>lambdaQuery().eq(FavoritesFolderEntity::getName, name)
                .eq(FavoritesFolderEntity::getUserId, AuthHelper.currentUserId()));
        if (!list.isEmpty()) {
            throw new ApiException(BlogResultCode.FAVORITES_FOLDER_NAME_REPEAT);
        }
        val id = IdUtils.getID(idGen);
        ffService.save(FavoritesFolderEntity.builder()
                .id(id)
                .name(name)
                .coverUrl(coverUrl)
                .userId(Long.valueOf(AuthHelper.currentUserId()))
                .auth(EnumUtils.fromCode(FavoritesFolderAuthEnum.class, dto.getAuth()))
                .build());

        return String.valueOf(id);
    }

    @Override
    public String updateFavoritesFolder(FavoritesFolderDTO dto) {
        if (dto == null || dto.getId() == null) {
            throw new ApiException(CommonCode.ILLEGAL_PARAMS);
        }
        val oldEntity = ffService.getById(dto.getId());
        if (oldEntity == null) {
            throw new ApiException(BlogResultCode.FAVORITES_FOLDER_NOT_EXIST);
        }
        val name = BlogUtils.safeTrimEmptyIsNull(dto.getName());
        val coverUrl = BlogUtils.safeTrimEmptyIsNull(dto.getCoverUrl());
        if (name == null) {
            throw new ApiException(CommonCode.ILLEGAL_PARAMS);
        }
        val list = ffService.list(Wrappers.<FavoritesFolderEntity>lambdaQuery()
                .eq(FavoritesFolderEntity::getName, name)
                .eq(FavoritesFolderEntity::getUserId, AuthHelper.currentUserId())
                .ne(FavoritesFolderEntity::getId, dto.getId()));
        if (!list.isEmpty()) {
            throw new ApiException(BlogResultCode.FAVORITES_FOLDER_NAME_REPEAT);
        }
        oldEntity.setAuth(EnumUtils.fromCode(FavoritesFolderAuthEnum.class, dto.getAuth()));
        oldEntity.setName(name);
        oldEntity.setCoverUrl(coverUrl);
        ffService.updateById(oldEntity);
        return oldEntity.getId().toString();
    }

    @Override
    public void deleteFavoritesFolder(String id) {
        if (id == null) {
            throw new ApiException(CommonCode.ILLEGAL_PARAMS);
        }
        val oldEntity = ffService.getOne(Wrappers.<FavoritesFolderEntity>lambdaQuery()
                .eq(FavoritesFolderEntity::getId, id).eq(FavoritesFolderEntity::getUserId, AuthHelper.currentUserId()));
        if (oldEntity == null) {
            throw new ApiException(BlogResultCode.FAVORITES_FOLDER_NOT_EXIST);
        }
        ffService.removeById(id);
        // 删除对应文件夹中的收藏文章
        faService.removeByFavoritesFolderId(Long.valueOf(id));
    }

    @Override
    public PageResult<FavoritesFolderEntity> favoritesFolderPage(FavoritesFolderPageDTO dto) {
        val name = BlogUtils.safeTrimEmptyIsNull(dto.getName());
        return ffService.page(dto, Wrappers.<FavoritesFolderEntity>lambdaQuery()
                .eq(FavoritesFolderEntity::getUserId, AuthHelper.currentUserId())
                .like(name != null, FavoritesFolderEntity::getName, dto.getName()));
    }

    @Override
    public PageResult<ArticleDTO> favoritesArticlePage(FavoritesArticlePageDTO dto) {
        return faService.selectFavoritesArticlePage(dto, dto.getFavoritesFolderId(), Long.valueOf(AuthHelper.currentUserId()));
    }
}
