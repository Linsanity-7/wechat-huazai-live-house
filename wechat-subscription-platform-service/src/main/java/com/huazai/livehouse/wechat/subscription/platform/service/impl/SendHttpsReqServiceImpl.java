package com.huazai.livehouse.wechat.subscription.platform.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.huazai.livehouse.wechat.subscription.platform.common.util.GsonUtil;
import com.huazai.livehouse.wechat.subscription.platform.factory.HttpsClientRequestFactory;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.AccessTokenRequest;
import com.huazai.livehouse.wechat.subscription.platform.pojo.https.req.ButtonRequest;
import com.huazai.livehouse.wechat.subscription.platform.service.RedisService;
import com.huazai.livehouse.wechat.subscription.platform.service.SendHttpsReqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @apiNote :发送https请求实现类
 * @author        :林尚华
 * @date    : 2019/01/02 17:20
 */
@Service(version ="1.0.0",interfaceClass = SendHttpsReqService.class,timeout = 60000)
public class SendHttpsReqServiceImpl<E> implements SendHttpsReqService<E>{

    private static Logger log = LoggerFactory.getLogger(SendHttpsReqServiceImpl.class);

    @Value("${wechat.url.post.menu.create}")
    private String createMenuUrl;

    @Resource
    private RedisService redisService;

    @Override
    public Object doGet(E e) {
        //请求头信息（选择性设置）
        //HttpHeaders实现了MultivalueMap接口
        HttpHeaders httpHeaders = new HttpHeaders();
        //给请求头中添加一些数据
        httpHeaders.add("lin", "他很帅！");
        if (e instanceof AccessTokenRequest){
            URI uri = getAccessTokenUrl((AccessTokenRequest)e);
            //GET请求 创建HttpEntity时，请求体传入null即可
            ResponseEntity<String> response =sendHttpsReqToTencent(uri, httpHeaders,null,HttpMethod.GET);
            log.info("获取到的状态码：{}" ,response.getStatusCodeValue());
            if (response.hasBody()){
                log.info("获取到的响应体为：{}",response.getBody());
                return response;
            }
        }
        return null;
    }

    @Override
    public Object doPost(E e) {
        //请求头信息（选择性设置）
        //HttpHeaders实现了MultivalueMap接口
        HttpHeaders httpHeaders = new HttpHeaders();
        //给请求头中添加一些数据
        httpHeaders.add("lin", "他很帅！");
        if (e instanceof ButtonRequest){
            URI uri = getCreateMenu();
            ResponseEntity<String> reponse = sendHttpsReqToTencent(uri, httpHeaders, e, HttpMethod.POST);
        }
        return null;
    }

    private ResponseEntity<String> sendHttpsReqToTencent(URI uri,HttpHeaders httpHeaders, E e, HttpMethod method){
        //获取rest客户端实例
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
        //解决（响应数据可能）中文乱码的问题
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        //移除原来的转换器
        converterList.remove(1);
        //设置字符编码为utf-8
        HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        //添加新的转换器（注：convert顺序错误会导致失败）
        converterList.add(1, converter);
        //请求体的类型任选即可；只要保证请求体的类型与HttpEntity的泛型保持一致即可
        if (e == null){
            HttpEntity<String> httpEntity = new HttpEntity<>(null, httpHeaders);
            return restTemplate.exchange(uri, method,httpEntity,String.class);
        }
        HttpEntity<E> httpEntity = new HttpEntity<>(e, httpHeaders);
        return restTemplate.exchange(uri, method,httpEntity,String.class);
    }

    private URI getAccessTokenUrl(AccessTokenRequest request){
        StringBuffer paramsUrl = new StringBuffer(request.getUrl());
        paramsUrl.append("?grant_type=" + request.getGrantType());
        paramsUrl.append("&appid=" + request.getAppId());
        paramsUrl.append("&secret=" + request.getSecret());
        return URI.create(paramsUrl.toString());
    }

    /**
     * 获取添加菜单的url地址
     * @return URI
     */
    private URI getCreateMenu(){
        StringBuffer paramsUrl = new StringBuffer(createMenuUrl);
        paramsUrl.append(redisService.getValueOperations("access_token"));
        return URI.create(paramsUrl.toString());
    }
}
