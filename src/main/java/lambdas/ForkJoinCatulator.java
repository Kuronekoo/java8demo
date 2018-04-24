package lambdas;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.concurrent.RecursiveTask;

/**
 * @program: java8demo
 * @description: ${description}
 * @author: Kuroneko
 * @create: 2018-04-23 21:47
 **/
@NoArgsConstructor
@AllArgsConstructor
public class ForkJoinCatulator extends RecursiveTask<Long> {

    private static final Long THRESHOLD = 10000L;
    private Long start;
    private Long end;


    @Override
    protected Long compute() {
        Long length = end - start;
        if(length<=THRESHOLD){
            Long sum = 0l;
            for (Long i =start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else {
            Long middle=(start+end)/2;
            ForkJoinCatulator left = new ForkJoinCatulator(start,middle);
            //拆分子任务，同时压入线程队列
            left.fork();

            ForkJoinCatulator right = new ForkJoinCatulator(middle+1,end);
            right.fork();

            return left.join()+right.join();
        }

    }
}
