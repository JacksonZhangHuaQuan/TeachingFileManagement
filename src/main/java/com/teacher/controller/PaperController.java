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

    @DeleteMapping("/paper/{id}")
    @ResponseBody
    public ServerResponse delete(@PathVariable("id") Long id){
        return paperService.delete(id);
    }

    @PutMapping("/paper")
    @ResponseBody
    public ServerResponse update(@RequestBody Paper paper){
        return paperService.update(paper);
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
