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
     * 学年
     */
    private String year;
    /**
     *学期时间
     */
    private String semester;
    /**
     *班级
     */
    private String className;
    /**
     * 附件名称
     */
    private String fileName;
    /**
     *关联用户id
     */
    private Long userId;

    public Paper() {
    }

    public Paper(Long id, String title, String paperType, String year, String semester, String className, String fileName, Long userId) {
        this.id = id;
        this.title = title;
        this.paperType = paperType;
        this.year = year;
        this.semester = semester;
        this.className = className;
        this.fileName = fileName;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
