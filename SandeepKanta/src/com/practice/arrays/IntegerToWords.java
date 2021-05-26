package com.practice.arrays;

public class IntegerToWords {

    static String convertToWords(long n) {
        String tens[]={"", "", "twenty", "thirty","forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String ones[]={"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String result="";
        int num[] = new int[9];
        long t = n;
        int j=8;
        while(t > 0){
            num[j--] = (int)t%10;
            t=t/10;
        }
        int x = num[0]*10+num[1];
        if(x > 0){
            if(x < 20)
                result+=ones[x]+" crore ";
            else
                result+=tens[num[0]]+" "+ones[num[1]]+" crore ";

        }
        x = num[2]*10+num[3];
        if(x > 0){
            if(x < 20)
                result+=ones[x]+" lakh ";
            else
                result+=tens[num[2]]+" "+ones[num[3]]+" lakh ";

        }
        x = num[4]*10+num[5];
        if(x > 0){
            if(x < 20)
                result+=ones[x]+" thousand ";
            else
                result+=tens[num[4]]+" "+ones[num[5]]+" thousand ";

        }
        x = num[6];
        if(x > 0){
            result+=ones[x]+" hundred ";
        }
        if(result!=""){
            result+=" and ";
        }
        x = num[7]*10+num[8];
        if(x > 0){
            if(x < 20)
                result+=ones[x];
            else
                result+=tens[num[7]]+" "+ones[num[8]];

        }
        return result;

    }

    public static void main(String[] args) {
        convertToWords(438237764L);
    }
}
