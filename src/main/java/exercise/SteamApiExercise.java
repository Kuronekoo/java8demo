package exercise;

import domain.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: Kuroneko
 * @Date: created in 20:54 2018/4/18
 * @Description:
 */
public class SteamApiExercise {
	/**
	  	1.	给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
		，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
	 */

	@Test
	public void exer1(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> collect = integers.stream()
                .map(e -> e * e)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    	/**
	 2.	怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
	 */

        List<Employee> employees = Arrays.asList(
                new Employee("张三",18,9999.9, Employee.Status.BUSY),
                new Employee("李四",35,4444.4, Employee.Status.FREE),
                new Employee("王五",40,2222.2, Employee.Status.VOCATION),
                new Employee("小六",65,3333.3, Employee.Status.FREE),
                new Employee("田七",8,6666.6, Employee.Status.BUSY)
        );

    @Test
    public void exer2(){
        Optional<Integer> reduce = employees.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
    }

}
