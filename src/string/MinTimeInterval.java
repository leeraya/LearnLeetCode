package string;

import java.util.*;

/**
 * 
 * 给定一个 24 小时制（小时:分钟）的时间列表，找出列表中任意两个时间的最小时间差并已分钟数表示。
 *
 */
/*
 * 基本的思路就是将列表中的所有时间都转换成分钟。
 */
public class MinTimeInterval {
	 public int findMinDifference(List<String> timePoints){
		 int [] time = new int[1440];
		 int i = 0,min = -1, j, k;
		 int first = -1,last = -1;
		 //第一步，先将所有的时间都转成分钟
		 for(String s : timePoints){
			 k = (s.charAt(0) - '0') * 600 + (s.charAt(1) - '0') * 60 + (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
			 time[k]++;
			 if(time[k] > 1) return 0;	//如果有相同的时间，那么最小的时间间隔就是0。
			 i++;
		 }
		 if(min < 0){
			 //掐头去尾
			 for(first = 0;time[first] == 0;first++);
			 for(last = 1439;time[last] == 0;last--);
			 //获得首尾元素的差值
			 min = last - first;
			 if(min>720)min=1440-min;
			 i = first;
			 for(j = i + 1;j <= last;j++){
				if(time[j] > 0){
					if(j - i < min) min = j -i;
					i = j;
				}
			 }
		 }
		 return min;
	 }
	 //参考
	 //------------------------------------------//
	 public int findMinDifference2(List<String> timePoints) {
	        int [] a=new int [1440];
	        int first=-1,last=-1;
	        int min=-1;
	        int i=0,j,k;
	        for(String s:timePoints){
	            k=(s.charAt(0)-'0')*600+(s.charAt(1)-'0')*60+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
	            a[k]++;
	            if(a[k]>1)return 0;
	            i++;
	        }
	        if(min<0){
	            for(first=0;a[first]==0;first++);
	            for(last=1439;a[last]==0;last--);
	            min=last-first;
	            if(min>720)min=1440-min;
	            i=first;
	            for(j=i+1;j<=last;j++)if(a[j]>0){
	                if(j-i<min)min=j-i;
	                i=j;
	            }
	        }
	        return min;
	    }
}
