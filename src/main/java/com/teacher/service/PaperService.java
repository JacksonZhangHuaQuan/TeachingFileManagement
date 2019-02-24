package com.teacher.service;

import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.entity.Grade;
import com.teacher.entity.Paper;

import java.util.List;

public interface PaperService {
    /**
     * 添加论文
     * @param paper
     * @return ServerResponse
     */
    ServerResponse add(Paper paper);

    /**
     * 根据id删除论文
     * @param id
     * @return ServerResponse
     */
    ServerResponse delete(Long id);

    /**
     * 更新论文
     * @param paper
     * @return ServerResponse
     */
    ServerResponse update(Paper paper);

    /**
     * 根据论文id查找论文
     * @param id
     * @return ServerResponse<Paper>
     */
    ServerResponse<Paper> findById(Long id);

    /**
     * 查询所有论文
     * @return ServerResponse<List<Paper>>
     */
    ServerResponse<List<Paper>> findAll();

    /**
     * 根据关联用户id及相关条件分页查询相关论文
     * @param paper
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> findByCondition(Paper paper, int pageNum, int pageSize);
}
