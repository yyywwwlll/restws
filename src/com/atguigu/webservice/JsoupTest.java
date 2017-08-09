package com.atguigu.webservice;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * 
 * 类描述：网页抓取测试
 * 
 * @author: ywl
 * @date： 日期：2017年7月21日 时间：下午3:40:48
 * @version 1.0
 */
public class JsoupTest {

	public static void main(String[] args) throws Exception {
		HttpClient httpclienta = null;
		String result = null;
		// 注意 Defaulthttpclient 已过时
		// 1. 创建HttpClient
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();

		// 2. 发送get请求
		HttpGet httpget = new HttpGet("http://img.alicdn.com/bao/uploaded/i3/TB14ji8SXXXXXbpXpXXXXXXXXXX_!!0-item_pic.jpg_220x330.jpg");

		// 3. 发送请求
		HttpResponse response = httpclient.execute(httpget);
		// 4. 得到返回信息
		HttpEntity entity = response.getEntity();
		// 5. 响应参数是否为200
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			result = EntityUtils.toString(entity, "UTF-8");
			System.out.println(result);
		} else {
			System.out.println("err:" + response.getStatusLine());
			;
		}
		// 6.清楚返回信息
		EntityUtils.consume(entity);
		// 7.关闭流
		httpclient.close();

		Document parse = Jsoup.parse(result);

		// 访问连接
		Document doc = Jsoup
				.connect(
						"https://list.tmall.com/search_product.htm?spm=875.7931836/B.subpannel2016025.1.10c849daSc6JgW&new=1&q=%CC%EC%C3%A8%C5%AE%D7%B0&pos=2&style=g&from=.list.pc_1_searchbutton&acm=2016031463.1003.2.1398732&search_condition=48&sort=s&shopType=any&scm=1003.2.2016031463.OTHER_1496779139035_1398732")
				.header("User-Agent",
						"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2")
				.get();
		// Connection connect = Jsoup
		// .connect("https://www.tmall.com/?ali_trackid=2:mm_26632331_7304251_24130794:1500882290_3k3_958642836");
		// // 设置请求头
		// Connection userAgent = connect
		// .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31");
		// // 设置超时时间
		// Connection timeout = userAgent.timeout(3000);
		// // 发起post请求得到document对象
		// Document doc = timeout.post();
		// 找到a标签
		Elements elements = doc.getElementsByTag("img");
		System.out.println(elements);
	}
}
