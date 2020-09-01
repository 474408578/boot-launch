package com.xschen.boot.launch.service;

import com.xschen.boot.launch.dao.testdb.ArticleRepository;
import com.xschen.boot.launch.dao.testdb.Article;
import com.xschen.boot.launch.dao.testdb2.Message;
import com.xschen.boot.launch.dao.testdb2.MessageRepository;
import com.xschen.boot.launch.model.ArticleVO;
import com.xschen.boot.launch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author xschen
 */

@Service
public class ArticleJPAServiceImpl implements ArticleService{
    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private Mapper dozerMapper;

    @Transactional
    public void saveArticle(ArticleVO articleVO) {
        Article articlePO = dozerMapper.map(articleVO, Article.class);
        articleRepository.save(articlePO);
        messageRepository.save(new Message(null, "zimug", "love studying"));
//        int a = 10 / 0;
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    public void updateArticle(ArticleVO articleVO) {
        Article articlePO = dozerMapper.map(articleVO, Article.class);
        // 更新一个对象到数据库，仍然使用save方法，实际是根据articlePO.id去update
        articleRepository.save(articlePO);
    }

    public ArticleVO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        // optional.get()有值将其返回，否则爬出NoSuchElementException
        return dozerMapper.map(article.get(), ArticleVO.class);
    }

    public List<ArticleVO> getAll() {
        List<Article> articleList = articleRepository.findAll();

        return DozerUtils.mapList(articleList, ArticleVO.class);
    }

}
