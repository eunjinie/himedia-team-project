package com.himedia.java.collection.program;

import java.util.Comparator;

public class AscType implements Comparator<ProductDTO> {

    @Override
    public int compare(ProductDTO o1, ProductDTO o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
