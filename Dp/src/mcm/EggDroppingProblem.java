package mcm;

public class EggDroppingProblem {

    public static void main(String[] args) {
        int e=3;
        int f=5;

        System.out.println(solve(e,f));
    }

    static int solve(int e, int f){
        if(f==0 || f==1) return f;
        if(e==1) return f;

        int min=Integer.MAX_VALUE;
        for(int i=1;i<=f;i++){
            int temp=1 + Math.max(solve(e-1,i-1), solve(e,f-i));
            min=Math.min(min,temp);
        }
        return min;
    }
}
