
class WordFilter {

    class TrieNode {
        TrieNode[] children = new TrieNode[27];
        int index = -1;
    }

    TrieNode root = new TrieNode();

    public WordFilter(String[] words) {

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            // Create every possible suffix
            for (int j = 0; j < word.length(); j++) {

                String suffix = word.substring(j);

                // Example:
                // word = "apple"
                // suffix = "le"
                // key = "le#apple"

                String key = suffix + "#" + word;

                insert(key, i);
            }
        }
    }

    private void insert(String key, int index) {

        TrieNode node = root;

        for (char c : key.toCharArray()) {

            int position;

            if (c == '#') {
                position = 26;
            } else {
                position = c - 'a';
            }

            if (node.children[position] == null) {
                node.children[position] = new TrieNode();
            }

            node = node.children[position];

            // Store the largest index
            node.index = index;
        }
    }

    public int f(String pref, String suff) {

        // Search for suffix + "#" + prefix
        String key = suff + "#" + pref;

        TrieNode node = root;

        for (char c : key.toCharArray()) {

            int position;

            if (c == '#') {
                position = 26;
            } else {
                position = c - 'a';
            }

            if (node.children[position] == null) {
                return -1;
            }

            node = node.children[position];
        }

        return node.index;
    }
}

