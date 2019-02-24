package com.teacher.service;

import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.entity.Grade;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GradeService {
    /**
     * 添加成绩
     * @param grade
     * @return ServerResponse
     */
    ServerResponse add(Grade grade);

    /**
     * 根据id删除成绩
     * @param id
     * @return ServerResponse
     */
    ServerResponse delete(Long id);

    /**
     * 更新成绩
     * @param grade
     * @return ServerResponse
     */
    ServerResponse update(Grade grade);

    /**
     * 根据id查询成绩
     * @param id
     * @return ServerResponse<Grade>
     */
    ServerResponse<Grade> findById(Long id);

    /**
     * 查询所有成绩
     * @return ServerResponse<List<Grade>>
     */
    ServerResponse<List<Grade>> findAll();

    /**
     * 根据关联用户id及条件查询相关成绩
     * @param grade
     * @return ServerResponse<List<Grade>>
     */
    ServerResponse<PageInfo> findByCondition(Grade grade, int pageNum, int pageSize);
}
