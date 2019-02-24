package com.teacher.controller;

import com.github.pagehelper.PageInfo;
import com.teacher.common.ServerResponse;
import com.teacher.entity.Paper;
import com.teacher.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PaperController {
    @Autowired
    PaperService paperService;

    @PostMapping("/paper")
    @ResponseBody
    public ServerResponse add(@RequestBody Paper paper){
        return paperService.add(paper);
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
    public ServerResponse<PageInfo> findByUserId(@RequestBody Paper paper, @PathVariable("pageNum") int pageNum){
        return paperService.findByCondition(paper,pageNum,10);
    }
}
