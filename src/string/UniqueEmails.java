package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leeray
 * @version 创建时间：2019年1月7日 下午5:09:30 <br>
 *          描述：929. 独特的电子邮件地址<br>
 *          每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 * 
 *          例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * 
 *          除了小写字母，这些电子邮件还可能包含 ',' 或 '+'。
 * 
 *          如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com”
 *          和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 * 
 *          如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com
 *          将转发到 my@email.com。 （同样，此规则不适用于域名。）
 * 
 *          可以同时使用这两个规则。
 * 
 *          给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 */
public class UniqueEmails {
	public int numUniqueEmails(String[] emails) {
		//先要对字符串数组中的每一个字符串进行处理
		//具体处理过程
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < emails.length; i++){
			for(int j = 0; j < emails[i].length(); j++){
				if(emails[i].charAt(j) == '.'){
					continue;
				}else if(emails[i].charAt(j) == '+'){
					sb.append("@");
					sb.append(emails[i].split("@")[1]);
					break;
				}else{
					sb.append(emails[i].charAt(j));
				}
			}
			emails[i] = sb.toString();
			sb = new StringBuilder();
		}
		//set可以排除重复元素
		Set<String> set = new HashSet<String>();
		for(String str : emails){
//			System.out.println(str);
			set.add(str);
		}
		
		return set.size();
		
	}
}
