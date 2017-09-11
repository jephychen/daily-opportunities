package com.chemix.controllers;

import com.chemix.libs.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenshijue on 2017/9/11.
 */

@RestController
public class WxappController extends BaseController {

    @RequestMapping(value = "/addWxAppuser", method = RequestMethod.POST)
    public Result addWxAppuser(String user_json){
        return _true();
    }

    @RequestMapping(value = "/getWxAppUserInfo", method = RequestMethod.POST)
    public Result getWxAppUserInfo(String code){
        return _true();
    }

}
