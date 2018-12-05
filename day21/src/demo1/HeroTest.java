package demo1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeroTest {
    public static void main(String[] args) throws IOException {
        HashSet <Hero> heroes = new HashSet <> ( );
        Stream <String> line = Files.lines ( Paths.get ( "C:\\Users\\Administrator\\Desktop" +
                "\\java\\21\\heroes.txt" ) );
        line.forEach ( s -> {
            String[] split = s.split ( "\t" );
            heroes.add ( new Hero ( split[1], split[2], split[3], Integer.valueOf ( split[4] ),
                    Integer.valueOf ( split[5] ), Integer.valueOf ( split[6] ) ) );

        } );
        System.out.println ( "武力值前三的对象有：" );
        heroes.stream ( ).sorted ( (o1, o2) -> o2.getLevel ( ) - o1.getLevel ( ) ).limit ( 3 ).forEach ( s -> System.out.println ( s ) );
        //下面按出生地分组-------------------------------------------------------------------
        System.out.println ( "--------------------------------------------------------------" );
        Map <String, List <Hero>> collect = heroes.stream ( ).collect ( Collectors.groupingBy ( s
                -> s.createplace ) );
        collect.forEach ( (key, value) -> {
            if (key.equals ( "" )) {
                System.out.println ( "没有产地的有：" );
                value.stream ( ).forEach ( s -> System.out.println ( s ) );
            } else {
                System.out.println ( "产自" + key + "的有：" );
                value.stream ( ).forEach ( s -> System.out.println ( s ) );
            }
        } );
        //下面找寿命前三的武将------------------------------------------------------------------
        System.out.println ( "--------------------------------------------------------------" );
        System.out.println ( "寿命前三的武将有：" );
        heroes.stream ( ).sorted ( new Comparator <Hero> ( ) {
            @Override
            public int compare(Hero o1, Hero o2) {
                return (o2.deathtime - o2.createtime - o1.deathtime + o1.createtime);
            }
        } ).limit ( 3 ).forEach ( s -> System.out.println ( s.getName ( ) ) );
        //下面找女性寿命最高的-----------------------------------------------------------------
        System.out.println ( "--------------------------------------------------------------" );
        System.out.println ( "女性寿命最高的人有：" );
        Map <String, List <Hero>> collect1 = heroes.stream ( ).collect ( Collectors.groupingBy ( s -> s.getSex ( ) ) );

        List <Hero> gir = collect1.get ( "女" ).stream ( ).sorted ( new Comparator <Hero> ( ) {
            @Override
            public int compare(Hero o1, Hero o2) {
                return (o2.deathtime - o2.createtime - o1.deathtime + o1.createtime);
            }
        } ).limit ( 1 ).collect ( Collectors.toList ( ) );
        collect1.get ( "女" ).stream ( ).forEach ( s -> {
            if ((s.getDeathtime ( ) - s.getCreatetime ( )) == (gir.get ( 0 ).getDeathtime ( ) - gir.get ( 0 ).getCreatetime ( ))) {
                System.out.println ( s.getName ( ) );
            }
        } );
        //下面找无力排名前三的-----------------------------------------------------------------
        System.out.println ( "--------------------------------------------------------------" );
        System.out.println ( "无力排名前三的人有：" );
        List <Hero> collect2 = heroes.stream ( ).sorted ( (s1, s2) -> s2.getLevel ( ) -
                s1.getLevel ( ) ).limit ( 3 ).collect ( Collectors.toList ( )
        );
        heroes.stream ( ).sorted ( (s1, s2) -> s2.getLevel ( ) - s1.getLevel ( ) ).forEach (
                s -> {
                    if (s.getLevel ( ) >= collect2.get ( 2 ).getLevel ( )) {
                        System.out.println ( s.getName ( ) );
                    }
                }
        );
        //下面按年龄段分组-----------------------------------------------------------------
        System.out.println ( "--------------------------------------------------------------" );
        Map <String, List <Hero>> collect3 = heroes.stream ( ).collect ( Collectors.groupingBy ( s -> s.getagelevel ( ) ) );
        collect3.forEach ( (a,b)->{
            System.out.println ("年龄段"+a+"的有：" );
            b.stream ().forEach ( c->{
                System.out.println (c.getName () );
            });
        } );
        //下面按武力年龄段分组-----------------------------------------------------------------
        System.out.println ( "--------------------------------------------------------------" );
        Map <String, List <Hero>> collect4 = heroes.stream ( ).collect ( Collectors.groupingBy ( s -> s.getlevelsection ( ) ) );
        collect4.forEach ( (a,b)->{
            System.out.println ("武力段"+a+"的有：" );
            b.stream ().forEach ( c->{
                System.out.println (c.getName () );
            } );
        } );
        //下面统计各出生地分组人数；
        System.out.println ( "--------------------------------------------------------------" );
        Map <String, List <Hero>> collect5 = heroes.stream ( ).collect ( Collectors.groupingBy ( s -> s.getCreateplace ( ) ) );
        collect5.forEach ( (a,b)->{
            if (a.equals ( "" )){
                System.out.println ("没有产地的人数有"+b.size ()+"人" );
            }else {
                System.out.println ("产自"+a+"的人数有"+b.size ()+"人" );
            }
        } );
    }
}
