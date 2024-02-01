class Solution {
    public long distinctNames(String[] ideas) {
        long result = 0;

        HashSet<String>[] initialGroup = new HashSet[26];
        for(int i = 0; i<26; i++){
            initialGroup[i] = new HashSet<>();
        }

        for(String idea:ideas){
            initialGroup[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

    
        for(int a = 0; a < 25; a++){
            for(int b = a+1; b < 26; b++){
                int mutualSuffix = 0;
                for(String ideaA: initialGroup[a]){
                    if(initialGroup[b].contains(ideaA)){
                        mutualSuffix++;
                    } 
                }
                result += 2*(initialGroup[a].size() - mutualSuffix) * (initialGroup[b].size() - mutualSuffix);
            }
        }
        return result;
    }
}