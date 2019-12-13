class Solution {
    public double myPow(double x, int n) {
        // idea
        double ans = 1;
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                ans *= x;
            }
        } else {
            for (int i = 0; i < -n; i++) {
                ans *= 1.0 / x;
            }
        }
        return ans;
    }
}
// Time limit exceed O(n)
// Space O(1)

class Solution {
    public double myPow(double x, int n) {
        // idea 2
        if (n == 0) return 1.0;
        if (x == 0) return 0.0;
        if (n < 0) {
            double ans = 1.0 / x;
            int index = 1;
        }
        double ans = n < 0 ? 1.0 / x : x;
        int index = 1;
        int power = n < 0 ? -n : n;
        Map<Integer, Double> map = new TreeMap<Integer, Double>(Collections.reverseOrder());
        map.put(index, ans);
        while (index < power) {
            if (index * 2 <= power) {
                ans *= ans;
                index *= 2;
                map.put(index, ans);
            } else {
                for (Integer k : map.keySet()) {
                    if (k <= power - index) {
                        ans *= map.get(k);
                        index += k;
                    }
                    if (index == power) {
                        break;
                    }
                }            
            }
        }
        return ans;
    }
}

// Time limit exceed O(n)
// Space O(1)

class Solution {
    public double myPow(double x, int n) {
        // idea 3
        if (n == 0) return 1.0;
        double root = n < 0? 1.0/x: x;
        int power = n < 0? -n: n;
        double ans = 1;
        for (int i = power; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * root;
            }
            root *= root;
        }
        return ans;
    }
}
