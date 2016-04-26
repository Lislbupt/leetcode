package com.lisl.code;

/**
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists
 *  one unique longest palindromic substring.
 */
public class LongestPalindromicSubstring {
	public static boolean isPalindromic(String s,int begin,int end){
		while(begin<end){
			if(s.charAt(begin)!=s.charAt(end)){
				return false;
			}
			begin++;
			end--;
		}
		return true;
	}
	//�����㷨��ʱ�临�Ӷ�O(n3),�ռ临�Ӷ�O(1)
	public static String longestPalindrome1(String s) {
		for(int i=s.length();i>0;i--){
			for(int j=0;j<=s.length()-i;j++){
				if(isPalindromic(s, j, j+i-1)){
					return s.substring(j,j+i);
				}
			}
		}
        return null;
    }
	
	public static String expandFromCenter(String s,int left,int right){
		while(left>=0 && right<s.length()){
			if(s.charAt(left)==s.charAt(right)){
				left--;
				right++;
			}else{
				break;
			}
		}
		return s.substring(left+1,right);
	}
	//������չ����ʱ�临�Ӷ�O(n2),�ռ临�Ӷ�O(1)
	public static String longestPalindrome2(String s) {
		String res = "";
		for(int i=0;i<s.length();i++){
			String s1 = expandFromCenter(s, i, i);	//�������
			if(s1.length()>res.length()){
				res = s1;
			}
			String s2 = expandFromCenter(s, i, i+1);	//ż�����
			if(s2.length()>res.length()){
				res = s2;
			}
		}
        return res;
    }
	//��̬�滮����ʱ�临�Ӷ�O(n2),�ռ临�Ӷ�O(n2)
	public static String longestPalindrome3(String s) {
		int len = s.length();
		int len_sub = 1;
		int begin = 0;
		
//		flag(i��j)Ϊtrueʱ�����ַ���Si��Sj��һ�����ģ�Ϊfalseʱ�����ַ���Si��Sj����һ�����ġ�
		boolean flag[][] = new boolean[len][len];
		
//		flag(i��i)= true
		for(int i=0;i<len;i++){
			flag[i][i] = true;
		}
		
//		flag(i��i+1)=true if(flag[i] = flag[i+1])
		for(int i=0;i<len-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				flag[i][i+1] = true;
				len_sub = 2;
				begin = i;
			}
		}
		
//		flag(i��j)= flag(i+1��j-1) if(flag[i] = flag[j]).���Ƕ�̬�滮��״̬ת�Ʒ��̡�
		for(int i=3;i<=len;i++){
			for(int j=0;j<=len-i;j++){
				if(s.charAt(j)==s.charAt(j+i-1) && flag[j+1][j+i-2]){
					flag[j][j+i-1] = true;
					len_sub = i;
					begin = j;
				}
			}
		}
		
        return s.substring(begin,begin+len_sub);
    }
	
	public static void main(String[] args) {
		String s = "abvb";
//		System.out.println(longestPalindrome1(s));
//		System.out.println(longestPalindrome2(s));
		System.out.println(longestPalindrome3(s));
	}
}
