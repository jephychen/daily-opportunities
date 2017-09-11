package com.chemix.controllers;

import com.chemix.Repositories.WxappRepository;
import com.chemix.libs.controller.BaseController;
import com.chemix.models.Wxapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenshijue on 2017/9/11.
 */

@RestController
public class WxappController extends BaseController {

    @Autowired
    private WxappRepository wxappRepository;

    @RequestMapping(value = "/addWxAppuser", method = RequestMethod.POST)
    public Result addWxAppuser(String user_json){
        Wxapp app = wxappRepository.findByAppName("每日商机");
        return _true(app);
    }

    @RequestMapping(value = "/getWxAppUserInfo", method = RequestMethod.POST)
    public Result getWxAppUserInfo(String code){
        return _true();
    }

}
