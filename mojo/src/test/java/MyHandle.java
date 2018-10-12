import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liangwei on 2018/9/14.
 */
public class MyHandle implements InvocationHandler {
    private Object target;

    public  Object getinstance(Object target){
        this.target=target;
        IUser o = (IUser) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        return o;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object re = null;
        System.out.println("runnng my handle !");
        System.out.println(String.format("proxy对象：%s\nmethod方法是：%s\nargs参数是：%s",proxy.getClass().getName()
                ,method.getName(),args[0]));
        re = method.invoke(target,args);
        return re;
    }
}
