
// In this problem using few variables to store the intermediate data.
// "static void main" must be defined in a public class.

// Time Complexity : O(1) we can say O(n) where is length of brackets or tax slabs list, but in any country the number of tax slabs 
// are constant so constant
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

public class CalculateTax {
    public static double calculateTax(List<List<Double>> brackets, double salary) {
        // Take i to iterate over the tax brackets
        int i = 0;
        // Take initial tax as 0.0
        double tax = 0.0;
        // Take the limit variable so that when we go to each bracket, we can have value
        // of what amount we already computed tax
        double limit = 0.0;
        // Take left variable for storing the amount remaining from the salary on which
        // the tax is not calculated yet
        double left = salary;
        // Now loop till left becomes 0 i.e no amount from salary remains to calc tax on
        while (left > 0) {
            // Get the bracket at index i
            List<Double> li = brackets.get(i);
            // percent will be bracket list of 1
            double percent = li.get(1);
            // Check if the first value is null, that means this is the last bracket, so
            // compute tax for all the left value with this percent
            if (li.get(0) == null) {
                tax = tax + left * percent;
                // And return tax
                return tax;
            }
            // Else get the amount from index of 0 of bracket list at i
            // And the amount on which the current percent is applicable is min of amount at
            // index 0 - limit and left amount
            double taxableIncome = Math.min((li.get(0) - limit), left);
            // compute tax
            tax = tax + taxableIncome * percent;
            // Update left amount
            left = left - taxableIncome;
            // Update limit
            limit = li.get(0);
            // move i
            i++;
        }
        return tax;
    }

    public static void main(String[] args) {
        List<List<Double>> brackets = new ArrayList<>();
        brackets.add(Arrays.asList(10000.0, 0.3));
        brackets.add(Arrays.asList(20000.0, 0.2));
        brackets.add(Arrays.asList(30000.0, 0.1));
        brackets.add(Arrays.asList(null, 0.1));
        System.out.println(calculateTax(brackets, 15000.0));
        System.out.println(calculateTax(brackets, 45000.0));

    }
}