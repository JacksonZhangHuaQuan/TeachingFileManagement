package com.teacher.service;

import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.entity.StudentWork;

import java.util.List;

public interface StudentWorkService {
    /**
     * 添加学生相关作业
     * @param studentWork
     * @return ServerResponse
     */
    ServerResponse add(StudentWork studentWork);

    /**
     * 根据学生作业id删除学生相关作业
     * @param id
     * @return ServerResponse
     */
    ServerResponse delete(Long id);

    /**
     * 更新学生相关作业
     * @param studentWork
     * @return ServerResponse
     */
    ServerResponse update(StudentWork studentWork);

    /**
     * 根据学生作业id查询学生相关作业
     * @param id
     * @return ServerResponse<StudentWork>
     */
    ServerResponse<StudentWork> findById(Long id);

    /**
     * 查询所有学生相关作业
     * @return ServerResponse<List<StudentWork>>
     */
    ServerResponse<List<StudentWork>> findAll();

    /**
     * 根据关联用户id及动态条件分页查询学生相关作业
     * @param studentWork
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> findByCondition(StudentWork studentWork,int pageNum,int pageSize);
}
