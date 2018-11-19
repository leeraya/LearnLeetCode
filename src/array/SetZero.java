package array;

/**
 * @author leeray
 * @version 创建时间：2018年11月19日 下午5:05:23 <br>
 *          描述：73. 矩阵置零<br>
 *          给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class SetZero {
	public void setZeroes(int[][] f) {
		if(f.length == 0 || f[0].length == 0)
            return;
            
        boolean isR0 = false;
        boolean isC0 = false;
        //第一列
        for(int i = 0; i < f.length; i++){
            if(f[i][0] == 0){//第一列如果有0
                isC0 = true;
            }
        }
        //第一行
        for(int i = 0; i < f[0].length; i++){
            if(f[0][i] == 0){//第一行如果有0
                isR0 = true;
            }
        }
        //遍历
        for(int i = 0; i < f.length; i++){
            for(int j = 0; j < f[0].length;j++){
                if(f[i][j] == 0){
                    f[i][0] = 0;//第一列记录
                    f[0][j] = 0;//第一行记录
                }
            }
        }
        //根据第一列填充行
        for(int i = 1; i < f.length; i++){
            if(f[i][0] == 0){//第一列
                for(int j = 0; j < f[0].length; j++){
                    f[i][j] = 0;
                }
            }
        }
        //根据第一行填充列
        for(int i = 1; i < f[0].length; i++){
            if(f[0][i] == 0){
                for(int j = 0; j < f.length; j++){
                    f[j][i] = 0;
                }
            }
        }
        if(isR0){//第一行也为0
            for(int i = 0; i < f[0].length; i++){
                f[0][i] = 0;
            }
        }
        
        if(isC0){//第一列也为0
            for(int i = 0; i < f.length; i++){
                f[i][0] = 0;
            }
        }
	}
}
