package com.teacher.controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class FileController {

    @GetMapping("/file")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response,String fileName) throws IOException {
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
