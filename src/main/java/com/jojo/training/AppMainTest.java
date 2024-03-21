package com.jojo.training;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 * just for test!
 *
 */
public class AppMainTest {
    public static final Logger log = Logger.getLogger(AppMainTest.class.getName());

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch), start);
            }
            maxLength = Math.max(maxLength, i - start);
            map.put(ch, i);
        }
        return maxLength;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null || l2 != null) {
            l1 = l1 == null ? new ListNode() : l1;
            l2 = l2 == null ? new ListNode() : l2;
            int sum = l1.val + l2.val;
            if (l1.next == null && l2.next == null) {
                return new ListNode(sum % 10, sum > 9 ? new ListNode(sum / 10) : null);
            }
            l1.next = l1.next == null ? new ListNode() : l1.next;
            l2.next = l2.next == null ? new ListNode() : l2.next;
            return new ListNode(sum % 10, addTwoNumbers(l1.next, l2.next));
        }
        return null;
    }
    static class DyeingRequest{
        String[] queryDate;

        public DyeingRequest(String[] queryDate){
            this.queryDate=queryDate;
        }
        public void setQueryDate(String[] queryDate){
            this.queryDate = queryDate;
        }
    }

    public static void main(String[] args) throws ParseException {
        Map<String,DyeingRequest> testMap = new LinkedHashMap<>();
        testMap.put("1",new DyeingRequest(new String[]{"1","2"}));
        testMap.put("2",new DyeingRequest(new String[]{"3","4"}));
        testMap.put("1",new DyeingRequest(new String[]{"5","6"}));

        String testString = "[\"test\"]";
        System.out.println(testString.replaceAll("\\[|\\]|\"", ""));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse("2021-12-29 00:00:00");
        DyeingRequest queryDate = new DyeingRequest(new String[]{});
        String[] queryDates = new String[2];
        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH) + 1;
        instance.add(Calendar.MONTH, -1);
        int preMonth = instance.get(Calendar.MONTH) + 1;
        instance.add(Calendar.MONTH, -1);
        int prepreMonth = instance.get(Calendar.MONTH) + 1;
        int prepreYear = instance.get(Calendar.YEAR);
        int preYear = instance.get(Calendar.YEAR);
        if (month == 12) {
            if (day < 29) {
                queryDates[0] = prepreYear + "-" + prepreMonth + "-26 00:00:00.000";
                queryDates[1] = preYear + "-" + preMonth + "-25 23:59:59.998";
                queryDate.setQueryDate(queryDates);
            } else {
                queryDates[0] = preYear + "-" + preMonth + "-26 00:00:00.000";
                queryDates[1] = year + "-" + month + "-29 23:59:59.998";
                queryDate.setQueryDate(queryDates);
            }
        } else if (month == 1) {
            if (day < 25) {
                queryDates[0] = prepreYear + "-" + prepreMonth + "-26 00:00:00.000";
                queryDates[1] = preYear + "-" + preMonth + "-29 23:59:59.998";
                queryDate.setQueryDate(queryDates);
            } else {
                queryDates[0] = preYear + "-" + preMonth + "-30 00:00:00.000";
                queryDates[1] = year + "-" + month + "-25 23:59:59.998";
                queryDate.setQueryDate(queryDates);
            }
        } else if (day < 25) {
            queryDates[0] = prepreYear + "-" + prepreMonth + "-26 00:00:00.000";
            queryDates[1] = preYear + "-" + preMonth + "-25 23:59:59.998";
            queryDate.setQueryDate(queryDates);
        } else {
            queryDates[0] = preYear + "-" + preMonth + "-26 00:00:00.000";
            queryDates[1] = year + "-" + month + "-25 23:59:59.998";
            queryDate.setQueryDate(queryDates);
        }
        String test = "1*2*3";
        System.out.println(test.split("[*]").length);
//        Set<String> testSet = new HashSet<>();
//        Map<String,String> testmap = new HashMap<>();
//        System.out.println(testmap.get("tst"));
//        testSet.add(null);
//        testSet.add("stet");
//        Set<String> collect1 = testSet.stream().filter(Objects::nonNull).collect(Collectors.toSet());
//        System.out.println(collect1.toString());
//        String msg ="[message]";
//        JSONArray objects = JSON.parseArray(msg);
//        List<String> javaList = objects.toJavaList(String.class);
//        Object obj = null;
//        System.out.println((String) null);
//        Integer a = null;
//        System.out.println(a);
//        DecimalFormat format = new DecimalFormat("0.00#");
//        BigDecimal numner =new BigDecimal(620);
//        System.out.print(format.format(numner));
        List<test> list = new ArrayList<>();
        List<String> listString = new ArrayList<>();
        listString.add("test");
        listString.add("1");
        listString.add("1");
        listString.add("1");
        List<String> collect = listString.stream().map(x -> "'" + x + "'").collect(Collectors.toList());
        System.out.println(collect.toString().substring(1,collect.toString().length()-1));
        list.add(new test("jinxin","1"));
        list.add(new test("jinxin","1"));
        list.add(new test("jinxin","1"));
        test te =list.get(0);
        te.setName("123");
        System.out.println("======================");
        System.out.println(list.get(0));
        System.out.println(JSON.toJSONString(new ArrayList<>(Collections.singletonList("test"))));
//        Map<String, String> collect = list.stream().collect(Collectors.toMap(test::getName, test::getId,(x1,x2)->x1));

//        Calendar calendar = Calendar.getInstance();
//        calendar.add(12, 20);
//        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.MONTH));
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println(calendar.get(Calendar.HOUR));
//        System.out.println(calendar.get(Calendar.MINUTE));
        // String test = JSON.toJSONString("test\n");
        // System.out.println(test);
        // SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss",Locale.CHINA);
        // System.out.println(sDateFormat.format(new Date()));
        // String content = "test  \n";
        // System.out.println(content.replace("  \n", "<br/>"));
        // String[] test = "sdf.fdsa.fdsa.1".split("\\.");
        // System.out.println(test.length);
        // Map<String,Object> testMap = new LinkedHashMap<>();
        // testMap.put("test1",1);
        // testMap.put("ap2",null);
        // testMap.put("oa3",3);
        // testMap.put("aa4",4);
        // testMap.put("bc5",5);
        // testMap.
        // System.out.println(testMap.values());

    }
}

class test{
    String name;
    String id;
    public test(String name,String id){
        this.id=id;
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        ListNode node = this;
        while (node != null) {
            str.append(node.val).append(",");
            node = node.next;
        }
        str = new StringBuilder(str.substring(0, str.length() - 1));
        str.append("]");
        return str.toString();
    }
}