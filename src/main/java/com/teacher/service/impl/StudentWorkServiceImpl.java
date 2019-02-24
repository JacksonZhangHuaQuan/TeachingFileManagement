package com.teacher.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.dao.StudentWorkMapper;
import com.teacher.entity.StudentWork;
import com.teacher.service.StudentWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentWorkServiceImpl implements StudentWorkService {
    @Autowired
    StudentWorkMapper studentWorkMapper;
    @Override
    public ServerResponse add(StudentWork studentWork) {
        int num = studentWorkMapper.add(studentWork);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("添加成功！");
        }
        return ServerResponse.createError("添加失败！");
    }

    @Override
    public ServerResponse delete(Long id) {
        int num = studentWorkMapper.delete(id);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("删除成功！");
        }
        return ServerResponse.createError("删除失败！");
    }

    @Override
    public ServerResponse update(StudentWork studentWork) {
        int num = studentWorkMapper.update(studentWork);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("更新成功！");
        }
        return ServerResponse.createError("更新失败！");
    }

    @Override
    public ServerResponse<StudentWork> findById(Long id) {
        StudentWork studentWork = studentWorkMapper.findById(id);
        if ( studentWork != null ){
        return ServerResponse.createSuccess(studentWork);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

    @Override
    public ServerResponse<List<StudentWork>> findAll() {
        List<StudentWork> studentWorkList = studentWorkMapper.findAll();
        if ( studentWorkList != null && !studentWorkList.isEmpty() ){
            return ServerResponse.createSuccess(studentWorkList);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

    @Override
    public ServerResponse<PageInfo> findByCondition(StudentWork studentWork, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<StudentWork> studentWorkList = studentWorkMapper.findByCondition(studentWork);
        PageInfo pageInfo = new PageInfo(studentWorkList);
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty()){
            return ServerResponse.createSuccess(pageInfo);
        }
        return ServerResponse.createError("未找到相关信息！");
    }


}
