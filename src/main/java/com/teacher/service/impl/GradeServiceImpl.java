package com.teacher.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.dao.GradeMapper;
import com.teacher.entity.Grade;
import com.teacher.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;
    @Override
    public ServerResponse add(Grade grade) {
        int num = gradeMapper.add(grade);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("添加成功！");
        }
        return ServerResponse.createError("添加失败！");
    }

    @Override
    public ServerResponse delete(Long id) {
        int num = gradeMapper.delete(id);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("删除成功！");
        }
        return ServerResponse.createError("删除失败！");
    }

    @Override
    public ServerResponse update(Grade grade) {
        int num = gradeMapper.update(grade);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("更新成功！");
        }
        return ServerResponse.createError("更新失败！");
    }

    @Override
    public ServerResponse<Grade> findById(Long id) {
        Grade grade = gradeMapper.findById(id);
        if ( grade != null ){
            return ServerResponse.createSuccess(grade);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

    @Override
    public ServerResponse<List<Grade>> findAll() {
        List<Grade> gradeList = gradeMapper.findAll();
        if ( gradeList != null && !gradeList.isEmpty() ){
            return ServerResponse.createSuccess(gradeList);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

    @Override
    public ServerResponse<PageInfo> findByCondition(Grade grade, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Grade> gradeList = gradeMapper.findByCondition(grade);
        PageInfo pageInfo = new PageInfo(gradeList);
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()){
            return ServerResponse.createSuccess(pageInfo);
        }
        return ServerResponse.createError("未找到相关信息！");
    }


}
