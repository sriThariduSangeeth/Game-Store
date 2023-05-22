package com.store.game.util;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Objects;

public class HttpClient {

//    private static volatile HttpClient INSTANCE  = null;
//    private CloseableHttpClient httpClient;
//    private CloseableHttpResponse httpResponse;
//
//
//    private HttpClient(){
//        try {
//            this.httpClient = HttpClients.createDefault();
//        }catch (Exception e){
//
//        }
//    }
//
//    public synchronized static HttpClient getInstance() {
//        if (INSTANCE == null) {
//            INSTANCE = new HttpClient();
//        }
//        return INSTANCE;
//    }
//
//    public CloseableHttpResponse getHttpClient(HttpUriRequest request, ResponseHandler responseHandler, Objects obj){
//        try {
//            this.httpResponse = this.httpClient.execute(obj);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return this.httpClient;
//    }

}
