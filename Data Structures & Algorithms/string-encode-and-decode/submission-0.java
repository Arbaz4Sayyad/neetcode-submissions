class Solution {

    // Encodes a list of strings to one string.
    public String encode(List<String> strs) {

        StringBuilder result = new StringBuilder();

        for (String str : strs) {

            // Store:
            // length + "#" + actual string
            //
            // Example:
            // "hello" -> "5#hello"
            result.append(str.length())
                  .append("#")
                  .append(str);
        }

        return result.toString();
    }

    // Decodes one string to a list of strings.
    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Find the '#' separating length and actual string
            int delimiter = s.indexOf('#', i);

            // Extract the length
            int length = Integer.parseInt(
                    s.substring(i, delimiter)
            );

            // Start of actual string
            int start = delimiter + 1;

            // Extract exactly 'length' characters
            String str = s.substring(
                    start,
                    start + length
            );

            result.add(str);

            // Move to the next encoded string
            i = start + length;
        }

        return result;
    }
}