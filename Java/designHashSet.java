class MyHashSet {

    private int[] set;

    public MyHashSet() {
        this.set = new int[0];       
    }
    
    public void add(int key) {
        if(contains(key))
            return;

        int[] tempSet = new int[this.set.length+1];
        int j = 0;
        boolean keyInserted = false;
        for(int i = 0; i < this.set.length; i++){
            if (!keyInserted && this.set[i] > key) {
                tempSet[j] = key;
                j++;
                keyInserted = true;
            }
            tempSet[j]=this.set[i];
            j++;
        }
        if (j == tempSet.length-1) {
            tempSet[j] = key;
   
        }
                 this.set = tempSet;

        
    }
    
    public void remove(int key) {
        if(contains(key)){
            int[] tempSet = new int[this.set.length-1];
                
            int j=0;
            for(int i = 0; i < this.set.length; i++){
                
                if(key!=this.set[i]){
                    tempSet[j]=this.set[i];
                    j++;
                } 
            }
            this.set = tempSet;
        }
    }
    
    public boolean contains(int key) {
        
        int check = 0;
        int total = 0;
        int min = 0;
        int max = this.set.length;
        while (true) {
            total = min + max;
            check = (total / 2);
            if (max < min || (this.set.length - 1) < check) {
                return false;
            }
            if (this.set[check] == key) {
                return true;
            }
            if (min == max)
                return false;
            if (this.set[check] > key) {
                max = check - 1;
            }
            else {
                min = check + 1;
            }
        }
        

        /*
        for(int i = 0; i < this.set.length; i++){
            if (this.set[i]==key) {
                return true;
            }
        }
        return false;
        */
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */