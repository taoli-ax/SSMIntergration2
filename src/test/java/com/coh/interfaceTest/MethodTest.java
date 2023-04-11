package com.coh.interfaceTest;
import com.coh.domain.Cup;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.net.*;
import java.io.*;
public class MethodTest {
    public static void main(String[] args) {
        try {
            GetTest();
            postTest();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void GetTest() throws IOException {
        URL url = new URL("http://localhost:8080/SSMIntergration2_war_exploded/cups/count");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
    @Test
    public static void postTest() throws IOException {
        String url = "http://localhost:8080/SSMIntergration2_war_exploded/cups";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // 设置 HTTP 请求头部信息
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        // 设置请求体对象，并转json
        Cup cup=new Cup();
        cup.setName("nihao");
        cup.setBrand("steel");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(cup);

        // 发送请求参数
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(json);
        wr.flush();
        wr.close();

        // 获取请求相应结果
        int responseCode = con.getResponseCode();
        System.out.println("nSending POST request to URL : " + url);
        System.out.println("Post request Body : " + cup);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // 打印响应结果
        System.out.println(response.toString());
    }

}
