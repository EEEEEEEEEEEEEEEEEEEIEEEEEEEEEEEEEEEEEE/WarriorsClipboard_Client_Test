package top.thoxvi.WarriorsClipboardClientTest.Logger;

/**
 * Created by Thoxvi on 2017/4/15.
 */
public interface ILog {
    void WTF(String tag, String info);

    void Info(String tag, String info);

    void Debug(String tag, String info);

    void Erro(String tag, String info);
}
