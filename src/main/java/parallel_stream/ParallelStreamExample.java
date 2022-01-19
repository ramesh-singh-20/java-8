package parallel_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static void parallelStream(){
        /*long startTime= System.currentTimeMillis();
        IntStream.range(1, 100).forEach(System.out:: println);
        long endTime= System.currentTimeMillis();
        System.out.println("Time Taken by Sequential Stream: "+(endTime-startTime));

        System.out.println("********************************");
        long startTime1= System.currentTimeMillis();
        IntStream.range(1, 100).parallel().forEach(System.out:: println);
        long endTime1= System.currentTimeMillis();
        System.out.println("Time Taken by parallel Stream: "+(endTime1-startTime1));*/

        List<Employee> employeeList= new ArrayList<>();
        for(int i=0; i< 1000; i++){
            Employee employee= new Employee(new Random().nextDouble()*1000);
            employeeList.add(employee);
        }

        long start= 0;
        long end= 0;

        start= System.currentTimeMillis();
        var salarySeqStream = employeeList.stream()
                .map(emp -> emp.getSalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();

        end= System.currentTimeMillis();
        System.out.println("Time taken by sequential stream: "+ (end-start)
        + " Avg salary: "+ salarySeqStream);

        start= System.currentTimeMillis();
        var salaryParallelStream = employeeList.parallelStream()
                .map(emp -> emp.getSalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();

        end= System.currentTimeMillis();
        System.out.println("Time taken by parallel stream: "+ (end-start)
                + " Avg salary: "+ salaryParallelStream);


    }


}
