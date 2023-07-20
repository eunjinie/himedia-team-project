package com.himedia.java.game;

import static com.himedia.java.game.Hamburger.*;

public class CustomMade {

    String customMadeRecipe;

    public String customizeBurger(String originRecipe,String except) {
        switch (except) {
            case "양상추":
                customMadeRecipe = originRecipe.replace(LETTUCE, "");
                break;
            case "양파":
                customMadeRecipe = originRecipe.replace(ONION, "");
                break;
            case "치즈":
                customMadeRecipe = originRecipe.replace(CHEESE, "");
                break;
            case "피클":
                customMadeRecipe = originRecipe.replace(PICKLE, "");
                break;
            default:customMadeRecipe = originRecipe;
                break;
        }
        return customMadeRecipe;
    }
}
