package com.himedia.java.game;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Staff player = new Staff(); //매장의 직원이 곧 플레이어다

        String[] menu = {"기본버거(패티 X)", "새우버거", "치킨버거", "불고기버거"};
        String[] exceptIngredients = {"양상추", "양파", "치즈", "피클", "선택 안함"}; //못먹는 재료가 있다면 빼도록 함.

        Hamburger orderedHamburger = null;

        while(true) {
            System.out.println("\"안녕하세요 하이미디어 햄버거 가게입니다.\"\n" + "\"무엇을 주문하시겠습니까?\" " + Arrays.toString(menu));
            int order = (int) (Math.random() * 4);

            System.out.println("\"빼고 싶은 재료가 있습니까?\" [양상추, 양파, 치즈, 피클]");
            int minus = (int)(Math.random() * 5);
            System.out.println( "\n" + menu[order] + " 주문이 들어왔습니다.(제외 : " + exceptIngredients[minus] + ")\n");
            long beforeTime = System.currentTimeMillis(); // 코드 실행 전 시간 받아오기
            //주문은 직접 입력받지 않고 random하게 출력되도록 함.

            switch (order) {
                case 0 : orderedHamburger = new Hamburger(); break; //Hamburger는 패티가 들어가지 않은 기본 버거임
                case 1 : orderedHamburger = new ShrimpBurger(); break;
                case 2 : orderedHamburger = new ChickenBurger(); break;
                case 3 : orderedHamburger = new BulgogiBurger(); break;
            }

            String except = exceptIngredients[minus]; //CustomMade에서 switch 돌려서 뺄 재료 찾기 위해 변수 선언함.

            CustomMade customBurger = new CustomMade(); //원래의 버거 레시피에서 손님이 주문한 버거로 제작되도록 함.

            String customizedBurger = customBurger.customizeBurger(orderedHamburger.BurgerRecipe(), except);
            //인자로 원래의 버거 레시피와 뺄 재료를 줘서 custom한 burger가 만들어지도록 함.

            boolean isSuccess = player.makeBurger().equals(customizedBurger);
            //custom한 burger와 player가 입력한 버거와 같으면 성공임.

            long afterTime = System.currentTimeMillis();
            long secDiffTime = (afterTime - beforeTime) / 1000;
            System.out.println("소요 시간은 " + secDiffTime + "초 입니다.");
            //버거를 주문하고 나오는데 걸린 시간을 측정해서 15초 이상 걸리면 손님이 떠나고 점수를 잃도록 할거임.

            if(isSuccess && secDiffTime < 15){
                System.out.println("손님께 올바른 버거가 전달되었습니다.\n다음 손님을 받습니다.\n");
                player.plusSuccess();
            }else if(isSuccess == false && secDiffTime < 15){
                System.out.println("순서가 잘못되었습니다. 손님의 컴플레인이 들어왔고 손님은 떠났습니다. 다음 손님을 받습니다.\n");
                player.plusLoseCustomer();
            } else if(secDiffTime >= 15){
                System.out.println("손님이 기다리지 못하고 떠났습니다. 다음 손님을 받습니다.\n");
                player.plusLoseCustomer();
            }

            if(player.getSuccess() >= 7){
                System.out.println("가게 사장이 되었습니다. 승리하셨습니다.");
                return;
            } else if(player.getLoseCustomer() >= 4){
                System.out.println("이렇게 손님을 다 놓치면 돈을 벌 수 없습니다. 해고입니다. 다른 직장을 구하세요");
                return;
            }

        }



    }
}

