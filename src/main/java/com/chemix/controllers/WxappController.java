package com.chemix.controllers;

import com.chemix.Repositories.BusinessOpportunityRepository;
import com.chemix.Repositories.UserRepository;
import com.chemix.Repositories.WxappRepository;
import com.chemix.libs.JwtHelper;
import com.chemix.libs.controller.BaseController;
import com.chemix.libs.http.HttpUtils;
import com.chemix.libs.json.JsonHelper;
import com.chemix.models.BusinessOpportunity.BusinessOpportunity;
import com.chemix.models.User.User;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest httpRequest;

    @RequestMapping("/test")
    public Result test(String param) throws IOException {
        Map<String, String> body = new HashMap<>();
        body.put("user_id", param);
        String jwt = JwtHelper.genJwt(body, 5);
        BasicDBObject decodejwt = JwtHelper.getPayload(jwt);
        return _true(decodejwt);
    }

    @RequestMapping(value = "/addWxAppuser", method = RequestMethod.POST)
    public Result addWxAppuser(String user_json) throws Exception {
        BusinessOpportunity o = (BusinessOpportunity) JsonHelper.parse(BusinessOpportunity.class, user_json);
        return _true(o);
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

        User user = userRepository.findByOpenid(jsResult.getString("openid"));
        if (user == null){
            user = new User();
            user.setOpenid(jsResult.getString("openid"));
            User newUser = userRepository.save(user);
            return _true(newUser);
        }

        return _true(user);
    }

}
