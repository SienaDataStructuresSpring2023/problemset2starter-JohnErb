import java.util.ArrayList;

/**
 * Write a description of class Portfolio here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Portfolio
{
    private ArrayList<StockHolding>stocks;
    private double investment;
    private double payout;
    public Portfolio(){
        ArrayList<StockHolding>stocks  = new ArrayList<StockHolding>();
        investment = 0;
        payout = 0;
    }
    public double getInvestment(){
        return investment;
    }
    
    public double getPayout(){
        return payout;
    }
    
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
    
    public double buyStock(String symbol, String name, double shares, double price){
        int index = getIndex(symbol);
        double cost = 0;
        if(index != -1){
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
    
    public double sellStock(String symbol, double shares){
        int index = getIndex(symbol);
        double cost =0;
        if(stocks.get(index).getNumShares()>shares){
            cost = stocks.get(index).sellShares(shares);
        }
        if(stocks.get(index).getNumShares()-shares==0){
            cost = stocks.get(index).sellShares(shares);
            stocks.remove(index);
        }
        payout+=cost;
        return cost;
    }
    
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
