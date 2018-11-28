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
        HashMap <String, String> nei = new HashMap <> ( );
        while (true) {
            Socket accept = ser.accept ( );
            new Thread (  ){
                @Override
                public void run() {
                    try {
                        OutputStream out = accept.getOutputStream ( );
                        InputStream in = accept.getInputStream ( );
                        while (true) {
                            byte[] bytes = new byte[1024 * 8];
                            int read = in.read ( bytes );
                            String s = new String ( bytes, 0, read );
                            String[] split = s.split ( "-" );
                            if (split[0].equals ( "a" )) {
                                boolean add = set.add ( split[1] );
                                if (add){
                                    out.write ( "a-true".getBytes () );
                                }else {
                                    out.write ( "a-false".getBytes () );
                                }
                            } else if (split[0].equals ( "b" )) {
                                if (nei.containsKey ( split[2] )){
                                    String remove = nei.remove ( split[2] );
                                    nei.put (split[2],remove+"_"+split[1]+"%"+split[3] );
                                } if (nei.containsKey ( split[2])==false){
                                    nei.put (split[2],split[1]+"%"+split[3] );
                                } if (nei.containsKey ( split[1] )){
                                    String remove = nei.remove ( split[1] );
                                    out.write (("b-"+remove).getBytes ());
                                    System.out.println ("已经反馈" );
                                } if (nei.containsKey ( split[1] )==false){
                                    out.write ( "b-".getBytes ());
                                    System.out.println ("已经反馈" );
                                }
                            } else if (split[0].equals ( "c" )) {
                                for (String s1:set){
                                    if (nei.containsKey ( s1 )){
                                        String remove = nei.remove ( s1);
                                        nei.put (s1,remove+"_"+split[1]+"%"+split[2] );
                                    }else if (nei.containsKey ( s1)==false){
                                        nei.put (s1,split[1]+"%"+split[2] );
                                    }
                                }
                                if (nei.containsKey ( split[1] )){
                                    String remove = nei.remove ( split[1] );
                                    out.write (("b-"+remove).getBytes ());
                                    System.out.println ("已经反馈" );
                                }
                            } else if (split[0].equals ( "d" )) {
                                StringBuffer stringBuffer = new StringBuffer ( );
                                for (String s1:set){
                                    stringBuffer.append ( s1+"," );
                                }
                                if (nei.containsKey ( split[1] )){
                                    String remove = nei.remove ( split[1] );
                                    out.write ( (split[0]+ "-"
                                            +stringBuffer.toString ()+"-"+remove
                                    ).getBytes () );
                                }else {
                                    out.write ( (split[0]+ "-" +stringBuffer.toString ()).getBytes () );
                                }

                            } else if (split[0].equals ( "e" )) {
                                if (nei.containsKey ( split[1] )){
                                    String remove = nei.remove ( split[1] );
                                    out.write ( (split[0]+ "-"+remove).getBytes () );
                                    set.remove ( split[1] );
                                }else {
                                    set.remove ( split[1] );
                                    out.write ( "e-".getBytes () );
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println ("有人退出" );
                    }
                }
            }.start ();
        }
    }
}
