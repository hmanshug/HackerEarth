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
#define MAX 9999999
using namespace std;
typedef pair<ll, pair<ll, ll> > PPI;

//------VARIABLES------
int t,n,m;
int u,v,w;
int mat[15][15], dp[2000];
//---------------------

int main() {
	ios_base::sync_with_stdio(false);
	si(n);si(m);
	memset(mat, -1, sizeof mat);
	memset(dp, MAX, sizeof dp);
	rep(1, m+1) {
		si(u);si(v);si(w);
		mat[u][v]=w;
	}
	for(int mask=0; mask<pow(2,n), mask++) {
		int x=__builtin_popcount(mask);
		for(int j=0; j<n; j++) {
			if(!(mask&(1<<j))) {
				dp[mask|(1<<j)]=min(dp[mask|(1<<j)], dp[mask]+mat[][]);
			}
		}
	}
	return 0;
}
