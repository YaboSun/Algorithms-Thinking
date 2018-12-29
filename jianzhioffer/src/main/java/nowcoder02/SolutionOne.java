package nowcoder02;

/**
 * @author YaboSun
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class SolutionOne {
    /**
     * 初步思路：
     * 主要考察：
     * 1、StringBuffer结构
     * 2、替换以后长度变化问题
     *
     * 可以先遍历数组 找到已有的空格数 然后新建一个
     */
    public String replaceSpace(StringBuffer str) {
        if (str.length() == 0 || str == null) {
            return "";
        }
        char[] ch = str.toString().toCharArray(); // 这里感觉完全没有必要 之前对StringBuffer不太理解
        int spaceNum = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == ' '){
                spaceNum++;
            }
        }
        char[] ch1 = new char[2 * spaceNum + str.length()];
        int len = 2 * spaceNum + str.length() - 1;
        for(int i = ch.length - 1; i >= 0; i--){
            if(ch[i] != ' '){
                ch1[len--] = ch[i];
            }else{
                ch1[len--] = '0';
                ch1[len--] = '2';
                ch1[len--] = '%';
            }
        }
        return String.valueOf(ch1);
    }
}
