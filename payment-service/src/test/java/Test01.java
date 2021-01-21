import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Test01 {

    private static ReentrantLock lock = new ReentrantLock();
    private static  AtomicBoolean isTokenRefreshed = new AtomicBoolean(); //默认为false，当第一次获取token后，设置为true
    public static void main(String[] args) throws InterruptedException {
        isTokenRefreshed.set(true);
        System.out.println("系统第一次获取token，重置已刷新标识为 true");
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                private int code = 40010;
                @Override
                public void run() {
                    //1.判断token失效后，上锁，立即设置isTokenRefreshed = false;
                    if(code == 40010){

                        if (isTokenRefreshed.get()) {

                        }
                        System.out.println(Thread.currentThread().getName()+": token在远程已失效");
                        isTokenRefreshed.set(false);
                        System.out.println("重置token已刷新标识为false");
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + "：上锁");

                        if(isTokenRefreshed.get()) { //如果token已刷新
                            System.out.println("token已经刷新");
                            System.out.println("业务逻辑处理。。。。。。");
                            lock.unlock();
                            System.out.println("释放锁");
                        } else { //token未刷新
                            refreshToken();
                            isTokenRefreshed.set(true);
                            System.out.println("重置token刷新标识为 true");
                            lock.unlock();
                            System.out.println(Thread.currentThread().getName() + "：释放锁");
                        }
                    } else {

                    }


                }
            }).start();
        }

    }

    public static void refreshToken(){
        System.out.println("token已刷新");
    }
}
