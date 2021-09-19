package demoGL.Transactions;
import java.util.*;

public class Transaction {
	public static void main(String[] args) {
		System.out.println("Enter the number of transactions: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int tx[] = new int [num];  //created array
		for (int i=0; i<num; i++) {
			System.out.println("Enter transaction "+(i+1));
			tx[i] = sc.nextInt();
		}
		System.out.println("Enter number of targets: ");
		int targets = sc.nextInt();
		for(int j=0; j<targets; j++) {
			System.out.println("Enter target value"+(j+1));
			int targetValue = sc.nextInt();
			int sum = 0;
			for(int k=0; k<num; k++) {
				sum = sum + tx[k];
				if(sum>=targetValue) {
					System.out.println("Given target is achieved after "+(k+1)+" transactions");
					break;
				}
			}
			if(sum<targetValue) {
				System.out.println("Given target is not achieved");
			}
		}
		sc.close();
	}
}
