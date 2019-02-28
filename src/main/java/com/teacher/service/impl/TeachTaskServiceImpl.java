package com.teacher.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.dao.TeachTaskMapper;
import com.teacher.entity.TeachTask;
import com.teacher.service.TeachTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachTaskServiceImpl implements TeachTaskService {
    @Autowired
    TeachTaskMapper teachTaskMapper;
    @Override
    public ServerResponse add(TeachTask teachTask) {
        if (teachTask.getFileName() == null ){
            teachTask.setFileName("");
        }
        int num = teachTaskMapper.add(teachTask);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("添加成功！");
        }
        return ServerResponse.createError("添加失败！");
    }

    @Override
    public ServerResponse delete(Long id) {
        int num = teachTaskMapper.delete(id);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("删除成功！");
        }
        return ServerResponse.createError("删除失败！");
    }

    @Override
    public ServerResponse update(TeachTask teachTask) {
        int num = teachTaskMapper.update(teachTask);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("更新成功！");
        }
        return ServerResponse.createError("更新失败！");
    }

    @Override
    public ServerResponse<TeachTask> findById(Long id) {
        TeachTask teachTask = teachTaskMapper.findById(id);
        if ( teachTask != null ){
            return ServerResponse.createSuccess(teachTask);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

    @Override
    public ServerResponse<List<TeachTask>> findAll() {
        List<TeachTask> teachTaskList = teachTaskMapper.findAll();
        if ( teachTaskList != null && !teachTaskList.isEmpty() ){
            return ServerResponse.createSuccess(teachTaskList);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

    @Override
    public ServerResponse<PageInfo> findNow(Long userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TeachTask> teachTaskList = teachTaskMapper.findNow(userId);
        PageInfo pageInfo = new PageInfo(teachTaskList);
        if ( pageInfo.getList() != null && !pageInfo.getList().isEmpty()){
            return ServerResponse.createSuccess(pageInfo);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

    @Override
    public ServerResponse<PageInfo> findHistory(Long userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TeachTask> teachTaskList = teachTaskMapper.findHistory(userId);
        PageInfo pageInfo = new PageInfo(teachTaskList);
        if ( pageInfo.getList() != null && !pageInfo.getList().isEmpty()){
            return ServerResponse.createSuccess(pageInfo);
        }
        return ServerResponse.createError("未找到相关信息！");
    }


}
