/**
 *	Author: G1
 *	Description: 
 */

#include <bits/stdc++.h>

#define sl(n) scanf("%lld", &n)
#define si(n) scanf("%d", &n)
#define ss(n) scanf("%s", n)
#define pi(n) printf("%d", n)
#define pl(n) printf("%lld\n", n)
#define ps(n) printf("%s", n)
#define p printf(" ")
#define pn printf("\n")
#define rep(j,n) for(int i=j; i<n; ++i)
#define ll  long long
#define MP make_pair 
using namespace std;
typedef pair<ll, pair<ll, ll> > PPI;

//------VARIABLES------
int t,len,dp[1000][1000];
int countt;
char c[100001];
//---------------------
bool check(char ch) {
    if(ch=='A' || ch=='a' || ch=='B' || ch=='b' || ch=='C' || ch=='c')
        return true;
    else
        return false;
}
int main() {
	ios_base::sync_with_stdio(false);
	si(t);
	while(t--) {
		ss(c);countt=0;
		memset(dp, 0, sizeof(dp));
		for(int i=0; c[i]!='\0'; ++i, len=i);
		for(int i=0; i<=len; i++) dp[0][i]=1;
		for(int i=1; i<=len; ++i) {
		    for(int j=i; j<=len; j++) {
		        if(dp[i-1][j-1]==1 && check(c[j-1])) {
		        	dp[i][j]=1;countt++;
				} 
		    }
		}
		pi(countt);
	}
	return 0;
}
