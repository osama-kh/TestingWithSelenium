package infra;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.openqa.selenium.json.Json;

import java.io.IOException;
import java.net.URLConnection;

public class HttpFacade {

    public static int getStatus() {
        return status;
    }

    private static int status;



    public enum HttpMethod {
        GET, POST,DELETE,PATCH
    }
    public static <T> T GET(Class<T> clz,String URL){
        String result = null;
        HttpGet request = new HttpGet(URL);
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            try(CloseableHttpResponse response = httpClient.execute(request)){
                HttpEntity entity =response.getEntity();
                result = EntityUtils.toString(entity);
                status= response.getCode();

            }

        } catch (IOException | ParseException e ) {
            throw new RuntimeException(e);
        }
        Gson gson=new Gson();
        try{
            System.out.println(result);
            return  gson.fromJson(result, clz);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static <T> T POST(Class<T> clz,String URL) {
        String result = null;
        String acceptHeader = "application/json";
        String contentTypeHeader = "application/json";
        String requestBody = "{\"id\": 121212, \"name\": \"Shalom's place\", \"score\": 3.2, \"address\": \"The street 1\"}";

        HttpPost request = new HttpPost(URL);
        request.setHeader("accept", acceptHeader);
        request.setHeader("Content-Type", contentTypeHeader);
        request.setEntity(new StringEntity(requestBody, ContentType.parse("UTF-8")));



        HttpEntity entity;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                entity = response.getEntity();
                result = EntityUtils.toString(entity);

            }

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        Gson gson = new Gson();
        try {
            return gson.fromJson(result  , clz);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }





    public static <T> T makeHttpRequest(Class<T> clz, String URL, HttpMethod method, String requestBody) {
        String result = null;
        CloseableHttpResponse response = null;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            if (method == HttpMethod.GET) {
                HttpGet request = new HttpGet(URL);
                response = httpClient.execute(request);
            } else if (method == HttpMethod.POST) {
                HttpPost request = new HttpPost(URL);
                request.setHeader("accept", "application/json");
                request.setHeader("Content-Type", "application/json");
                request.setEntity(new StringEntity(requestBody, ContentType.parse("UTF-8")));
                response = httpClient.execute(request);
            } else if (method == HttpMethod.PATCH) {
                HttpPatch request = new HttpPatch(URL);
                request.setHeader("accept", "application/json");
                request.setHeader("Content-Type", "application/json");
                request.setEntity(new StringEntity(requestBody, ContentType.parse("UTF-8")));
                response = httpClient.execute(request);

            } else if (method == HttpMethod.DELETE) {
                HttpDelete request = new HttpDelete(URL);
                response = httpClient.execute(request);

            }

            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    // Handle the exception if necessary
                }
            }
        }

        System.out.println(result);
        Gson gson = new Gson();
        try {
            return gson.fromJson(result, clz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
























}
