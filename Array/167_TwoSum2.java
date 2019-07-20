// a nice solution, use two index to find ans
public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;
    while (numbers[l] + numbers[r] != target) {
        if (numbers[l] + numbers[r] > target) r--;
        else l++;
    }
    return new int[]{l + 1, r + 1};
}

// my solution
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = 0;
        int[] ans = new int[2];
        for(i = 0, j = 1; numbers[i] <= target; j++){
            if(numbers[i] + numbers[j] == target){
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }
            else if(j == numbers.length - 1){
                i++;
                j = i;
            }
        }
        return ans;
    }
}
