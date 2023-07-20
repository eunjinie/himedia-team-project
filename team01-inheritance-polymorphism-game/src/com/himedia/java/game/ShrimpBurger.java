package com.himedia.java.game;

public class ShrimpBurger extends Hamburger {


    @Override
    public String BurgerRecipe() {
        String shrimpBurgerRecipe = new StringBuilder(super.BurgerRecipe()).insert(1,(SHRIMP + SHRIMP)).toString();
        return shrimpBurgerRecipe;
    }
}

