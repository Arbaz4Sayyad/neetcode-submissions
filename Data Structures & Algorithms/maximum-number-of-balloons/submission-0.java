class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;

        // Count frequencies of the required characters
        for (char ch : text.toCharArray()) {
            // if(ch == 'b') b++;
            // if(ch == 'a') a++;
            // if(ch == 'l') l++;
            // if(ch == 'o') o++;
            // if(ch == 'n') n++;

            switch (ch) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }

        // 'l' and 'o' are needed twice per word, so divide their counts by 2
        l = l / 2;
        o = o / 2;

        return Math.min(b, Math.min(a, Math.min(n, Math.min(l, o))));
    }
}