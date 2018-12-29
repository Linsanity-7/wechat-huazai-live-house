package com.huazai.livehouse.wechat.subscription.platform.pojo.message.resp;

import java.util.List;

/**
 * 上海美市科技有限公司开发部
 *
 * @author        :林尚华
 * @date    : 2018/12/29 15:29
 * @Description:
 */
public class NewMessage extends BaseMessage {
    /**
     * 图文消息个数，限制为10条以内
     */
    private int articleCount;
    /**
     * 多条图文消息信息，默认第一个item为大图
     */
    private List<Article> articles;

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
