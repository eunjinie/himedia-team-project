package com.himedia.java.collection.program;

import java.util.ArrayList;
import java.util.List;

public class FoodManager {

    /* Food 목록이 저장되는 List */
    private List<FoodDTO> foodList = new ArrayList<>();


    /* 음식 추가 */
    public void addList(FoodDTO food){
        foodList.add(food);
    }

    /* 음식 전체 조회 */
    public List<FoodDTO> searchAllFood (){
        return foodList;
    }

    /* 음식 이름 조회 */
    public List<FoodDTO> searchName(String name){
        List<FoodDTO> searchList = new ArrayList<>();
        for(FoodDTO food : foodList){
            if(food.getName().contains(name)){
                searchList.add(food);
            }
        }
        return searchList;
    }

    /* 음식 타입 조회 (면인지, 밥인지, 빵인지 등등) */
    public List<FoodDTO> searchType(String type){
        List<FoodDTO> searchList = new ArrayList<>();
        for(FoodDTO food : foodList){
            if(food.getType().equalsIgnoreCase(type)){
                searchList.add(food);
            }
        }
        return searchList;
    }

    /* 잔여 수량 조회 */
    public int remainNumber(String name){
        int remain = 0;
        for(FoodDTO food : foodList){
            if(food.getName().equalsIgnoreCase(name)){
                 return food.getNumber();
            }
        }
        return remain;
    }

    /* 수량 변경 */



}
