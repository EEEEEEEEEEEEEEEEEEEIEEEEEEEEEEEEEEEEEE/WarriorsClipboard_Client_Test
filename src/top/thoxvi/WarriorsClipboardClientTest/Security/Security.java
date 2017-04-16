package top.thoxvi.WarriorsClipboardClientTest.Security;

import top.thoxvi.WarriorsClipboardClientTest.Logger.ILog;
import top.thoxvi.WarriorsClipboardClientTest.Logger.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Created by Thoxvi on 2017/4/15.
 */
public class Security implements SecurityMode {
    private byte[] password;

    public Security(byte[] password) {
        setPassword(password);
    }

    private ILog logger = LoggerFactory.getInstance().getLogger();

    @Override
    public byte[] encrypt(byte[] data) {
        logger.WTF(this.getClass().getName(), "我加密了！");
        return encrypt(data, password);
//        return data;
    }

    @Override
    public byte[] decrypt(byte[] data) {
        logger.WTF(this.getClass().getName(), "我解密了！");
        return decrypt(data, password);
//        return data;
    }

    @Override
    public void setPassword(byte[] password) {
        logger.WTF(this.getClass().getName(), "我设置了密码！");
        this.password = password;
    }


    private byte[] encrypt(byte[] content, byte[] password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            logger.Erro(this.getClass().getName(), "加密失败！");
        }
        return null;
    }

    private byte[] decrypt(byte[] content, byte[] password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
            logger.Erro(this.getClass().getName(), "解密失败！");
        }
        return null;
    }
}