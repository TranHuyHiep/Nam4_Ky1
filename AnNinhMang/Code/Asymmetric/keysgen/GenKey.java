package Asymmetric.keysgen;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class GenKey {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyPairGen kg = new KeyPairGen(1024);
        kg.wwriteToFile("D:/Keys/PrivateKey",
                kg.getPrivateKey().getEncoded());
        kg.wwriteToFile("D:/Keys/PublicKey",
                kg.getPublicKey().getEncoded());
    }
}
