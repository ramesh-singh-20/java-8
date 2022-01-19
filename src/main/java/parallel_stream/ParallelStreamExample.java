package parallel_stream;

import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static void parallelStream(){
        long startTime= System.currentTimeMillis();
        IntStream.range(1, 100).forEach(System.out:: println);
        long endTime= System.currentTimeMillis();
        System.out.println("Time Taken by Sequential Stream: "+(endTime-startTime));

        System.out.println("********************************");
        long startTime1= System.currentTimeMillis();
        IntStream.range(1, 100).parallel().forEach(System.out:: println);
        long endTime1= System.currentTimeMillis();
        System.out.println("Time Taken by parallel Stream: "+(endTime1-startTime1));
    }


}
