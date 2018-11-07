package string;

/**
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和
 * D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 */
public class RobotMoving {
	public boolean judgeCircle(String moves) {
		int x = 0,y = 0;
		for(char c : moves.toCharArray()){
			if(c == 'U') y++;
			if(c == 'D') y--;
			if(c == 'L') x++;
			if(c == 'R') x--;
		}
		if(x == 0 && y == 0){
			return true;
		}
		return false;
	}
}
