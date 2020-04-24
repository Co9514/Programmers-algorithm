package level2;

public class StockPrice {
        public int[] solution(int[] prices) {
            for(int i = 0 ; i < prices.length ; i++){
                if(i == prices.length -1){prices[i] = 0; break;}
                int cnt = 0 ;
                for(int j = i ; j < prices.length;j++){
                    if(prices[i] <= prices[j] && j != prices.length-1){
                        cnt++;
                    }else{
                        break;
                    }
                }
                prices[i] = cnt;
            }
            return prices;
        }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        System.out.println(stockPrice.solution(new int[]{1,2,3,4}));
    }
}
