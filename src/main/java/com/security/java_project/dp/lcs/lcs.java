package com.security.java_project.dp.lcs;

public class lcs {

    public static StringBuilder ans = new StringBuilder();
     public static String lcs1(String s, String s1,int m, int n,String[][] memo)
    {

     if(m==0||n==0)
         return "";

        if (memo[m-1][n-1] != null) {
            return  memo[m-1][n-1];
        }

     if(s.charAt(m-1)==s1.charAt(n-1))
     {
        // ans.append(s.charAt(m - 1));
         memo[m][n]= lcs1( s, s1,m-1 ,n-1,memo)+s.charAt(m-1);
         System.out.println(memo[n][n]);
         return memo[m][n];
     }

        String choice1 = lcs1(s, s1, m - 1, n,memo);
        String choice2 = lcs1(s, s1, m, n - 1,memo);

        if (choice1.length() > choice2.length()) {
            memo[m][n] = choice1;
        } else {
            memo[m][n] = choice2;
        }

            return memo[m][n];

  //   return  Math.max(lcs1( s, s1,m-1 ,n),lcs1( s, s1,m ,n-1));

    }


    public static void  main(String[] args)
    {
        String[][] memo = new String[5][5];
       String result= lcs1("cbbd","dbbc",4,4,memo);
        System.out.println("the longest palindramic sequence length is "+result);
        //System.out.println("LCS String: " + ans.toString());
    }




}
