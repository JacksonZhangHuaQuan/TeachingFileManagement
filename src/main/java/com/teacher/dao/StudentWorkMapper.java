package com.teacher.dao;

import com.teacher.entity.StudentWork;

import java.util.List;

public interface StudentWorkMapper {
    /**
     * 添加学生相关作业
     * @param studentWork
     * @return int
     */
    int addStudentWork(StudentWork studentWork);

    /**
     * 根据学生作业id删除学生相关作业
     * @param id
     * @return int
     */
    int deleteStudentWorkById(Long id);

    /**
     * 更新学生相关作业
     * @param studentWork
     * @return int
     */
    int updateStudentWork(StudentWork studentWork);

    /**
     * 根据学生作业id查询学生相关作业
     * @param id
     * @return StudentWork
     */
    StudentWork findStudentWorkById(Long id);

    /**
     * 查询所有学生相关作业
     * @return List<StudentWork>
     */
    List<StudentWork> findAllStudentWork();

    /**
     * 根据关联用户id查询其所有学生相关作业
     * @param userId
     * @return List<StudentWork>
     */
    List<StudentWork> findAllStudentWorkByUserId(Long userId);
}
