/**
 * Write a description of class Asset here.
 *
 * @author (John Erb)
 * @version (2/21/2023)
 */
public class StockHolding
{
    private String symbol;
    private String name;
    private double numShares;
    private double price;
    // @Override
    public StockHolding(String symbol, String name, int numShares, double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
    }
    
    public String getSymbol(){
        return symbol;    
    }
    
    public String getName(){
        return name;    
    }
    
    public double getNumShares(){
        return numShares;    
    }
    
    public double getPrice(){
        return price;    
    }
    
    public void buyShares(int newShares, double newPrice){
        numShares += newShares;
        price = newPrice;
    }
    
    public double sellShares(int shares){
        double profit = 0;
        if(numShares>= shares){
            profit = shares*price;
            numShares = numShares - shares;
        }
        return profit;
    }
    
    public String toString()
    {
        // //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
        symbol, name, numShares, price, numShares * price); 
     }
}
