package com.himedia.java.game;

public class BulgogiBurger extends Hamburger {



    @Override
    public String BurgerRecipe() {
        String bulgogiBurgerRecipe = new StringBuilder(super.BurgerRecipe()).insert(1,(BULGOGI+BULGOGI)).toString();
        return bulgogiBurgerRecipe;
    }
}
