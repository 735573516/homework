package demo;

import dao.StudentDao;
import domain.Student;

import java.util.List;

public class test {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao ( );
        List <Student> all = dao.findAll ( );
        all.stream ().forEach ( a-> System.out.println (a ) );
    }
}
