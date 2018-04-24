package interfaces;

/**
 * @program: java8demo
 * @description: ${description}
 * @author: Kuroneko
 * @create: 2018-04-24 22:59
 **/
public interface TomInterface {
    /**
     * default关键词
     * @return
     */

    default String getName(){
        return "Tom interface";
    }

    /**
     * static关键词
     */
    public static void show(){
        System.out.println("tom's show");
    }
}
