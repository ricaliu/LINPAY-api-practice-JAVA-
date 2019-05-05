
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Gethello {

    public static void main(String[] args) {
	
     
        System.out.println("No PARAMS");

        try{
            URL obj = new URL("http://rica.topedu.io:5000/v2/payments/oneTimeKeys");
            HttpURLConnection c = (HttpURLConnection) obj.openConnection();
            c.setRequestMethod("GET");
         
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
