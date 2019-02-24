package com.teacher.service;

import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.entity.TeachTask;

import java.util.List;

public interface TeachTaskService {
    /**
     * 增加教学任务
     * @param teachTask
     * @return ServerResponse
     */
    ServerResponse add(TeachTask teachTask);

    /**
     * 根据id删除教学任务
     * @param id
     * @return ServerResponse
     */
    ServerResponse delete(Long id);

    /**
     * 更新教学任务
     * @param teachTask
     * @return ServerResponse
     */
    ServerResponse update(TeachTask teachTask);

    /**
     * 根据id查询教学任务
     * @param id
     * @return ServerResponse<TeachTask>
     */
    ServerResponse<TeachTask> findById(Long id);

    /**
     * 查询所有的教学任务
     * @return ServerResponse<List<TeachTask>>
     */
    ServerResponse<List<TeachTask>> findAll();

    /**
     * 分页查询本学期教学任务
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> findNow(Long userId,int pageNum,int pageSize);

    /**
     * 分页查询历史教学任务
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> findHistory(Long userId,int pageNum,int pageSize);
}
