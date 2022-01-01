import java.util.Arrays;
import java.util.Scanner;

public class BoxPacking {
	
	public static int packMin(double[] items, int itemsTotal) {
        Arrays.sort(items);

        int count = 0;
        double maxWeight = 1.0;
        
        double[] remaining = new double[itemsTotal];

        for (int i = 0; i < itemsTotal; i++) {
            int j;
            for (j = 0; j < count; j++) {
                
                if (remaining[j] >= items[i]) {
                    remaining[j] = remaining[j] - items[i];
                    break;
                }
            }

            if (j == count) {
                remaining[count] = maxWeight - items[i];
                count++;
            }
        }
    
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of items: ");
        int itemsTotal = s.nextInt();
        double[] items = new double[itemsTotal];
        

        for (int i = 0; i < itemsTotal; i++) {
            System.out.println("Enter the weight of item # " + (i + 1) + ": ");
            double weight = s.nextDouble();
            while (weight > 1.0) {
                System.out.println("Invalid Option: Enter a weight between 0.0 and 1.0: ");
                weight = s.nextDouble();
            }
   
            items[i] = weight;
        }
        s.close();

        System.out.println("The number of boxes is: " + BoxPacking.packMin(items, itemsTotal));

    }
}
