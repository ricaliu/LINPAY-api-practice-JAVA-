//package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Refund {

    public static void main(String[] args) {
	// write your code here
        final String POST_PARAMS = "{\n" +
                "    \"refundAmount\": 35" +
                "\n}";
        System.out.println(POST_PARAMS);

        try{
            URL obj = new URL("https://sandbox-api-pay.line.me/v2/payments/orders/TW2019-LINE-00005/refund");
            HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("POST");
            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setRequestProperty("X-LINE-ChannelId", "1649580251");
            postConnection.setRequestProperty("X-LINE-ChannelSecret", "ddca54d0f3e50847af3f6ec4fcaef890");

            postConnection.setDoOutput(true);
            OutputStream os = postConnection.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();

            int responseCode = postConnection.getResponseCode();
            System.out.println("POST Response Code :  " + responseCode);
            System.out.println("POST Response Message : " + postConnection.getResponseMessage());
            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        postConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in .readLine()) != null) {
                    response.append(inputLine);
                } in .close();
                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("POST NOT WORKED");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
