package com.wzz.other.steamApiTrain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Date 2021/3/17 15:36
 * @created by wzz
 */
public class Main {

    private static Trader raoul = new Trader("Raoul", "Cambridge");
    private static Trader mario = new Trader("Mario", "Milan");
    private static Trader alan = new Trader("Alan", "Cambridge");
    private static Trader brian = new Trader("Brian", "Cambridge");

    private static List<Transaction> transactionList = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
//      1.找出2011年发生的所有交易，并按交易额排序（从高到低）。
        List<Transaction> case1 = transactionList.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted((transaction1, transaction2) -> transaction2.getValue().compareTo(transaction1.getValue()))
                .collect(Collectors.toList());
        System.out.println("case1:" + case1);

//        2. 交易员都在哪些不同的城市工作过？
        List<String> case2 = transactionList.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("case2:" + case2);

//        3.查找所有来自Cambridge的交易员，并按姓名排序。
        List<Trader> case3 = transactionList.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println("case3:" + case3);

//        4. 返回所有交易员的姓名字符串，按字母顺序排序。
        List<String> case4 = transactionList.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(Trader::getName)
                .sorted(String::compareTo).collect(Collectors.toList());
        System.out.println("case4:" + case4);

//        5. 有没有交易员在Milan工作
        boolean case5 = transactionList.stream()
                .map(Transaction::getTrader)
                .distinct()
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println("case5:" + case5);

//        6. 打印生活在Cambridge的交易员的所有交易额。
        Integer case6 = transactionList.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println("case6:" + case6);

//        7. 所有的交易额中，最高的交易额是多少？
        Integer case7 = transactionList.stream()
                .max(Comparator.comparingInt(Transaction::getValue))
                .map(Transaction::getValue)
                .orElse(0);
        System.out.println("case7:" + case7);

//        8. 所有的交易额中，找到交易额最小的交易
        Integer case8 = transactionList.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .map(Transaction::getValue)
                .orElse(0);
        System.out.println("case8:" + case8);
    }

}
