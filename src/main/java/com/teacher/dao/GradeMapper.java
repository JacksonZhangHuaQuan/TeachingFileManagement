package com.teacher.dao;

import com.teacher.entity.Grade;

import java.util.List;

public interface GradeMapper {
    /**
     * 添加成绩
     * @param grade
     * @return int
     */
    int add(Grade grade);

    /**
     * 根据id删除成绩
     * @param id
     * @return int
     */
    int delete(Long id);

    /**
     * 更新成绩
     * @param grade
     * @return int
     */
    int update(Grade grade);

    /**
     * 根据id查询成绩
     * @param id
     * @return Grade
     */
    Grade findById(Long id);

    /**
     * 查询所有成绩
     * @return
     */
    List<Grade> findAll();

    /**
     * 根据关联用户id查询相关成绩
     * @param userId
     * @return
     */
    List<Grade> findAllByUserId(Long userId);
}
