/**
 * Created by liangwei on 2018/9/12.
 */
public class MyRunnable implements Runnable {

    User user ;
    Double blance ;

    MyRunnable(User user,Double money){
        this.user= user;
        this.blance=money;
    }
    public void run(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.add(blance);

        System.out.println("当前线程money："+user.getBlance()+"当前线程名称："+Thread.currentThread().getName());
    }
}
