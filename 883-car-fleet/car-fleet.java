import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        
    
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
       
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        
        int fleets = 0;
        double slowestTime = 0.0; 
        
        for (int i = 0; i < n; i++) {
           
            double currentTime = (double) (target - cars[i][0]) / cars[i][1];
            
            
            if (currentTime > slowestTime) {
                fleets++;
                slowestTime = currentTime; 
            }
        }
        
        return fleets;
    }
}