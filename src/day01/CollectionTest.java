package day01;

import org.junit.Test;

import javax.lang.model.SourceVersion;
import java.util.*;

/**
 * @author QuXiaohai
 * @create 2019/11/18 - 20:23
 */
public class CollectionTest {
    /**
     * 测试Collection 接口的十五种抽象方法
     * 注:集合中的自定义 对象类型 必须重写 equals方法 因为Collection方法中很多都会调用元素的equals方法 而Object类的equals方法用的是==号
     * 比较的是内存地址!!
     */
    @Test
    public void test01() {
        //1.add（）方法与 2.addAll方法（）
        //添加单个元素 返回值 为boolean
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(789);
        coll.add(new Date());
        coll.add(new Person("张三", 001, "male"));
        System.out.println(coll);
        System.out.println(coll.add(456));
        Collection coll1 = new ArrayList();
        coll1.addAll(coll);//添加所有 将另外一个集合中的元素一次性全部添加进来 boolean
        System.out.println(coll);


        // 3.isEmpty（）方法与4.clear（）方法
        boolean empty = coll.isEmpty(); //判断集合元素个数是否为零 boolean
        System.out.println("empty = " + empty);
        coll.clear(); //清除 此集合中的所有元素 void
        boolean empty1 = coll.isEmpty();
        System.out.println("empty1 = " + empty);


        //5. equals 方法 判断 俩个集合 是否相等 （值相等） boolean 与  6 .hashCode()方法 返回该集合的哈希值 int
        boolean equals = coll.equals(coll1);
        System.out.println("equals = " + equals);
        int i = coll.hashCode();
        System.out.println("i = " + i);

        // 7. contains（）方法  与 8 .contaisAll（）方法           boolean
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(1);
        boolean contains = coll2.contains(123); //比较的是传入对象的 值相等 也就是调equals方法 基本类型会被封装为包装类型
        System.out.println("contains = " + contains);
        boolean b = coll1.containsAll(coll2);//判断是否包含另一个集合的所有元素的类型
        System.out.println("b = " + b);


    }

    @Test
    public void test02() {
        //9.remove()方法 与 10.removeAll（）方法
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(789);
        coll.add(new Date());
        coll.add(new Person("张三", 001, "male"));
        System.out.println(coll);
//        coll.remove(123); //与add（）方法相反 是剔除一个元素 比较的也是值。。调用的是元素的eqals方法
        System.out.println(coll);
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(789);
        coll2.add(new Date());
        coll.removeAll(coll2); //与addAll（）方法相反 是剔除一个集合的全部元素 比较的也是值。。调用的是元素的eqals方法 boolean
        System.out.println(coll2);
        System.out.println(coll);
        //11.size 方法 返回值为int  获取集合中元素的个数
        System.out.println(coll.size());
        //12.retainAll() 方法 求俩个集合的交集 并把交集 返回给 所在集合
        System.out.println("============================");
        coll.add(123);
        System.out.println(coll);
        System.out.println(coll2);
        coll.retainAll(coll2); //若无交集 则为空
        System.out.println(coll);
        System.out.println("===============================");


    }

        // //13. toArray()方法 与toArray(T[] a)方法

        @Test
        public void test03(){
            Collection coll = new ArrayList();
            coll.add(123); //添加单个元素 返回值 为boolean
            coll.add(789);
            coll.add(new Date());
            coll.add(new Person("张三", 001, "male"));
            Object[] objects = coll.toArray();
            for (int i = 0; i < coll.size(); i++) {
                System.out.println(objects[i]);
            }
            //数组 转化成 list Arrays.asList
            List<Object> objects1 = Arrays.asList(objects);
            System.out.println(objects1);
            //如果int类型数组 则需要转化成Integer
            List ints = Arrays.asList(new Integer[]{1, 2, 3});
            System.out.println(ints);

        }
}
