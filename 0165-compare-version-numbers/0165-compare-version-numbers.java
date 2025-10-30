


class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

                // System.out.println(Arrays.toString(v1)+" "+v2);
        for(int i=0; i<v1.length || i<v2.length; i++){

            // if(v1[i].equals(v2[i])) continue;
            int s1 = i<v1.length? Integer.parseInt(v1[i]) : 0;
            int s2 = i<v2.length ? Integer.parseInt(v2[i]) : 0;

            if(Integer.compare(s1, s2) != 0)
                    return Integer.compare(s1, s2);    


            
        }
        return 0;
    }
}