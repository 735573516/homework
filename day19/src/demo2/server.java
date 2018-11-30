package demo2;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.TreeSet;

public class server {
    public static void main(String[] args) throws IOException {

        ServerSocket ser = new ServerSocket ( 5556 );
        TreeSet<String> set = new TreeSet <> ( );
        HashMap <String, String> map = new HashMap <String,String> ( );
        while (true) {
            Socket accept = ser.accept ( );
            OutputStream out = accept.getOutputStream ( );
            InputStream in = accept.getInputStream ( );
            StringBuffer xiancheng = new StringBuffer ( );
            new  thread1 (map,xiancheng,out).start ();
            new Thread ( new Runnable ( ) {
                @Override
                public void run() {
                    try {
                        while (true) {
                            byte[] bytes = new byte[1024 * 8];
                            int read = in.read ( bytes );
                            String s = new String ( bytes, 0, read );
                            String[] split = s.split ( "-" );
                            if (split[0].equals ( "a" )) {
                                boolean add = set.add ( split[1] );
                                if (add){
                                    xiancheng.append ( split[1] );
                                    out.write ( "a-true".getBytes () );
                                }else {
                                    out.write ( "a-false".getBytes () );
                                }
                            } else if (split[0].equals ( "b" )) {
                                if (map.containsKey ( split[2] )){
                                    String remove = map.remove ( split[2] );
                                    map.put (split[2],"b-"+split[1]+"-"+split[3]+"^"+remove);
                                }else {
                                    map.put (split[2],"b-"+split[1]+"-"+split[3]);
                                }
                            } else if (split[0].equals ( "c" )) {
                                for (String ss:set){
                                    if (map.containsKey ( ss )){
                                        String remove = map.remove ( ss );
                                        map.put (ss,remove+"^"+"b"+"-"+split[1]+"-"+split[2]);
                                    }else {
                                        map.put ( ss,"b"+"-"+split[1]+"-"+split[2] );
                                    }

                                }
                            } else if (split[0].equals ( "d" )) {
                                StringBuffer stringBuffer = new StringBuffer ( );
                                for (String s1:set){
                                    stringBuffer.append ( s1+"," );
                                }
                                out.write ( ("d-"+stringBuffer.toString ()).getBytes () );
                            } else if (split[0].equals ( "e" )) {
                                set.remove ( split[1] );
                                out.write ( "e-".getBytes () );
                            }
                        }
                    } catch (IOException e) {
                        System.out.println ("有人退出" );
                    }
                }
            } ).start ();
        }
    }
}
