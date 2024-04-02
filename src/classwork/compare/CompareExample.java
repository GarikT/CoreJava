package classwork.compare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompareExample {
    public static void main(String[] args) throws ParseException {
//        Set<String> nameSet = new TreeSet<>();
//        nameSet.add("Zaven");
//        nameSet.add("Aram");
//        nameSet.add("Poxos");
//
//        for (String s : nameSet) {
//            System.out.println(s);
//        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
        //Set<Student> students = new TreeSet<>();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Poxos", "Poxosyan", 21, simpleDateFormat.parse("2023") ));
        students.add(new Student("Petros", "Petrosyan", 20, simpleDateFormat.parse("2024")));
        students.add(new Student("Martiros", "Martirosyan", 22, simpleDateFormat.parse("2020")));

        students.sort(new AgeComparator());

        for (Student student : students) {
            System.out.println(student);
        }

        students.sort(new Comparator<Student>() { //Անոնիմ կլաս
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }

        String text = """
                asd
                asdf
                asdf
                asdf
                
                asdf
                sdfaasdf
                
                sadf
                """;
        System.out.println(text);
    }
}
