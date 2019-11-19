package day01;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author QuXiaohai
 * @create 2019/11/19 - 12:57
 */
public class IteratorTest {
    @Test
    public  void test01(){
        Collection coll = getCollection();

        /**
         * Iterator 迭代器使用
         * 1.先获取一个迭代器对象
         * 2.使用 hasNext（）方法判断是否有下个元素（并不是判断下个元素是否为空！！）
         * 3.使用 next（）方法将指针下移并获取指针移动所指向的元素
         *
         */
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //迭代器使用要点
        //当使用一个迭代器遍历容器时 ，迭代器的指针已经指向最后一个元素 若想再迭代一次 必须重新生成一个迭代器！！
        iterator =coll.iterator();//重新生成一个迭代器
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        //增强for循环 foreach
        //foreach 不能改变容器中的元素的值 快捷键 iter
        // 其内部实现原理也是用了迭代器
        for (Object o : coll) {
            System.out.println(o);
        }
    }

    private Collection getCollection() {

        Collection coll = new ArrayList();
        coll.add(null);
        coll.add(789);
        coll.add("Tom");
        coll.add(new Date());
        coll.add(new Person("张三", 001, "male"));
        return coll;
    }
}
