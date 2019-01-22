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
     *附件
     */
    private String fileAttachment;
    /**
     *关联用户id
     */
    private Long userId;

    public StudentWork() {
    }

    public StudentWork(String workType, String semester, String className, String courseTitle, String fileAttachment, Long userId) {
        this.workType = workType;
        this.semester = semester;
        this.className = className;
        this.courseTitle = courseTitle;
        this.fileAttachment = fileAttachment;
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

    public String getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(String fileAttachment) {
        this.fileAttachment = fileAttachment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
