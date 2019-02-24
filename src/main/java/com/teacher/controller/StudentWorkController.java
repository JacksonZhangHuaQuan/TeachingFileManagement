package com.teacher.controller;

import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.entity.StudentWork;
import com.teacher.service.StudentWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentWorkController {
    @Autowired
    StudentWorkService studentWorkService;

    /**
     * 增加学生作业
     * @param studentWork
     * @return
     */
    @PostMapping("/studentwork")
    @ResponseBody
    public ServerResponse add(@RequestBody StudentWork studentWork){
        return studentWorkService.add(studentWork);
    }

    /**
     * 删除学生作业
     * @param id
     * @return
     */
    @DeleteMapping("/studentwork/{id}")
    @ResponseBody
    public ServerResponse delete(@PathVariable("id") Long id){
        return studentWorkService.delete(id);
    }

    /**
     * 更新学生作业
     * @param studentWork
     * @return
     */
    @PutMapping("/studentwork")
    @ResponseBody
    public ServerResponse update(@RequestBody StudentWork studentWork){
        return studentWorkService.update(studentWork);
    }

    /**
     * 根据userId和动态条件分页查询学生作业实验
     * @param studentWork
     * @param pageNum
     * @return
     */
    @PostMapping("/studentworks/{pageNum}")
    @ResponseBody
    public ServerResponse<PageInfo> findByCondition(@RequestBody StudentWork studentWork, @PathVariable("pageNum") int pageNum){
        return studentWorkService.findByCondition(studentWork,pageNum,10);
    }

    /**
     * 根据学生作业编号id查询学生作业
     * @param id
     * @return
     */
    @GetMapping("/studentwork/{id}")
    @ResponseBody
    public ServerResponse<StudentWork> findById(@PathVariable("id") Long id){
        return studentWorkService.findById(id);
    }
}
