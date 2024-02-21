class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int r = 0;
        while (left > 0 && right > 0) {
            int msbLeft = getMostSignificantBit(left);
            int msbRight = getMostSignificantBit(right);

            if (msbLeft != msbRight) {
                return r;
            }

            // 2^msb
            int msbVal = (1 << msbLeft);
            left -= msbVal;
            right -= msbVal;
            r += msbVal;
        }
        return r;
    }

    int getMostSignificantBit(int n) {
        // This is just the position of the most significant bit
        int mostSignificantBit = -1;
        while (n > 0) {
            mostSignificantBit++;
            // Shift right untill we cover all bits
            n = n >> 1;
        }
        return mostSignificantBit;
    }
}