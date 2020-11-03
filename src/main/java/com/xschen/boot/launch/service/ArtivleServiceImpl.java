package com.xschen.boot.launch.service;


import com.xschen.boot.launch.generator.mapper.ArticleMapper;
import com.xschen.boot.launch.generator.model.Article;
import com.xschen.boot.launch.model.ArticleVO;
import com.xschen.boot.launch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xschen
 */

@Service
public class ArtivleServiceImpl implements ArticleService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public void saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleMapper.insert(articlePO);

    }

    @Override
    public void deleteArtice(Long id) {
        articleMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
//        return null;
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id), ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
//        return null;
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
