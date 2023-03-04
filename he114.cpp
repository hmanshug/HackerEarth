/**
 *	Author: G1
 *	Description: DP
 */

#include <bits/stdc++.h>

#define sl(n) scanf("%lld", &n)
#define si(n) scanf("%d", &n)
#define ss(n) scanf("%s", n)
#define pi(n) printf("%d", n)
#define pl(n) printf("%lld\n", n)
#define p printf(" ")
#define pn printf("\n")
#define rep(n) for(int i=0; i<n; ++i)
#define ll  long long
#define MP make_pair 
using namespace std;
typedef pair<ll, pair<ll, ll> > PPI;

int t, i;
int dp[1010][1010];
char s[1010];
int sl;
ll sum=0;

int main() {
	ios_base::sync_with_stdio(false);
	si(t);
	while(t--) {
		ss(s);sum=0;
		for(i=0; s[i]!='\0'; ++i);sl=i;
		memset(dp, 0, sizeof dp);
		for(int len=1; len<=sl; ++len) {
			for(int i=1; i+len-1<=sl; ++i) {
				int j=i+len-1;
				if(s[i-1]==s[j-1]) {
					if(i==j || i==j-1) dp[i][j]=1;
					if(dp[i+1][j-1]==1) dp[i][j]=1;
				}
			}
		}
		
		for(int i=1; i<=sl; ++i) {
			for(int j=1; j<=sl; ++j) {
				//pi(dp[i][j]);p;
				if(dp[i][j]==1) {
					sum+=(j-i+1)*(j-i+1);
				}
			}
			//pn;
		}
		pl(sum);
	}
	return 0;
}
