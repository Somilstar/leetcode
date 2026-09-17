class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] passengerChange = new int[1001]; 

        for (int[] trip : trips) {
            int passengers = trip[0], from = trip[1], to = trip[2];
            passengerChange[from] += passengers; 
            passengerChange[to] -= passengers;    
        }

        int currentPassengers = 0;
        for (int change : passengerChange) {
            currentPassengers += change;
            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }
}