package com.wenziyue.blog.article.dal.service;

import com.wenziyue.blog.article.dal.dto.ArticleDTO;
import com.wenziyue.blog.article.dal.entity.FavoritesArticleEntity;
import com.wenziyue.mybatisplus.base.PageExtendService;
import com.wenziyue.mybatisplus.page.PageRequest;
import com.wenziyue.mybatisplus.page.PageResult;

/**
 * @author wenziyue
 */
public interface FavoritesArticleService extends PageExtendService<FavoritesArticleEntity> {

    PageResult<ArticleDTO> selectFavoritesArticlePage(PageRequest dto, Long ffId, Long userId);

    void cancelFavoritesArticle(Long favoritesFolderId, Long articleId, Long userId);

    void removeByFavoritesFolderId(Long favoritesFolderId);
}
