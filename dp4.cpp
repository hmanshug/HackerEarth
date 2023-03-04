#include <iostream>
#include <cstring>
#include <stdlib.h>
using namespace std;
#define sc(n) scanf("%d", &n)
#define pr(n) printf("%d ", n)
#define prn printf("\n");
#define ll long long
#define min(a,b) a<b?a:b

int main()
{
    int n;sc(n);
    int a[n+1], dp[n+1][n+1];
    memset(dp, 0, sizeof dp);
    for(int i=1; i<=n; i++) sc(a[i]);
    for(int i=n; i>=1; i--) {
    	for(int j=i; j<=n; j++) {
    		if(i==j)
    			dp[i][j]=1;
    		else if(i==j-1) {
    			if(a[i]!=a[j])
    				dp[i][j]=2;
			} else {
				if(a[i]==a[j]) {
					dp[i][j]= min(dp[j+1][n], dp[j][n]+1);
				}
				else {
					dp[i][j]=dp[j][n ]+1;
				}
			}
		}
	}
	for(int i=0; i<=n; i++) {
		for(int j=0; j<=n; j++) {
			pr(dp[i][j]);
		}
		prn;
	}
	
	pr(dp[1][n]);
    return 0;
}

