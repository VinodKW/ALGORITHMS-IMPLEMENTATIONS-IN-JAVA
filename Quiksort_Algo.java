class Quicksort {

    public int partition(int[] arr, int l, int r) {
    	int pivot = arr[r];
    	int i = l-1;

    	for(int j = l; j<r; j++) {
    		if(arr[j]<= pivot) {
    			i++;
    			int temp = arr[i];
    			arr[i] = arr[j];
    			arr[j] = temp;
    		}
    	}

    	int temp  = arr[i+1];
    	arr[i+1] = arr[r];
    	arr[r] = temp;
    	return i+1;
    }
	public void sort(int[] arr, int l, int r) {
		if(l<r) {
			int position = partition(arr,l,r);
			sort(arr,l,position-1);
			sort(arr,position+1,r);
		}
	}
	public static void main(String[] args) {
		Quicksort q = new Quicksort();

		int[] arr = {1,4,2,5,6,7,5};
		q.sort(arr,0,arr.length-1);

		for(int i = 0; i<arr.length; i++) {
			System.out.printf("%d\t",arr[i]);
		}

	}
}