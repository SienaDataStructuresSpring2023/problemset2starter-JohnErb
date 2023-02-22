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
