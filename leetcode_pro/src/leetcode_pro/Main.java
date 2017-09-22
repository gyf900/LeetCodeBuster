package leetcode_pro;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	     public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	int num=sc.nextInt();
	    	int allTime=sc.nextInt();
	    	int[] input_arr= new int[num];
	    	for(int i=0;i<num;i++)
	    	input_arr[i]=sc.nextInt();
	    	Arrays.sort(input_arr);
	    	for(int i=1;i<allTime;i++)
	    	{
	    		if(combinationSum2(input_arr,allTime-i)>0)
	    		{
	    			System.out.println(allTime-i+input_arr[num-1]);
	    			break;
	    		}
	    	}
	    	sc.close();
	    			//System.out.println(i+","+j+","+k);
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
	    				break;
	    			} else if (candi[i] < target) {
	    				//continue to look for the rest.
	    				List<Integer> newComb = new ArrayList<>(comb);
	    				newComb.add(candi[i]);
	    				combination(candi, target - candi[i], i + 1, newComb, ans);
	    			} else 
	    				break; //invalid path, return nothing.
	    		}
	    	}  
}