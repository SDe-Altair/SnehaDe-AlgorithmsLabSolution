package demoGL.Denomination;
import java.util.*;

public class Currency {

	public static void merge(int arr[], int left, int mid, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] >= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			}
			else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}


	public static void main(String[] args) {
		System.out.println("Enter the number of denominations: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int denom[] = new int [num];
		for (int i=0; i<num; i++) {
			System.out.println("Enter choice denominations "+(i+1));
			denom[i] = sc.nextInt();
		}
		merge(denom, 0, (denom.length-1)/2, denom.length-1);

		for (int i=0; i<denom.length; i++) {
			System.out.println(denom[i]);
		}

		System.out.println("Enter amount you want to pay: ");
		int amount = sc.nextInt();

		for (int i=0; i<denom.length; i++) {
			if(amount>denom[i]) {
				int notes = amount/denom[i];
				System.out.println(denom[i]+" :"+notes);
				amount = amount%denom[i];
			}
		}
		if(amount>0) {
			System.out.println("Denomination unavailable for payment of "+amount);
		}
		sc.close();
	}
	
}
