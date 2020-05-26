package flaty.swordToOffer._05替换空格;

/**
 * @author flaty
 * @date 2020-5-26
 */
public class Solution {

    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append("%20");
            }else {
                sb.append(aChar);
            }

        }
        return sb.toString();
    }
}

