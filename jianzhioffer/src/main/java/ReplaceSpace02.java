/**
 * @author YaboSun
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class ReplaceSpace02 {

    /**
     * 初步思路：
     * 主要考察：
     * 1、StringBuffer结构
     * 2、替换以后长度变化问题
     *
     * 可以先遍历数组 找到已有的空格数 然后新建一个
     */
    public String replaceSpace1(StringBuffer str) {
        if (str == null || str.length() == 0) {
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

    // 看notebook上面的解法，也是这个比较好的一种解法
    public String replaceSpace2(StringBuffer str) {
        if(str == null || str.length() == 0) {
            return null;
        }
        // 定义指向str当前末尾的指针p
        int p = str.length() - 1;
        // 遍历字符串得到包含的空格数
        for(int i = 0; i <= p; i++) {
            if(str.charAt(i) == ' ') { // 如果找到空格，就在str末尾追加2个空格
                str.append("  "); // 因为原来有一个空格%20占三个空格
            }
        }
        int q = str.length() - 1; // 定义指向已经追加的字符串末尾的指针
        while (p >= 0 && p < q) {
            char c = str.charAt(p--);
            if (c == ' ') { // 倒序遍历，如果找到空格，将q所在的位置一依次变为02%
                str.setCharAt(q--, '0');
                str.setCharAt(q--, '2');
                str.setCharAt(q--, '%');
            } else {
                str.setCharAt(q--, c);
            }
        }
        return str.toString();
    }
}
