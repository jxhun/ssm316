package cn.jxhun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/03/17
 * Description:
 * Version: V1.0
 */
@Controller
@RequestMapping("/user")
public class shangChuanController {
    //    1、 进入上传 页面
    @RequestMapping(value = {"/importArticle", "/importArticle.html"})
    @ResponseBody
    public Map<String, Object> importArticle() {
        Map<String, Object> map = new HashMap<>();
        map.put("returncode", 200);
        return map;
    }

    //    2、执行上传操作
    @RequestMapping(value = {"/executeImport"}, method = RequestMethod.POST)
    @ResponseBody
    public String executeImport(MultipartFile articleFile) throws Exception {
        String originalFilename = articleFile.getOriginalFilename();
        File file = new File("F:/" + System.currentTimeMillis() + originalFilename.substring(originalFilename.indexOf(".")));
        try {
            articleFile.transferTo(file);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }
}
