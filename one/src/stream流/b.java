package stream流;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class b {
    private static final ArrayList<Person> PERSON_LIST = new ArrayList<>();

    static {
        PERSON_LIST.add(new Person("A001", "张二狗", 22, "北京市昌平区", "男"));
        PERSON_LIST.add(new Person("A002", "张四毛", 23, "北京市门头沟区", "女"));
        PERSON_LIST.add(new Person("A002", "张四毛", 23, "北京市门头沟区", "女"));
        PERSON_LIST.add(new Person("A003", "刘铁柱", 19, "北京市通州区", "男"));
        PERSON_LIST.add(new Person("A003", "刘铁柱", 19, "北京市通州区", "男"));
        PERSON_LIST.add(new Person("A003", "刘铁柱", 19, "北京市通州区", "男"));
        PERSON_LIST.add(new Person("A003", "刘铁柱", 19, "北京市通州区", "男"));
        PERSON_LIST.add(new Person("A004", "李狗蛋", 24, "北京市海淀区", "男"));
        PERSON_LIST.add(new Person("A005", "王钢蛋", 33, "上海市徐汇区", "女"));
        PERSON_LIST.add(new Person("A005", "王钢蛋", 33, "上海市徐汇区", "女"));
        PERSON_LIST.add(new Person("A005", "王钢蛋", 33, "上海市徐汇区", "女"));
        PERSON_LIST.add(new Person("A006", "王建国", 32, "上海市浦东新区", "男"));
        PERSON_LIST.add(new Person("A007", "张全蛋", 17, "上海市静安区", "女"));
        PERSON_LIST.add(new Person("A007", "张全蛋", 17, "上海市静安区", "女"));
        PERSON_LIST.add(new Person("A008", "宋援朝", 19, "天津市北辰区", "男"));
        PERSON_LIST.add(new Person("A009", "李爱军", 16, "天津市河北区", "男"));
        PERSON_LIST.add(new Person("A009", "李爱军", 16, "天津市河北区", "男"));
        PERSON_LIST.add(new Person("A010", "张爱民", 19, "天津市和平区", "女"));
        PERSON_LIST.add(new Person("A011", "刘爱党", 24, "沈阳市大东区", "女"));
        PERSON_LIST.add(new Person("A011", "刘爱党", 24, "沈阳市大东区", "女"));
    }
    public static void main(String[] args) {
        //打印所有年龄大于20岁的人
        PERSON_LIST.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge()>20;
            }
        }).forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("所有大于20岁的人："+person);
            }
        });
        System.out.println("----------------------------------------------");
        //对所有人进行按照年龄排序(降序)并打印到控制台
        PERSON_LIST.stream().filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge()>0;
            }
        }).sorted(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge()-o1.getAge();
            }
        }).forEach(new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
    }
}
