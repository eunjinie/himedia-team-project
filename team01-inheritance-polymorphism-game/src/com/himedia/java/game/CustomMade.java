package com.himedia.java.game;

public class CustomMade {

    String customMadeRecipe;

    public String customizeBurger(String originRecipe,String except) {
        switch (except) {
            case "양상추":
                customMadeRecipe = originRecipe.replace("2", "");
                break;
            case "양파":
                customMadeRecipe = originRecipe.replace("4", "");
                break;
            case "치즈":
                customMadeRecipe = originRecipe.replace("5", "");
                break;
            case "피클":
                customMadeRecipe = originRecipe.replace("6", "");
                break;
            default:customMadeRecipe = originRecipe;
                break;
        }
        return customMadeRecipe;
    }
}
