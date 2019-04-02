package queens;

/**
 * @author leeray
 * @version 创建时间：2019年4月2日 下午4:14:00 <br>
 *          描述：52. N皇后 II<br>
 *          给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class NQueensTwo {
	public static void main(String[] args) {
		System.out.println(totalNQueens(15));
	}

	public static int totalNQueens(int n) {
		Queen(0, n);
		return count;
	}

	static int count = 0;
	static int A[] = new int[1000];
	static int B[] = new int[1000];
	static int C[] = new int[1000];
	static int Y[] = new int[334];

	static void Queen(int y, int n) {
		// 到底了
		if (y == n) {
			counter(Y, n);
			return;
		}
		for (int x = 0; x < n; x++) {
			if (A[x + n - 1] == 0 && B[x + y + n - 1] == 0 && C[x - y + n - 1] == 0) {
				Y[y] = x;// 占据(x,y)位置
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

	static void counter(int arr[], int n) {
		for (int y = 0; y < n; y++) {
			if (y % n == 0)
				count++;
		}
	}
}
