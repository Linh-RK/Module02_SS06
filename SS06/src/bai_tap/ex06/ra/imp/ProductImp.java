package bai_tap.ex06.ra.imp;

import bai_tap.ex06.re.entity.Product;

import java.util.Scanner;

public class ProductImp {
    public static Product[] arrProduct = new Product[100];
    public static int currentIndexProduct = -1 ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------MENU----------------------------------");
            System.out.println("        1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)           ");
            System.out.println("        2. Hiển thị thông tin các sản phẩm                          ");
            System.out.println("        3. Tính lợi nhuận các sản phẩm                              ");
            System.out.println("        4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần             ");
            System.out.println("        5. Thống kê các sản phẩm theo giá                           ");
            System.out.println("        6. Tìm các sản phẩm theo tên sản phẩm                       ");
            System.out.println("        7. Nhập sản phẩm                                            ");
            System.out.println("        8. Bán sản phẩm                                             ");
            System.out.println("        9. Cập nhật trạng thái sản phẩm                             ");
            System.out.println("        10. Thoát                                                   ");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Please enter your choice:");
            int choice;
            while (true){
                try{
                    choice = Integer.parseInt(scanner.nextLine());
                    if(choice >10 || choice <0){
                        System.err.println("Your choice must be integer between 1 and 10. Try again.");
                    } else
                        break;
                }
                catch (Exception e){
                    System.err.println("Your choice must be integer between 1 and 10. Try again.");
                }
            }
            switch (choice){
                case 1:{
                    while(true){
                        System.out.println("Enter the number of product you want to add: ");
                        try{
                            int numberAdd = Integer.parseInt(scanner.nextLine());
                            if (numberAdd < 0){
                                System.out.println("The number of product you want to add must be positive integer. Try again.");
                            } else{
                                for(int i = 0 ; i < numberAdd ; i++){
                                    System.out.println("Enter product number : " + (i+1));
                                    ProductImp.currentIndexProduct++;
                                    Product product = new Product();
                                    product.inputData(scanner,ProductImp.arrProduct);
                                    arrProduct[currentIndexProduct] = product;
                                }
                            }
                            ProductImp.displayProductList(scanner,arrProduct,ProductImp.currentIndexProduct);
                        }
                        catch (Exception e){
                            System.err.println("The number of product you want to add must be positive integer. Try again.");
                        }
                        break;
                    }
                }
                case 2:
                case 3:{
                    ProductImp.displayProductList(scanner,arrProduct,ProductImp.currentIndexProduct);
                    break;
                }
                case 4:{
                    for(int i = 0 ; i <= currentIndexProduct ; i++){
                        for(int j = i+1 ; j <= currentIndexProduct ; j++){
                            if(arrProduct[i].getProfit() < arrProduct[j].getProfit()){
                                Product temp = ProductImp.arrProduct[i];
                                ProductImp.arrProduct[i] = ProductImp.arrProduct[j];
                                ProductImp.arrProduct[j] = temp;
                            }
                        }
                    }
                    ProductImp.displayProductList(scanner,arrProduct,ProductImp.currentIndexProduct);
                    break;
                }
                case 5:{
                    for(int i = 0 ; i <= currentIndexProduct ; i++){
                        for(int j = i+1 ; j <= currentIndexProduct ; j++){
                            if(arrProduct[i].getExportPrice() < arrProduct[j].getExportPrice()){
                                Product temp = ProductImp.arrProduct[i];
                                ProductImp.arrProduct[i] = ProductImp.arrProduct[j];
                                ProductImp.arrProduct[j] = temp;
                            }
                        }
                    }
                    ProductImp.displayProductList(scanner,arrProduct,ProductImp.currentIndexProduct);
                    break;
                }
                case 6:{
                    break;
                }
                case 7:{
                    break;
                }
                case 8:{
                    break;
                }
                case 9:{
                    break;
                }
                case 10:{
                    break;
                }
                default:
                    break;


            }
        }
    }
    public static void displayProductList(Scanner scanner, Product[] arrProduct, int currentIndexProduct){
        System.out.printf("| %-6s | %-30s | %-12s | %-12s | %-12s | %-5s | %-30s | %-10s |\n","ID","ProductName","Import","Export","Profit","Qty","Description","Status");
        for(int i = 0 ; i < currentIndexProduct+1; i++){
            arrProduct[i].displayData();
        }
    }
}
