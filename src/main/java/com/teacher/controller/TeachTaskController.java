package com.teacher.controller;

import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.entity.TeachTask;
import com.teacher.service.TeachTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
public class TeachTaskController {
    @Autowired
    TeachTaskService teachTaskService;

    /**
     * 增加教学任务
     * @param teachTask
     * @return
     */
    @PostMapping("/teachtask")
    @ResponseBody
    public ServerResponse add(@RequestBody TeachTask teachTask){
        return teachTaskService.add(teachTask);
    }

    /**
     * 删除教学任务
     * @param id
     * @return
     */
    @PostMapping("/teachtaskdelete/{id}")
    @ResponseBody
    public ServerResponse delete(@PathVariable Long id, HttpSession session){
        String fileName = teachTaskService.findById(id).getData().getFileName();
        ServerResponse serverResponse = teachTaskService.delete(id);
        if (serverResponse.isSuccess()){
            if (fileName != ""){
                String targetFile = session.getServletContext().getRealPath("/file/"+fileName);
                File file = new File(targetFile);
                file.delete();
            }

        }

        return serverResponse;
    }

    /**
     * 更新教学任务
     * @param teachTask
     * @return
     */
    @PutMapping("/teachtask")
    @ResponseBody
    public ServerResponse update(@RequestBody TeachTask teachTask){
        return teachTaskService.update(teachTask);
    }

    /**
     * 查询用户相关本学期教学任务
     * @param userId
     * @param pageNum
     * @return
     */
    @GetMapping("/now_teachtasks/{userId}/{pageNum}")
    @ResponseBody
    public ServerResponse<PageInfo> findNow(@PathVariable("userId") Long userId, @PathVariable("pageNum") int pageNum){
        return teachTaskService.findNow(userId,pageNum,10);
    }

    /**
     * 查询用户相关历史期教学任务
     * @param userId
     * @param pageNum
     * @return
     */
    @GetMapping("/history_teachtasks/{userId}/{pageNum}")
    @ResponseBody
    public ServerResponse<PageInfo> findHistory(@PathVariable("userId") Long userId, @PathVariable("pageNum") int pageNum){
        return teachTaskService.findHistory(userId,pageNum,10);
    }

    /**
     * 根据教学任务编号id查询教学任务
     * @param id
     * @return
     */
    @GetMapping("/teachtask/{id}")
    @ResponseBody
    public ServerResponse<TeachTask> findById(@PathVariable("id") Long id){
        return teachTaskService.findById(id);
    }
 }
