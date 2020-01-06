package jvm;

public interface ITest {
    int a = 0;

    default void get() {
        System.out.println(" ");
    }
}
