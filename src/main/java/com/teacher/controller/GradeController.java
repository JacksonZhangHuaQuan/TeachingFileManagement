package com.teacher.controller;

import com.github.pagehelper.PageInfo;
import com.teacher.common.Const;
import com.teacher.common.ServerResponse;
import com.teacher.entity.Grade;
import com.teacher.entity.User;
import com.teacher.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class GradeController {
    @Autowired
    GradeService gradeService;

    @PostMapping("/grade")
    @ResponseBody
    public ServerResponse add(Grade grade, @RequestParam("uploadFile") MultipartFile uploadFile, HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        grade.setUserId(user.getId());
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
                grade.setFileName(filename);
                return gradeService.add(grade);
            } catch (IOException e) {
                e.printStackTrace();
                return ServerResponse.createError("提交失败！");
            }
        }
        return gradeService.add(grade);
    }

    @DeleteMapping("/grade/{id}")
    @ResponseBody
    public ServerResponse delete(@PathVariable("id") Long id,HttpSession session){
        ServerResponse serverResponse = gradeService.delete(id);
        if (serverResponse.isSuccess()){
             String fileName = gradeService.findById(id).getData().getFileName();
             String targetFile = session.getServletContext().getRealPath("/file/"+fileName);
             File file = new File(targetFile);
             file.delete();
        }
        return serverResponse;
    }

    @PutMapping("/grade")
    @ResponseBody
    public ServerResponse update( Grade grade,@RequestParam("uploadFile") MultipartFile uploadFile,HttpSession session){

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
                    grade.setFileName(filename);
                    return gradeService.update(grade);
                } catch (IOException e) {
                    e.printStackTrace();
                    return ServerResponse.createError("提交失败！");
                }
            }
            return gradeService.update(grade);
    }

    @GetMapping("/grade/{id}")
    @ResponseBody
    public ServerResponse<Grade> findById(@PathVariable("id") Long id){
        return gradeService.findById(id);
    }

    @PostMapping("/grades/{pageNum}")
    @ResponseBody
    public ServerResponse<PageInfo> findByCondition(@RequestBody Grade grade,@PathVariable(value = "pageNum")  int pageNum){
        return gradeService.findByCondition(grade,pageNum,10);
    }
}