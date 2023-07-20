package com.himedia.java.game;

public class ChickenBurger extends Hamburger {



    @Override
    public String BurgerRecipe() {
        String chickenBurgerRecipe = new StringBuilder(super.BurgerRecipe()).insert(1,(CHICKEN + CHICKEN)).toString();
        return chickenBurgerRecipe;
    }
}
