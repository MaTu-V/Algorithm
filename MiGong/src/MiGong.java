/**
 * 迷宫问题
 * 1	1	1	1	1	1	1
 * 1	0	0	0	0	0	1
 * 1	0	0	0	0	0	1
 * 1	1	1	0	0	0	1
 * 1	0	0	0	0	0	1
 * 1	0	0	0	0	0	1
 * 1	0	0	0	0	0	1
 * 1	1	1	1	1	1	1
 */
public class MiGong {
    public static void main(String[] args) {
       int[][] map = initMap();
       setWay(map,1,1);
       printMap(map);
       // 成功
//        1	1	1	1	1	1	1
//        1	2	0	0	0	0	1
//        1	2	2	2	0	0	1
//        1	1	1	2	0	0	1
//        1	0	0	2	0	0	1
//        1	0	0	2	0	0	1
//        1	0	0	2	2	2	1
//        1	1	1	1	1	1	1
    }

    /**
     * 地图初始化
     * @return
     */
    public static int[][] initMap(){
        // 先创建二维数组
        int[][] map = new int[8][7];
        // 使用 1 标识墙位置
        // 上下置为一
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右置为一
        for (int i=0;i<8;i++){
            map[i][0] =1;
            map[i][6] =1;
        }
        // 补充额外的墙
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }

    /**
     * 地图打印
     * @param map
     */
    public static void printMap(int[][] map){
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.printf("%d\t",map[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 迷宫问题（下->右 -> 上 -> 左）
     * @param map 地图
     * @param i 起始行标
     * @param j 起始列标
     * @return
     */
    public static boolean setWay(int[][] map ,int i, int j){
        // 终了条件
        if (map[6][5] ==2){
            return true;
        }else {
            // 判断当前点是否走过
            if (map[i][j] == 0){
                map[i][j] = 2; // 标识该点走过
                if (setWay(map,i+1,j)){ // 判断是否可以下移
                    return true;
                }else if (setWay(map,i,j+1)){ // 判断是否可以右移
                    return true;
                }else if (setWay(map,i-1,j)){ // 判断是否可以上移
                    return true;
                }else if (setWay(map,i,j-1)){ // 判断是否可以左移
                    return true;
                }else {
                    // 说明位于此节点时刻 下右上左 均不可走通
                    map[i][j] =3; // 标识失败
                    return false;
                }
            }else {
                // 不为0 说明遇到墙
                return false; // 返回下走失败
            }
        }
    }
}
