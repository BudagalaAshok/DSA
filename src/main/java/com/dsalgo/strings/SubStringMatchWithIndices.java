package com.dsalgo.strings;

public class SubStringMatchWithIndices {

    public static boolean search(String a,String b,int i, int j, int k, int l){

        int p=101;
        double mod=1000000007;
        long[] pha=new long[a.length()];
        long[] phb=new long[b.length()];

        int limit=Math.max(a.length(),b.length())+1;
        long[] pw=new long[limit];
        pw[0]=1;
        for (int x = 1; x < limit; x++) {
            pw[x]= (long) ((pw[x-1]*p)%mod);
        }

        pha[0]= (long) ((a.charAt(0)*p)%mod);
        for (int x = 1; x < a.length(); x++) {
            pha[x]= (long) ((pha[x-1]+a.charAt(x)*pw[x+1])%mod);
        }
        phb[0]= (long) ((b.charAt(0)*p) % mod);
        for (int x = 1; x < b.length(); x++) {
            phb[x]= (long) ((phb[x-1]+a.charAt(x)*pw[x+1])%mod);
        }

        long hva= (long) ((pha[j]-(i==0 ? 0:pha[i-1]+mod))%mod);
        long hvb= (long) ((phb[l]-(k==0 ? 0:phb[k-1]+mod))%mod);
        int ssphva=i+1;
        int ssphvb=k+1;
        int diff=Math.abs(ssphva-ssphvb);
        if(ssphva<ssphvb){
            hva= (long) ((hva*pw[diff])%mod);
        }else{
            hvb= (long) ((hvb*pw[diff])%mod);
        }

        return hva==hvb;


    }

    public static void main(String[] args) {
        int i=1,j=5,k=7,l=11;
        String text1="psmartabcdatanmn";
        String text2="xydatazsmart";
        System.out.println(search(text1,text2,i,j,k,l));
    }



}
