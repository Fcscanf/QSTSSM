package com.fcant.springmvc.bean;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * UploadedImageFile
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 23:06 2019-07-31/0031
 */
@Data
public class UploadedImageFile {
    MultipartFile image;
}
