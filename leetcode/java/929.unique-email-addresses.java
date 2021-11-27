class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for(String email : emails){
            String[] names = email.split("@");
            String local = names[0];
            String domain = names[1];
            int firstplus = local.indexOf("+");
            String token = local.substring(0 , firstplus);
            StringBuilder sb = new StringBuilder();
            for(char c : token.toCharArray()){
                if(c != '.'){
                    sb.append(c);
                }
            }
            String newemail = sb.toString() + "@" + domain;
            set.add(newemail);
        }
        return set.size();
    }
}