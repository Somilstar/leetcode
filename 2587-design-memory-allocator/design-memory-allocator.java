class Allocator {
    private int[] memory;

    public Allocator(int n) {
        // Initialize memory of size n. 
        // Java auto-fills arrays with 0, which we will use to mean "free space".
        memory = new int[n];
    }
    
    public int allocate(int size, int mID) {
        int consecutiveFree = 0;
        
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == 0) {
                consecutiveFree++;
                
                // We found a large enough block!
                if (consecutiveFree == size) {
                    int startIndex = i - size + 1;
                    
                    // Fill the block with the mID
                    for (int j = startIndex; j <= i; j++) {
                        memory[j] = mID;
                    }
                    
                    return startIndex;
                }
            } else {
                // We hit an occupied block, reset our consecutive free counter
                consecutiveFree = 0;
            }
        }
        
        // If we make it through the whole array without finding a block
        return -1;
    }
    
    public int freeMemory(int mID) {
        int freedCount = 0;
        
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == mID) {
                memory[i] = 0;
                freedCount++;
            }
        }
        
        return freedCount;
    }
}

