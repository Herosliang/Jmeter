import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liangwei on 2018/9/12.
 */
public class Excute {

    public static void main(String[] args){
        User user = new User();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i= 0;i<100;i++){
            executorService.execute(new MyRunnable(user, (double) 1));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("当前user余额："+user.getBlance());
    }

    @Test
    public void test(){
        IUser user = new User();
        MyHandle handle = new MyHandle();
        IUser proxy = (IUser) handle.getinstance(user);
        Double blance = proxy.add(15.0);
        System.out.println("执行add方法后的blance："+blance);
    }
}
