import java.util.*;
public class ArraysCC {
    
    //traped rain water
    
    public static int trappedRainWater(int height[]){//O(n)
        int n = height.length;
        //calculate left mox boundary
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i], leftMax[i-1]);
        }
        //calculate right max boundary
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i], rightMax[i+1]);
        }
        //loop
        int trappedWater =0;
        for(int i=0;i<n;i++){
            //waterlevel= min(leftmax,rightmaxbound)
            int waterlevel=Math.min(leftMax[i],rightMax[i]);
            //traped water = water level -height
            trappedWater += waterlevel-height[i];
        }
        
        
        return trappedWater;
    }

    //buy sell stocks

    public static int buySellStocks(int prices[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit =0;
        for(int i=0; i<prices.length;i++){
            if(buyPrice < prices[i]){//profit
                int profit = prices[i]-buyPrice;//todays profit
                maxProfit = Math.max(maxProfit, profit); //global profit
            }else{
                buyPrice=prices[i];
            }
        }

    return  maxProfit;
    }
    
    public static void main(String args[]){
        
                    //buy and sell stocks
        int prices[]={7,1,5,3,6,4};
        System.out.println(buySellStocks(prices));
        
                    //traped water
        // int height[]={4,2,0,6,3,2,5};
        // System.out.println(trappedRainWater(height));
    }
}
