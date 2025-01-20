class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0, maxH = 0;
        
        for(int[] size : sizes) {
            int sizeW = Math.max(size[0], size[1]);
            int sizeH = Math.min(size[0], size[1]);
            
            maxW = Math.max(maxW, sizeW);
            maxH = Math.max(maxH, sizeH);
            
        }
        
        return maxW * maxH;
    }
}