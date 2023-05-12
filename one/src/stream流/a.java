package stream流;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class a {
    private static final ArrayList<String> NAME_LIST=new ArrayList<>();
    static {
        NAME_LIST.add("张韵艺");
        NAME_LIST.add("赵丽颖");
        NAME_LIST.add("杨颖");
        NAME_LIST.add("张悬");
        NAME_LIST.add("张学友");
    }
    public static void main(String[] args) {
        List<String> list1 = NAME_LIST.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张") && s.length() == 3;
            }
        }).collect(Collectors.toList());
        System.out.println(list1);
        List<String> list2 = NAME_LIST.stream().filter(s -> s.startsWith("张") && s.length() == 3).collect(Collectors.toList());
        System.out.println(list2);
        NAME_LIST.stream().filter(s -> s.startsWith("张") && s.length() == 3).collect(Collectors.toList()).forEach(s -> System.out.println(s));
    }
}
