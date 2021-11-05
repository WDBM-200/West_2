package com.cxq.two;

import java.time.LocalDate;

public interface CatCafe {
    void buyCat(Cat cat);
    void treatCustomer(Customer customer);
    void close(LocalDate localDate);

}
