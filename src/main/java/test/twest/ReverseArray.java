package test.twest;

public class ReverseArray {
    
	public StringBuffer reverse(int arr[], StringBuffer sb, int counter) {
    	if (counter == 0) {
    		return sb;
    	} else {
    		sb.append(arr[counter -1]);
    		if(counter != 1) {
    			sb.append(" ");
    		}
    		reverse(arr, sb, counter -1);
    	}
		return sb;
    }
}
