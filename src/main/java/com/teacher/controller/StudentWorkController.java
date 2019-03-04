package com.teacher.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.teacher.common.Const;
import com.teacher.common.ServerResponse;
import com.teacher.entity.Paper;
import com.teacher.entity.StudentWork;
import com.teacher.entity.User;
import com.teacher.service.StudentWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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

    public String add(StudentWork studentWork, @RequestParam("uploadFile") MultipartFile uploadFile, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        studentWork.setUserId(user.getId());
        if (studentWork.getFileName() == null){
            studentWork.setFileName("");
        }
        if (uploadFile.getSize() > 0 ) {
            String filename = uploadFile.getOriginalFilename();
            String leftPath = session.getServletContext().getRealPath("/file");
            File path =new File(leftPath);
            if ( !path.exists() && path.isAbsolute() ){
                path.mkdir();
            }
            File file = new File(leftPath, filename);
            if ( file.exists() ){
                file.delete();
            }
            try {
                uploadFile.transferTo(file);
                studentWork.setFileName(filename);
                String json = JSON.toJSONString(studentWorkService.add(studentWork));
                request.setAttribute("serverResponse",json);
                return "main/work_add";
            } catch (IOException e) {
                e.printStackTrace();
                String json = JSON.toJSONString(ServerResponse.createError("提交失败！"));
                request.setAttribute("serverResponse",json);
                return "main/work_add";
            }
        }
        String json = JSON.toJSONString(studentWorkService.add(studentWork));
        request.setAttribute("serverResponse",json);
        return "main/work_add";
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
