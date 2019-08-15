package StringAndChan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]


 * @author Administrator
 *
 */
public class threeSum {
public static void main(String[] args) {
	 int [] nums = {-1, 0, 1, 2, -1, -4};
	 threeSum  s=new threeSum();
	 s.threeSum(nums);
}

	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        
        if (nums != null && nums.length > 2) {
            // 先对数组进行排序
            Arrays.sort(nums);
            // i表示假设取第i个数作为结果
            for (int i = 0; i < nums.length - 2; ) {
                // 第二个数可能的起始位置
                int j = i + 1;
                // 第三个数可能是结束位置
                int k = nums.length - 1;
 
                while (j < k) {
                    // 如果找到满足条件的解
                    if (nums[j] + nums[k] == -nums[i]) {
                        // 将结果添加到结果含集中
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
 
                        // 移动到下一个位置，找下一组解
                        k--;
                        j++;
 
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和大于0
                    else if (nums[j] + nums[k] > -nums[i]) {
                        k--;
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和小于0
                    else {
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    }
                }
 
                // 指向下一个要处理的数
                i++;
                // 从左向右找第一个与之前处理的数不同的数的下标
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }
 
        return result;
    }
	
	/**
	 * leecode 最快的算法
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSumLeecode(int[] nums) {
		int len = nums.length;
		if (len < 3)
			return new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);  //sort the array first
        List<List<Integer>> res = new ArrayList<>();
        int max = Math.max(nums[len - 1], Math.abs(nums[0])); //to allocate enough space to avoid check in if statement
                             
		byte[] hash = new byte[(max<<1) + 1];
		for (int v : nums) { //hash and count appearing times of every num
			hash[v + max]++;
		}
        
        int lastNeg = Arrays.binarySearch(nums, 0); //search the position of 0; it also means the position of the last negative number in array
        int firstPos = lastNeg; //the position of the first positive number in array
        if(lastNeg < 0){    //0 not found
            firstPos = ~lastNeg;
            lastNeg = -lastNeg - 2;//see the Java api
        }
        else{               //found
            while(lastNeg >=0 && nums[lastNeg] == 0) //skip all 0
                --lastNeg;
            while(firstPos < len && nums[firstPos] == 0)
                ++firstPos;
            int zeroCount = firstPos - lastNeg - 1;
            if (zeroCount >= 3) { // (0 appears 3 times at least)
                res.add(Arrays.asList(0, 0, 0));
		    }
            if (zeroCount > 0 ) { // (0 appears 1 times at least)
			for (int i = firstPos; i < len; ++i) { //traverse all the positive numbers to see whether there is a negative number whose absolute value equals to the positive number 
                if(i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                    continue;
                if ( hash[-nums[i] + max] > 0) {
					res.add(Arrays.asList(0, nums[i], -nums[i]));
                } 
			}
		}
        }
 
		// one positive number and two negetive numbers 
		for (int i = firstPos; i < len; ++i) { //traverse all the positive numbers to find whether there are two negative numbers to make the 3 numbers added up to 0
            if(i > firstPos && nums[i] == nums[i - 1]) //skip the same elements
                    continue;
            int half;   //we can traverse only half of the positive numbers
            if(nums[i] % 2 != 0)
                half = -((nums[i]>>1) + 1);
            else{
                half = -(nums[i]>>1);
                if(hash[half + max] > 1)
                    res.add(Arrays.asList(nums[i], half, half));
            }
            for(int j = lastNeg; j >=0 && nums[j] > half; --j){
                if(j < lastNeg && nums[j] == nums[j + 1])
                    continue;
                if(hash[(-nums[i] - nums[j]) + max] > 0)
                    res.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
            }
        }
        
        // one negative number and two positive numbers 
		for (int i = lastNeg; i >= 0; --i) { //traverse all the negative numbers to find whether there are two positive numbers to make the 3 numbers added up to 0
            if(i < lastNeg && nums[i] == nums[i + 1])//skip the same elements
                    continue;
            int half; //we can traverse only half of the negative numbers
            if(nums[i] % 2 != 0)
                half = -(nums[i] / 2 - 1);
            else{
                half = -(nums[i]>>1);
                if(hash[half + max] > 1)
                    res.add(Arrays.asList(nums[i], half, half));
            }
            for(int j = firstPos; j < len && nums[j] < half; ++j){
                if(j > firstPos && nums[j] == nums[j - 1])
                    continue;
                if(hash[(-nums[i] - nums[j]) + max] > 0)
                    res.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));
            }
        }
		return res;
	}
	
}
