package com.teacher.entity;

import java.sql.Date;

public class UserInfo {
    /**
     * 用户信息id
     */
    private Long id;
    /**
     *教师工号
     */
    private String jobNumber;
    /**
     *姓名
     */
    private String name;
    /**
     *性别
     */
    private String gender;
    /**
     *生日
     */
    private Date birthday;
    /**
     *民族
     */
    private String nation;
    /**
     *手机
     */
    private String mobilePhone;
    /**
     *邮箱
     */
    private String email;
    /**
     *家庭住址
     */
    private String address;
    /**
     *关联用户id
     */
    private Long userId;

    public UserInfo() {
    }

    public UserInfo(String jobNumber, String name, String gender, Date birthday, String nation, String mobilePhone, String email, String address, Long userId) {
        this.jobNumber = jobNumber;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.nation = nation;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.address = address;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
