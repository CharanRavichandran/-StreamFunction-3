package com.kgisl.javastream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Optional;
import javax.xml.transform.stream.StreamSource;
import java.util.stream.*;
import java.util.stream.Stream;

class Streamfunctions
{
    public static void main(String[] args) {
        ArrayList<Person> l2=new ArrayList<Person>();
        
    //   Person  p1=new Person();
    //     p1.setAge(8777777777777l);
    //     l2.add(p1);

    //     System.out.println(l2);
        List<Person> persons=Arrays.asList(new Person("ani",2),new Person("vani",18),new Person("vani",99),new Person("azar",41));
        //Find Maximum value
        //persons.add(new Person("fff", 5));
        // persons.stream().min(Comparator.comparing(Person::getAge)).ifPresent(p->System.out.println("sort by alphabet order person max"+p));
        // //Find Minimum value
       
        // List<Person> l1=persons.stream().filter(s->s.getAge()>98).collect(Collectors.toList());
        // l1.stream().forEach(System.out::println);        
        // long n=persons.stream().filter(e->e.getAge()>97).count();
        // System.out.println(n);


        // List<String> d=persons.stream().map(Person::getName).distinct().collect(Collectors.toList());
        // d.forEach(System.out::println);

        persons.stream().skip(2).forEach(System.out::println);
        //limit
        
        System.out.println("limit");

        persons.stream().limit(0).forEach(System.out::println);


        boolean b1 = persons.stream().allMatch(p1->p1.getAge()>17 && p1.getName().startsWith("a"));
        System.out.println(b1);

        boolean b2 = persons.stream().noneMatch(p1->p1.getAge()>20 && p1.getName().startsWith("m"));
        System.out.println(b2);
          //anymatch
          boolean b3 = persons.stream().anyMatch(p1->p1.getAge()>20 && p1.getName().startsWith("v"));
          System.out.println(b3);
       //reduce
          String[] myArray = { "this", "is", "a", "sentence" };
String result = Arrays.stream(myArray)
                .reduce("", (a,b) -> a +b);
                System.out.println(result);
                 //number reduce
                 int[] myArray1 = { 1,2,3,4 };
                 int result1 = Arrays.stream(myArray1)
                 .reduce(1,(a,b) -> a * b);
 System.out.println(result1);

  //find any
  Optional<Person> anyEmpAbove40 = persons.stream().filter(emp -> emp.getAge() > 40).findAny();
if(anyEmpAbove40.isPresent()){
System.out.println("Any Employee above age 40: " + anyEmpAbove40.get());
}
    //find first
// Optional<Person> o1 = persons.stream().filter(emp -> emp.getAge() > 20).findFirst();
// if(o1.isPresent()){
// System.out.println("Any Employee above age 20: " + o1.get());
// }
 //find first
 Optional<Person> o1 = persons.stream()
 .filter(emp -> emp.getAge() > 20)
 .findFirst();
if(o1.isPresent()){
System.out.println("Any Employee above age 20: " + o1.get());
}

 //sort
 List<Person> slist = persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
 slist.forEach(System.out::println);
 //peek
 List<Integer> list = Arrays.asList(10,11,12);
 list.stream().peek(i->System.out.println(i*i)).collect(Collectors.toList());
// System.out.println(list);
//Map
List<String> c1 = persons.stream().map(Person::getName).collect(Collectors.toList());
System.out.println(c1);

System.out.println("parallel Stream");
Stream<Person> stream = persons.parallelStream();  
         List<Person> evenNumbersArr = stream.filter(emp -> emp.getAge() > 40).sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
         
         for(Person even:evenNumbersArr)
         {
           System.out.println(even);
         }
           //maptoint and sum
    long sum1 = persons.stream().mapToLong(Person::getAge).sum();
    System.out.println(sum1);
    //average
    double sum4 = persons.stream().mapToDouble(Person::getAge).average().getAsDouble();
    System.out.println(sum4);
      //collect
      List<Person> c2 = persons.stream().collect(Collectors.toList());
      System.out.println(c2);
       //stream builder
   Stream.Builder<String> b = Stream.builder();
   b.accept("a");
   b.accept("b");
   b.accept("c");
   b.accept("d");
   Stream<String> s = b.build();
   s.forEach(System.out::println);
      //flat map
      String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
      Stream<String[]> temp = Arrays.stream(data);

      Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));

      Stream<String> stream1= stringStream.filter(x -> "a".equals(x.toString()));

      stream1.forEach(System.out::println);
  
    }
   
    }

