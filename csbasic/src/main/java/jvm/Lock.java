package jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ConcurrentHashMap;

public class Lock {

    static Test test = new Test();
    public static void main(String[] args) {
        System.out.println("start");

        System.out.println(ClassLayout.parseInstance(test).toPrintable());

        synchronized (test) {
            System.out.println("locking");

        }

        System.out.println("stop");
    }
}
