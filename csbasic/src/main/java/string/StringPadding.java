package string;

public class StringPadding {


    /**
     * get left padding String with specification char for existed suffix
     * for example,if need left padding zero for some String,
     * like left padding 0 to 12,and need total length 10,
     * then the result will be 0000000012.
     *
     * @param suffix
     * 			the suffix for return String
     * @param fill
     * 			the fill char for String
     * @param totalLength
     * 			the total length need for composite String
     * @return
     */
    public static String getLeftPadding(String suffix,char fill,int totalLength){

        return getFillString("",suffix,fill,totalLength);
    }

    /**
     * get right padding String with specification char for existed prefix
     * for example,if need left padding zero for some String,
     * like right padding 0 to A,and need total length 10,
     * then the result will be A000000000.
     *
     * @param prefix
     * 			the prefix for return String
     * @param fill
     * 			the fill char for String
     * @param totalLength
     * 			the total length need for composite String
     * @return
     */
    public static String getRightPadding(String prefix,char fill,int totalLength){

        return getFillString(prefix,"",fill,totalLength);
    }

    /**
     * get char fill composite String for existed prefix or suffix
     * for example,if need left padding zero for some String,
     * like padding 0 to 12,and need total length 10,
     * then the result will be 0000000012. what's more,
     * if add a prefix for this composite String,like A,
     * then then return String will be A000000012.
     *
     * @param prefix
     * 			the prefix for return String
     * @param suffix
     * 			the suffix for return String
     * @param fill
     * 			the fill char for String
     * @param totalLength
     * 			the total length need for composite String
     * @return
     */
    public static String getFillString(String prefix,String suffix,char fill,int totalLength){
        int c = 0;
        int needLength = totalLength - (prefix.length()+suffix.length());

        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        while(c < needLength){
            sb.append(fill);
            c++;
        }
        sb.append(suffix);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getFillString("A","1",'0',10));
        System.out.println(getLeftPadding("1",'0',10));
        System.out.println(getRightPadding("A",'0',10));
    }


}
