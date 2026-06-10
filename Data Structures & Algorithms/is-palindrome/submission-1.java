class Solution {
    public boolean isPalindrome(String s) {
        // brute force approach could be we can take 
        // another string which is reverse of the original string 
        // and point one pointer to first char of original string
        // and other pointer will point to first char of reversed string 
        // and then compare each and get to the result which will give us SC: O(N) and TC : 2*O(N) 

        // Step 1: Normalize the string by removing non-alphanumeric characters and converting to lowercase.
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // Step 2: Use the two-pointer technique to check for palindrome.
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    // public boolean isPalindrome(String s) {
    //     StringBuilder str = new StringBuilder();
        
    //     for (char c : s.toCharArray()) {
    //         if (Character.isLetterOrDigit(c)) {
    //             str.append(Character.toLowerCase(c));
    //         }
    //     }

    //     int start = 0;
    //     int end = str.length()-1;
    //     while(start < end){
    //         if(str.charAt(start) != str.charAt(end)){
    //             return false;
    //         }else{
    //             start++;
    //             end--;
    //         }
    //     }
    //     return true;
    // }

    // public boolean isPalindrome(String s) {
    //     int left = 0;
    //     int right = s.length()-1;

    //     while(left < right){
    //         while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
    //             left++;
    //         }
    //         while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
    //             right--;
    //         }
    //         if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
}
