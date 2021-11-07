package com.cxq.two;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InsufficientBalanceException,CatNotFoundException {
        Scanner input =new Scanner(System.in);
        System.out.println("-----先搞个店吧！-----");
        System.out.println("请输入店名、余额：");
        MyCatCafe mcc = new MyCatCafe();
        mcc.name = input.next();
        mcc.balance = input.nextInt();
        System.out.println("OK!你的店 "+mcc.name+" 余额为 "+mcc.balance+" 元");
//买猫
        System.out.println("-----还没有猫哟！-----");
        System.out.println("请输入要买猫的数量：");
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            Cat aCat = newCat(i); //搞新猫
            try {
                mcc.buyCat(aCat);
            }catch (InsufficientBalanceException e){
                e.printStackTrace();
                System.out.println("---余额不足 仅有 " + mcc.balance + " 元"+" 无法购买---");
                if (aCat instanceof BlackCat && mcc.balance >= 200){  //橘猫价格
                    System.out.println("可以买一只橘猫哦！买吗？(true or false)");
                    boolean buy = input.nextBoolean();
                    if (buy)
                        i--;
                    else break;
                }
                else
                    break;
            }
        }
        System.out.println("买猫后余额："+mcc.balance+" 元");
        System.out.println("店里的猫咪："+mcc.myCat);
//待客
        System.out.println("-----一切就绪 只缺顾客-----");
        Customer cus = new Customer();
        System.out.println("请输入到店客人人数：");
        int m = input.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println("请输入第 "+(i + 1)+" 位到店客人信息(姓名 rua次数 到店时间(yyyy-MM-dd)：");
            String name = input.next();
            int ruaNum = input.nextInt();
            String date = input.next();
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            cus.name = name;
            cus.ruaNum = ruaNum;
            cus.timeGet = localDate;
            mcc.treatCustomer(cus);
        }
        System.out.println("接待客人后余额："+mcc.balance);
        String date0 = input.next();
        LocalDate date1 = LocalDate.parse(date0,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        mcc.close(date1);
    }
    public static Cat newCat(int i) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第 " + (i + 1) + " 只要买猫的类型：");
        String type = null;
        boolean judge1 = true;
        while (judge1) {
            type = input.next().toLowerCase(Locale.ROOT);
            if (type.equals("黑猫") || type.equals("blackcat") || type.equals("orangecat") || type.equals("橘猫"))
                judge1 = false;
            else
                System.out.println("没有此类型猫 请重新输入");
        }
        System.out.println("请输入要买猫的名字、年龄、性别：");
        String name = input.next();
        int age = input.nextInt();
        boolean judge2 = true;
        String sex = null;
        while (judge2) {
            sex = input.next();
            if (sex.equals("公") || sex.equals("母") || sex.equals("male") || sex.equals("female")) {
                judge2 = false;
            } else
                System.out.println("性别错误 请重新输入性别：");
        }
        BlackCat bc = new BlackCat();
        OrangeCat oc = new OrangeCat();
        if (type.equals("黑猫") || type.equals("blackcat")) {
            bc.name = name;
            bc.age = age;
            bc.sex = sex;
            return bc;
        } else if (type.equals("orangecat") || type.equals("橘猫")) {
            System.out.println("橘猫要胖的吗：");
            boolean isFat = input.nextBoolean();
            oc.name = name;
            oc.age = age;
            oc.sex = sex;
            oc.isFat = isFat;
            return oc;
        }
        return bc;
    }
}
