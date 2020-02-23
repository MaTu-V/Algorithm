package hannoiTower;

public class HanoiTower {
    public static void main(String[] args) {
        towerMove(4,'a','b','c');
    }

    /**
     * 汉诺塔移动
     * @param num 塔数量
     * @param a
     * @param b
     * @param c
     */
    public static void towerMove(int num,char a,char b,char c){
        if (num == 1){
            System.out.println("第" + num +"从"+ a +"移动到：" + c);
        }else {
            // 看作两层 （ 0 ~ num-1） 层  num 层


            // 从 a -> b 将 num -1 从 a 移动到 b 上
            towerMove(num -1 ,a,c,b);
            // 最终是将  num 层 移动到 c
            System.out.println("第" + num +"从"+ a +"移动到：" + c);
            // 从 b -> c（ b 上此时一共 num - 1 个塔 ）
            towerMove(num -1 ,b,a,c);
        }
    }
}
