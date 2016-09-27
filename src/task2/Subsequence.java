package task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andzh on 27.09.2016.
 */
public class Subsequence {
    public static Boolean arrayCheck(List Xi, List Yi) {
        List<Object> list = new ArrayList<Object>();

        int tmp = 0;
        label: for (int i = 0; i < Xi.size(); i++) {
            for (int j = tmp; j < Yi.size(); j++) {
                if (Yi.get(j).equals(Xi.get(i))) {
                    list.add(Yi.get(j));
                    tmp = j;
                    continue label;
                }
            }
            return  false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");

        list2.add("zero");
        list2.add("one");
        list2.add("two");
        list2.add("one");
        list2.add("three");
        list2.add("rhrrt");
        list2.add("four");

        System.out.println(arrayCheck(list1, list2));
    }
}
