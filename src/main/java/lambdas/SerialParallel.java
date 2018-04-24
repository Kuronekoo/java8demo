package lambdas;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @program: java8demo
 * @description: ${description}
 * @author: Kuroneko
 * @create: 2018-04-23 20:41
 **/
public class SerialParallel {

    @Test
    public void testSerialParallel() {
        Instant start = Instant.now();

        LongStream.rangeClosed(0l,1000000000L)
                //parallel的底层是forkJoin，同时提供了一个公共的forkJoinPool
                .parallel()
                .reduce(0,Long::sum);
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());


    }

}
