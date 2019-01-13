// program to perform sorting using Mergesort Algorithm




class Mergesort
{
     //method to perform merge operation 
    public void merge(int[] arr, int l , int mid, int r)
    {
        int n1 = mid-l+1;
        int n2 = r-mid;
        
        int[] L = new int[n1+1];
        int[] R = new int[n2+1];
        for(int i = 0; i<n1 ; i++)
        {
            L[i] = arr[l+i];
        }
        for(int j = 0 ; j<n2 ; j++)
        {
            R[j] = arr[mid+1+j];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int x = 0; 
        int z = 0;

        for(int i = l ; i<=r ; i++)
        {
            if(L[x]<= R[z])
            {
                arr[i] = L[x++];
            }
            else
            {
                arr[i] = R[z++];
            }
        }




        
    }

    //sorting method 
    public void sort(int[] arr,int l, int r)
    {
       if(l<r)
       {
           int mid = l + (r-l)/2;
           sort(arr,l,mid);
           sort(arr,mid+1,r);
           merge(arr,l,mid,r);
       }
    }
    
    public static void main(String[] args)
    {
            int[] arr = {9,8,7,6,5,4,3,2,1};
            Mergesort m = new Mergesort();
            m.sort(arr,0,arr.length-1);
            for(int i = 0 ; i<arr.length ; i++)
            {
                System.out.printf(arr[i]+"\t");
            }
    }
}
