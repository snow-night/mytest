package com.example.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.vo.ResultVo;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2017-07-20 下午5:34
 */

@Controller
@RequestMapping("/")
public class TestController {


    @RequestMapping("mytest")
    public @ResponseBody ResultVo test(HttpServletRequest request) {



        System.out.println("Content-Type:"+request.getContentType());
        System.out.println("Encoding:"+request.getCharacterEncoding());
        System.out.println("QueryString:"+request.getQueryString());
        System.out.println("ServletContext:"+request.getServletContext());


        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int readlen = 0;
            try {
                readlen = request.getInputStream().read(buffer, i,
                        contentLength - i);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }

        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        String result = null;
        try {
            result = new String(buffer, charEncoding);
            System.out.println("参数："+result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ResultVo resultVo = new ResultVo(result, 00);
        return resultVo;
    }


}

