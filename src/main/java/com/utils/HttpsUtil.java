package com.utils;


import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IDEA
 *
 * @author Lee
 * @create 2016-12-23 上午12:47
 */
public class HttpsUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpsUtil.class);
    private static final Pattern AT_PATTERN = Pattern.compile("@[\\u4e00-\\u9fa5\\w\\-]+");
    private static final Pattern TAG_PATTERN = Pattern.compile("#([^\\#|.]+)#");
    private static final Pattern LINK_PATTERN = Pattern.compile("http://t.cn/([a-zA-Z0-9]+)");
    private static final Pattern FACE_PATTERN = Pattern.compile("\\[[\\u4e00-\\u9fa5\\w\\-]+\\]");
    public static final String ENCODE = "utf-8";
    public static final int SLEEP = 100;
    public static final int TRY_MAX = 3;
    public static final String WEIBO_URL = "http://food.weibo.com/proxy/proxy.gotosae?source=1751316174&password=yazuo_sae_2012&sid=v_food";

    public HttpsUtil() {
    }

    public static String executeHttpRequest(String url, Map<String, String> paramMap) {
        if (paramMap != null) {
            Set keySet = paramMap.keySet();

            String key;
            for (Iterator it = keySet.iterator(); it.hasNext(); url = url + key.trim() + "=" + ((String) paramMap.get(key)).trim() + "&") {
                key = (String) it.next();
            }
        }

        return executeHttpRequest(url, 0, false);
    }

    public static String executeHttpRequest(Map<String, String> paramMap) {
        String url = "";
        if (paramMap != null) {
            Set keySet = paramMap.keySet();

            String key;
            for (Iterator it = keySet.iterator(); it.hasNext(); url = url + "&" + key.trim() + "=" + ((String) paramMap.get(key)).trim()) {
                key = (String) it.next();
            }
        }

        return executeHttpRequest(url, 0, true);
    }

    private static String executeHttpRequest(String url, int tryNum, boolean urlIsDefault) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        if (urlIsDefault) {
            url = ("http://food.weibo.com/proxy/proxy.gotosae?source=1751316174&password=yazuo_sae_2012&sid=v_food" + url).replaceAll(" ", "");
        } else {
            url = url.replaceAll(" ", "");
        }

        URI uri = null;

        try {
            uri = new URI(url);
        } catch (URISyntaxException var13) {
            throw new RuntimeException(var13.getMessage());
        }

        HttpGet httpGet = new HttpGet(uri);
        String result = null;

        try {
            HttpResponse response = httpclient.execute(httpGet);
            InputStream e = response.getEntity().getContent();
            BufferedInputStream e1 = new BufferedInputStream(e);
            ByteArrayBuffer baf = new ByteArrayBuffer(20);
            boolean current = false;

            int var15;
            while ((var15 = e1.read()) != -1) {
                baf.append((byte) var15);
            }

            result = new String(baf.toByteArray(), "utf-8");
        } catch (Exception var14) {
            do {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException var12) {
                    var12.printStackTrace();
                }

                if (tryNum >= 3) {
                    break;
                }

                ++tryNum;
                result = executeHttpRequest(url, tryNum, urlIsDefault);
            } while (result == null);
        }

        return result;
    }

    public static String executeHttpPostRequest(String url, Map<String, String> paramMap) {
        ArrayList paramspairs = new ArrayList();
        if (paramMap != null && paramMap.size() > 0) {
            Iterator httpPost = paramMap.entrySet().iterator();

            while (httpPost.hasNext()) {
                Map.Entry httpclient = (Map.Entry) httpPost.next();
                paramspairs.add(new BasicNameValuePair((String) httpclient.getKey(), (String) httpclient.getValue()));
            }
        }

        DefaultHttpClient httpclient1 = new DefaultHttpClient();
        HttpPost httpPost1 = new HttpPost(url);
        httpclient1.getParams().setParameter("http.socket.timeout", Integer.valueOf(10000));
        httpclient1.getParams().setParameter("http.connection.timeout", Integer.valueOf(10000));
//        httpclient1.getParams().setParameter("api", Integer.valueOf(3));


        String result = null;

        try {
            UrlEncodedFormEntity e = new UrlEncodedFormEntity(paramspairs, "UTF-8");
            httpPost1.setEntity(e);

            httpPost1.setHeader("api","3");

            System.out.println("url-->" + url);
            HttpResponse response = httpclient1.execute(httpPost1);
            InputStream is = response.getEntity().getContent();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayBuffer baf = new ByteArrayBuffer(20);
            boolean current = false;

            int current1;
            while ((current1 = bis.read()) != -1) {
                baf.append((byte) current1);
            }

            result = new String(baf.toByteArray(), "utf-8");
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        return result;
    }

}
