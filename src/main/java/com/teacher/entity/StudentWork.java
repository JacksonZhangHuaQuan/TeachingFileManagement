package com.teacher.entity;

public class StudentWork {
    /**
     * 作业id
     */
    private Long id;
    /**
     * 作业类型
     */
    private String workType;
    /**
     * 学年
     */
    private String year;
    /**
     *学期时间
     */
    private String semester;
    /**
     *班级名称
     */
    private String className;
    /**
     *课程名称
     */
    private String courseTitle;
    /**
     * 附件名称
     */
    private String fileName;
    /**
     *关联用户id
     */
    private Long userId;

    public StudentWork() {
    }

    public StudentWork(Long id, String workType, String year, String semester, String className, String courseTitle, String fileName, Long userId) {
        this.id = id;
        this.workType = workType;
        this.year = year;
        this.semester = semester;
        this.className = className;
        this.courseTitle = courseTitle;
        this.fileName = fileName;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
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

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
