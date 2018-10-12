import org.testng.annotations.Test;

/**
 * Created by liangwei on 2018/9/12.
 */
public class MyThread {

    User user = new User();
    Double money = 10.00;
    private int size = 1;

    Runnable myrunnable = new MyRunnable(user,money);
   @Test
    public void start(){
        Thread t1 = new Thread(myrunnable);
        t1.start();
    }

    public void genarater(){
        for (int i=0;i<size;i++){
            Thread t = new Thread(myrunnable);
            t.start();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Test
    public void test(){
        MyThread thread = new MyThread();
        thread.setSize(10);
        thread.genarater();
    }

}
