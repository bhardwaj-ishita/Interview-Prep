class Solution
{ 
    static ArrayList<Integer> reverse(Stack<Integer> s)
    {
        divide(s);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!s.isEmpty()){
            ans.add(s.peek());
            s.pop();
        }
        Collections.reverse(ans);
        return ans;
    }
    
    static void divide(Stack<Integer> s){
        if(!s.isEmpty()){
            int temp = s.pop();
            divide(s);
            invert(s,temp);
        }
    }
    
    static void invert(Stack<Integer> s, int temp){
        if(s.isEmpty()){
            s.add(temp);
        }
        else{
            int val = s.pop();
            invert(s,temp);
            s.add(val);
        }
    }
}


//Java after python is getting difficult
//Too many things to remember
