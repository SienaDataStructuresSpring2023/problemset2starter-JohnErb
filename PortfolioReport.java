import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program creates a portfolio by reading the transactions in
 * the file transactions.txt and buying and selling stock shares
 * accordingly.  Then, this program prints the portfolio report
 * as described in the problem set 2 instructions.
 *
 * @author (John Erb)
 * @version (2/23/2023)
 */
public class PortfolioReport
{
    /**
     * This program creates a portfolio by reading the transactions in
     * the file transactions.txt and buying and selling stock shares
     * accordingly.  Then, this program prints the portfolio report
     * as described in the problem set 2 instructions.
     * 
     * @param args No command line arguments required.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File("transactions.txt"));        
        Portfolio p = new Portfolio();

        while(file.hasNext()){
            String line = file.nextLine();
            String[] data = line.split(", ");
            if(data[0].equals("B")){
                //Buy the stock for the portfolio.
                int shares = Integer.parseInt(data[3]);
                double price = Double.parseDouble(data[4]);
                p.buyStock(data[1], data[2], shares, price);
            } else {
                //Sell the stock from the portfolio.
                int shares = Integer.parseInt(data[2]);
                p.sellStock(data[1],shares );
            }
            
        }

        System.out.print(p);
        System.out.println();
        
        // Uncomment the lines of code below and complete the print statements to work as intended.
        System.out.println(String.format("      Current Value:  $%,15.2f", p.getCurrentValue()));
        System.out.println(String.format("Lifetime Investment:  $%,15.2f", p.getInvestment()));
        System.out.println(String.format("    Lifetime Payout:  $%,15.2f", p.getPayout()));
    }
}
