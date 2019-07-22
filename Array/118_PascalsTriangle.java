// my solution
// Do not forget to add a fully filled row to triangle
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        // base case, numRows = 0, return empty.
        if(numRows==0) return triangle;
        
        // if numRows >= 1
        // create first row and fill with 1.
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> upperRow = triangle.get(i-1);
            for(int j = 1; j < i; j++){
                row.add(upperRow.get(j) + upperRow.get(j-1));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
