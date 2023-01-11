import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.ObjectStreamException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.processing.FilerException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class api {
    public static void main(String[] args) {
        try {
            URL url=new URL("https://api.thingspeak.com/channels/875453/feeds.json?api_key=1DSQ7R1XTT1OK0Z1&results=20");
            HttpURLConnection u1=(HttpURLConnection)url.openConnection();
            u1.setRequestMethod("GET");
            InputStreamReader is=new InputStreamReader(u1.getInputStream());
            BufferedReader br=new BufferedReader(is);
             String st="";
             while(st!=null){
                st=br.readLine();
           // System.out.println(st);
                 
                br.close();
         JSONParser par=new JSONParser();
         JSONObject obj=(JSONObject)par.parse(st);
         JSONObject obj1=(JSONObject)obj.get("channel");
          System.out.println(obj1.get("name"));
          System.out.println(obj1.get("id"));
         

         JSONArray arr=(JSONArray)obj.get("feeds");
         for(int i=0;i<arr.size();i++){
           JSONObject obj2=(JSONObject)arr.get(0);
          System.out.println(obj2.get("field1"));
            
        }
            
    
        }
            

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
