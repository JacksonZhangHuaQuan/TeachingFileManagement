package com.teacher.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.teacher.common.Const;
import com.teacher.common.ServerResponse;
import com.teacher.entity.Grade;
import com.teacher.entity.Paper;
import com.teacher.entity.User;
import com.teacher.service.PaperService;
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
public class PaperController {
    @Autowired
    PaperService paperService;

    @PostMapping("/paper")
    public String add(Paper paper, @RequestParam("uploadFile") MultipartFile uploadFile, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        paper.setUserId(user.getId());
        if (paper.getFileName() == null){
            paper.setFileName("");
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
                paper.setFileName(filename);
                String json = JSON.toJSONString(paperService.add(paper));
                request.setAttribute("serverResponse",json);
                return "main/paper_add";
            } catch (IOException e) {
                e.printStackTrace();
                String json = JSON.toJSONString(ServerResponse.createError("提交失败！"));
                request.setAttribute("serverResponse",json);
                return "main/paper_add";
            }
        }
        String json = JSON.toJSONString(paperService.add(paper));
        request.setAttribute("serverResponse",json);
        return "main/paper_add";
    }

    @PostMapping("/paperdelete/{id}")
    @ResponseBody
    public ServerResponse delete(@PathVariable("id") Long id,HttpSession session){
        String fileName = paperService.findById(id).getData().getFileName();
        ServerResponse serverResponse = paperService.delete(id);
        if (serverResponse.isSuccess()){
            if (fileName != ""){
                String targetFile = session.getServletContext().getRealPath("/file/"+fileName);
                File file = new File(targetFile);
                file.delete();
            }
        }

        return serverResponse;
    }

    @PostMapping("/paperupdate")
    public String update( Paper paper,@RequestParam("uploadFile") MultipartFile uploadFile,HttpSession session,HttpServletRequest request){
        if (paper.getFileName() == null){
            paper.setFileName("");
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
                paper.setFileName(filename);
                String json = JSON.toJSONString(paperService.update(paper));
                request.setAttribute("serverResponse",json);
                return "main/paper_find";
            } catch (IOException e) {
                e.printStackTrace();
                String json = JSON.toJSONString(ServerResponse.createError("提交失败！"));
                request.setAttribute("serverResponse",json);
                return "main/paper_find";
            }
        }
        String json = JSON.toJSONString(paperService.update(paper));
        request.setAttribute("serverResponse",json);
        return "main/paper_find";
    }

    @GetMapping("/paper/{id}")
    @ResponseBody
    public ServerResponse<Paper> findById(@PathVariable("id") Long id){
        return paperService.findById(id);
    }

    @PostMapping("/papers/{pageNum}")
    @ResponseBody
    public ServerResponse<PageInfo> findByCondition(@RequestBody Paper paper, @PathVariable("pageNum") int pageNum){
        return paperService.findByCondition(paper,pageNum,10);
    }
}
