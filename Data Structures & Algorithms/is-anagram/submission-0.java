class Solution {

    /*
     * Valid Anagram
     * -------------
     *
     * Given two strings s and t,
     * return true if t is an anagram of s.
     *
     * Anagram:
     * Both strings contain the same characters
     * with the same frequencies.
     *
     * TC: O(N)
     * SC: O(1)
     *
     * (26 lowercase English letters)
     */
    public boolean isAnagram(String s, String t) {

        // Different lengths can never be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for a-z
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {

            // Add frequency from s
            count[s.charAt(i) - 'a']++;
            
            // Remove frequency from t
            count[t.charAt(i) - 'a']--;
        }

        /*
         * If strings are anagrams,
         * all frequencies should become 0.
         */
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}


// class Solution {

//     /*
//      * Valid Anagram - HashMap Approach
//      *
//      * TC: O(N)
//      * SC: O(K)
//      *
//      * K = Number of unique characters
//      */
//     public boolean isAnagram(String s, String t) {

//         // Different lengths can never be anagrams
//         if (s.length() != t.length()) {
//             return false;
//         }

//         Map<Character, Integer> freqMap = new HashMap<>();

//         // Count frequency of characters in s
//         for (char ch : s.toCharArray()) {
//             freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
//         }

//         // Remove frequency using characters from t
//         for (char ch : t.toCharArray()) {

//             // Character not present in s
//             if (!freqMap.containsKey(ch)) {
//                 return false;
//             }

//             freqMap.put(ch, freqMap.get(ch) - 1);

//             // Remove entry when frequency becomes 0
//             if (freqMap.get(ch) == 0) {
//                 freqMap.remove(ch);
//             }
//         }

//         // If map is empty, frequencies matched perfectly
//         return freqMap.isEmpty();
//     }
// }