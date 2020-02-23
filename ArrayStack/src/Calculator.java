public class Calculator {
    public static void main(String[] args) {
        // 计算表达式
        String express = "300000+2*6-2";
        // 创建两个栈 数栈 运算符栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int idx = 0;// 当前表达式遍历位置
        int num1 = 0, num2 = 0, res = 0, oper = 0;// 取出的计算量和结果以及操作符
        char ch = ' '; // 扫描的操作符
        String keepNum = ""; // 拼接字符串
        while (true){
            ch = express.substring(idx,idx+1).charAt(0); // 挨个取出字符
            if (operStack.isOper(ch)){// 判断是不是操作符
                // 判断当前栈是否为空
                if (!operStack.isEmpty()){
                    // 检测是否小于等于当前栈顶符号
                    // 若是 则从栈中取出
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        // 开始计算
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        // 若大于正常入栈
                        operStack.push(ch);
                    }
                }else {

                    operStack.push(ch);
                }
            }else {
                // 入 数栈 转 ASCI 码
                //numStack.push(ch-48); 单位数
                //多位数
                keepNum += ch;
                // 判断ch是否是最后一位
                if (idx==express.length()-1){
                    // 存入
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = ""; // 清空
                }else {
                    // 判断下一个字符是不是操作符
                    if (operStack.isOper(express.substring(idx+1,idx+2).charAt(0))){
                        // 如果是操作符
                        numStack.push(Integer.parseInt(keepNum));
                        // 必须清空 全局量
                        keepNum = "";
                    }
                }
            }
            idx++; // 截取后移
            // 表达式扫描结束
            if (idx >=express.length()){
                break;
            }
        }

        // 当表达式结束后 最终数栈两个 符号栈一个
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }


        System.out.println(express + " = " + numStack.pop());
    }
}
