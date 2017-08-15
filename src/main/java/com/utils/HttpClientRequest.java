package com.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.logging.log4j.LogManager;


import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.Logger;


public class HttpClientRequest {

	private static Logger logger = LogManager.getLogger(HttpClientRequest.class);
	private final static Pattern AT_PATTERN = Pattern
			.compile("@[\\u4e00-\\u9fa5\\w\\-]+");

	private final static Pattern TAG_PATTERN = Pattern.compile("#([^\\#|.]+)#");

	private final static Pattern LINK_PATTERN = Pattern
			.compile("http://t.cn/([a-zA-Z0-9]+)");

	private final static  Pattern FACE_PATTERN = Pattern.compile("\\[[\\u4e00-\\u9fa5\\w\\-]+\\]");
	
	public final static String ENCODE = "utf-8"; //编码
	
	public final static int SLEEP = 100; // 请求重试 间隔时间
	public final static int TRY_MAX = 3; // 请求最多尝试次数
	public final static String WEIBO_URL = "http://food.weibo.com/proxy/proxy.gotosae?source=1751316174&password=yazuo_sae_2012&sid=v_food"; // 默认代理url;
	public static String executeHttpRequest(String url,Map<String, String> paramMap) {
		if (paramMap != null) {
			Set<String> keySet = paramMap.keySet();
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				String key = it.next();
				url +=key.trim() + "=" + paramMap.get(key).trim()+ "&";
			}
		}
		
		return executeHttpRequest(url, 0,false);

	}
	
	public static String executeHttpRequest(Map<String, String> paramMap) {
		String url = "";
		if (paramMap != null) {
			Set<String> keySet = paramMap.keySet();
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				String key = it.next();
				url += "&" + key.trim() + "=" + paramMap.get(key).trim();
			}
		}
		return executeHttpRequest(url, 0,true);
	}
	/**
	 * 
	 * @param url
	 * @param tryNum
	 * @param urlIsDefault  如果是默认则访问新浪微博
	 * @return
	 */
	private static String executeHttpRequest(String url, int tryNum,boolean urlIsDefault) {
		HttpClient httpclient = new DefaultHttpClient();
		if(urlIsDefault){//如果是默认则访问新浪微博
			url = (WEIBO_URL + url).replaceAll(" ", "");
		}else{
			url=url.replaceAll(" ", "");
		}
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e2) {
			e2.printStackTrace();
			throw new RuntimeException(e2.getMessage());
		}
		HttpGet httpGet = new HttpGet(uri);
		String result = null;
		HttpResponse response;
		try {
			response = httpclient.execute(httpGet);
			InputStream is = response.getEntity().getContent();
			BufferedInputStream bis = new BufferedInputStream(is);
			ByteArrayBuffer baf = new ByteArrayBuffer(20);
			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}
			result = new String(baf.toByteArray(),ENCODE);
		} catch (Exception e) {
			while (true) {
				try {
					Thread.sleep(SLEEP);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (tryNum <TRY_MAX) {
					tryNum++;
					result = executeHttpRequest(url, tryNum,urlIsDefault);
				} else {
					break;
				}
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}
	
	public static String executeHttpPostRequest(String url, Map<String, String> paramMap) throws Exception {
//		List<NameValuePair> paramspairs = new ArrayList<NameValuePair>();
//		if(paramMap != null && paramMap.size() > 0) {
//			for(Map.Entry<String, String> entry : paramMap.entrySet()) {
//				paramspairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//			}
//		}
//		String proxyHost = "10.126.0.92";
//		int proxyPort = 8081;
//		String proxyHost = RiskConst.PROXY_HOST;
//                int proxyPort = RiskConst.PROXY_PORT;
		
		HttpClient httpclient = new DefaultHttpClient();
//		HttpHost proxy = new HttpHost(proxyHost, proxyPort);
//		httpclient.getParams().setParameter("http.route.default-proxy", proxy);
		
		HttpPost httpPost = new HttpPost(url);
		httpclient.getParams().setParameter("http.socket.timeout",10000);
		httpclient.getParams().setParameter("http.connection.timeout",10000);
		//httpclient.getParams().setParameter("http.connection-manager.timeout",60*60L);
		String result = null;
		HttpResponse response;
		try {
//			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramspairs, "UTF-8");
////			entity.setContentType("application/json");
//			httpPost.setEntity(entity);

			String jsonString = JSONObject.toJSONString(paramMap);

			StringEntity entity = new StringEntity(jsonString,"utf-8");
			System.out.println("jsonString->"+jsonString);
			httpPost.setEntity(entity);

			httpPost.setHeader("Content-Type","application/json");
//			System.out.println("url-->"+url);
			response = httpclient.execute(httpPost);
			System.out.println(response.getHeaders("Content-Type")[0]);
			InputStream is = response.getEntity().getContent();
			BufferedInputStream bis = new BufferedInputStream(is);
			ByteArrayBuffer baf = new ByteArrayBuffer(20);
			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}
			result = new String(baf.toByteArray(),ENCODE);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	


}
