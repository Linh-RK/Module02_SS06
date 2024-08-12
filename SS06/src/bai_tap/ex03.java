package bai_tap;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex03 {
    public static void main(String[] args) {
//        Một địa chỉ email hợp lệ có thể có dạng "username@OrganizationName. area symbol".
//        Khai báo chuỗi biểu thức chính quy (vd: String regex = "\\d{3}-\\d{2}-\\d{4}";)
//        và chuỗi cần kiểm tra String check (chuỗi này có thể nhập từ bàn phím) .
//        Sử dụng phương thức matches(regex, check) từ lớp Pattern
//        để kiểm tra xem chuỗi check có khớp với biểu thức chính quy regex hay không,
//        dùng câu lệnh điều kiện kiểm tra rồi đưa ra kết luận .
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter email :");
            String email = scanner.nextLine();
            if(email.matches("^[a-zA-Z][a-zA-Z0-9]{1,}@[a-z]{5,}.[a-z]{3,}$")){
                System.out.println(email);
            }else {
                System.out.println("Email is not in right form.");
            }

        }
}
