class Solution {
    public int getSum(int a, int b) {

        // Keep adding until there is no carry
        while (b != 0) {

            // Sum without carry
            int sum = a ^ b;

            // Carry bits
            int carry = (a & b) << 1;

            // Update values
            a = sum;
            b = carry;
        }

        return a;
    }
}

/*
4 = 0100
7 = 0111

sum   = 0100 ^ 0111 = 0011 (3)
carry = 0100 & 0111 = 0100
carry <<= 1 = 1000 (8)

Now add 3 + 8

3 = 0011
8 = 1000

sum   = 1011 (11)
carry = 0000

Answer = 11
*/