public class DecodeString{
    public static void main(String[] args) {
        
    }
}
/**
 * 执行用时 : 6 ms, 在所有 java 提交中击败了6.34%的用户
 * 内存消耗 :34.7 MB, 在所有 java 提交中击败了80.79%的用户
 */
class Solution1 {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for(char c:chars){
            //如果字符为]出栈
            if(c==']'){
                //保存出栈字符
                List<Character> characters = new LinkedList<>();
                while (true){
                    char c1 = stack.pop();
                    if(c1=='['){
                        Collections.reverse(characters);
                        //获取乘数
                        int multi = 0;
                        for(int i=0;!stack.isEmpty()&&Character.isDigit(stack.getFirst());i++){
                            multi+=Math.pow(10,i)*(stack.pop()-'0');
                        }
                        //解码
                        for(int i=0;i<multi;i++){
                            for (char c2: characters) {
                               stack.push(c2);
                            }
                        }
                        break;
                    }
                    characters.add(c1);
                }
                continue;
            }
            stack.push(c);
        }
        char[] decodeChar = new char[stack.size()];
        for(int i=0;i<stack.size();i++){
            decodeChar[i]=(char)((List)stack).get(stack.size()-i-1);
        }
        String res = new String(decodeChar);
        return res;
    }
}
