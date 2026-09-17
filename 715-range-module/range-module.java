class RangeModule {
    private TreeMap<Integer, Integer> ranges; 

    public RangeModule() {
        ranges = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        int start = left, end = right;

      
        Map.Entry<Integer, Integer> lower = ranges.floorEntry(left);
        if (lower != null && lower.getValue() >= left) {
            start = Math.min(start, lower.getKey());
            end = Math.max(end, lower.getValue());
        }

        
        Map.Entry<Integer, Integer> higher = ranges.floorEntry(right);
        if (higher != null && higher.getValue() >= right) {
            end = Math.max(end, higher.getValue());
        }

     
        ranges.subMap(start, true, end, true).clear();
        ranges.put(start, end);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> floor = ranges.floorEntry(left);
        return floor != null && floor.getValue() >= right;
    }

    public void removeRange(int left, int right) {
     
        Map.Entry<Integer, Integer> lower = ranges.floorEntry(left);
        if (lower != null && lower.getValue() > left) {
            if (lower.getKey() < left) {
                ranges.put(lower.getKey(), left); 
            } else {
                ranges.remove(lower.getKey());
            }
            if (lower.getValue() > right) {
                ranges.put(right, lower.getValue()); 
            }
        }

       
        Map.Entry<Integer, Integer> higher = ranges.ceilingEntry(left);
        while (higher != null && higher.getKey() < right) {
            ranges.remove(higher.getKey());
            if (higher.getValue() > right) {
                ranges.put(right, higher.getValue()); 
                break;
            }
            higher = ranges.ceilingEntry(left);
        }
    }
}