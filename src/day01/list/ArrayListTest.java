package day01.list;

/**
 * @author QuXiaohai
 * @create 2019/11/19 - 14:54
 * <p>
 * <p>
 * 1. ---Collection接口
 * ----List接口
 * --ArrayList :底层采用Object[] 数组  线程不安全的，效率高 List接口的主要实现类
 * --LinkedList：对于数据量大的频繁的插入 和删除 使用此类时比AarrayList类效率高 底层采用的是双向链表的结构
 * --Vector:底层采用Object[] 数组  线程安全的，效率低  List接口的最初实现类
 * ArrayList 总共有三十一个方法
 * 2. ArrayList类的源码分析：
 * ArrayList 在jdk1.7与jdk1.8中实现有略微不同
 * jdk1.7中时
 * 在ArrayList list =new ArrayList()时已经创建好了 长度为10的Object数组
 * 当容量不够时 ，再创建一个新的数组 其容量是旧的数组的1.5倍
 * jdk1.8时
 * 在list.add(obj)时才给我们创建一个长度为10的Object数组 ，才去扩容，相比于jdk1.7时 省了内存
 * 在开发中 如果我们知道此list的元素个数不会超过多大时  我们最好指定长度 等不够时再去扩容
 * ArrayList list = new ArrayList(50);
 * 3. LinkedList的源码分析：
 * LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 * list.add(123);//将123封装到Node中，创建了Node对象。
 * 其中，Node定义为：体现了LinkedList的双向链表的说法
 * private static class Node<E> {
 * E item;
 * Node<E> next;
 * Node<E> prev;
 * <p>
 * Node(Node<E> prev, E element, Node<E> next) {
 * this.item = element;
 * this.next = next;
 * this.prev = prev;
 * }
 * }
 * <p>
 * 4. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
 * 在扩容方面，默认扩容为原来的数组长度的2倍。
 * <p>
 * <p>
 * <p>
 * void add(int index, Object ele):在index位置插入ele元素
 * boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
 * Object get(int index):获取指定index位置的元素
 * int indexOf(Object obj):返回obj在集合中首次出现的位置
 * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 * Object remove(int index):移除指定index位置的元素，并返回此元素
 * Object set(int index, Object ele):设置指定index位置的元素为ele
 * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
 * <p>
 * 总结：常用方法
 * 增：add(Object obj)
 * 删：remove(int index) / remove(Object obj)
 * 改：set(int index, Object ele)
 * 查：get(int index)
 * 插：add(int index, Object ele)
 * 长度：size()
 * 遍历：① Iterator迭代器方式
 * ② 增强for循环
 * ③ 普通的循环
 */

/**
 *  1. ---Collection接口
 *          ----List接口
 *              --ArrayList :底层采用Object[] 数组  线程不安全的，效率高 List接口的主要实现类
 *              --LinkedList：对于数据量大的频繁的插入 和删除 使用此类时比AarrayList类效率高 底层采用的是双向链表的结构
 *              --Vector:底层采用Object[] 数组  线程安全的，效率低  List接口的最初实现类
 * ArrayList 总共有三十一个方法
 * 2. ArrayList类的源码分析：
 *       ArrayList 在jdk1.7与jdk1.8中实现有略微不同
 *      jdk1.7中时
 *          在ArrayList list =new ArrayList()时已经创建好了 长度为10的Object数组
 *          当容量不够时 ，再创建一个新的数组 其容量是旧的数组的1.5倍
 *      jdk1.8时
 *          在list.add(obj)时才给我们创建一个长度为10的Object数组 ，才去扩容，相比于jdk1.7时 省了内存
 *          在开发中 如果我们知道此list的元素个数不会超过多大时 我们最好指定长度 等不够时再去扩容
 *          ArrayList list = new ArrayList(50);
 *  3. LinkedList的源码分析：
 *      LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123);//将123封装到Node中，创建了Node对象。
 *      其中，Node定义为：体现了LinkedList的双向链表的说法
 *      private static class Node<E> {
 E item;
 Node<E> next;
 Node<E> prev;

 Node(Node<E> prev, E element, Node<E> next) {
 this.item = element;
 this.next = next;
 this.prev = prev;
 }
 }
 *
 *  4. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
 *      在扩容方面，默认扩容为原来的数组长度的2倍。
 *
 *
 *
 * void add(int index, Object ele):在index位置插入ele元素
 *   boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
 *Object get(int index):获取指定index位置的元素
 int indexOf(Object obj):返回obj在集合中首次出现的位置
 int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 Object remove(int index):移除指定index位置的元素，并返回此元素
 Object set(int index, Object ele):设置指定index位置的元素为ele
 List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

 总结：常用方法
 增：add(Object obj)
 删：remove(int index) / remove(Object obj)
 改：set(int index, Object ele)
 查：get(int index)
 插：add(int index, Object ele)
 长度：size()
 遍历：① Iterator迭代器方式
 ② 增强for循环
 ③ 普通的循环
 */

import day01.Person;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ArrayListTest {
    @Test
    public void test01() {
        ArrayList list = getList();
        list.add(123); //add方法 有俩种 此时使用的是在结尾插入
        System.out.println(list);
        list.add(0, "在开头插入");//此时的add方法有俩个参数 一个是index 指定位置 一个是element 插入元素
        System.out.println(list);
        ArrayList list1 = getList();
        list.addAll(1, list1); //此时的list是指在某位值插入另外一个集合的所有元素
        System.out.println("list = " + list);
    }
    @Test
    public  void test02(){
        ArrayList list = getList();
        Object o = list.get(1); //获取指定位置的元素 若获取不到则为报角标越界异常 IndexOutOfBoundsException
        System.out.println(o);
        System.out.println("==========================");
        Object set = list.set(1, "修改成功");//设置指定位置的元素为
        System.out.println(set);
        System.out.println(list);
        list.add(1, "插入成功"); //在某个位置插入一个元素
        System.out.println(list);

    }
    private ArrayList getList() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(789);
        list.add(new Date());
        list.add(new Person("张三", 001, "male"));
        return list;
    }

}
