class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openstack = new Stack<>();
        Stack<Integer> endstack = new Stack<>();
        for(int i = 0 ; i < s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                openstack.push(i);
            }else if(c=='*'){
                endstack.push(i);
            }else{
                if(!openstack.isEmpty()){
                    openstack.pop();
                }else if(!endstack.isEmpty()){
                    endstack.pop();
                }else return false;
            }
        }
        while(!openstack.isEmpty() && !endstack.isEmpty()){
            if(endstack.pop() < openstack.pop()){
                return false;
            }
        }
        return openstack.isEmpty();
    }
}