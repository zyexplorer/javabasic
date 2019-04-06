package com.zhuyin.httpclient;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * <p>Title: HttpClientDemo.java</p>
 * <p>Description: HttpClient演示程序</p>
 * <p>Company: </p>
 * @author ZY
 * <p> Just go on !!!</p>
 * @date 2018年5月8日  下午8:09:03 
 * @version v1.0
 */
public class HttpClientDemo1 {
	
	public static void main(String[] args) throws Exception {
		
		List<NameValuePair>formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("account", "821516575@qq.com"));
		formparams.add(new BasicNameValuePair("password", "ZHUyin123"));
		
		HttpEntity reqEntigy = new UrlEncodedFormEntity(formparams,"UTF-8");
		
		Builder builder = RequestConfig.custom();
		RequestConfig config = builder.setConnectTimeout(5000)	//一、连接超时：connectionTimeout-->指的是连接一个url的连接等待时间 
								      .setSocketTimeout(5000)	//二、读取数据超时：SocketTimeout-->指的是连接上一个url，获取response的返回等待时间 
								      .setConnectionRequestTimeout(5000) 
								      .build();
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://cnivi.com.cn/login");
		post.setEntity(reqEntigy);
		post.setConfig(config);
		HttpResponse httpResponse = httpClient.execute(post);
		
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			HttpEntity httpEntity = httpResponse.getEntity();
			String responseStr = EntityUtils.toString(httpEntity, "UTF-8");
			System.out.println(responseStr);
		} else {
			System.out.println("请求失败");
		}
	}
}
