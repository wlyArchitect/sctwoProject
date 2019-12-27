package com.wh.sys.controller;

import com.wh.sys.utils.AppFileUtil;
import com.wh.sys.utils.RandomUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传的控制器
 * @author 万浩
 * @data 2019/12/14 21:57
 * @description
 */
@RequestMapping("/upload")
@Controller
public class FileController {
    /**
     * 上传文件不改文件名
     */
    @RequestMapping("/upload01")
    public String upload01(MultipartFile mf, HttpServletRequest request) throws IOException {
        //1.得到文件相关信息
        //文件类型
        String contentType = mf.getContentType();
        //文件的流
        //InputStream inputStream = mf.getInputStream();
        //得到form表单中的name属性的值
        String name = mf.getName();
        //得到文件名称
        String originalFilename = mf.getOriginalFilename();
        //文件大小
        long size = mf.getSize();
        //2.得到上传文件的路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        System.err.println(realPath);
        //3.组装文件对象
        File file = new File(realPath,name);
        //4.把文件流写到file
        mf.transferTo(file);
        System.out.println(mf);
        return "system/main/success";
    }
    /**
     * 上传文件到tomacat服务器下
     * 改文件名
     * 分文件夹管理
     */
    @RequestMapping("/upload02")
    public String upload02(MultipartFile mf, HttpServletRequest request) throws IOException {
        //1.得到文件相关信息
        //文件类型
        String contentType = mf.getContentType();
        //文件的流
        InputStream inputStream = mf.getInputStream();
        //2.得到文件名称
        String originalFilename = mf.getOriginalFilename();
        String newName = RandomUtil.createFileNameUseTime(originalFilename);
        //3.根据当前日期生成文件夹
        String dirName = RandomUtil.getCurrentDateForString();
        //4.得到上传文件的路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File newDir = new File(realPath,dirName);
        if (!newDir.exists()){
            newDir.mkdirs();
        }
        //5.组装文件对象
        File file = new File(newDir,newName);
        //6.把文件流写到file
        mf.transferTo(file);
        System.out.println(mf);
        return "system/main/success";
    }
    /**
     * 上传文件,上传到D盘
     * 细节:需要响应json格式的数据给前台
     * 改文件名
     * 分文件夹管理
     */
    @ResponseBody
    @RequestMapping("/upload03")
    public Map<String,Object> upload03(MultipartFile mf) throws IOException {
        //1.得到文件相关信息
        System.err.println(mf);
        //文件类型
        String contentType = mf.getContentType();
        //文件的流
        InputStream inputStream = mf.getInputStream();
        //2.得到文件名称
        String originalFilename = mf.getOriginalFilename();
        //todo 得到文件新名字
        String newName = RandomUtil.createFileNameUseTime(originalFilename);
        // 3.根据当前日期生成文件夹
        String dirName = RandomUtil.getCurrentDateForString();
        //4.得到上传文件的路径:D盘下的路径
        String realPath = AppFileUtil.PATH;
        File newDir = new File(realPath,dirName);
        if (!newDir.exists()){
            newDir.mkdirs();
            System.err.println(newDir.getAbsolutePath());
        }
        //5.组装文件对象
        File file = new File(newDir,newName);
        //6.把文件流写到file
        mf.transferTo(file);
        System.out.println(mf);
        Map<String,Object> hashMap = new HashMap<>(16);
        hashMap.put("code", 0);
        hashMap.put("msg", "");
        Map<String,Object> data = new HashMap<>(16);
        data.put("src", "downloadFile.action?path="+dirName+"/"+newName);
        hashMap.put("data",data );
        return hashMap;
    }

    /**
     * 文件下载
     */
    @RequestMapping("/downloadFile")
    public ResponseEntity<Object> downloadFile(String path, HttpServletResponse response){
        return AppFileUtil.downloadFile(response, path,"");
    }
}