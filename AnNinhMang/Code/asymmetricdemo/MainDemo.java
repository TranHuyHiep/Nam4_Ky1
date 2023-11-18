package asymmetricdemo;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MainDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, UnsupportedEncodingException, BadPaddingException, InvalidKeyException {
        SymmetricCryptor sc = new SymmetricCryptor();
        String msg = "Tran Huy Hiep";
        String en_msg = sc.encryptText1(msg, sc.getSecretKeySpec());
        System.out.println(Base64.getEncoder().encodeToString(sc.getSecretKeySpec().getEncoded()));
        System.out.println("Plain text: " + msg);
        System.out.println("Encrypted text: " + en_msg);
        String de_msg = sc.decryptText1(en_msg, sc.getSecretKeySpec());
        System.out.println("Decrypted text: " + de_msg);
    }
}
