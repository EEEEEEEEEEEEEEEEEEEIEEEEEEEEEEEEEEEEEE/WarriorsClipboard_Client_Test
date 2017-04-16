package top.thoxvi.WarriorsClipboardClientTest.Logger;


/**
 * Created by Thoxvi on 2017/4/15.
 */
public class PrintlnLogger implements ILog {
    @Override
    public void WTF(String tag, String info) {
        System.out.println(tag+":"+info);
    }

    @Override
    public void Info(String tag, String info) {
        System.out.println(tag+":"+info);
    }

    @Override
    public void Debug(String tag, String info) {
        System.out.println(tag+":"+info);
    }

    @Override
    public void Erro(String tag, String info) {
        System.err.println(tag+":"+info);
    }
}
