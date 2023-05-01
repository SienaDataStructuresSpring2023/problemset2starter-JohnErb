
/**
 * Class which creates a stock object to be held in portfolio class.
 *
 * @author (John Erb)
 * @version (2/21/2023)
 */
public class StockHolding
{
    private String symbol;
    private String name;
    private int numShares;
    private double price;
    // @Override
    /**
    *Constructor for stockholding object, given symbol, number of shares, price
    *and name.
    * @param String symbol
    * @param String name
    * @param int numShares
    * @param double price
    */
    public StockHolding(String symbol, String name, int numShares, double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
    }
    /**
     * Getter method for symbol
     */
    public String getSymbol(){
        return symbol;    
    }
    /**
     * Getter method for name
     */
    public String getName(){
        return name;    
    }
    /**
     * Getter method for numShares
     */
    public double getNumShares(){
        return numShares;    
    }
    /**
     * Getter method for getPrice
     */
    public double getPrice(){
        return price;    
    }
    /**
     * buys shares for the stock holding given how many shares and the price
     * @param int newShares
     * @param double new Price
     */
    public void buyShares(int newShares, double newPrice){
        numShares += newShares;
        price = newPrice;
    }
    /**
     * Sells shares for an existing stock holding, given the number of shares.
     * And returns the profit from the sale.
     * @param int shares
     * @return profit
     */
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
        //return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n");
        String output = symbol+ " " + name + " " + numShares+ " " + price+ " " + (numShares*price);
        return output;
    }
}
