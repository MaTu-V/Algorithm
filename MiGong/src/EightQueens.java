/**
 * 八皇后问题
 */
public class EightQueens {
    int max = 8; // 皇后数量
    int[] arr = new int[max]; // 皇后存放结果
    int res = 0; // 记录结果数

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println(eightQueens.res);
    }

    /**
     * 皇后放入
     *
     * @param n
     */
    public void check(int n) {
        if (n == max) {  // 皇后已经全部放置完成
            res++;
            print(); // 打印此时皇后位置
            return;
        }
        // 皇后结果
        for (int i = 0; i < max; i++) {
            // 先放入当前皇后 并且检测皇后位置
            arr[n] = i;  // 放到该行的 第 i 列
            // 检测是否冲突
            if (judge(n)) { // 不冲突
                check(n + 1); // 放下一个皇后
            } else {
                // 如果冲突 就继续执行当前for
                continue;
            }
        }
    }

    /**
     * 皇后位置检测
     *
     * @param n
     * @return
     */
    public boolean judge(int n) {
        // 检测所有皇后位置
        boolean flag= true;
        for (int i = 0; i < n; i++) {
            // arr[i] 代表每个皇后列 位置
            // arr[n] 代表当前皇后所在列 位置
            // arr[n] == arr[i] 判断是否在同一列
            // 是否处在同一斜线位置条件
            // 列 - 列  =  行 - 行  ： true 则在同一斜线 false： 不在同一个斜线
            if (arr[i] == arr[n] || (Math.abs(n - i) == Math.abs(arr[n] - arr[i]))) { //是否在同一列
                flag = false;
                break;
            }
        }
        return flag;
    }


    /**
     * 皇后位置输出
     */
    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
