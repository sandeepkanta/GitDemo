package com.practice.arrays;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AmazonTest1 {

    long findNoOfWays(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkrits, List<Integer> priceOfTops, int dollars){
        Collections.sort(priceOfJeans);
        Collections.sort(priceOfShoes);
        Collections.sort(priceOfSkrits);
        Collections.sort(priceOfTops);
        int noOfWays=0;
        for(int i=0;i<priceOfJeans.size();i++){
            int jeansPrice = priceOfJeans.get(i);
            if(dollars < jeansPrice)
                break;
            for(int j=0;j<priceOfShoes.size();j++){
                int shoePrice = priceOfShoes.get(j);
                if(dollars < jeansPrice + shoePrice)
                    break;
                int m=0, n=priceOfTops.size() -1;
                while(m < priceOfSkrits.size() && n >=0){
                    int skritPrice = priceOfSkrits.get(m);
                    int topsPrice = priceOfTops.get(n);
                    int budget = jeansPrice + shoePrice;
                    if(skritPrice + topsPrice   <= dollars - budget) {
                        noOfWays += n-m+1;
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }
        return noOfWays;
    }

    public static void main(String[] args) {
        List<Integer> priceOfJeans = Arrays.asList(2, 3);
        List<Integer> priceOfShoes = Arrays.asList(4);
        List<Integer>priceOfSkrits = Arrays.asList(2);
        List<Integer>priceOfTops = Arrays.asList(1, 2, 3);

        var obj = new AmazonTest1();
        obj.findNoOfWays(priceOfJeans, priceOfShoes, priceOfSkrits, priceOfTops,10);

    }

}
