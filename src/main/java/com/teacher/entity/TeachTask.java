package com.teacher.entity;

import java.util.Date;

public class TeachTask {
    /**
     * 教学任务编号
     */
     private Long id;
    /**
     * 课程名称
     */
     private String courseTitle;
    /**
     * 开始时间
     */
     private Date timeBegin;
    /**
     * 结束时间
     */
     private Date timeEnd;
    /**
     * 地点
     */
     private String location;
    /**
     * 上课时间
     */
     private String classTime;
    /**
     * 学分
     */
     private Double credit;
    /**
     * 课程类型
     */
     private String courseType;
    /**
     * 附件名称
     */
    private String fileName;
    /**
     * 关联用户id
     */
     private Long userId;

    public TeachTask() {
    }

    public TeachTask(Long id, String courseTitle, Date timeBegin, Date timeEnd, String location, String classTime, Double credit, String courseType, String fileName, Long userId) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.location = location;
        this.classTime = classTime;
        this.credit = credit;
        this.courseType = courseType;
        this.fileName = fileName;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Date getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
