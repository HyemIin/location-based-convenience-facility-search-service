package org.example.domain;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpUrlConnection {
    public String requestApiConnection(String url) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Authorization", "KakaoAK " + KakaoApi.API_KEY);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
        String apiInfo = bufferedReader.readLine();
        return apiInfo;
    }
}
