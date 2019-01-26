package com.teacher.dao;

import com.teacher.entity.TeachTask;

import java.util.List;

public interface TeachTaskMapper {
    /**
     * 增加教学任务
     * @param teachTask
     * @return int
     */
    int add(TeachTask teachTask);

    /**
     * 根据id删除教学任务
     * @param id
     * @return int
     */
    int delete(Long id);

    /**
     * 更新教学任务
     * @param teachTask
     * @return int
     */
    int update(TeachTask teachTask);

    /**
     * 根据id查询教学任务
     * @param id
     * @return TeachTask
     */
    TeachTask findById(Long id);

    /**
     * 查询所有的教学任务
     * @return List<TeachTask>
     */
    List<TeachTask> findAll();

    /**
     * 根据关联用户id查询其所有教学任务
     * @param id
     * @return List<TeachTask>
     */
    List<TeachTask> findAllByUserId(Long id);
}
