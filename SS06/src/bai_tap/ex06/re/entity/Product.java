package bai_tap.ex06.re.entity;

import java.util.Scanner;

public class Product {
    private String productid;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private Boolean status;

    public Product() {
    }

    public Product(String productid, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, Boolean status) {
        this.productid = productid;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void inputData(Scanner sc, Product[] arrProduct){
        this.productid = inputProductId(sc,arrProduct);
        this.productName = inputProductName(sc, arrProduct);
        this.importPrice = inputImportPrice(sc);
        this.exportPrice = inputExportPrice(sc);
        this.profit = calcProfit();
        this.quantity = inputQuantity(sc);
        System.out.println("Enter product descriptions: ");
        this.descriptions = sc.nextLine();
        this.status = inputStatus(sc);
    }

    private Boolean inputStatus(Scanner sc) {
        while (true){
            System.out.println("Enter product status: ");
            try{
                Boolean status = Boolean.parseBoolean(sc.nextLine());
                return status;
            }
            catch(Exception e){
                System.err.println("Product status must be true or false");
            }
        }
    }

    private int inputQuantity(Scanner sc) {
        while (true){
            System.out.println("Enter product quantity: ");
            try{
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity < 0){
                    System.out.println("Product quantity must be greater than 0");
                }else
                    return quantity;
            }
            catch(Exception e){
                System.err.println("Product quantity must be positive integer.");
            }
        }
    }

    private float inputExportPrice(Scanner sc) {
        while (true){
            System.out.println("Enter export price: ");
            try{
                float exportPrice = Float.parseFloat(sc.nextLine());
                if (exportPrice < this.importPrice*1.2){
                    System.out.println("Export price must be greater 20% than importPrice");
                }else
                    return exportPrice;
            }
            catch(Exception e){
                System.err.println("Export price must be a float.");
            }
        }
    }

    private float inputImportPrice(Scanner sc) {
        while (true){
            System.out.println("Enter product import: ");
            try{
                float importPrice = Float.parseFloat(sc.nextLine());
                if (importPrice <= 0){
                    System.out.println("Import price must be greater than 0");
                } else
                    return importPrice;
            }
            catch (Exception e){
                System.err.println("Product import must be a float");
            }

        }

    }
    //    productid – String: Mã sản phẩm gồm 4 ký tự, bắt đầu là ký tự P, không được trùng lặp
    private String inputProductId(Scanner sc, Product[] arrProduct) {
        while(true){
            System.out.println("Enter product id (4 characters, begin with P, be unique): ");
            String productId = sc.next();
            if(productId.matches("^[P][a-zA-Z0-9]{3}$")){
                boolean isExist = false ;
                for(Product product : arrProduct){
                    if(product != null){
                        if(product.getProductid().equals(productId)){
                            isExist = true ;
                            break;
                        }
                    }else
                        break;
                }
                if (isExist)
                    System.out.println("Product ID already exist");
                else
                    return productId;
            } else
                System.out.println("Product ID must be in form Pxxx");

        }
    }

    //    productName – String: Tên sản phẩm có từ 6-50 ký tự, không trùng lặp
    private String inputProductName(Scanner sc, Product[] arrProduct) {
        while (true) {
            System.out.println("Enter product name: ");
            String productName = sc.nextLine();
        if(productName.length() <6 || productName.length() > 50){
            System.out.println("Product name must be between 6 and 50 characters!");
        } else {
            boolean isExist = false ;
            for(Product product : arrProduct){
                if(product != null){
                    if(product.getProductName().equals(productName)){
                        isExist = true ;
                        break;
                    }
                }
            }
            if (isExist)
                System.out.println("Product name already exist");
            else
                return productName;
        }
        }


//    profit – float: Lợi nhuận tính theo công thức:
//    profit = exportPrice – importPrice
//    quantity – int: Số lượng sản phẩm có giá trị lớn hơn 0
//    descriptions – String: Mô tả sản phẩm
//    status – Boolean: Trạng thái sản phẩm chỉ nhận 1 trong 2 giá trị true | false



}
//
    public void displayData(){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-6s | %-30s | %-12.2f | %-12.2f | %-12.2f | %-5d | %-30s | %-10s |\n",this.productid,this.productName,this.importPrice,this.exportPrice,this.profit,this.quantity,this.descriptions,this.status);
    }
    public float calcProfit(){
        float profit;
        profit= this.exportPrice-this.importPrice;
        return profit;
    }
    }

