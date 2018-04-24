package design;

/**
 * @Author: Kuroneko
 * @Date: created in 22:27 2018/3/22
 * @Description:
 */
@FunctionalInterface
public interfaces MyPredicate<T> {

    boolean test(T t);
}
