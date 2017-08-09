package com.atguigu.wechart;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class AccessToken {
	public static void main(String[] args) throws Exception {

		// 1. 创建HttpClient
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();

		// 2. 发送get请求
		HttpGet httpget = new HttpGet(WechartConfig.access_token_url
									+ "grant_type=" + WechartConfig.grant_type 
									+ "&appid=" + WechartConfig.appid 
									+ "&secret=" + WechartConfig.appsecret);

		// 3. 发送请求
		HttpResponse response = httpclient.execute(httpget);
		// 4. 得到返回信息
		HttpEntity entity = response.getEntity();
		// 5. 响应参数是否为200
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			String result = EntityUtils.toString(entity, "UTF-8");
			System.out.println(result);
		} else {
			System.out.println("err:" + response.getStatusLine());
			;
		}
		// 6.清楚返回信息
		EntityUtils.consume(entity);
		// 7.关闭流
		httpclient.close();
	}

}
