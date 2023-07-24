package com.himedia.java.collection.program;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private List<ProductDTO> productList = new ArrayList<>();

    /* 제품 추가 */
    public void addList(ProductDTO product) {
        productList.add(product);
    }

    /* 전체 제품 조회 */
    public List<ProductDTO> searchList() {
        return productList;
    }


    /* 제품명으로 리스트 조회 */
    public List<ProductDTO> searchName(String name) {
        List<ProductDTO> nameList = new ArrayList<>();
        for (ProductDTO product : productList) {
            if (product.getName().equals(name)) {
                nameList.add(product);
            }
        }
        return nameList;
    }

    /* 식품명으로 리스트 조회 */
    public List<ProductDTO> searchType(String type) {
        List<ProductDTO> typeList = new ArrayList<>();
        for (ProductDTO product : productList) {
            if (product.getType().contains(type)) {
                typeList.add(product);
            }
        }
        return typeList;
    }


    /* 수량 변경 */
    public boolean updateNumber(ProductDTO updateNumber) {

        ProductDTO old = null;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(updateNumber.getName())
                    && productList.get(i).getExpirationDate().isEqual(updateNumber.getExpirationDate())) {
                old = productList.set(i, updateNumber);
            }
        }
        return old != null;
    }

    /* 상품 삭제 */
    public boolean removeProduct(String name, LocalDate expirationDate) {

        ProductDTO old = null;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)
                    && productList.get(i).getExpirationDate().isEqual(expirationDate)) {
                old = productList.remove(i);
            }
        }
        return old != null;
    }
}

