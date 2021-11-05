package com.cxq.two;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InsufficientBalanceException,CatNotFoundException {
        Scanner input =new Scanner(System.in);
        //MyCatCafe mcc = new MyCatCafe(1000);
//        MyCatCafe mcc = new MyCatCafe(10000);
        /*BlackCat bc1 = new BlackCat("bcBob",3,"male");
        BlackCat bc2 = new BlackCat("bcBol",5,"female");
        BlackCat bc3 = new BlackCat("bcDan",1,"male");
        BlackCat bc4 = new BlackCat("bcDen",8,"female");
        BlackCat bc5 = new BlackCat("bcMim",2,"male");
        BlackCat bc6 = new BlackCat("bcMak",6,"male");
        OrangeCat oc1 = new OrangeCat("ocLily",1,"female",false);
        OrangeCat oc2 = new OrangeCat("ocLam",5,"male",true);
        OrangeCat oc3 = new OrangeCat("ocNan",3,"female",true);
        OrangeCat oc4 = new OrangeCat("ocNin",1,"male",false);
        OrangeCat oc5 = new OrangeCat("ocHum",5,"female",true);
        OrangeCat oc6 = new OrangeCat("ocHang",2,"female",false);
        OrangeCat oc7 = new OrangeCat("ocJudy",7,"male",false);
        Customer jim = new Customer("jim",3, LocalDate.of(2021,10,30));
        Customer jam = new Customer("jam",3,LocalDate.of(2021,10,30));
        Customer jack = new Customer("jack",2,LocalDate.of(2021,10,30));
        Customer julia = new Customer("julia",3,LocalDate.of(2021,10,30));
        Customer judy = new Customer("judy",1,LocalDate.of(2021,5,30));
        //买猫
        mcc.buyCat(bc1);
        mcc.buyCat(bc2);
        mcc.buyCat(bc3);
        mcc.buyCat(bc4);
        mcc.buyCat(bc5);
        mcc.buyCat(bc6);
        mcc.buyCat(oc1);
        mcc.buyCat(oc2);
        mcc.buyCat(oc3);
        mcc.buyCat(oc4);
        mcc.buyCat(oc5);
        mcc.buyCat(oc6);
        mcc.buyCat(oc7);*/
//        CatKing 50000
//        橘猫 judia 4 male true
//        黑猫 kuu 3 female
//        黑猫 gugu 4 male
//        blackcat jigu 2 male
//        orangecat jik 5 female true
//        jim 3 2021-10-30
//        jam 3 2021-10-30
//        jack 2 2021-10-30
//        julia 3 2021-10-30
//        judy 1 2021-05-30
        System.out.println("-----先搞个店吧！-----");
        System.out.println("请输入店名，余额：");
        MyCatCafe mcc = new MyCatCafe();
        mcc.name = input.next();
        mcc.balance = input.nextInt();
        System.out.println("OK!你的店 "+mcc.name+" 余额为 "+mcc.balance+"元");

        System.out.println("-----还没有猫哟！-----");
        System.out.println("请输入要买猫的数量：");
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("请输入一只要买猫的类型：");
            String type = null;
            boolean judge1 = true;
            while (judge1){
                type = input.next().toLowerCase(Locale.ROOT);
                if (type.equals("黑猫") || type.equals("blackcat") ||type.equals("orangecat") || type.equals("橘猫"))
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
                if (sex.equals("公") || sex.equals("母") ||sex.equals("male") || sex.equals("female")){
                    judge2 = false;
                }
                else
                    System.out.println("性别错误 请从新输入性别：");
            }
            if (type.equals("黑猫") || type.equals("blackcat")){
                BlackCat bc = new BlackCat();
                bc.name = name;
                bc.age = age;
                bc.sex = sex;
                mcc.buyCat(bc);
            }
            else if (type.equals("orangecat") || type.equals("橘猫")){
                System.out.println("橘猫要胖的吗：");
                boolean isFat = input.nextBoolean();
                OrangeCat oc = new OrangeCat();
                oc.name = name;
                oc.age = age;
                oc.sex = sex;
                oc.isFat = isFat;
                mcc.buyCat(oc);
            }
        }
        System.out.println("买猫后余额："+mcc.balance+"元");
        System.out.println("店里的猫咪："+mcc.myCat);
//        //待客
//        mcc.treatCustomer(jim);
//        mcc.treatCustomer(jam);
//        mcc.treatCustomer(jack);
//        mcc.treatCustomer(julia);
//        mcc.treatCustomer(judy);

        System.out.println("-----一切就绪 只缺顾客-----");
        Customer cus = new Customer();
        System.out.println("请输入到店客人人数：");
        int m = input.nextInt();
        System.out.println("请输入到店客人信息(姓名 rua次数 到店时间(yyyy-MM-dd)：");
        for (int i = 0; i < m; i++) {
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
        mcc.close(LocalDate.of(2021,10,30));

    }
}
