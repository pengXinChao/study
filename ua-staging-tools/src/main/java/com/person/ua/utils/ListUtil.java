package com.person.ua.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengxc copy
 */
public class ListUtil {

    /**
     * 将list分割成指定大小的list
     * @param list 原list
     * @param groupSize list大小
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int groupSize) {
        int length = list.size();
        // 计算可以分成多少组
        int num = (length + groupSize - 1) / groupSize;
        List<List<T>> newList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置
            int toIndex = Math.min((i + 1) * groupSize, length);
            newList.add(list.subList(fromIndex, toIndex));
        }
        return newList;
    }

    /**
     * 将list分割成指定的组
     * @param list 原list
     * @param groupNumber 分组数量
     */
    public static <T> List<List<T>> splitListByGroupNumber(List<T> list, int groupNumber) {
        // 确认指定分多少组, 判断每组需要到的数据量
        int modulusRemainder = list.size() % groupNumber;
        int groupSize = (list.size() / groupNumber) + (modulusRemainder == 0 ? 0 : 1);
        return splitList(list, groupSize);
    }

    public static void main(String args[]){
        List<String> stringList = Arrays.asList(
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"
        );
        List<List<String>> list = ListUtil.splitList(stringList,10);
        int i = 0;
        for(List<String> alist : list){
            for(String a : alist){
                i += 1;
            }
        }
        System.out.println(i);
    }
}
