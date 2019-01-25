package com.teacher.entity;

public class Grade {
    /**
     * 成绩表id
     */
    private Long id;
    /**
     * 学期时间
     */
    private String semester;
    /**
     * 教学班级
     */
    private String teachClass;
    /**
     * 课程名称
     */
    private String courseTitle;
    /**
     * 关联用户id
     */
    private Long userId;

    public Grade() {
    }

    public Grade(String semester, String teachClass, String courseTitle, Long userId) {
        this.semester = semester;
        this.teachClass = teachClass;
        this.courseTitle = courseTitle;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTeachClass() {
        return teachClass;
    }

    public void setTeachClass(String teachClass) {
        this.teachClass = teachClass;
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
}
