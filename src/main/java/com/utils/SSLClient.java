// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   SSLClient.java

package com.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

public class SSLClient extends DefaultHttpClient
{

	public SSLClient()
		throws Exception
	{
		SSLContext ctx = SSLContext.getInstance("TLS");
		X509TrustManager tm = new X509TrustManager() {

			final SSLClient this$0;

			
			
			public void checkClientTrusted(X509Certificate ax509certificate[], String s)
				throws CertificateException
			{
			}

			public void checkServerTrusted(X509Certificate ax509certificate[], String s)
				throws CertificateException
			{
			}

			public X509Certificate[] getAcceptedIssuers()
			{
				return null;
			}

			{
			    
                            this$0 = SSLClient.this;
//                            super();
                    }
			
		};
		ctx.init(null, new TrustManager[] {
			tm
		}, null);
		SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		ClientConnectionManager ccm = getConnectionManager();
		SchemeRegistry sr = ccm.getSchemeRegistry();
		sr.register(new Scheme("https", 443, ssf));
	}
}
