package exercise;

import domain.Trader;
import domain.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionExercise {
    List<Transaction> transactions = null;

    @Before
    public void before(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }


    //1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）

    @Test
    public void exercise1(){
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .collect(Collectors.toList());
        System.out.println(collect);
    }


    //2. 交易员都在哪些不同的城市工作过？
    @Test
    public void exercise2(){
        List<String> collect = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

    }

    //3. 查找所有来自剑桥的交易员，并按姓名排序
    @Test
    public void exercise3(){
        List<Trader> cambridge = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .collect(Collectors.toList());
        System.out.println(cambridge);

    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序

    @Test
    public void exercise4(){
        String collect = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted(String::compareTo)
                .collect(Collectors.joining(","));
        System.out.println(collect);
        System.out.println("---------------------");

        transactions.stream()
                .map(t->t.getTrader().getName())
                .flatMap(TransactionExercise::getStringList)
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::print);

    }

    public static Stream<String> getStringList(String str){
        List<String> list = new ArrayList<>();
        for (Character c:
             str.toCharArray()) {
            list.add(c.toString());
        }
        return list.stream();

    }

    //5. 有没有交易员是在米兰工作的？
    @Test
    public void exercise5(){
        List<Trader> milan = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Milan"))
                .collect(Collectors.toList());
        System.out.println(milan);

    }

    //6. 打印生活在剑桥的交易员的所有交易额
    @Test
    public void exercise6(){
        transactions.stream()
                .filter(t->"Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

    }

    //7. 所有交易中，最高的交易额是多少
    @Test
    public void exercise7(){
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compare);
        System.out.println(max.get());

    }

    //8. 找到交易额最小的交易

    @Test
    public void exercise8(){
        Optional<Transaction> min = transactions.stream()
                .min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
        System.out.println(min.get());

    }


}
