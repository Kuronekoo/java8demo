package lambdas;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @program: java8demo
 * @description: ${description}
 * @author: Kuroneko
 * @create: 2018-04-23 22:00
 **/
public class RunForkJoin {
    @Test
    public void test1(){
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCatulator(0l,100000000L);
        Long sum = forkJoinPool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());
    }


}
