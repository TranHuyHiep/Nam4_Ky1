package asymmetricdemo;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SymmetricCryptor {
    private final String algorithm = "AES";
    private KeyGenerator keyGen;
    private SecretKey secretKey;
    private SecretKeySpec secretKeySpec;
    private Cipher cipher;

    public SymmetricCryptor() throws NoSuchAlgorithmException {
        // khởi tạo bộ tạo khóa theo thuật toán đã chọn
        keyGen = KeyGenerator.getInstance(algorithm);
        // tạo khóa
        secretKey = keyGen.generateKey();
        // tạo khóa băng việc thêm 256bit thông tin mật
        String key = "mothaibabonnamsa";
        secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
    }

    public String encryptText(String msg, SecretKey key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        // khoi tao bo ma
        cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // để m hóa dùng phuơng thức doFinal của cipher
        // tham số truyền vào là luồng bit cần max hóa
        return Base64.getEncoder().encodeToString(
                cipher.doFinal(msg.getBytes("UTF-8"))
        );
    }

    public String decryptText(String msg, SecretKey key) throws IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        // khởi tạo bộ mã
        cipher = Cipher.getInstance(algorithm);
        // xác lập chế độ giải mã
        cipher.init(Cipher.DECRYPT_MODE, key);
        // để giải mã dùng hàm doFinal của đối tuợng cipher
        // tham số vào là luồng bit cần giải mã
        return new String(cipher.doFinal(
                Base64.getDecoder().decode(msg)), "UTF-8");
    }

    public String encryptText1(String msg, SecretKeySpec key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        // khoi tao bo ma
        cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // để m hóa dùng phuơng thức doFinal của cipher
        // tham số truyền vào là luồng bit cần max hóa
        return Base64.getEncoder().encodeToString(
                cipher.doFinal(msg.getBytes("UTF-8"))
        );
    }

    public String decryptText1(String msg, SecretKeySpec key) throws IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        // khởi tạo bộ mã
        cipher = Cipher.getInstance(algorithm);
        // xác lập chế độ giải mã
        cipher.init(Cipher.DECRYPT_MODE, key);
        // để giải mã dùng hàm doFinal của đối tuợng cipher
        // tham số vào là luồng bit cần giải mã
        return new String(cipher.doFinal(
                Base64.getDecoder().decode(msg)), "UTF-8");
    }

    public SecretKey getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public SecretKeySpec getSecretKeySpec() {
        return secretKeySpec;
    }

    public void setSecretKeySpec(SecretKeySpec secretKeySpec) {
        this.secretKeySpec = secretKeySpec;
    }


}
