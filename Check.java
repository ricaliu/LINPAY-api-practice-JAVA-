import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Check {

    public static void main(String[] args) {
	
     
        System.out.println("No PARAMS");

        try{
            URL obj = new URL("https://sandbox-api-pay.line.me/v2/payments/orders/TW2019-LINE-00005/check");
            HttpURLConnection c = (HttpURLConnection) obj.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-Type", "application/json");
            c.setRequestProperty("X-LINE-ChannelId", "1649580251");
            c.setRequestProperty("X-LINE-ChannelSecret", "ddca54d0f3e50847af3f6ec4fcaef890");

           

            int responseCode = c.getResponseCode();
            System.out.println("GET Response Code :  " + responseCode);
            System.out.println("GET Response Message : " + c.getResponseMessage());
            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        c.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in .readLine()) != null) {
                    response.append(inputLine);
                } in .close();
                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET NOT WORKED");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
