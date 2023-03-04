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
int n, a[1000001], dp[1000001], ans=0;
//---------------------

int main() {
	ios_base::sync_with_stdio(false);
	si(n);
	rep(0,n) {
		si(a[i]);
	}
	memset(dp, -1, sizeof dp);
	dp[0]=0;
	for(int mask=0; mask<pow(2,n); mask++) { 
		//cout<<mask<<""<<endl;
		for(int j=0; j<n; j++) {
			if(!(mask&(1<<j)) && dp[mask|(1<<j)] ==-1) {
				dp[mask|(1<<j)]=a[j]^dp[mask];
			}
		}
	}
	for(int mask=0; mask<pow(2,n); mask++) { 
		ps("dp--");pi(dp[mask]);pn;
		if(dp[mask]!=-1)
		ans=ans|dp[mask];
	}
	pi(ans);
	return 0;
}
