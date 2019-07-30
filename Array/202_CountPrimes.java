class Solution {
    public int countPrimes(int n) {
        //This is a great solution
        boolean[] nonPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            
            if(nonPrime[i] == false){
                count++;
                for(int j = 2; i*j < n; j++){
                    nonPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}
