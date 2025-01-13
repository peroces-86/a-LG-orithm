class Solution {
    public int[] solution(int brown, int yellow) {
        for (int height = 1; height <= Math.sqrt(yellow); height++) {
            if (yellow % height == 0) {
                int width = yellow / height;
                
                if ((width + height + 2) * 2 == brown) {
                    return new int[] {width + 2, height + 2};
                }
            }
        }
        
        return new int[0];
    }
}
