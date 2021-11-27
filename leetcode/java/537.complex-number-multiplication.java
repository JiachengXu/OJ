class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] as = getRandI(a);
        int[] bs = getRandI(b);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(as[0] * bs[0] - as[1] * bs[1]));
        sb.append('+');
        sb.append(String.valueOf(as[1] * bs[0] + as[0] * bs[1]));
        sb.append('i');
        return sb.toString();
    }
    int[] getRandI(String a){
        String[] as = a.split("\\+");
        int[] res = new int[2];
        res[0] = Integer.valueOf(as[0]);
        res[1] = Integer.valueOf(as[1].split("i")[0]);
        return res;
    }
}