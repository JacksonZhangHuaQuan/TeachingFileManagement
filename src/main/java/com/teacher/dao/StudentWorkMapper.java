package com.teacher.dao;

import com.teacher.entity.StudentWork;

import java.util.List;

public interface StudentWorkMapper {
    /**
     * 添加学生相关作业
     * @param studentWork
     * @return int
     */
    int add(StudentWork studentWork);

    /**
     * 根据学生作业id删除学生相关作业
     * @param id
     * @return int
     */
    int delete(Long id);

    /**
     * 更新学生相关作业
     * @param studentWork
     * @return int
     */
    int update(StudentWork studentWork);

    /**
     * 根据学生作业id查询学生相关作业
     * @param id
     * @return StudentWork
     */
    StudentWork findById(Long id);

    /**
     * 查询所有学生相关作业
     * @return List<StudentWork>
     */
    List<StudentWork> findAll();

    /**
     * 根据关联用户id查询其所有学生相关作业
     * @param userId
     * @return List<StudentWork>
     */
    List<StudentWork> findAllByUserId(Long userId);
}
