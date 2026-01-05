import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiClient {

    public static void main(String[] args) {
        try {
            // 1. API URL
            URL url = new URL("https://jsonplaceholder.typicode.com/users/1");

            // 2. Open connection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // 3. Read response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();

            // 4. Display response
            System.out.println("API Response:");
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
