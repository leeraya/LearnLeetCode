package string;

/**
 * 给定一个字符串来代表一个学生的出勤纪录，这个纪录仅包含以下三个字符：
 * 
 * 'A' : Absent，缺勤 'L' : Late，迟到 'P' : Present，到场
 * 如果一个学生的出勤纪录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 
 * 你需要根据这个学生的出勤纪录判断他是否会被奖赏。
 */
public class StudentReward {
	//低端算法
	public boolean checkRecord(String s) {
		if(checkA(s) == true && checkL(s) == false){
			return true;
		}
		return false;
	}
	private boolean checkA(String s){
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 'A'){
				count++;
			}
			if(count >= 2){
				return false;
			}
		}
		return true;
	}
	private boolean checkL(String s){
		for(int j = 0;j < s.length() - 2;j++){
			if(s.charAt(j)=='L'&&s.charAt(j + 1)=='L'&&s.charAt(j + 2)=='L'){
				return true;
			}
		}
		return false;
	}
	
	//奇淫巧计
	public boolean checkRecord2(String s) {
        if(s==null){
            return true;
        }
        if(s.indexOf("LLL")>=0){
            return false;
        }
        int from=s.indexOf("A");
        if(from<0){
            return true;
        }
        return s.indexOf("A",from+1)<0;	//就是说除第一个A外，没有其他A的index，那么A就只有一次，是满足的
    }
}
