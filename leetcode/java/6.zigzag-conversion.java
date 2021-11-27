class Solution {
    public String convert(String s, int numRows) {
		if(s.length()<=numRows){
			return s;
		}
		char[] c = s.toCharArray();
		StringBuffer[] sb = new StringBuffer[numRows];
		for(int i = 0; i< numRows;i++){
			sb[i] = new StringBuffer();
		}	
		int index = 0;	
		while(index<c.length){
			for(int i = 0;i<numRows&&index<c.length;i++){
				sb[i].append(c[index]);
				index++;
			}
			for(int i = numRows-2;i>0&&index<c.length;i--){
				sb[i].append(c[index]);
				index++;
			}
		}
		for(int i = 1;i<numRows;i++){
			sb[0].append(sb[i]);
		}
		return sb[0].toString();
    }
}
