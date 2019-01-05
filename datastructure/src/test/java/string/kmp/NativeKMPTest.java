package string.kmp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YaboSun
 */
public class NativeKMPTest {
    NativeKMP nativeKMP = new NativeKMP();
    @Test
    public void indexKMP() {
        String S = "1234abcabcabcabc";
        String T = "abcabcabc";
        int pos = 4;
        System.out.println(nativeKMP.indexKMP(S, T, pos));
    }
}