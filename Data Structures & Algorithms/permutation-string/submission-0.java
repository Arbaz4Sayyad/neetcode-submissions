class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        // If s1 is longer, permutation is impossible.
        if (n > m)
            return false;

        // Frequency array for s1.
        int[] freq1 = new int[26];

        // Frequency array for current window in s2.
        int[] freq2 = new int[26];

        // Store frequencies of s1 and first window.
        for (int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check first window.
        if (isSame(freq1, freq2))
            return true;

        // Slide the window.
        for (int i = n; i < m; i++) {

            // Add new character.
            freq2[s2.charAt(i) - 'a']++;

            // Remove leftmost character.
            freq2[s2.charAt(i - n) - 'a']--;

            // Compare frequencies.
            if (isSame(freq1, freq2))
                return true;
        }

        return false;
    }

    // Compare two frequency arrays.
    private boolean isSame(int[] a, int[] b) {

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }
}
