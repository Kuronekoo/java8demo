package interfaces;

/**
 * @program: java8demo
 * @description: ${description}
 * @author: Kuroneko
 * @create: 2018-04-24 23:03
 **/
public class SonClass  implements JerryInterface,TomInterface{


    /**
     * 类优先原则，如果继承的类和实现的接口中有名称和参数列表一样的方法，优先使用类中的方法
     * extends TomClass
     * @return
     * @Override
    public String getName() {
    return super.getName();
    }
     */

    /**
     * 如果两个接口中有一摸一样的方法，如果需要调用默认的方法，则要用 interfaceName.super.methodName
     * @return
     */
    @Override
    public String getName() {
        return TomInterface.super.getName();
    }
}
