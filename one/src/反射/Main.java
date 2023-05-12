package 反射;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //三种获取class对象的方式：
        //1
        Class p1=Person.class;
        //2
        Class p2=Class.forName("反射.Person");
        //3
        Person person=new Person();
        Class p3=person.getClass();
        //获取构造函数:getConstructors()只能获取到public的不能获取到private和protect的 而getDeclaredConstructors()可以获得所有的构造函数
        Constructor[] constructors=p3.getDeclaredConstructors();
        System.out.println("构造方法的数目："+constructors.length);
        //遍历构造方法：
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
            //Member.getModifiers()会返回特定的字节码，接着使用Modifier.toString（int mod）来解释此字节码吗mod，会返回修饰符的字符串形式。
            System.out.println(Modifier.toString(constructors[i].getModifiers()));//获取构造方法的权限
            //获取每个构造方法的参数列表
            Class[] parameterTypes = constructors[i].getParameterTypes();
            for (int i1 = 0; i1 < parameterTypes.length; i1++) {
                System.out.print(parameterTypes[i1].getName()+"--");
            }
            System.out.println();
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //获取指定构造函数
        Class[] classes={Integer.class,String.class};
        Constructor de=p1.getDeclaredConstructor(classes);

        Class[] parameterTypes = de.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            System.out.print(parameterTypes[i].getName() + "--");
        }
        System.out.println();
        System.out.println("ヽ(*。>Д<)o゜/(ㄒoㄒ)/~~(#_<-)≡(▔﹏▔)≡");
        //获取指定的构造函数
        Class[] classes1={Integer.class,String.class};
        Constructor declaredConstructor = p1.getDeclaredConstructor(classes1);
        Class[] parameters = declaredConstructor.getParameterTypes();
        for (int i = 0; i < parameters.length; i++) {
            System.out.print(parameters[i].getName() + "--");//获取构造方法的参数列表
        }
        System.out.println();
        System.out.println("╥﹏╥...╥﹏╥...╥﹏╥...╥﹏╥...╥﹏╥...╥﹏╥...╥﹏╥...╥﹏╥...");
        //通过默认构造函数生成对象
        Person instance1=(Person) p2.newInstance();
        System.out.println(instance1.getAge());
        //通过指定构造函数生成对象
        Class[] classes2={Integer.class,String.class};
        Constructor definedConstructor=p2.getDeclaredConstructor(classes2);
        definedConstructor.setAccessible(true);
        Person instance2= (Person) definedConstructor.newInstance(10,"xiaohong");
        System.out.println(instance2.getAge());

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //遍历成员方法
        Method[] methods1 = p2.getMethods();//获取本类及父类或者父接口中所有公共方法
        System.out.println(methods1.length);
        Method[] members2=p2.getDeclaredMethods();//获取本类中的所有方法，包括私有保护默认及公共方法
        System.out.println(members2.length);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //获取指定成员方法并且调用
        Person instance= (Person) p2.newInstance();
        Class[] classe={int.class,String.class};
        Method method=p2.getDeclaredMethod("test1",classe);
        method.setAccessible(true);//避免权限问题
        method.invoke(instance,10,"xiaohong");
        //遍历成员变量
        Field[] declaredFields = p3.getDeclaredFields();
        System.out.println(declaredFields.length);
        //获取指定成员方法并修改她的值
        Person ins=(Person) p3.newInstance();
        Field field = p3.getDeclaredField("age");
        field.setAccessible(true);//避免权限问题
        field.set(ins,10);
        System.out.println(ins.getAge());
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
       //获取指定成员变量的值
        System.out.println(field.get(ins));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        //获取指定静态方法并且调用
        Class[] cla = {int.class};
        Method me = p2.getDeclaredMethod("test3", cla);
        me.setAccessible(true);
        me.invoke(null,1000);//这里的obj是null表示不需要用对象去调，则一定是静态方法
        //静态成员变量
        Field grade = p3.getDeclaredField("grade");
        grade.setAccessible(true);
        grade.set(null,1000);//对静态成员变量赋值
        System.out.println("获取静态成员变量"+grade.get(null));//获取静态成员变量
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");













    }
}
