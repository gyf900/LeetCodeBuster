/*
 * jd_cal---找个数
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

package leetcode_pro;
import java.util.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
//    	int num=sc.nextInt();
//    	int[] input_arr= new int[num];
//    	for(int i=0;i<num;i++)
//    	input_arr[i]=sc.nextInt();
//    	String[] out=sinaGetName(input,"sc");
//    	for(int i=0;i<out.length;i++)
    	int[] arr= {1,2,3,4,5,6};
    	int tar=8;
    	System.out.println(combinationSum2(arr,tar));
    	sc.close();
	}
    
    
    
    public static int GetCombineDigit(int lim,int tar)//get _Asd_asda.ajdk_ into  formmed way
    {
    	int new_tar1=0,new_tar2=0;
    	return GetCombineDigit(lim,new_tar1)+GetCombineDigit(lim,new_tar1);
    }
    
    public static String GetChangeForm(String str)//get _Asd_asda.ajdk_ into  formmed way
    {
    	//str=str.toUpperCase();
    	str=str.replace('.', '_');
    	for(int i=2;i<str.length();i++)
    	{
    		if((Character.isLowerCase(str.charAt(i)))&&Character.isUpperCase(str.charAt(i-1)))
    		{
    			if(str.charAt(i-2)!='_')
    				str = new StringBuilder(str).insert(i-1, "_").toString();
    		}
    	}
    	for(int i=1;i<str.length();i++) {
    		if(Character.isDigit(str.charAt(i))&&Character.isUpperCase(str.charAt(i-1)))
    		{
    			if(str.charAt(i-1)!='_')
    				str = new StringBuilder(str).insert(i, "_").toString();
    		}
    	}
    	for(int i=1;i<str.length();i++) {
    		if(Character.isDigit(str.charAt(i))&&Character.isLowerCase(str.charAt(i-1)))
    		{
    			if(str.charAt(i-1)!='_')
    				str = new StringBuilder(str).insert(i, "_").toString();
    		}
    	}
    	str="_"+str+"_";
    	str=str.toUpperCase();
    	return str;
    }
    
    

    
    
    public static String[] sinaGetName(String name[], String key) {//name means list of names, key means user input
    	String a="";
    	for(String na:name)
    		if(na.contains(key))
    			a=a+na+" ";
    	String[] matchName=a.split(" ");
    return matchName;
    }
    
public static Set<Integer> sina_getSingleInt(int[] numbers) {//jd pow problem
	HashSet<Integer> set=new HashSet<Integer> ();
	 for(int num:numbers)
	 {
		 set.add(num);
	 }
	return set;
}
    
public static int jd_cal(int num) {//jd pow problem 
   int genral=2*num*num-num;
   int sum_add=0;
   if(num==1)return 1;
   if(num==2)return 6;
   if(num==3)return 15;
   for(int base=2; base<=(int)Math.sqrt(num);base++)
   {
	   for(int index=2; ;index++)
	   {
		   if(Math.pow(base,index)>num)
		   {
			   break;
		   }else {
			   sum_add+=2*num/index*(1+not_div(index));
		   }
	   }
	   
   }
    return (genral+sum_add)%1000001;
}
public static int not_div(int num) { 	
	int s=0;
	for(int i=2;i<num;i++)
	{
		if(num%i!=0)
		{
			s++;
		}
	}
	return s;
}

public static int DD_space(int[] num) { 	
	int len=num.length;
	int sumSpace=0;
	int count=1;
	if(num[0]==0)
	{
		sumSpace++;
	}
	for(int i=1; i<len;i++)
	{
		if(num[i]==0)
		{
			sumSpace++;
			sumSpace+=count/2;
			count=1;
		}
		else if((num[i-1]==num[i]))
		{
			count++;
		}else if((num[i-1]!=num[i]))
		{
			sumSpace+=count/2;
			count=1;
		}
		if(i==len-1)
			sumSpace+=count/2;
	}
	return sumSpace;
}

public int sumOfLeftLeaves(TreeNode root) {//Find the sum of all left leaves in a given binary tree.
	int sum=0;
	if(root==null) return 0;
	sumOfLeftLeavesNode(root);
	return 0;
	
}
public TreeNode sumOfLeftLeavesNode(TreeNode root) {//Find the sum of all left leaves in a given binary tree
	
	
	return (root.left != null && root.right != null)? root : root.left == null ? root.right : root.left;
}


public String convertToBase7(int num) {// Given an integer, return its base 7 string representation.
    String base="";
    boolean flag=false;
    if(num==0)return "0";
    if(num<0)
    {
    	flag=true;
    	num=-num;
    }
    while(num!=0)
    {
    	base=(num%7)+base;
        num=num/7;
    }
    return !flag? base:"-"+base;
}
public int[] twoSum2(int[] numbers, int target) {
	int[] result = new int[2];
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0; i<numbers.length; i++){
        if(!map.containsKey(target-numbers[i])){
            map.put(numbers[i], i);
        }
        else{
            result[0]=map.get(target-numbers[i])+1;
            result[1]=i+1;
            break;
        }
    }
    return result;
}
public int majorityElement(int[] nums) { //find majorityElement in nums
	Arrays.sort(nums);
	return nums[nums.length/2];
}
public int maximumProduct(int[] nums) {	//Given an integer array, find three numbers whose product is maximum and output the maximum
	int len=nums.length;
	if(len<3) return 0;
	Arrays.sort(nums);
	if(nums[len-1]<0)
		return nums[len-1]*nums[len-2]*nums[len-3];
	else
		return nums[len-1]*nums[len-2]*nums[len-3]>nums[len-1]*nums[0]*nums[1]? nums[len-1]*nums[len-2]*nums[len-3]:nums[len-1]*nums[0]*nums[1];
}

public int reverse(int x)		//input 123 return 321
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}

public int[] twoSum(int[] nums, int target) {	//get the id of two sum
        int[] result = new int[2];
        if(nums.length<2) return result;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i], i);
            }
            else{
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                break;
            }
        }
        return result;
}



public boolean containsNearbyDuplicate(int[] nums, int k) {
    return true;
}
public int getMoneyAmount(int n) {
    int[][] table = new int[n+1][n+1];
    return DP(table, 1, n);
}

int DP(int[][] t, int s, int e){
    if(s >= e) return 0;
    if(t[s][e] != 0) return t[s][e];
    int res = Integer.MAX_VALUE;
    for(int x=s; x<=e; x++){
        int tmp = x + Math.max(DP(t, s, x-1), DP(t, x+1, e));
        res = Math.min(res, tmp);
    }
    t[s][e] = res;
    return res;
}
//public int guessNumber(int n) {
//	if(n==1)return 1;
//	int up=n;
//	int down=0;
//	int gs=n;
//	while(up!=down)
//	{
//		if(guess(gs)==0)return gs;
//		gs=(up-down+1)/2+down;
//		if(guess(gs)==0)return gs;
//		if(guess(gs)==1) down=gs;
//		if(guess(gs)==-1) up=gs;
//	}
//	return 0;
//}

public boolean canMeasureWater(int x, int y, int z) {
	int m=0;
	if(z==0)return true;
	if(x>y){	
		m=x;
		x=y;
		y=m;
	}
	if (x==0||y==0)
	{
		if(z!=y)return false;
		else return true;
	}
	if(z>(y+x))
		return false;
	int divisor=0;
	while(x!=y){
	if(y>x)
	y=y-x;
	else
		x=x-y;
	}
	if(z%x==0)
    return true;
	else
		return false;
}

public static int combinationSum4(int[] nums, int target) {
    Arrays.sort(nums);
    int[] res = new int[target + 1];
    for (int i = 1; i < res.length; i++) {
    for (int num : nums) {
        if (num > i)
	    break;
	else if (num == i)
	    res[i] += 1;
	else
	    res[i] += res[i-num];
    }
}
    return res[target];
}


public int firstUniqChar(String s) {
	 int len=s.length();
	 char[] ss=s.toCharArray();
	 int [] sint=new int[len];
	 int [] table=new int [26];
	 if(s.isEmpty())return -1;
	 for(int m=0;m<len;m++)
	 {
		 sint[m]=(int)ss[m]-97;
	 }
	 for(int m=0;m<len;m++)
	 {
		 table[sint[m]]++;
	 }
	 for(int m=0;m<len;m++)
	 {
		 if(table[sint[m]]==1)
		 {
			 return m;
		 }
		 
	 }
	return -1;
}

public boolean canConstruct(String ransomNote, String magazine) {
	int[] table = new int[26]; // only lowercase letters
	for (char c : magazine.toCharArray()) { // 字符计数
		table[c - 'a']++;
	}
	for (char c : ransomNote.toCharArray()) { // 递减字符计数
		table[c - 'a']--;
		if (table[c - 'a'] < 0) { // 字符短缺
			return false;
		}
	}
	return true;
}

public int superPow(int a, int[] b) {
	a=a%1337;
	int sum=1;
	int powk=1;
	if(b.length ==0)
		return 0;
	if(b.length==1)
		return powmod(a,b[b.length-1],0);
	for(int i=b.length-1; i>=0;i--)
	{
		for(int m=b[i];m>=0;m--)
		{
			powk*=a;
			powk%=1337;
		}
		sum*=powk;
		sum%=1337;
	}
	
    return 0;
    
}
public int powmod(int a,int b,int level)
{
	int pow=1;
	for(;b>0;b--)
	{
		pow*=a;
		pow%=1337;
	}
	for(;level>0;level--)
	{
		
	}
	return pow;
}



public int countNumbersWithUniqueDigits(int n) {
	int count=1,sum=0;
	int base =9;
	if(n>=10)
		return 0;
	if(n==0)
		return 1;
	if(n==1)
		return 10;
	if(n>1)
	{
		count=9;
		sum=10;
		for(;n>1;n--)
		{
			count*=base;
			base--;
			sum+=count;
		}
	}
	return sum ;
}
public int minSubArrayLen(int s, int[] nums) {
	Arrays.sort(nums);
	int sum=0;
	for(int i=nums.length-1;i>=0;i--)
	{
		sum+=nums[i];
		if(sum>=s)
		{
			return nums.length-i;
		}
	}
    return 0;
}
public int hammingWeight(int n) {//计算10进数变2进制有几个一的
	int result=0;
	while(n!=0)
	{
		if((n&1)==1)
		{
		result++;
		}
		n=n>>>1;		//逻辑右移，无符号位，两个的有符号位
	}
    return result;
}


public boolean isHappy(int n) {
	if(n==1||n==7)return true;
	else if(n<10)return false;
	int s=0;
	while(n>0)
	{
		s+=(n%10)*(n%10);
		n/=10;
	}
    return isHappy(s);
}
public int singleNumber(int[] nums) { //寻找一个数组中只出现一次的数字
	 Set<Integer> set=new HashSet<Integer> ();
	 int sum=0;
	 for(int num:nums)
	 {
		 sum^=num;
	 }
    return sum;
}
public static int countPrimes(int n) {//to count the prime number less than n
	if(n<3) return 0;
	boolean prime[]=new boolean[n];
	int result=0;
	for(int i=2;i<n;i++)
	{
		if(prime[i])
			continue;
		for(int k=2;k*i<n;k++)
			prime[k*i]=true;
		result++;
	}
		
    return result;
}
public int titleToNumber(String s) {
    int l=s.length();
    int result=0;
    int m=1;
    for(int i=l-1;i>=0;i--)
    {
    	result+=(int)(s.charAt(i)-64)*m;
    	m=m*26;
    }
    return result;
}

public int trailingZeroes(int n) {
	int k5[]=new int[13];
	int result=0;
	k5[0]=5;
	result=n/k5[0];
	for(int i=1;i<13;i++)
	{
		k5[i]=k5[i-1]*5;
		result+=n/k5[i];
	}
    return result;
}
//public boolean isPowerOfTwo(int n) {
//	int power[]=new int[31];
//	power[0]=1;
//	if(n==1)
//		return true;
//	for(int i=1;i<31;i++)
//	{
//		power[i]=power[i-1]*2;
//		if(power[i]==n)
//			return true;
//	}	
//    return false;
//}
public static boolean isPowerOfTwo(int n) {
	if(n%2==0)
	{
		n=n/2;
	    return isPowerOfTwo(n);
	}
	else if(n==1)
		return true;
	else
		return false;
}
   public void rotate(int[] nums, int k) {
	if(nums.length>1)
	{
	    int real=k%nums.length;
	    int left[]=new int[nums.length-real];
	    int right[]=new int[real];
	    System.arraycopy(nums, 0, left, 0, left.length);
	    System.arraycopy(nums, nums.length-real, right, 0, right.length);
	    System.arraycopy(right, 0, nums, 0, right.length);
	    System.arraycopy(left, 0, nums, right.length, left.length);
	}   
}


public int[] intersect(int[] nums1, int[] nums2) {// from here
	Arrays.sort(nums1);
	Arrays.sort(nums2);
	int section[]=new int [nums1.length];
	int index1=0,index2=0,i=0;
	for(index1=0,index2=0;(index1<nums1.length)&& (index2<nums2.length);){
		if(nums1[index1]==nums2[index2]){
			section[i++]=nums1[index1];
			index1++;
			index2++;
		}
		else if(nums1[index1]<nums2[index2]){
			index1++;
		}
		else{
			index2++;
		}
	}
	int result[]=new int[i];
	System.arraycopy(section, 0, result, 0, i);
    return result;
}

public int[] intersection(int[] nums1, int[] nums2) {
	 Set<Integer> set=new HashSet<Integer> ();
	 for(int num:nums1)
	 {
		 set.add(num);
	 }
	 int[] section=new int [nums1.length];
	 int i=0;
	 for(int num:nums2)
	 {
		 if(set.remove(num))
		 {
		 section[i++]=num;
		 }
	 }
	 int result[] =new int[i];
	System.arraycopy(section, 0, result, 0, i);
    return result; 	
}
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if(root==null)
		return null;
	if(root==p||root==q)
		return root;
	TreeNode left=lowestCommonAncestor(root.left,p,q);
	TreeNode right=lowestCommonAncestor(root.right,p,q);
	
	return (left != null && right != null)? root : left == null ? right : left;
    
}
public int[] productExceptSelf(int[] nums) {//product of sevaral numbers (still unknown)
    int[] res = new int[nums.length];

    res[0] = 1;
    for(int i=1; i < nums.length; i++) {
        res[i] = res[i-1] * nums[i-1];
    }
    for(int j = nums.length - 1; j > 0; j--) {
        res[j] *= res[0];
        res[0] *= nums[j];
    }
    return res;
}
public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	int l = Math.max(B,F)>Math.min(D,H) ? 0 : Math.min(D,H)-Math.max(B, F);
    int h = Math.max(A,E)>Math.min(C,G) ? 0 : Math.min(C,G)-Math.max(A, E);
	return (C-A)*(D-B)+(G-E)*(H-F)-l*h;
}


public String reverseVowels(String s) {
    if (s == null || s.length() <= 1) {
        return s;
    } else {
        char[] chs = s.toCharArray();
        Set<Character> vowels = new HashSet<Character>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        int low = 0;
        int high = chs.length - 1;
        while (low < high) {
            while (low < high && !vowels.contains(chs[low])) {
                low++;
            }

            while (low < high && !vowels.contains(chs[high])) {
                high--;
            }

            if (low != high) {
                char temp = chs[low];
                chs[low] = chs[high];
                chs[high] = temp;
                low++;
                high--;
            } else {
                break;
            }
        }

        return new String(chs);
    }
}

public static int[] maxSlidingWindow(int[] nums, int k) {
	if(k==0) return nums;
    int[] rs=new int[nums.length-k+1];
    int maxIndex=0;
    for(int i=1;i<k;i++)
        if(nums[i]>=nums[maxIndex]) maxIndex=i;
    rs[0]=nums[maxIndex];
    for(int i=1;i<rs.length;i++){
        if(maxIndex==i-1){
            maxIndex=i;
            for(int j=i;j<i+k;j++) if(nums[j]>=nums[maxIndex]) maxIndex=j;
        }
        else if(nums[i+k-1]>=nums[maxIndex]){
            maxIndex=i+k-1;
        }
        rs[i]=nums[maxIndex];
    }
    return rs;
}
public boolean searchMatrix(int[][] matrix, int target) {//didn't solve yet
	if(matrix[0][0]>target)
		return false;
	int i=0; int j=0;
	while(matrix[i][j]<target)
	{
		i++;
		j++;
		if(matrix[i][j]==target)
			return true;
		if(i==matrix.length)
			return false;
	}
	for(int k=i-1;k<matrix.length;k++)
	{
		if(matrix[i-1][k]==target)
			return true;
	}
	for(int k=1;k<i;k++)
	{
		if(matrix[i][k]==target)
			return true;
	}
    return false;
}
public boolean isAnagram(String s, String t) {// to judge the string in order
    if(s.length()!=t.length())
    return false;
    char [] S =s.toCharArray();
    char [] T =t.toCharArray();
    Arrays.sort(S);
    Arrays.sort(T);
    String news = new String(S);
    String newt = new String(T);
    if(news.compareTo(newt)==0)
    return true;
    else
    return false;
}
public int addDigits(int num) {  //calculate the digits of every number in all 
//	if(num==0)
//		return 0;
//	if(num%9==0)
//		return 9;
//    return num%9;
	 return num!=0?(num%9!=0?num%9:9):0;
}
public static int[] singleNumber2(int[] nums) {
	int[] single=new int[2];
	Arrays.sort(nums);
	int k=0;
	if(nums.length==2)
		return nums;
	for(int i=0;i<nums.length-1 ;i+=2)
	{
		if(nums[i]!=nums[i+1])
		{
			if(k==0)
			{
				single[0]=nums[i];
				k++;
			}
			else
			{
				single[1]=nums[i];
				k++;
			}
			i-=1;
		}
	}
	if(k!=2)
		single[1]=nums[nums.length-1];
    return new int[] {single[0],single[1]};
}
public boolean isUgly(int num) {	// to judge a num if only contain a factory of 2,3,5 
	if(num==1)
		return true;
	int forwardnum=0;
	while(num!=1)
	{
		if(num%2==0)
			num=num/2;
		if(num%3==0)
			num=num/3;
		if(num%5==0)
			num=num/5;
		if(forwardnum==num)
		{
			return false;
		}
		forwardnum=num;
	}
 return true;   
}
public static int nthUglyNumber(int n) {//ugly number
	int[] uglyprimes={2,3,5};
    int[] p = new int[uglyprimes.length];
    Arrays.fill(p, 0);
    int ugly[] = new int[n];
    ugly[0] = 1;
    for(int i = 1; i < n; i++){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int j = 0; j < uglyprimes.length; j++){
            if(ugly[p[j]] * uglyprimes[j] < min){
                min = ugly[p[j]] * uglyprimes[j];
                minIndex = j;
            }else if(ugly[p[j]] * uglyprimes[j] == min){
                p[j]++;
            }
        }
        ugly[i] = min;
        p[minIndex]++;
    }
    return ugly[n - 1];
}

public int missingNumber(int[] nums) {
//	Arrays.sort(nums);
//	for(int i=0;i<nums.length;i++)
//	{
//		if(nums[i]!=i)
//			return nums[i]-1;
//	}
//    return nums.length;
	int sum = 0, i = 0;			//better way to solve missing number

    for (; i < nums.length; i++)
        sum = sum + i - nums[i];

    return (sum + i);
}
public static int hIndex(int[] citations) {        //hIndex calculation 
	int maxIndex=0;
	int len=citations.length;
	if(len==0||citations==null)
	{
		return 0;
	}
	Arrays.sort(citations);
	for(int i=1; i<len+1;i++)
	{
		if(citations[len-i]>=i)
			maxIndex=i;
		else
			return  maxIndex;
	}
    return maxIndex;
}
public String reverseString(String s) {// reverse a string 
	char temp;
	for(int i=0;i<s.length()/2;i++)
	{
		temp=(char)s.charAt(i);
		//s.charAt(s.length()-i)
	}
    return s;
}
public int integerBreak(int n) {		//break a num into seveal part to make it power max
	int numof3=0;
	int numof2=0;
	if(n<=3)
		return n-1;
	
	if(n%3==1)
	{
		numof3=n/3-1;
		numof2=2;
	}
	if(n%3==0)
	{
		numof3=n/3;
		numof2=0;
	}
	if(n%3==2)
	{
		numof3=n/3;
		numof2=1;
	}
	
    return (int)(Math.pow(3, numof3)*Math.pow(2, numof2));
}
public boolean isPowerOfFour(int num) { //to see if it's a power of 4
	int[] power=new int[16];
	power[0]=1;
	if(num==1)
		return true;
	for(int i=1;i<16;i++)
	{
		power[i]=power[i-1]*4;
		if(power[i]==num)
			return true;
	}
	
    return false;
}
public void moveZeroes(int[] nums) { //move all zeroes to right
	int j=0;
	for(int i=0;i<nums.length;i++)
	{
		
		if(nums[i]!=0)
		{
			nums[j]=nums[i];
			j++;
		}
			
	}
	for(int i=j;i<nums.length;i++)
	{
		nums[i]=0;
	}
}

public boolean canWinNim(int n) { 
    
    return (n%4==0)? true :false; 
}

public int lengthOfLIS(int[] nums) {
    if(nums==null||nums.length==0)
    	return 0;
    int len=nums.length;
    int maxlength=0;
    int [] st=new int[len];
    int top=-1;
    for(int i=0;i<len;i++)
    {
    	int a=top;
    	
    }
    return maxlength;
}

public String getHint(String secret, String guess) {
	int numA=0,numB=0;
	int[] result=new int [10];
	if(secret.length()==0){
		return "0A0B";}
	for(int i=0;i<secret.length();i++)
	{
		int x=secret.charAt(i)-48;
		int y=guess.charAt(i)-48;
		if(x==y)
		{
			numA++;
		}
		else{
			if(result[x]<0){numB++;}
			result[x]++;
			if(result[y]>0){numB++;}
			result[y]--;
		}
			
	}
	return numA+"A"+numB+"B";
}


public boolean isAdditiveNumber(String num) {
	if(num.length()<=2||num==null)
		return false;
	for(int i=0;i<(num.length()-1)/2;i++)
	{
		for(int j=i+1;num.length()-j-1>=Math.max(i+1, j-i);j++)
		{
			if(isVaild(num.substring(0, i+1),num.substring(i+1, j+1),num.substring(j+1)))
				return true;
		}
	}
	return false;
}
public boolean isVaild(String num1,String num2,String remain){
	if(remain.isEmpty())return true;
	if(num1.charAt(0)=='0'&& num1.length()>1)return false;
	if(num2.charAt(0)=='0'&& num2.length()>1)return false;
	String sum=String.valueOf(Long.parseLong(num1)+Long.parseLong(num2));
	if(!remain.startsWith(sum))return false;
	
	return isVaild(num2,sum,remain.substring(sum.length()));
}

public int maxProfit(int[] prices) {
    if(prices==null||prices.length==0) {
        return 0;
    }
    int len= prices.length;
    int[] sell= new int[len];
    int[] cooldown= new int[len];
    sell[0] = 0;
    cooldown[0] = 0;
    for(int i=1;i<len;i++)
    {
    	sell[i]=Integer.max(sell[i-1]+prices[i]-prices[i-1],cooldown[i-1]);
    	cooldown[i]=Integer.max(sell[i-1],cooldown[i-1]);
    }
    return Integer.max(sell[len-1], cooldown[len-1]);
}
    
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if(n==0)
    {
    	return new ArrayList<>();
    }
    	else if (n==1)
    	{
    		List<Integer> ret=new ArrayList<>();
    		ret.add(0);
    		return ret;
    	}
    List<Integer>[] lists = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        lists[i] = new ArrayList<>();
    }
    
    for (int i = 0; i < edges.length; i++) {
        int v1 = edges[i][0];
        int v2 = edges[i][1];
        lists[v1].add(v2);
        lists[v2].add(v1);
    }
    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (lists[i].size() == 1) {
            leaves.add(i);
        }
    }
    int count = n;
    while (count > 2) {
        int size = leaves.size();
        count -= size;
        List<Integer> newLeaves = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int leaf = leaves.get(i);
            for (int j = 0; j < lists[leaf].size(); j++) {
                int toRemove = lists[leaf].get(j);
                lists[toRemove].remove(Integer.valueOf(leaf));
                if (lists[toRemove].size() == 1)
                    newLeaves.add(toRemove);
            }
        }
        leaves = newLeaves;
    }
    return leaves;
}


public static int maxCoins(int[] nums) {  //burst ballons cal num[n-1]*num[n]*num[n+1] and sum 
	int left=0,right=0;
	int len=nums.length+2;
	int[] newnums=new int[len];
	newnums[0]=1;
	newnums[len-1]=1;
	for(int i=0;i<len-2;i++)
	{
		newnums[i+1]=nums[i];
	}
	int i=0;
	int[][] max=new int[len][len];
	for(int k=2;k<len;k++)
	for(left=0;left+k<len;left++)
		right=left+k;
		for(i=left+1;i<right;i++)
			{
				max[left][right]=Math.max(max[left][right], max[left][i]+max[i][right]+newnums[left]*newnums[i]*newnums[right]);
			}
	
    return max[0][len-1];
}

public int nthSuperUglyNumber(int n, int[] primes) {//ugly number
    int[] pointer = new int[primes.length];
    Arrays.fill(pointer, 0);
    int ugly[] = new int[n];
    ugly[0] = 1;
    for(int i = 1; i < n; i++){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int j = 0; j < primes.length; j++){
            if(ugly[pointer[j]] * primes[j] < min){
                min = ugly[pointer[j]] * primes[j];
                minIndex = j;
            }else if(ugly[pointer[j]] * primes[j] == min){
                pointer[j]++;
            }
        }
        ugly[i] = min;
        pointer[minIndex]++;
    }
    return ugly[n - 1];
}
public int maxProduct(String[] words) {	//max product of "asdf"and "qwsf"using bitset
	
	HashMap<String, BitSet> map = new HashMap<>();
	int max=0;
	for(String word: words)
	{
		BitSet bs=new BitSet();
		for(int i=0;i<word.length();i++)
		{
			bs.set(word.charAt(i)-'a');
		}
		map.put(word, bs);
	}
	
	for(int i=0;i<words.length;i++)
	{
		for(int j=i+1;j<words.length;j++)
		{		
			if(words[i].length()*words[j].length()<=max) continue;
			BitSet temp=(BitSet)map.get(words[i]).clone();
			temp.and(map.get(words[j]));
			if(temp.isEmpty())
				max=Math.max(words[i].length()*words[j].length(),max);
		}
	}
	
    System.out.println(words[0]);
    return max;
    
}

public  static int change(int amount, int[] coins) {// how many ways to get answer for coin
    int[][] dp = new int[coins.length+1][amount+1];
    dp[0][0] = 1;
    
    for (int i = 1; i <= coins.length; i++) {
        dp[i][0] = 1;
        for (int j = 1; j <= amount; j++) {
            dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
        }
    }
    return dp[coins.length][amount];
}

public static int combinationSum2(int[] candidates, int target) {//combine a list of Integer to sum, no duplicate, return each way. 
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> comb = new ArrayList<>();
	Arrays.sort(candidates); // need sort to make this work.
	combination(candidates, target, 0, comb, ans);
	return ans.size();
}

private static void combination(int[] candi, int target, int start,
		List<Integer> comb, List<List<Integer>> ans) {
	for (int i = start; i < candi.length; i++) {
		if (i > start && candi[i] == candi[i - 1]) //remove duplicates.
			continue;
		if (candi[i] == target) {
			//recursion exit.
			List<Integer> newComb = new ArrayList<>(comb);
			newComb.add(candi[i]);
			ans.add(newComb);
		} else if (candi[i] < target) {
			//continue to look for the rest.
			List<Integer> newComb = new ArrayList<>(comb);
			newComb.add(candi[i]);
			combination(candi, target - candi[i], i + 1, newComb, ans);
		} else 
			break; //invalid path, return nothing.
	}
}

    public static int coinChange(int[] coins, int amount) {
        if (coins==null || coins.length==0 || amount<0) {
            return 0;
        }
        int[] dp = new int[amount+1];  // dp[0] = 0
        for (int i=1; i<=amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (coin<=i && dp[i-coin]!=-1) {// current coin is not too large and there is a solution for i-coin
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {  // amount == i has no solution
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
    
 public void wiggleSort(int[] nums) {
	 
        
    }
public int minPatches(int[] nums, int n) {// add some patch to array ,make the sum of array cover( 1-n)
	long covered=0;
	int patch=0,i=0;
		for(covered=0;covered<n;)
		{			
			if(i<nums.length && nums[i]>covered+1||i>=nums.length)
			{
				covered=2*covered+1;
				++patch;
			}
			else
			{
				covered+=nums[i++];
			}
			
		}
        return patch;
    }
    
    public static boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int degree = -1;         // root has no indegree, for compensate init with -1
        for (String str: strs) {
            degree++;             // all nodes have 1 indegree (root compensated)
            if (degree > 0) {     // total degree should never exceeds 0
                return false;
            }      
            if (!str.equals("#")) {// only non-leaf node has 2 outdegree
                degree -= 2;
            }  
        }
        return degree == 0;
    }
    
//public static boolean isValidSerialization(String preorder) { //binary tree --runtime error
//        if(!preorder.endsWith("#"))
//        	return false;
//        int lastlength=0;
//        while(preorder.length()!=1)
//        {
//        	if(preorder.startsWith("#"))
//        		return false;
//        	
//        	String[] splitString = new String [preorder.split(",#,#").length] ;
//	        splitString=preorder.split(",#,#");
//	        
//	        preorder=new String();
//	        
//	        //System.out.println(splitString[]);
//	        for(int i=0;i<splitString.length;i++)
//	        {
//	        	splitString[i]=splitString[i].substring(0,splitString[i].length()-1 )+"#";
//	        	preorder+=splitString[i];
//	        }
//	        System.out.println(preorder);
//	        if(preorder.compareTo("#")==0)
//	        {
//	        	//System.out.println(preorder);
//	        	return true;
//	        }
//	        
//	        if(lastlength==preorder.length())
//	        	break;
//	        
//	        lastlength=preorder.length();
//	        
//	       // System.out.println(preorder);
//	       
//        }
//        
//        return false;
//    }
    
    private int length;
    private HashMap<String, ArrayList<String>> ticketMap = new HashMap<String, ArrayList<String>>();

public List<String> findItinerary(String[][] tickets) {// ticket problem with hashmap
	
	
	length=tickets.length+1;
	
	for(String[] trip : tickets)
	{
		if (ticketMap.containsKey(trip[0]))
        {
            ticketMap.get(trip[0]).add(trip[1]);
        }
        else
        {
            ArrayList<String> arr = new ArrayList<String>();
            arr.add(trip[1]);
            ticketMap.put(trip[0], arr);
        }
		
	}
	 for (ArrayList<String> value : ticketMap.values()) {
	        Collections.sort(value);
	    }

	    ArrayList<String> itinerary = new ArrayList<String>();
	    itinerary.add("JFK");

	    search("JFK", itinerary);

	    return itinerary;
        
    }
public boolean search(String start, ArrayList<String> itinerary)
{
    if (itinerary.size() == length)
        return true;
    ArrayList<String> arr = ticketMap.get(start);
    if (arr != null)
    {//it's OK to continue
        for (int i = 0; i < arr.size(); ++i)
        {
            String end = arr.get(i);
            itinerary.add(end);
            arr.remove(i);
            if (search(end, itinerary) == false)
            {
                //undo the move
                itinerary.remove(itinerary.size() - 1);
                arr.add(i, end);
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    else
    {
        return false;
    }
}


public boolean increasingTriplet(int[] nums) { //triplet problem incress three pair
	
	int min2num=2147483647;
	int minnum=2147483647;
	for(int i=0;i<nums.length-1;i++)
	{
		minnum=Math.min(minnum, nums[i]);
		if((nums[i]>min2num)||(nums[i+1]>min2num))
			return true;
		if(nums[i]<nums[i+1])
		{
			min2num=Math.min(min2num, nums[i+1]);
			if(nums[i]>minnum)
				return true;
		}	
	}
	return false;
        
    }

    
public int rob(TreeNode root) {	//calculate treenode by recursion 
	int summax=0; 
	int summax2=0;
	if(root==null)
		return 0;
	if(root.left==null&&root.right==null)
		return root.val;
	summax=root.val;
	if(root.left!=null)
	{
		summax+=rob(root.left.left);
		summax+=rob(root.left.right);
	}
	if(root.right!=null)
	{
		summax+=rob(root.right.left);
		summax+=rob(root.right.right);
	}
	
	summax2=rob(root.left)+rob(root.right);
	
	if(summax > summax2)
	return summax;
	else return summax2; 
        
    }
public int[] countBits(int num) {  //countbit of i in binary number
	int[] list=new int[num+1];
	int i=0;
	list[0]=0;
	for(i=1;i<list.length;i++)
	{
		
		list[i]=list[i/2];
		if(i%2==1) list[i]++;
	}
	return list;     
    }
 public int bulbSwitch(int n) { 		//bulblight problem
	 
	 //better way :return (int)Math.sqrt(n);
	 int result=0;
	 int i=0;
	 int mod_eff=2;

	 if(n==0||n==1)
		 return n;
	 
	 int [] bulb=new int[n];
	 for(i=0;i<n;i++)
	 {
		 bulb[i]=1;
	 }
	 
	 for(mod_eff=2;mod_eff<n;mod_eff++)
	 {
		 for(i=0;i<n;i++)
		 {
			 if((i+1)%mod_eff==0)
			 {
				 if(bulb[i]==0)
					 bulb[i]=1;
				 if(bulb[i]==1)
					 bulb[i]=0;
			 }
		 }
	 }
	 
	 for(i=0;i<n;i++)
	 {
		 result+=bulb[i];
	 }
        return result; 
    }
    
    
public ListNode oddEvenList(ListNode head) { ///listNode odd_even change problem
	if((head==null)||(head.next==null))
		return head;
	ListNode odd=head;
	ListNode even=head.next;
	ListNode evenHead=even;
	while((odd.next!=null)&&(even.next!=null))
	{
		odd.next=even.next;
		odd=odd.next;
		even.next=odd.next;
		even=even.next;
		
	}
	odd.next=evenHead;
	return head;
    }





public static boolean isSelfCrossing(int[] x) {	//self crossing problem
        if(x.length<4)
        	return false;
      
        int i=2;
        while(i<x.length&& x[i]>x[i-2]){
        	i++;
	        if(i>=x.length)
	        {
	          return false;
	        }
	    }
        if((i>=4 && x[i]>=x[i-2]-x[i-4])||(i==3 && x[i]==x[i-2]))
        {
        	x[i-1]-=x[i-3];
        	
        }
        i++;
        while (i < x.length) {
            if (x[i] >= x[i - 2]) {
                return true;
            }
            i++;
        }
        return false;
    }
/*
 * public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int alen = sc.nextInt();
        int blen = sc.nextInt();
        Set<Integer> set= new TreeSet<Integer>();
        for(int i=0;i<alen;i++){
            set.add(sc.nextInt());
        }
        for(int j=0;j<blen;j++){
            set.add(sc.nextInt());
        }
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
            if(iterator.hasNext()){
                System.out.print(" ");
            }
        }
    }
 */


}
