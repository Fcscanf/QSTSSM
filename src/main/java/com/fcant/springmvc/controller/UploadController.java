package com.fcant.springmvc.controller;

import com.fcant.springmvc.bean.UploadedImageFile;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * UploadController
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 23:07 2019-07-31/0031
 */
@Controller
public class UploadController {
    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file)
            throws IllegalStateException, IOException {
        // 获取随机文件名
        String name = RandomStringUtils.randomAlphanumeric(10);
        // 获取原有文件名称（包括文件类型）
        String fileName = file.getImage().getOriginalFilename();
        // 截取文件类型
        int  indexdot =  fileName.indexOf(".");
        String suffix =  fileName.substring(indexdot);

        // 创建文件，给文件起名字
        String newFileName = name + suffix;
        //  创建 File对象，并设定存放位置和存放文件的文件名
        File newFile = new File(request.getServletContext().getRealPath("/image"), newFileName);
        // 调用newFile这个实例的getParentFile方法， 返回它的父目录对象的实例，得到父目录实例后，接着调用.mkdirs()(是父目录这个实例调用的)，创建文件夹。
        newFile.getParentFile().mkdirs();
        // 复制文件，把图片写入磁盘
        file.getImage().transferTo(newFile);

        ModelAndView mav = new ModelAndView("showUploadedFile");
        mav.addObject("imageName", newFileName);
        return mav;
    }
}
