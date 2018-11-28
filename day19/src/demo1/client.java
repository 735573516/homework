package demo1;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
//爬虫
public class client {
    public static void main(String[] args) throws IOException {
        Random random = new Random ( );
        HttpURLConnection connection = (HttpURLConnection)
                new URL ("https://tieba.baidu.com/p/2256306796?red_tag=1781367364/html").openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader buffer = new BufferedReader ( new InputStreamReader ( in ) );
        while (true){
            String s = buffer.readLine ( );
            if (s==null){
                break;
            }else {
                if (s.contains ( "<img" )){
                    show(s,random);
                }
            }
        }
    }

    private static void show(String s,Random random) throws IOException {
        int imgindex = s.indexOf ( "<img" );
        String s1 = s.substring ( imgindex );
        int srcindex = s1.indexOf ( "src=" );
        String s2 = s1.substring ( srcindex+5);
        int yinindex = s2.indexOf ( "\"" );
        String s3 = s2.substring ( 0, yinindex );
        System.out.println (s3 );
        if (s3.startsWith ( "http" )){
            HttpURLConnection url = (HttpURLConnection)new URL ( s3 ).openConnection ( );
            InputStream in = url.getInputStream ( );
            String i = random.nextInt ( )+"";
            FileOutputStream out = new FileOutputStream ( "C:\\Users\\Administrator\\Desktop\\jpg\\" + i + ".png" );

            while (true){
                byte[] bytes = new byte[1024 * 8];
                int read = in.read ( bytes );
                if (read==-1){
                    break;
                }
                out.write ( bytes,0,read );
            }
        }
        String str = s2.substring ( yinindex );
        if (str.contains ( "<img" )){
            show ( str,random );
        }
    }
}