package com.example.demo.model;

public class Publish {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.id
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.title
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.gmt_create
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.gmt_modified
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.creator
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private Integer creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.comment_count
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.view_count
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private Integer viewCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.like_count
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.tag
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private String tag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.description
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.id
     *
     * @return the value of publish.id
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.id
     *
     * @param id the value for publish.id
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.title
     *
     * @return the value of publish.title
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.title
     *
     * @param title the value for publish.title
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.gmt_create
     *
     * @return the value of publish.gmt_create
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.gmt_create
     *
     * @param gmtCreate the value for publish.gmt_create
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.gmt_modified
     *
     * @return the value of publish.gmt_modified
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.gmt_modified
     *
     * @param gmtModified the value for publish.gmt_modified
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.creator
     *
     * @return the value of publish.creator
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.creator
     *
     * @param creator the value for publish.creator
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.comment_count
     *
     * @return the value of publish.comment_count
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.comment_count
     *
     * @param commentCount the value for publish.comment_count
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.view_count
     *
     * @return the value of publish.view_count
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.view_count
     *
     * @param viewCount the value for publish.view_count
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.like_count
     *
     * @return the value of publish.like_count
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.like_count
     *
     * @param likeCount the value for publish.like_count
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.tag
     *
     * @return the value of publish.tag
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.tag
     *
     * @param tag the value for publish.tag
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.description
     *
     * @return the value of publish.description
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.description
     *
     * @param description the value for publish.description
     *
     * @mbg.generated Thu Apr 30 17:07:53 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}