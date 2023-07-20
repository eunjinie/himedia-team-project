package com.himedia.java.game;

import java.util.Scanner;

public class Staff {

    Scanner sc = new Scanner(System.in);

    private String result = "";

    private int success = 0;
    private int loseCustomer = 0;

    public int getSuccess() {
        return success;
    }

    public int getLoseCustomer() {
        return loseCustomer;
    }


    public String makeBurger() {

        System.out.println("\n1.참깨빵, 2.양상추, 3.특별한 소스, 4.양파, 5.치즈, 6.피클, 7.불고기 패티, 8.치킨 패티, 9.새우 패티");
        System.out.println("Recipe : bbb위에 PP 2장, 특별한 SS, lll, CC, pp, OO까지~\n");
        System.out.print("순서에 맞게 번호를 눌러주세요 : ");

        result = sc.nextLine();

        return result;

    }


    public void plusSuccess() {
        success++;
    }

    public void plusLoseCustomer() {
        loseCustomer++;
    }


}
