/**
 * @Author: shenchao
 * @Date: created in 21:50 2018/3/22
 * @Description:
 */
interfaces Formula {
    double caculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }

}
