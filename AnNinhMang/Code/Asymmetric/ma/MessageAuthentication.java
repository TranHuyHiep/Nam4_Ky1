package Asymmetric.ma;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageAuthentication {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String msg = "Tran Huy Hiep";
        // khởi tạo bộ tạo bản băm với tham số vào là tên thuật toán
        MessageDigest md = MessageDigest.getInstance("MD5");
        // thiết lập đầu vào cho bản băm là chuỗi byte
        md.update(msg.getBytes("UTF-8"));
        // gọi hàm md.digest để thu được bản băm là chuỗi byte đầu ra
        byte byteData[] = md.digest();
        // hiển thị chuỗi byte đầu ra dạng mã Hexa
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println("Hex format: " + hexString.toString());
    }
}
