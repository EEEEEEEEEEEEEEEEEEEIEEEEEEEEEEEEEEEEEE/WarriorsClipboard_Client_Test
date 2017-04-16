package top.thoxvi.WarriorsClipboardClientTest.Security;

/**
 * Created by Thoxvi on 2017/4/15.
 */
public interface SecurityMode {
    byte[] encrypt(byte[] data);
    byte[] decrypt(byte[] data);
    void setPassword(byte[] password);
}
