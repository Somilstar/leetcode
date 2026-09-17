class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int countOfMaxFreq = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                countOfMaxFreq++;
            }
        }

        int partCount = maxFreq - 1;
        int partLength = n - (countOfMaxFreq - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFreq * countOfMaxFreq;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}