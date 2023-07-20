package com.himedia.java.game;

import java.util.Arrays;
import java.util.Scanner;

public class Info {

    Scanner sc = new Scanner(System.in);

    String[] menu = {"베지버거", "새우버거", "치킨버거", "불고기버거"};

    public boolean gameStart(){
        System.out.println("\"알바 하이\"");
        System.out.println("우리 매장 메뉴는 여기 있다. : " + Arrays.toString(menu));
        System.out.println("주문이 들어오면 재료 번호를 입력해 햄버거를 만들어라");
        int order = (int) (Math.random() * 4);
        int minus = (int)(Math.random() * 5);
        System.out.println("1.참깨빵, 2.양상추, 3.특별한 소스, 4.양파, 5.치즈, 6.피클, 7.불고기 패티, 8.치킨 패티, 9.새우 패티\n");
        System.out.println("Recipe : bbb위에 PP 2장, 특별한 SS, lll, CC, pp, OO까지~\n");
        System.out.println("신속 정확 빠른 플레이 부탁^^");
        System.out.println();
        System.out.print("고(GO)? (Y / N) : ");
        char answer = sc.nextLine().toUpperCase().charAt(0);
        System.out.println();

        if(answer != 'Y'){
            System.out.println("게임을 종료합니다.");
            return false;
        }


        return true;



    }
}
