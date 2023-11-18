package Asymmetric.asymmetricdemo;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class AsymmetricDemo {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        AsymmetricCryptor AsC = new AsymmetricCryptor();
        String msg = "Tran Huy Hiep";
        String en_msg = AsC.encryptText(msg, AsC.getPublicKey("D:/Keys/PublicKey"));
        System.out.println("Plain text: " + msg);
        System.out.println("Encrypted text: " + en_msg);
        String de_msg = AsC.decryptText(en_msg, AsC.getPrivateKe("D:/Keys/PrivateKey"));
        System.out.println("Decrypted text: " + de_msg);
    }
}
