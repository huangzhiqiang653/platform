package com.platform.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 测试生成代码表实体
 * 表名 runoob_tbl
 *
 * @author huangzhiqiang
 * @date 2019-01-19 20:46:46
 */
public class RunoobTblEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 标题
     */
    private String runoobTitle;
    /**
     * 作者
     */
    private String runoobAuthor;
    /**
     * 时间
     */
    private Date submissionDate;

    /**
     * 设置：主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public String getId() {
        return id;
    }
    /**
     * 设置：标题
     */
    public void setRunoobTitle(String runoobTitle) {
        this.runoobTitle = runoobTitle;
    }

    /**
     * 获取：标题
     */
    public String getRunoobTitle() {
        return runoobTitle;
    }
    /**
     * 设置：作者
     */
    public void setRunoobAuthor(String runoobAuthor) {
        this.runoobAuthor = runoobAuthor;
    }

    /**
     * 获取：作者
     */
    public String getRunoobAuthor() {
        return runoobAuthor;
    }
    /**
     * 设置：时间
     */
    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    /**
     * 获取：时间
     */
    public Date getSubmissionDate() {
        return submissionDate;
    }
}
