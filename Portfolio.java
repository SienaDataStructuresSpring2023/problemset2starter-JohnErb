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
    /**
     * Constructor
     */
    public Portfolio(){
        stocks  = new ArrayList<StockHolding>();
        investment = 0;
        payout = 0;
    }

    /**
     * Getter for Lifetime Investment 
     */
    public double getInvestment(){
        return investment;
    }

    /**
     * Getter for Lifetime Payout
     */
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
        for (StockHolding stock : stocks) {
            if (stock.getSymbol().equals(symbol)) {
                stock.buyShares(shares, price);
                investment +=shares * price;
                return shares * price;
            }
        }
        StockHolding newStock = new StockHolding(symbol, name, shares, price);
        stocks.add(newStock);
        investment += shares * price;
        return shares * price;

    }

    /**
     * Sells the stock given the symbol, and how many shares. If no shares remain the item is removed from the arrayList. Also adds to lifetime payout.
     *
     * @param symbol and shares
     * @returns profit from selling 
     */
    public double sellStock(String symbol, int shares){
        double cost = 0.0;

        for (int i = 0; i < stocks.size(); i++) {
            StockHolding s = stocks.get(i);
            if (s.getSymbol().equals(symbol)) {
                payout += s.sellShares(shares);
                if (s.getNumShares() == 0) {
                    stocks.remove(i);
                }
            }
        }
        payout += cost;
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
    /**
     * toString Override method given in the problem set.
     */
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
