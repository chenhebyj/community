package com.example.demo.provider;

import com.alibaba.fastjson.JSON;
import com.example.demo.dto.AccessToken;
import com.example.demo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import javax.net.ssl.*;
import java.io.IOException;

@Component
public class GithubProvider {
    //okHttp3添加信任所有证书

    public static OkHttpClient getUnsafeOkHttpClient() {

        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final javax.net.ssl.SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);

            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public String getToken(AccessToken accessToken){
            final MediaType mediaType = MediaType.get("application/json; charset=utf-8");
            OkHttpClient client = getUnsafeOkHttpClient();
            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessToken));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String s = response.body().string();
                //System.out.println(s);
                String s1 = s.split("&")[0].split("=")[1];
                return s1;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }

    public GithubUser getUser(String token){
        OkHttpClient client = getUnsafeOkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+token)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                String s = response.body().string();
                GithubUser user = JSON.parseObject(s, GithubUser.class);
                return  user;
            } catch (IOException e) {
                e.printStackTrace();
            }

        return null;
    }

}
