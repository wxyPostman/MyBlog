package com.zjweu.controller;
import com.zjweu.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;
    @RequestMapping( "delcontent" )
    @ResponseBody
    public String content(Integer ccid) {
        boolean isok= contentService.deleteContent(ccid);
        String msg;
        if (isok) {
            msg = "删除成功";
        } else {
            msg = "删除失败";
        }
        return msg;
    }
}