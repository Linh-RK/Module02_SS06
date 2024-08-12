package bai_tap;

public class ex02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello ");
        System.out.println(sb.toString());
        sb.insert(6,"world");
        System.out.println(sb.toString());
        sb.replace(0,5,"Hi");
        System.out.println(sb.toString());
        sb.delete(0,3);
        System.out.println(sb.toString());
        System.out.println(sb.length());
        sb.reverse();
        System.out.println(sb.toString());
//        append(String s): được sử dụng để nối thêm các chuỗi được chỉ định với chuỗi này.
//        insert(int offset, String s): được sử dụng để chèn chuỗi chỉ định với chuỗi này tại vị trí quy định
//        replace(int startIndex, int endIndex, String str): được sử dụng để thay thế chuỗi từ vị trị startIndex đến endIndex bằng chuỗi str
//        delete(int startIndex, int endIndex): được sử dụng để xóa chuỗi từ vị trí startIndex đến endIndex.
//        length(): được sử dụng trả về chiều dài của chuỗi nghĩa là tổng số ký tự.
//                reverse(): được sử dụng để đảo ngược chuỗi.
    }
}
