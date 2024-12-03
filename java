Given a string s, the task is to find the minimum characters to be added at the front to make the string palindrome.

Note: A palindrome string is a sequence of characters that reads the same forward and backward.

Examples:

Input: s = "abc"
Output: 2
Explanation: Add 'b' and 'c' at front of above string to make it palindrome : "cbabc"
Input: s = "aacecaaaa"
Output: 2
Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
Constraints:
1 <= s.size() <= 106

solution:
  
class Solution {
    public static int minChar(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;
        int[] lps = computeLPSArray(combined);

        // Minimum characters to add = Total length - Length of the longest palindromic prefix
        return s.length() - lps[lps.length - 1];
    }

    private static int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}


