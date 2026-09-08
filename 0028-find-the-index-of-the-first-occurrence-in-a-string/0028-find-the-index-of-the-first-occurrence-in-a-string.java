class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // Try every possible starting position
        for (int i = 0; i <= n - m; i++) {

            boolean match = true;

            // Compare needle with haystack starting from i
            for (int j = 0; j < m; j++) {

                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }

        return -1;
    }
}