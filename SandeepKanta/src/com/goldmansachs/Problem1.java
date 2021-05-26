package com.goldmansachs;

import java.util.Arrays;
import java.util.Map;

public class Problem1 {

    static int findConsecutiveRepeats(String pattern,int index,char character){
        char toggleCharacter = character=='N' ? 'M' : 'N';
        //System.out.println(toggleCharacter);
        int foundIndex = pattern.indexOf(toggleCharacter,index+1);
        //System.out.println(foundIndex);
        if(foundIndex==-1){
            return pattern.length()-1-index;
        }
        return foundIndex - index - 1;
    }

    static int appendInteger(int i,int j){
        //System.out.println(String.valueOf(i)+" "+ String.valueOf(j));
        return Integer.parseInt(i+""+j);
    }

    static int[] initialOutputString(char initialCharacter,int countOfMsSoFar){
        int output = 0;
        if(initialCharacter=='N'){
            output = appendInteger(output,countOfMsSoFar+1);
            output = appendInteger(output,countOfMsSoFar+2);
        }else{
            output = appendInteger(output,countOfMsSoFar+2);
            output = appendInteger(output,countOfMsSoFar+1);
        }
        for(int j = countOfMsSoFar;j>=1;j--) {
            output = appendInteger(output,j);
        }
        int[] returnValue = {output,countOfMsSoFar+2};
        return returnValue;
    }

    static int[] findOccurrence(char initialCharacter,int countOfMsSoFar,int leastNumberUsedSoFar) {
        int output = appendInteger(0,leastNumberUsedSoFar+countOfMsSoFar+1);
        for(int j = countOfMsSoFar;j>=1;j--) {
            output = appendInteger(output,j+leastNumberUsedSoFar);
        }
        int[] returnValue = {output,leastNumberUsedSoFar+countOfMsSoFar+1};
        //System.out.println(Arrays.toString(returnValue));
        return returnValue;
    }

    static int findPossibleSmallestNumberMatchingPattern(String pattern) {
        char[] patternCharacters = pattern.toCharArray();
        int minNumberUsedSoFar = 0;
        int i=0, output = 0;
        while(i < pattern.length()){
            //System.out.println(minNumberUsedSoFar);
            if(i == 0){
                int countOFMs = findConsecutiveRepeats( pattern, 0,'M');
                int [] result = initialOutputString(pattern.charAt(0),countOFMs);
                output = result[0];
                minNumberUsedSoFar = result[1];
                i+=countOFMs+1;
                //System.out.println(output);
            }else{
                int countOFMs = findConsecutiveRepeats( pattern, i,'M');
                int [] result = findOccurrence(pattern.charAt(i), countOFMs, minNumberUsedSoFar);
                output = appendInteger(output,result[0]);
                minNumberUsedSoFar = result[1];
                i+=countOFMs+1;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(findPossibleSmallestNumberMatchingPattern("NMMMNM"));
    }
}
