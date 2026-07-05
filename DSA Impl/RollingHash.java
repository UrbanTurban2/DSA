class RollingHash
{
    static long MOD = (long)(1e9+7);
    static long[] hashArray, pInverseArray;

    int n;
    RollingHash(String str)
    {
        n = str.length();
        int i=0, j=n-1;
        hashArray=new long[n];
        pInverseArray=new long[n];
        precomputeHashArray(str);
        for(int p=0;p<n;++p)
        {
            pInverseArray[p]=modInverse(power(31, p));
        }
    }
    public int hash(String s, int i, int j)
    {
        if(i==0)
        {
            return (int) ((hashArray[j]*pInverseArray[i])%MOD);
        }
        else
        {
            return (int)((((hashArray[j]+MOD-hashArray[i-1])%MOD)*pInverseArray[i])%MOD);
        }
    }
    private void precomputeHashArray(String s)
    {
        long p = 31;
        long hashValue = 0;
        long p_pow = 1;
        for (int i=0;i<s.length();++i) {
            char c = s.charAt(i);
            hashValue = (hashValue + (c - 'a' + 1) * p_pow) % MOD;
            hashArray[i] = hashValue;
            p_pow = (p_pow * p) % MOD;
        }
    }
    private long modInverse(long n)
    {
        return power(n, MOD-2);
    }
    private long power(long x, long y)
    {
        if(y==0)
            return 1;
        long halfAns=power(x, y/2);
        long myAns=(halfAns*halfAns)%MOD;

        if((y&1)==1)
            myAns=(myAns*x)%MOD;
        return myAns;
    }
}
