package com.teacher.entity;

public class Paper {
    /**
     * 论文编号
     */
    private Long id;
    /**
     *论文名称
     */
    private String title;
    /**
     *论文类型
     */
    private String paperType;
    /**
     *学期时间
     */
    private String semester;
    /**
     *班级
     */
    private String className;

    /**
     *关联用户id
     */
    private Long userId;

    public Paper() {
    }

    public Paper(String title, String paperType, String semester, String className, Long userId) {
        this.title = title;
        this.paperType = paperType;
        this.semester = semester;
        this.className = className;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
