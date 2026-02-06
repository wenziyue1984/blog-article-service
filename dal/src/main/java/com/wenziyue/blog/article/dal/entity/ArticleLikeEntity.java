package com.wenziyue.blog.article.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wenziyue.blog.article.common.enums.LikeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wenziyue
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("TB_WZY_BLOG_ARTICLE_LIKE")
public class ArticleLikeEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("article_id")
    private Long articleId;

    @TableField("user_id")
    private Long userId;

    @TableField( "time")
    private Long time;

    @TableField("type")
    private LikeTypeEnum type;
}
