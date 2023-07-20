package com.himedia.java.game;

public class Hamburger {

    public static final String BREAD = "1";
    public static final String LETTUCE = "2";
    public static final String SOURCE = "3";
    public static final String ONION = "4";
    public static final  String CHEESE = "5";
    public static final String PICKLE = "6";
    public static final String BULGOGI = "7";
    public static final String CHICKEN = "8";
    public static final String SHRIMP = "9";

    public String BurgerRecipe(){
       String recipe = new StringBuilder(BREAD + SOURCE + LETTUCE + CHEESE + PICKLE + ONION).toString();
        return recipe;
    }



}
