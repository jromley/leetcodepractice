class Solution {

    public ArrayList<ArrayList<String>> list;

    public List<String> letterCombinations(String digits) {

        if(digits.length()==0){
            return new ArrayList();
        }

        char count = 'a';
        list = new ArrayList<ArrayList<String>>();

        for(int i = 0; i < 8; i++) {
            ArrayList<String> temp = new ArrayList<String>();
            for(int j = 0; j < 3; j++){
                temp.add(count+"");
                count++;
            }

            if(i == 5 || i == 7) {
                temp.add(count+"");
                count++;
            }
            list.add(temp);
        }

        return recurse(digits.substring(1), getAssociatedChars(digits.charAt(0)+""));
    }

    public ArrayList<String> recurse(String digits, ArrayList<String> result){

        if(digits.length()==0){
            return result;
        }

        ArrayList<String> tempResult = new ArrayList<String>();
        ArrayList<String> associatedChars = getAssociatedChars(digits.charAt(0)+"");

        for(String temp : result){
            for(int i = 0 ; i < associatedChars.size(); i++){
                tempResult.add(temp+associatedChars.get(i));
            }
        }

        result = tempResult;
        return recurse(digits.substring(1), result);
    }

    public ArrayList<String> getAssociatedChars(String x){
        int transformed = Integer.parseInt(x) - 2;
        return list.get(transformed);
    }

}