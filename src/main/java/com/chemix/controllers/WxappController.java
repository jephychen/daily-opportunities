package com.chemix.controllers;

import com.chemix.DailyOpportunitiesApplication;
import com.chemix.Repositories.BusinessOpportunityRepository;
import com.chemix.Repositories.WxappRepository;
import com.chemix.libs.controller.BaseController;
import com.chemix.libs.http.HttpUtils;
import com.chemix.models.BusinessOpportunity;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenshijue on 2017/9/11.
 */

@RestController
public class WxappController extends BaseController {

    @Value("${wxapp.appid}")
    private String appid;

    @Value("${wxapp.appsecret}")
    private String appsecret;

    @Autowired
    private WxappRepository wxappRepository;

    @Autowired
    private BusinessOpportunityRepository businessOpportunityRepository;

    @RequestMapping(value = "/addWxAppuser", method = RequestMethod.POST)
    public Result addWxAppuser(String user_json) throws Exception {
        /*
        Wxapp app = wxappRepository.findByAppName("每日商机");
        BusinessOpportunity bo = new BusinessOpportunity();
        bo.setCompanyName("氪米科技");
        bo.setRegion("四川成都");
        bo.setToUser("18682731302");
        bo.setType("sell");
        Good good = new Good("taifai", "1000", "1000");
        List<Good> goods = new ArrayList<>();
        goods.add(good);
        Contact contact = new Contact("mr wang", "1868232334");
        bo.setGoods(goods);
        bo.setContact(contact);
        BusinessOpportunity newBo = businessOpportunityRepository.save(bo);*/
        BusinessOpportunity bo = businessOpportunityRepository.findById("59b64b7b9142b400dd9f47ec");
        return _true(bo);
    }

    @RequestMapping(value = "/getWxAppUserInfo", method = RequestMethod.POST)
    public Result getWxAppUserInfo(String code) throws Exception {
        if (code == null) return _falseParam();

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret="
                + appsecret + "&js_code=" + code + "&grant_type=authorization_code";
        String result = HttpUtils.sendGet(url, new HashMap<>());
        BasicDBObject jsResult = (BasicDBObject) JSON.parse(result);

        if (jsResult.get("errcode") != null){
            return _false("GET_SESSION_FROM_WX_ERROR", "获取会话失败");
        }

        return _true(jsResult);
    }

}
