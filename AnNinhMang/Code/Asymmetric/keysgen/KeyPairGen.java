package Asymmetric.keysgen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class KeyPairGen {
    // đối tượng KeyPairGenerator là bộ sinh khóa
    private KeyPairGenerator keyGen;
    // đối tượng KeyPair lưu trữ cặp khóa (public và private)
    private KeyPair keypair;
    // đối tượng PublicKey lưu trữ khóa công khai
    private PublicKey publicKey;
    // đối tượng PrivateKey lưu trữ khóa bí mật
    private PrivateKey privateKey;
    public KeyPairGen(int keylength) throws NoSuchAlgorithmException {
        // tạo đối tượng KeyPairGenerator để sinh khóa
        keyGen = KeyPairGenerator.getInstance("RSA");
        // khởi tạo bộ sinh khóa với tham số đầu vào là số byte
        keyGen.initialize(keylength);
        // sinh khóa
        keypair = keyGen.genKeyPair();
        // lấy khóa công khai
        publicKey = keypair.getPublic();
        // lấy khóa bí mật
        privateKey = keypair.getPrivate();
    }

    // ghi khóa ra file
    public void wwriteToFile(String path, byte[] key) throws IOException {
        File f = new File(path);
        // tạo thưu mục lưu trữ 2 khóa
        f.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
