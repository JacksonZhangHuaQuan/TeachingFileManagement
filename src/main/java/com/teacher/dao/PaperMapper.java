package com.teacher.dao;

import com.teacher.entity.Paper;

import java.util.List;

public interface PaperMapper {
    /**
     * 添加论文
     * @param paper
     * @return int
     */
    int addPaper(Paper paper);

    /**
     * 根据id删除论文
     * @param id
     * @return int
     */
    int deletePaperById(Long id);

    /**
     * 更新论文
     * @param paper
     * @return int
     */
    int updatePaper(Paper paper);

    /**
     * 根据论文id查找论文
     * @param id
     * @return Paper
     */
    Paper findPaperById(Long id);

    /**
     * 查询所有论文
     * @return List<Paper>
     */
    List<Paper> findAllPaper();

    /**
     * 根据关联用户id查询相关论文
     * @param userId
     * @return List<Paper>
     */
    List<Paper> findAllPaperByUserId(Long userId);
}
