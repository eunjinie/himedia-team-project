package com.himedia.java.collection.program;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {

    private ProductManager productManager = new ProductManager();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu(){

        mainMenu:
        while(true){
            System.out.println("========== 메뉴 ==========");
            System.out.println("1. 제품 추가");
            System.out.println("2. 제품 전체 조회(식품명 오름차순) ");
            System.out.println("3. 전 제품 유통기한 오름차순 조회");
            System.out.println("4. 제품명으로 검색(유통기한 오름차순)");
            System.out.println("5. 식품명으로 검색");
            System.out.println("6. 수량 수정");
            System.out.println("7. 제품 삭제");
            System.out.println("9. 프로그램 종료");


            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    addList();
                    break;
                case 2:
                    searchList();
                    break;
                case 3:
                    sortExpDate();
                    break;
                case 4:
                    searchName();
                    break;
                case 5:
                    searchType();
                    break;
                case 6:
                    updateNumber();
                    break;
                case 7:
                    removeProduct();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    break mainMenu;
                default:
                    System.out.println("잘못 선택하셨습니다. 번호를 다시 입력해주세요.");
                    break;
        }
    }
}

    public void addList() {

        System.out.println("=====제품 추가=====");
        System.out.print("제품명 입력 : ");
        String name = sc.nextLine();
        System.out.print("식품명 입력 : ");
        String type = sc.nextLine();
        System.out.print("브랜드 입력 : ");
        String brand = sc.nextLine();
        System.out.print("수량 입력 : ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("유통기한 입력(ex.2023-07-21) : ");
        String edate = sc.nextLine();
        String[] expirationDate = edate.split("-");
        int year = Integer.parseInt(expirationDate[0].toString());
        int month = Integer.parseInt(expirationDate[1].toString());
        int date = Integer.parseInt(expirationDate[2].toString());
        LocalDate exDate = LocalDate.of(year, month, date);

        productManager.addList(new ProductDTO(name,brand,type,number,exDate));

    }

    public void searchList() {

        System.out.println("=====제품 전체 조회=====");

        List<ProductDTO> sortList = new ArrayList<>();
        sortList.addAll(productManager.searchList());

        if(!sortList.isEmpty()){
                System.out.println(sortList);

        } else {
            System.out.println("목록이 존재하지 않습니다.");
        }
    }

    public void sortExpDate(){

        List<ProductDTO> sortList = new ArrayList<>();
        sortList.addAll(productManager.searchList());

        if(sortList.isEmpty()){
            System.out.println("목록이 존재하지 않습니다.");
            return;
        }

        sortList.sort(new AscExp());

        for(ProductDTO product : sortList){
            System.out.println(product);
        }
    }

    public void searchName(){
        System.out.println("=====제품명으로 검색=====");
        System.out.print("제품명 입력 : ");
        List<ProductDTO> sortList = new ArrayList<>();
        List<ProductDTO> searchList = productManager.searchName(sc.nextLine());
        sortList.addAll(searchList);
        sortList.sort(new AscExp());

        if (!searchList.isEmpty()) {
            for (int i = 0; i < sortList.size(); i++) {
                System.out.println(sortList.get(i));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void searchType(){
        System.out.println("=====식품명으로 검색=====");
        System.out.print("식품명 입력 : ");
        List<ProductDTO> searchList = productManager.searchType(sc.nextLine());

        if (!searchList.isEmpty()) {
            for (int i = 0; i < searchList.size(); i++) {
                System.out.println(searchList.get(i));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void updateNumber(){
        System.out.println("=====수량 변경=====");
        System.out.print("제품명 : ");
        String name = sc.nextLine();
        System.out.print("식품명 : ");
        String type = sc.nextLine();
        System.out.print("브랜드명 : ");
        String brand = sc.nextLine();
        System.out.print("유통기한 : ");
        String edate = sc.nextLine();
        String[] expirationDate = edate.split("-");
        int year = Integer.parseInt(expirationDate[0].toString());
        int month = Integer.parseInt(expirationDate[1].toString());
        int date = Integer.parseInt(expirationDate[2].toString());
        LocalDate exDate = LocalDate.of(year, month, date);

        System.out.print("변경할 수량 입력 : ");
        int number = sc.nextInt();

        ProductDTO editProduct = new ProductDTO(name, brand, type, number, exDate);

        if(productManager.updateNumber(editProduct)){
            System.out.println("성공적으로 수정되었습니다.");
        } else {
            System.out.println("수정할 제품을 찾지 못했습니다.");
        }
    }

    public void removeProduct(){

        System.out.println("===== 제품 삭제 =====");
        System.out.print("삭제할 제품명 : ");
        String dName = sc.nextLine();
        System.out.print("삭제할 제품의 유통기한 : ");
        String edate = sc.nextLine();
        String[] expirationDate = edate.split("-");
        int year = Integer.parseInt(expirationDate[0].toString());
        int month = Integer.parseInt(expirationDate[1].toString());
        int date = Integer.parseInt(expirationDate[2].toString());
        LocalDate exDate = LocalDate.of(year, month, date);

        if (productManager.removeProduct(dName,exDate)) {
            System.out.println("성공적으로 삭제 되었습니다.");
        } else {
            System.out.println("삭제할 제품을 찾지 못했습니다.");
        }
    }



    }




