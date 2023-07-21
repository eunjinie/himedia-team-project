package com.himedia.java.game;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Staff player = new Staff(); //매장의 직원이 곧 플레이어다

        String[] menu = {"베지버거", "새우버거", "치킨버거", "불고기버거"}; //베지버거를 기반으로 각각의 버거에 패티 추가되도록 구성
        String[] exceptIngredients = {"양상추", "양파", "치즈", "피클", "선택 안함"}; //못먹는 재료가 있다면 빼도록 함.

        Hamburger orderedHamburger = null;

        Info ready = new Info();
        boolean isStart = ready.gameStart(); //게임 스타트 할건지 물어보고 시작함
        if(isStart == false){ return; }

        while(true) {
            int order = (int) (Math.random() * 4);
            int minus = (int)(Math.random() * 5);

            switch (order) {
                case 0 : orderedHamburger = new Hamburger(); break; //Hamburger는 패티가 들어가지 않은 베지 버거임
                case 1 : orderedHamburger = new ShrimpBurger(); break;
                case 2 : orderedHamburger = new ChickenBurger(); break;
                case 3 : orderedHamburger = new BulgogiBurger(); break;
            }
            //주문은 직접 입력받지 않고 random하게 출력되도록 함.
            System.out.println("====================================================================================");
            System.out.println(menu[order] + " 주문이 들어왔습니다.(제외 : " + exceptIngredients[minus]+")");
            System.out.println("====================================================================================");
            long beforeTime = System.currentTimeMillis(); // 코드 실행 전 시간 받아오기


            String except = exceptIngredients[minus]; //CustomMade에서 switch 돌려서 뺄 재료 찾기 위해 변수 선언함.

            CustomMade customBurger = new CustomMade(); //원래의 버거 레시피에서 손님이 주문한 버거로 제작되도록 함.

            String customizedBurger = customBurger.customizeBurger(orderedHamburger.BurgerRecipe(), except);
            //인자로 원래의 버거 레시피와 뺄 재료를 줘서 custom한 burger가 만들어지도록 함.

            boolean isSuccess = player.makeBurger().equals(customizedBurger);
            //custom한 burger와 player가 입력한 버거와 같으면 성공임.

            long afterTime = System.currentTimeMillis();
            long secDiffTime = (afterTime - beforeTime) / 1000;
            System.out.println("\n<소요 시간 : " + secDiffTime + "초>");
            //버거를 주문하고 나오는데 걸린 시간을 측정해서 15초 이상 걸리면 손님이 떠나고 점수를 잃도록 할거임.

            if(isSuccess && secDiffTime < 15){
                System.out.println("조았어~~~^^ 진행시켜^^\n");
                player.plusSuccess();
            }else if(isSuccess == false && secDiffTime < 15){
                System.out.println("%%%%%%정신 차려%%%%%%\n");
                player.plusLoseCustomer();
            } else if(secDiffTime >= 15){
                System.out.println("%%%%%%손님은 기다려주지 않는다%%%%%%%\n");
                player.plusLoseCustomer();
            }

            if(player.getSuccess() >= 3){
                System.out.println("수습기간이 끝났습니다. 이제 정직원입니다. ㅋㅋ 짝짝짝 ㅋㅋ");
                return;
            } else if(player.getLoseCustomer() >= 3){
                System.out.println("강재원 황주희 이은진 이었습니다.");
                return;
            }

        }

    }

}

