class Solution {
    public boolean isHappy(int n) {
        // 0
        if(n == 0) return false;
        //
        
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
            int sum = 0;
            int remain = 0;
            while(n > 0){
                remain = n % 10;
                sum += remain * remain;
                n /= 10;
            }
            if(sum == 1) 
                return true;
            else
                n = sum;
        }
        return false;
    }
}
