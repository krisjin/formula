package org.formula.camp.week02;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author krisjin
 * @date 2020/11/1
 */
public class A {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:8808/test");
//        httpGet.setURI();
        CloseableHttpResponse response = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(2000) //服务器响应超时时间
                    .setConnectTimeout(2000) //连接服务器超时时间
                    .build();

            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println(String.format("response status = %s：", response.getStatusLine().getStatusCode()));
            String result = EntityUtils.toString(entity);
            System.out.println(String.format("response content = %s：", result));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            response.close();
//            httpClient.close();
        }
    }
}
