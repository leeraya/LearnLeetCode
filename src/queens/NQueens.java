package queens;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leeray
 * @version 创建时间：2019年4月2日 下午4:13:00 <br>
 *          描述：51. N皇后<br>
 */
public class NQueens {
	List<List<String>> list = new ArrayList<List<String>>();

	public List<List<String>> solveNQueens(int n) {
		Queen(0, n);
		return list;
	}

	void write(int[] arr, int n) {
		List<String> temp = new ArrayList<String>();
		for (int y = 0; y < n; y++) {
			if (y % n == 0)
				list.add(temp);
			String str = "";
			for (int x = 0; x < n; x++) {
				if (x != arr[y])
					str += ".";
				else
					str += "Q";
			}
			temp.add(str);
		}
	}

	static int A[] = new int[1000];
	static int B[] = new int[1000];
	static int C[] = new int[1000];
	static int Y[] = new int[334];

	void Queen(int y, int n) {
		if (y == n) {
			write(Y, n);
			return;
		}
		for (int x = 0; x < n; x++) {
			if (A[x + n - 1] == 0 && B[x + y + n - 1] == 0 && C[x - y + n - 1] == 0) {
				Y[y] = x;// 占据(x,y)的位置
				A[x + n - 1] = 1;
				B[x + y + n - 1] = 1;
				C[x - y + n - 1] = 1;
				Queen(y + 1, n);
				A[x + n - 1] = 0;
				B[x + y + n - 1] = 0;
				C[x - y + n - 1] = 0;
			}
		}
	}
}
