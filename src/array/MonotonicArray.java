package array;

/**
 * @author leeray
 * @version 创建时间：2018年12月17日 下午7:54:43 <br>
 * 			描述：<br>
 */
public class MonotonicArray {
	public boolean isMonotonic(int[] A) {
		if (A == null || A.length == 0)
			return false;
		if (A.length == 1)
			return true;
		int len = A.length;
		int count = 1;
		for (int i = 1; i < len; i++) {
			if (A[i] >= A[i - 1])
				count++;
		}
		if (count == len) {
			return true;
		} else {
			count = 1;
			for (int i = 1; i < len; i++) {
				if (A[i] <= A[i - 1]) {
					count++;
				}
			}
			if (count == len) {
				return true;
			}
		}
		return false;
	}
	
	//---------------------------------//
	public boolean isMonotonic_2(int[] A) {
        if(A == null || A.length == 0) return false;
        if(A.length == 1) return true;
        int len = A.length;
        int bgr = 0,smr = 0,equl = 0;
        for(int i = 1; i < len; i++){
            if(A[i] > A[i-1]){
                bgr++;
            }else if(A[i] < A[i-1]){
                smr++;
            }else{
                equl++;
            }
        }
        if(bgr == len-1||smr == len-1||bgr + equl == len-1 || smr + equl == len-1){
            return true;
        }
        return false;
    }
}
