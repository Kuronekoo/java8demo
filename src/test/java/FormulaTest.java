import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * @Author: shenchao
 * @Date: created in 21:51 2018/3/22
 * @Description:
 */
public class FormulaTest {


    @Test
    public void testFormula(){
    //        List<String> names = Arrays.asList("alice","peter","tom","jerry");
    //        System.out.println(names);
    //        Collections.sort(names,(a,b)->b.compareTo(a));
    //        System.out.println(names);
    //
    //        Comparator<Integer> com = (x,y)->Integer.compare(x,y);

            String json = "{\"cardList\":[{\"shopid\":\"123\"},{\"shopid\":\"345\"}]}";

            JSONObject jsonObject = JSON.parseObject(json);
         System.out.println(jsonObject.toString());

            JSONArray cardlist = JSON.parseArray(jsonObject.getString("cardList"));

        JSONObject jsonObject1 = cardlist.getJSONObject(0);
        System.out.println(jsonObject1.toString()+"::"+jsonObject1.getString("shopid"));

//        Map<String,Object> map = new HashMap<>();
//        map.put("cardList",cardlist);
//        System.out.println(JSON.toJSONString(map));
    }

}
