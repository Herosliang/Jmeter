import com.sun.deploy.util.SyncAccess;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liangwei on 2018/9/12.
 */
public class User implements IUser {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBlance() {
        return blance;
    }

    public void setBlance(Double blance) {
        this.blance = blance;
    }

    String name ;
    Double blance = 0.00;
    private Lock accountAccount=new ReentrantLock();

    public Double add(Double money){
        accountAccount.lock();
        Double newBlance = blance+money;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.blance=newBlance;
        accountAccount.unlock();
        return blance;
    }
}
