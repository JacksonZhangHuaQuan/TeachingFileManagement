package com.teacher.dao;

import com.teacher.entity.TeachTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeachTaskMapper {
    /**
     * 增加教学任务
     * @param teachTask
     * @return int
     */
    int add(@Param("teachTask") TeachTask teachTask);

    /**
     * 根据id删除教学任务
     * @param id
     * @return int
     */
    int delete(@Param("id") Long id);

    /**
     * 更新教学任务
     * @param teachTask
     * @return int
     */
    int update(@Param("teachTask") TeachTask teachTask);

    /**
     * 根据id查询教学任务
     * @param id
     * @return TeachTask
     */
    TeachTask findById(@Param("id") Long id);

    /**
     * 查询所有的教学任务
     * @return List<TeachTask>
     */
    List<TeachTask> findAll();

    /**
     * 本学期教学任务
     * @param userId
     * @return
     */
    List<TeachTask> findNow(@Param("userId") Long userId);

    /**
     * 历史教学任务
     * @param userId
     * @return
     */
    List<TeachTask> findHistory(@Param("userId") Long userId);
}
