import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.*;
public class RedirectAquisition {
    public static void main(String[] args) {
        try {
            String url = "https://www.google.com/news/";
            System.out.println("访问地址:" + url);

            //发送get请求
            URL serverUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");
            //必须设置false，否则会自动redirect到重定向后的地址
            conn.setInstanceFollowRedirects(false);
            conn.connect();

            //判定是否会进行302重定向
            if (conn.getResponseCode() == 302) {
                //如果会重定向，保存302重定向地址，以及Cookies,然后重新发送请求(模拟请求)
                String location = conn.getHeaderField("Location");
                System.out.println(location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
