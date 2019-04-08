package opersystem;

/**
 * @author YaboSun
 */
public class DeadLock {
    // 通过一个简单的例子测试线程死锁

    public static void main(String[] args) {
        // 线程a
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                DeadLock.method1();
            }
        });

        // 线程b
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                DeadLock.method2();
            }
        });

        a.start();
        b.start();
    }

    private static void method1() {
        synchronized (String.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程 a 尝试获取integer.class");
            synchronized (Integer.class){

            }
        }
    }

    private static void method2() {
        synchronized (Integer.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程 b 尝试获取 string.class");
            synchronized (String.class){

            }
        }
    }
}
