package others;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr=new int[]{10, 2,-10, 5, 20};
        System.out.println(solve(arr, 0, arr.length, 2));
    }

    static int solve(int[] arr, int i, int n, int max_step){
        if(i>=n) return 0;
        if(i==n-1) return arr[i];

        int max=Integer.MIN_VALUE;

        for(int j=1;j<=max_step;j++){
            int ret=solve(arr,i+j,n,max_step);
            max = Math.max(ret,max);
        }

        return max+arr[i];
    }
}
