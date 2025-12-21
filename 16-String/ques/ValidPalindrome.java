// leet code 125

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String newS = s.toLowerCase();

        //Then repalceAll non Alphanumeric characters
        String finalStr=newS.replaceAll("[^a-z0-9]", "");

        int n=finalStr.length();
        // going only halfway through the string
        for(int i=0;i<n/2;i++){
            char ch=finalStr.charAt(i);
            if(ch !=finalStr.charAt(n-i-1)) return false; // comparing first and last char 
        }
        return true;
    }
}