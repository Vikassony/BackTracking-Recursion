Question Link : https://leetcode.com/problems/combinations/
/*
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> al = new ArrayList<>();
        combinations(1,n,0,k,"",al);
        return al;
    }
    void combinations(int cb, int n, int ssf, int k, String asf, List<List<Integer>> al ){
        if(cb>n){
             if(ssf == k){
                ArrayList<Integer> al1 = new ArrayList<>();
                String s[] = asf.split(",");
                for(int i=0;i<s.length;i++){
                    String s1 = s[i];
                    if(s1!="")
                        al1.add(Integer.parseInt(s1));
                }
                al.add(al1);
             }
            return;
        }
        combinations(cb+1,n, ssf+1, k,asf+","+cb,al);
        combinations(cb+1,n, ssf, k,asf,al);
    }
}
