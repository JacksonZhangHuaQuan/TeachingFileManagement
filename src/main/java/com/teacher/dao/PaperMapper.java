package com.teacher.dao;

import com.teacher.entity.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMapper {
    /**
     * 添加论文
     * @param paper
     * @return int
     */
    int add(@Param("paper") Paper paper);

    /**
     * 根据id删除论文
     * @param id
     * @return int
     */
    int delete(@Param("id") Long id);

    /**
     * 更新论文
     * @param paper
     * @return int
     */
    int update(@Param("paper") Paper paper);

    /**
     * 根据论文id查找论文
     * @param id
     * @return Paper
     */
    Paper findById(@Param("id") Long id);

    /**
     * 查询所有论文
     * @return List<Paper>
     */
    List<Paper> findAll();

    /**
     * 根据关联用户id及动态条件查询相关论文
     * @param paper
     * @return
     */
    List<Paper> findByCondition(@Param("paper") Paper paper);
}
