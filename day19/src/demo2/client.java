package demo2;


import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket ( "192.168.1.204", 5556);
        OutputStream out = socket.getOutputStream ( );
        InputStream in = socket.getInputStream ( );
        StringBuffer name = new StringBuffer ( );
        while (true){
            BufferedReader sc = new BufferedReader ( new InputStreamReader ( System.in ) );
            System.out.print ("请输入你的昵称:" );
            String name1 = sc.readLine ();
            out.write ( ("a"+"-"+name1).getBytes () );
            byte[] bytes = new byte[1024 * 8];
            int read = in.read ( bytes );
            String s = new String ( bytes, 0, read );
            String[] split = s.split ( "-" );
            if (split[0].equals ( "a" )) {
                if (split[1].equals ( "true" )){
                    name.append ( name1 );
                    show();
                    break;
                }else{
                    System.out.println ("该名字已经存在" );
                }
            }
        }
        new Thread ( new Runnable ( ) {//收消息线程
            @Override
            public void run() {
                try {
                    while (true){
                        byte[] bytes = new byte[1024 * 8];
                        int read = in.read ( bytes );
                        String s2 = new String ( bytes, 0, read );
                        String[] str = s2.split ( "-" );
                        if (str[0].equals ( "d" )){
                            if (str.length==2){
                                System.out.print ("当前聊天室中的成员有：" );
                                String[] split1 = str[1].split ( "," );
                                for (String s:split1){
                                    System.out.print (s+"  " );
                                }
                                System.out.println ( );
                            }

                        }else if (str[0].equals ( "e" )){
                            if (str.length==1){break;}
                            else if (str.length==2){
                                String[] split1 = str[1].split ( "_" );
                                for (String s:split1){
                                    String[] split2 = s.split ( "%" );
                                    System.out.println ( split2[0]+"发来消息："+split2[1]);
                                }
                                break;
                            }
                        }else if (str[0].equals ( "b" )){
                            String[] split = s2.split ( "^" );
                            for (String s:split){
                                String[] split1 = s.split ( "-" );
                                System.out.println (split1[1]+"发来消息："+split1[2] );
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println ("读取异常" );
                }
            }
        } ).start ();
        new Thread ( new Runnable ( ) {//发消息线程
            @Override
            public void run() {
                while (true){
                    Scanner sc = new Scanner ( System.in );
                    String next = sc.next ( );
                    String[] split = next.split ( "-" );
                    try {
                        if (split[0].equals ( "b" )){
                            if (split.length==3){
                                String s=split[0]+"-"+name.toString () +"-"+
                                        split[1]+"-"+split[2];
                                out.write ( s.getBytes () );
                            }else {
                                System.out.println ("你输入的格式有误" );
                            }
                        }else if (split[0].equals ( "c" )){
                            if (split.length==2){
                                String s=split[0]+"-"+name.toString () +"-"
                                        +split[1];
                                out.write ( s.getBytes () );
                            }else {
                                System.out.println ("你输入的格式有误" );
                            }
                        } else if (split[0].equals ( "d" )){
                            if (split.length==1){
                                String s=split[0]+"-"+name.toString () ;
                                out.write ( s.getBytes () );
                            }else {
                                System.out.println ("你输入的格式有误 ");
                            }
                        }
                        else if (split[0].equals ( "e" )){
                            if (split.length==1){
                                String s=split[0]+"-"+name.toString () ;
                                out.write ( s.getBytes () );
                                break;
                            }else {
                                System.out.println ("你输入的格式有误 ");
                            }
                        }else {
                            System.out.println ("错误的命令！" );
                        }

                    }catch (IOException e){

                    }

                }
            }
        } ).start ();
    }

    private static void show() {
        System.out.println ("--------------------------------------------------------" );
        System.out.println ("************************欢迎使用*************************" );
        System.out.println ("功能如下" );
        System.out.println ("1.私聊   输入格式（b-目标名字-内容）" );
        System.out.println ("2.群发   输入格式（c-内容）" );
        System.out.println ("3.查看当前成员   输入格式（d-）" );
        System.out.println ("4.退出   输入格式（e-）" );
    }
}
