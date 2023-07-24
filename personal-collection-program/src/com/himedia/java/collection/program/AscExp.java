package com.himedia.java.collection.program;

import java.util.Comparator;

public class AscExp implements Comparator<ProductDTO> {

    @Override
    public int compare(ProductDTO o1, ProductDTO o2) {
        boolean isTrue = o1.getExpirationDate().isBefore(o2.getExpirationDate());

        return (isTrue) ? -1 : 1;
    }
}
