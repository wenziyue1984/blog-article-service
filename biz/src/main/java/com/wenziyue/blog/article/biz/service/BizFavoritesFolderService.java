package com.wenziyue.blog.article.biz.service;

import com.wenziyue.blog.article.dal.dto.ArticleDTO;
import com.wenziyue.blog.article.dal.dto.FavoritesArticlePageDTO;
import com.wenziyue.blog.article.dal.dto.FavoritesFolderDTO;
import com.wenziyue.blog.article.dal.dto.FavoritesFolderPageDTO;
import com.wenziyue.blog.article.dal.entity.FavoritesFolderEntity;
import com.wenziyue.mybatisplus.page.PageResult;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wenziyue
 */
public interface BizFavoritesFolderService {
    @Transactional
    String createFavoritesFolder(FavoritesFolderDTO dto);

    @Transactional
    String updateFavoritesFolder(FavoritesFolderDTO dto);

    @Transactional
    void deleteFavoritesFolder(String id);

    @Transactional(readOnly = true)
    PageResult<FavoritesFolderEntity> favoritesFolderPage(FavoritesFolderPageDTO dto);

    @Transactional(readOnly = true)
    PageResult<ArticleDTO> favoritesArticlePage(FavoritesArticlePageDTO dto);
}
