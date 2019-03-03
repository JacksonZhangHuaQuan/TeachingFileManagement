package com.teacher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Bug弃用
 */
@Controller
public class FileController {

    @GetMapping("/fileDownload/{fileName}")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response,@PathVariable("fileName") String fileName) throws IOException {
          String leftPath = request.getSession().getServletContext().getRealPath("/file");
          File downloadFile = new File(leftPath,fileName);
          response.reset();
          response.setContentType("application/octet-stream");
          response.setHeader("content-disposition", "attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
          InputStream in = new FileInputStream(downloadFile);
          int len = 0;
          byte[] buffer = new byte[1024];
          OutputStream out = response.getOutputStream();
          while ( (len = in.read(buffer)) > 0 ){
              out.write(buffer,0,len);
          }
          in.close();
    }
}
