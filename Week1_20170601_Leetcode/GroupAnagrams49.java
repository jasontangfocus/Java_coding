/* Problem Description
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/
public class 49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //Exception case
        if(strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        
        //Normal case
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strs) {
            //transform each string in the string strs array to char array
            char[] ca = str.toCharArray();
            //sort each character 
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}