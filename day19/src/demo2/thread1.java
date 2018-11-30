package demo2;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class thread1 extends Thread {
    HashMap<String, String> map;
    StringBuffer xiancheng;
    OutputStream out;

    public  thread1(HashMap<String, String> map,StringBuffer xiancheng,OutputStream out) {
        this.out=out;
        this.map=map;
        this.xiancheng=xiancheng;
    }
    @Override
    public void run() {
        while (true){
            try {
                thread1.sleep ( 1000 );
            } catch (InterruptedException e) {

            }
            try {
                if (map.containsKey ( xiancheng.toString () )){
                    String remove = map.remove ( xiancheng.toString () );
                    out.write ( (remove).getBytes () );
                }
            } catch (IOException e) {
                e.printStackTrace ( );
            }
        }
    }
}
