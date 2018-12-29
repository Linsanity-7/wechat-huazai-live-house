package com.huazai.livehouse.wechat.subscription.platform.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.huazai.livehouse.wechat.subscription.platform.service.CoreService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上海美市科技有限公司开发部
 *
 * @author        :林尚华
 * @date    : 2018/12/29 15:43
 * @Description:
 */
@Service(version = "1.0.0",interfaceClass = CoreService.class,timeout = 6000)
public class CoreServiceImpl implements CoreService {


    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
