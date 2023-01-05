
import java.util.*;

public class LinearSelecction {
	public Object select(int array[],int start, int fin, int target) {
		if(start == fin) {
			return array[start];
		}
		int q = partition(array,start,fin);
		
		if(q > target) {
			return select(array,start,q-1,target);
		}else if(q==target) {
			return array[q];
		}else {
			return select(array,q+1,fin,target);
		}
	}
	
	public int partition(int array[],int start, int fin) {
		int pivot = array[fin];
		int i = start - 1;
		int j = start;
		int temp;
		
		while( j< array.length) {
			if (array[j]<= pivot) {
				temp = array[j];
				i++;
				array[j] = array[i];
				array[i] = temp;
			}
			j++;
		}
		if(j==array.length) {
			j--;
		}
		if(array[i]>array[j]) {
			temp = array[j];
			array[j]=array[i];
			array[i] = temp;
		}
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		String b = sc.nextLine();
		String[] c = a.split("\\s");
		String[] d = b.split("\\s");
		int[] array = new int[5];
		
		
		int p = Integer.parseInt(c[0]);
		int r = Integer.parseInt(c[1]);
		int q = Integer.parseInt(c[2]);
		
		array = Arrays.stream(d).mapToInt(Integer::parseInt).toArray();

		System.out.println(p);
		System.out.println(r);
		System.out.println(q);
		System.out.println(Arrays.toString(array));

		

		
		
	}

}
