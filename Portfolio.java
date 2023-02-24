import java.util.ArrayList;

/**
 * Creates an arrayList called portfolio which holds individual stockHoldings from the StockHolding class.
 *
 * @author (John Erb)
 * @version (2/22/23)
 */
public class Portfolio
{
    private ArrayList<StockHolding>stocks;
    private double investment;
    private double payout;
    public Portfolio(){
        stocks  = new ArrayList<StockHolding>();
        investment = 0;
        payout = 0;
    }
    public double getInvestment(){
        return investment;
    }
    
    public double getPayout(){
        return payout;
    }
    
    
    /**
     * Finds the index of the stock in the array list. Using the given symbol.
     *
     * @param symbol 
     * @returns index
     */
    private int getIndex(String symbol){
        int index = 0;
            for(int i=0;i<stocks.size();i++){
                if(stocks.get(i).getSymbol().equals(symbol)){
                    index = i;
                }                                   
                else{
                    index = -1;
                }
            }
        

        return index;
    }
    
    /**
     * Adds shares at a new price if stock is already being held. If not adds stock to portfolio while adding to the life investment counter.
     *
     * @param symbol, name, shares, and price 
     * @returns how much it cost
     */
    public double buyStock(String symbol, String name, int shares, double price){
        int index = getIndex(symbol);
        double cost = 0;
        if(index != -1 && index != 0){
            stocks.get(index).buyShares(shares, price);
        }
        else{
            StockHolding newStock = new StockHolding(symbol, name, shares, price);
            stocks.add(newStock);
        }
        cost = price*shares;
        investment += cost;
        return cost;
    }
    
    /**
     * Sells the stock given the symbol, and how many shares. If no shares remain the item is removed from the arrayList. Also adds to lifetime payout.
     *
     * @param symbol and shares
     * @returns profit from selling 
     */
    public double sellStock(String symbol, int shares){
        int index = getIndex(symbol);
        double cost = 0;
        if(index != -1){
            if(stocks.get(index).getNumShares()>shares){
                cost = stocks.get(index).sellShares(shares);
            }
            if(stocks.get(index).getNumShares()-shares==0){
                cost = stocks.get(index).sellShares(shares);
                stocks.remove(index);
            }
        }
        else{
            return -1;
        }
        payout+=cost;
        return cost;
    }
    
    /**
     * Gets the current value of the portfolio by multipling shares owned by price
     
     * @returns total value
     */
    public double getCurrentValue(){
        double total =0;
        for(int i=0;i<stocks.size();i++){
            total = total + (stocks.get(i).getNumShares()*stocks.get(i).getPrice()); 
        }
        return total;
    }
    // @Override
    public String toString()
    {
        // //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                "Symbol", "Name", "Shares", "@Price", "Total"));
        sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
            
        }
        return sb.toString();
    }
}
