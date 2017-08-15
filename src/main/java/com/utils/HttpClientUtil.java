// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HttpClientUtil.java

package com.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EntityUtils;

// Referenced classes of package utils:
//			SSLClient

public class HttpClientUtil
{

	public HttpClientUtil()
	{
	}

	public static String doPost(String url, Map map, String charset)
	{
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try
		{
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			List list = new ArrayList();
			Map.Entry elem;
			for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); list.add(new BasicNameValuePair((String)elem.getKey(), (String)elem.getValue())))
				elem = (Map.Entry)iterator.next();

			if (list.size() > 0)
			{
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null)
			{
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null)
					result = EntityUtils.toString(resEntity, charset);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}

	public static String executeHttpPostRequest(String url, Map paramMap)
	{
		List paramspairs = new ArrayList();
		if (paramMap != null && paramMap.size() > 0)
		{
			Map.Entry entry;
			for (Iterator iterator = paramMap.entrySet().iterator(); iterator.hasNext(); paramspairs.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
				entry = (Map.Entry)iterator.next();

		}
		String proxyHost = "10.126.0.92";
		int proxyPort = 8081;
		HttpClient httpclient = new DefaultHttpClient();
		HttpHost proxy = new HttpHost(proxyHost, proxyPort);
		httpclient.getParams().setParameter("http.route.default-proxy", proxy);
		HttpPost httpPost = new HttpPost(url);
		httpclient.getParams().setParameter("http.socket.timeout", Integer.valueOf(10000));
		httpclient.getParams().setParameter("http.connection.timeout", Integer.valueOf(10000));
		String result = null;
		try
		{
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramspairs, "UTF-8");
			httpPost.setEntity(entity);
			HttpResponse response = httpclient.execute(httpPost);
			InputStream is = response.getEntity().getContent();
			BufferedInputStream bis = new BufferedInputStream(is);
			ByteArrayBuffer baf = new ByteArrayBuffer(20);
			for (int current = 0; (current = bis.read()) != -1;)
				baf.append((byte)current);

			result = new String(baf.toByteArray(), "utf-8");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	//post请求传String
	 public static String executeHttpPostRequestString(String url, String json) {
             HttpClient httpclient = new DefaultHttpClient();
             HttpPost httpPost = new HttpPost(url);
             httpclient.getParams().setParameter("http.socket.timeout",20000);
             httpclient.getParams().setParameter("http.connection.timeout",20000);
             String result = null;
             HttpResponse response;
             try {
                     StringEntity se = new StringEntity(json,"UTF-8");
             se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
                     httpPost.setEntity(se);
                     httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
                     response = httpclient.execute(httpPost);
                     InputStream is = response.getEntity().getContent();
                     BufferedInputStream bis = new BufferedInputStream(is);
                     ByteArrayBuffer baf = new ByteArrayBuffer(20);
                     int current = 0;
                     while ((current = bis.read()) != -1) {
                             baf.append((byte) current);
                     }
                     result = new String(baf.toByteArray(),"utf-8");
             } catch (Exception e) {
                     e.printStackTrace();
             }
             return result;
     }
	
}
