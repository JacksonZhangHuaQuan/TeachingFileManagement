package com.teacher.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.dao.PaperMapper;
import com.teacher.entity.Paper;
import com.teacher.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperMapper paperMapper;
    @Override
    public ServerResponse add(Paper paper) {
        int num = paperMapper.add(paper);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("添加成功！");
        }
        return ServerResponse.createError("添加失败！");
    }

    @Override
    public ServerResponse delete(Long id) {
        int num = paperMapper.delete(id);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("删除成功！");
        }
        return ServerResponse.createError("删除失败！");
    }

    @Override
    public ServerResponse update(Paper paper) {
        int num = paperMapper.update(paper);
        if ( num > 0 ){
            return ServerResponse.createSuccessMessage("更新成功！");
        }
        return ServerResponse.createError("更新失败！");
    }

    @Override
    public ServerResponse<Paper> findById(Long id) {
        Paper paper = paperMapper.findById(id);
        if ( paper != null ){
            return ServerResponse.createSuccess(paper);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

    @Override
    public ServerResponse<List<Paper>> findAll() {
        List<Paper> paperList = paperMapper.findAll();
        if ( paperList != null && !paperList.isEmpty() ){
            return ServerResponse.createSuccess(paperList);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

    @Override
    public ServerResponse<PageInfo> findByCondition(Paper paper, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Paper> paperList =paperMapper.findByCondition(paper);
        PageInfo pageInfo = new PageInfo(paperList);
        if (pageInfo.getList() != null && !pageInfo.getList().isEmpty() ) {
             return ServerResponse.createSuccess(pageInfo);
        }
        return ServerResponse.createError("未找到相关信息！");
    }

}
