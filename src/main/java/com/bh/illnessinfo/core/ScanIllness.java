package com.bh.illnessinfo.core;

import com.bh.illnessinfo.entity.IllnessInfo;
import com.bh.illnessinfo.service.IllnessInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring5.context.SpringContextUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RestController
public class ScanIllness {

    @Autowired
    private IllnessInfoService illnessInfoService;

    private String TARGET_URL="https://m.120ask.com/askg/posts_detail/";

    @GetMapping("scan")
    public String getHtmlBak(){
        log.info("=========开始执行扫描操作======");
        IllnessInfo illnessInfo=illnessInfoService.getLatestOne();
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(TARGET_URL+"100");
        CloseableHttpResponse response = null;
        String result="";
        try {
            //使用httpclient发送请求
            response = httpClient.execute(httpGet);
            //响应码为200是表示成功
            if (response.getStatusLine().getStatusCode() == 200) {
                //需要设置编码，这里主要看抓取的页面的编码，编码不一致会使结果乱码
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @GetMapping("scan2")
    public String getHtml() throws IOException {

        log.info("=========开始执行扫描操作======");
        IllnessInfo illnessInfo=illnessInfoService.getLatestOne();
        Document document = Jsoup.connect(TARGET_URL+"100").get();
        return document.toString();
    }

    @GetMapping("getInfo")
    public IllnessInfo getInfo(String htmlContent)
    {
        htmlContent=getHtmlBak();
        Document document=Jsoup.parse(htmlContent);
        IllnessInfo illnessInfo=new IllnessInfo();
        Elements sexDiv=document.getElementsByClass("g-under-askB");
        /*Element sexSpan=sexDiv.getElementsByTag("span").get(0);
        String sex=sexSpan.text().replace("性别：","");
        illnessInfo.setSex(sex);*/
        return illnessInfo;
    }



}
