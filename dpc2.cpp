#include <iostream>
#include <cstring>
#include <stdlib.h>
using namespace std;
#define sc(n) scanf("%d", &n)
#define scs(n) scanf("%s", &n)
#define pr(n) printf("%d\n", n);
#define ll long long;

int dp[101][101][101], n;
int R[101], B[101];

int f(int i, int r, int b) {
    if(i==n || (r==0 && b==0))
        return 0;
    if(dp[i][r][b]!=-1) return dp[i][r][b];
    int x, y;
    if(r>=R[i] && b>=B[i])
        x=f(i+1, r-R[i], b-B[i])+1;
    
    y=f(i+1, r, b);
        
    dp[i][r][b]= x>y?x:y;
    return dp[i][r][b];
}
int main()
{   
    
    sc(n);
    char s[100];
    
    memset(R, 0, sizeof R);
    memset(B, 0, sizeof B);
    for(int i=0; i<n; i++) {
        scs(s);
        for(int j=0; s[j]!='\0'; j++) {
            if(s[j]=='R')
                R[i]++;
            else
                B[i]++;
        }
    }
    int q;sc(q);
    while(q--) {
        memset(dp, -1, sizeof dp);
        int a,b;sc(a);sc(b);
        f(0, a, b);
        pr(dp[0][a][b]);
    }
    
    
    return 0;
}

