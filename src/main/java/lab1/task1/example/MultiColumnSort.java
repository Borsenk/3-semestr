package lab1.task1.example;

import lab1.task1.QuickSort;
import lab1.task1.SimpleArrayList;
import lab1.task1.SimpleList;

import java.util.Comparator;

public class MultiColumnSort {


    static class Student {
        public String name;
        int age;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name +
                    "', age=" + age +
                    "}";
        }
    }

    private final Student[] arr=new Student[]{
            new Student("Name 1",23),
            new Student("Name 7",18),
            new Student("Name 5",21),
            new Student("Name 4",23),
            new Student("Name 3",19),
            new Student("Name 6",20),
            new Student("Name 2",23)
    };


    public static void main(String[] args) {
        new MultiColumnSort().test();
    }

    private <T> void  prn(SimpleList<T> lst){
        System.out.println(lst.toString().replace("},","}\n"));

    }
    private void test() {
        var list=new SimpleArrayList<Student>();
        for(Student s : arr){
            list.add(s);
        }

        prn(list);
        QuickSort.sort(list, Comparator.comparing(Student::getAge).reversed());
        prn(list);

        QuickSort.sort(list, Comparator.comparing(Student::getAge).reversed().thenComparing(Student::getName).reversed());
        prn(list);

    }


}