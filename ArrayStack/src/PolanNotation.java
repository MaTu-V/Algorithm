import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 */
public class PolanNotation {
    public static void main(String[] args) {
//        String express = "30  4 + 5 * 6 -";
        String express = "4 5 * 8 - 60 + 8 2 / +";
        // 思路
        // 1. 先将 "3 4 + 5 * 6 -" 放到arraylist中
        // 2. 有ArrayList 传递一个方法，遍历ArrayList 配合栈 完成计算
        List<String> rExpress = getListString(express);
        System.out.println(cal(rExpress));
    }

    /**
     * 字符串处理
     * @param express
     * @return
     */
    public  static List<String> getListString(String express){
        String[] split = express.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele: split){
            list.add(ele);
        }
        return list;
    }

    /**
     * 字符串扫描
     */
    public static int cal(List<String> list){
        // 创建一个栈
        Stack<String> stack = new Stack<>();
        for (String item:list){
            // 使用正则表达式取出值 匹配多位数
            if (item.matches("\\d+")){
                // 入栈
                stack.push(item);
            }else {
                // 运算符
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 + num2;
                }else if (item.equals("-")){
                    res = num2 - num1;
                }else if (item.equals("*")){
                    res = num2 * num1;
                }else if (item.equals("/")){
                    res = num2 / num1;
                }else {
                    throw new RuntimeException("表达式有误!");
                }
                // res 入栈
                stack.push(res+"");
            }
        }
        // 最后输出stack的运算结果
        return Integer.parseInt(stack.pop());
    }
}
