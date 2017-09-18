package com.chemix.controllers;

import com.chemix.Repositories.BusinessOpportunityRepository;
import com.chemix.Repositories.UserRepository;
import com.chemix.Repositories.WxappRepository;
import com.chemix.libs.JwtHelper;
import com.chemix.libs.controller.BaseController;
import com.chemix.libs.http.HttpHelper;
import com.chemix.libs.http.HttpUtils;
import com.chemix.libs.json.JsonHelper;
import com.chemix.models.BusinessOpportunity.BusinessOpportunity;
import com.chemix.models.User.User;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenshijue on 2017/9/11.
 */

@RestController
public class WxappController extends BaseController {

    private static final long ONE_WEEK = 60 * 60 * 24 * 7;
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
    public Result test(String code) throws IOException {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret="
                + appsecret + "&js_code=" + code + "&grant_type=authorization_code";
        String url1 = "https://huaxue.drea.mx/groups_encrypt/services/rest/businessopportunity/getBuyBo";
        Object responseBody = HttpHelper.get(url1);
        return _true(JSON.parse((String) responseBody));
    }

    @RequestMapping(value = "/addWxAppuser", method = RequestMethod.POST)
    public Result addWxAppuser(String user_json) throws Exception {
        BusinessOpportunity o = (BusinessOpportunity) JsonHelper.parse(BusinessOpportunity.class, user_json);
        return _true(o);
    }

    @RequestMapping(value = "/getWxAppUserInfo", method = RequestMethod.POST)
    public Result getWxAppUserInfo(String code) throws Exception {
        if (code == null) return _falseParam();

        //首先使用code从微信获取用户session
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret="
                + appsecret + "&js_code=" + code + "&grant_type=authorization_code";
        String result = HttpUtils.sendGet(url, new HashMap<>());
        BasicDBObject session = (BasicDBObject) JSON.parse(result);

        if (session.get("errcode") != null){
            return _false("GET_SESSION_FROM_WX_ERROR", "获取会话失败");
        }

        //如果用户不存在，则新建用户。将用户jwt信息返回给客户端
        Map<String, String> payload = new HashMap<>();
        User user = userRepository.findByOpenid(session.getString("openid"));
        if (user == null){
            user = new User();
            user.setOpenid(session.getString("openid"));
            User newUser = userRepository.save(user);

            payload.put("userId", newUser.getId());
            newUser.setJwt(JwtHelper.genJwt(payload, ONE_WEEK));

            return _true(newUser);
        }

        payload.put("userId", user.getId());
        payload.put("mobile", user.getMobile());
        user.setJwt(JwtHelper.genJwt(payload, ONE_WEEK));

        return _true(user);
    }

}
