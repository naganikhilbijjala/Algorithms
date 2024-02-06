public class KMP {
    
    public static void main(String[] args) {
        String txt = "SaiRam";
        String pat = "Ram";

        kmpSearch(txt, pat);
    }

    static void kmpSearch(String txt, String pat){
        int m = pat.length(), n = txt.length();
        int lps[] = new int[m];
        int j = 0; // index for pattern
        computeLpsArray(pat, m, lps);
        int i = 0; // index for txt
        while ((n-i) >= (m-j)) {
            if(pat.charAt(j) == txt.charAt(i)){
                i++;
                j++;
            }
            if(j == m){
                System.out.println("Found pattern at index " + (i-j));
                j = lps[j-1];
            }else if(i < n && pat.charAt(j) != txt.charAt(i)){
                if(j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
    }

    static void computeLpsArray(String pat, int m, int[] lps){
        int len = 0;
        int i = 1;
        lps[i] = 0;
        while(i < m){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                // Go through the example on GFG if you didn't get it
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    
}
