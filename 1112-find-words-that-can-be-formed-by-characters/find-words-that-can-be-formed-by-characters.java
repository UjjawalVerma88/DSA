class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];

        for (char ch : chars.toCharArray()) {
            freq[ch - 'a']++;
        }

        int ans = 0;

        for (String word : words) {
            int[] count = new int[26];

            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }

            boolean valid = true;

            for (int i = 0; i < 26; i++) {
                if (count[i] > freq[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans += word.length();
            }
        }

        return ans;
    }
    
}