package com.cxq.two;

import java.time.LocalDate;
import java.util.ArrayList;

public class MyCatCafe implements CatCafe{

    String name;
    double balance;
    int profitOne = 0;
    ArrayList<Cat> myCat = new ArrayList<>();
    ArrayList<Customer> myCustomer = new ArrayList<>();

    public MyCatCafe(){

    }

    public MyCatCafe(String name,double balance){
        this.name = name;
        this.balance = balance;
    }

    private void getCatMsg(Cat cat){
        if (cat instanceof BlackCat)
            System.out.println(((BlackCat)cat).toString());
        if (cat instanceof OrangeCat)
            System.out.println(((OrangeCat)cat).toString());
    }

    @Override
    public String toString() {
        return "MyCatCafe{" +
                "balance=" + balance +
                ", myCat=" + myCat +
                ", myCustomer=" + myCustomer +
                '}';
    }

//    @Override
//    public void buyCat(Cat cat) throws InsufficientBalanceException{
//        System.out.println(cat.price);
//        if (balance < cat.price)
//            throw new InsufficientBalanceException("余额不足 无法购买");
//        balance -= cat.price;
//        myCat.add(cat);
//    }
    @Override
    public void buyCat(Cat cat) throws InsufficientBalanceException{
            if (balance < cat.price)
                throw new InsufficientBalanceException("余额不足 无法购买");
            balance -= cat.price;
            myCat.add(cat);
        }
    @Override
    public void treatCustomer(Customer customer) {
        try {
//            if (myCat == null)
            if (myCat.size() == 0)
                throw new CatNotFoundException("无猫可RUA");
            System.out.println("被 "+customer.name+" RUA猫咪的信息：");
            for (int i = 0; i < customer.ruaNum; i++) {
                int j = (int) (Math.random() * myCat.size());
                getCatMsg(myCat.get(j));
            }
            balance += 15 * customer.ruaNum;
            myCustomer.add(customer);
        }catch (CatNotFoundException e){
            e.printStackTrace();
            System.out.println("---无猫可RUA---");
        }

    }

    @Override
    public void close(LocalDate localDate) {
        System.out.println(localDate + " 一天顾客信息：");
        for (int i = 0; i < myCustomer.size(); i++) {
            Customer aCustomer = myCustomer.get(i);
            if (aCustomer.timeGet.isEqual(localDate)){
                System.out.println(aCustomer);
                profitOne += aCustomer.ruaNum * 15;
            }
        }
        System.out.println(localDate + " 一天的利息为："+ profitOne);
    }
}
