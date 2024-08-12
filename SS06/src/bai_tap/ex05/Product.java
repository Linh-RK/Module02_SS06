package bai_tap.ex05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
//    productid – String: mã sản phẩm đồ uống, gồm 4 ký tự bắt đầu là một trong 3 ký tự
//    (C: các đồ uống là café, S: các đồ uống là sinh tố, A: các đồ ăn nhanh).
    private String productId;
//    productName – String: tên sản phẩm đồ uống, có từ 10-50 ký tự.
    private String productName;
//    price – float: giá sản phẩm có giá trị lớn hơn 0.
    private float price;
//    description – String: mô tả sản phẩm
    private String description;
//    created – date: ngày nhập sản phẩm có định dạng dd/mm/yyyy.
    private Date created;
//  catalogName – String: Tên danh mục mà sản phẩm thuộc về.
    private String catalogName;
//    productStatus – int: trạng thái sản phẩm, chỉ nhận 1 trong các trạng thái sau
//    (0: Đang bán – 1: Hết hàng – 2: Không bán).
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, String catalogName, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogName = catalogName;
        this.productStatus = productStatus;
    }
    //    Các constructor
//
//    Các phương thức getter/setter

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

//    Xây dựng các phương thức:
//
//    inputData(): cho phép nhập thông tin của sản phẩm
    public void inputData(Scanner scanner){
        this.productId = inputProductId(scanner);
        this.productName = inputProductName(scanner);
        this.price = inputPrice(scanner);
        System.out.println("Enter product description: ");
        this.description = scanner.nextLine();
        this.created = inputCreated(scanner);
        System.out.println("Enter catalog of product !");
        this.catalogName = scanner.nextLine();
        this.productStatus = inputProductStatus(scanner);
    }

    private int inputProductStatus(Scanner scanner) {
        while(true) {
            System.out.println("Enter product status (0: Available, 1: Out of stock, 2: Unavailable");
            try{
                int productStatus = Integer.parseInt(scanner.nextLine());
            }
            catch(Exception e){
                System.err.println("Product status must be an integer between 0 and 2");
            }
            if(productStatus <0 || productStatus > 2){
                System.out.println("Product status must be between 0 and 2");
            } else
                return productStatus;
        }

    }

    private Date inputCreated(Scanner scanner) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        do
        {
            System.out.println("Enter created date by format: dd/MM/yyyy: ");
            String Date = scanner.nextLine();
            try
            {
                return sdf.parse(Date);
            }
            catch (ParseException e)
            {
                System.err.println("Date is not in DD/MM/YYYY format");
            }
        }
        while (true);
    }

    private float inputPrice(Scanner scanner) {
        while (true){
            System.out.println("Enter the price of the product: ");
            float price = Float.parseFloat(scanner.nextLine());
            if(price < 0){
                System.out.println("Price  must be greater than 0!");
            }
            else
                return price;
        }
    }

    private String inputProductName(Scanner scanner) {

        while(true) {
            System.out.println("Enter product name:");
            String productName = scanner.nextLine();
            if(productName.length() <10 || productName.length() > 50){
                System.out.println("Product name must be between 10 and 50 characters!");
            } else
                return productName;
        }
    }

    private String inputProductId(Scanner scanner) {
        while (true){
            System.out.println("Enter product id: ");
            String productId = scanner.next();
            if(productId.matches("^[CSA][a-zA-Z0-9]{3}$")){
                return productId;
            }else
                System.out.println("Invalid product id");
        }
    }

//    displayData(): Cho phép hiển thị thông tin sản phẩm
    public void displayData(){
        System.out.println("_________________________________________________________________________________________________________________________");
        System.out.printf("|%-6s|%-20s|%-10.2f|%-30s|%-12s|%-20s|%-15s|",productId,productName,price,description,created,catalogName,productStatus == 0 ? "Available" : (productStatus == 1 ? "Out of stock" : "Unavailable"));

    }
}
