/**
 *	Author: G1
 *	Description:
 */

#include <bits/stdc++.h>

#define sl(n) scanf("%lld", &n)
#define si(n) scanf("%d", &n)
#define ss(n) scanf("%s", n)
#define pi(n) printf("%d\n", n)
#define pl(n) printf("%lld\n", n)
#define rep(n) for(int i=0; i<n; ++i)
#define ll  long long
#define MP make_pair 
using namespace std;
typedef pair<ll, pair<ll, ll> > PPI;

int n,m,t;
int w[1001], v[1001], dp[1001][1001];

int rec(int id, int wei) {
	if(id>=n || wei<=0) return 0;
	if(dp[id][wei]!=-1) return dp[id][wei];
	int a=0, b=0;
	if(wei>=w[id]) a=rec(id+1, wei-w[id])+v[id];
	b=rec(id+1, wei);
	return dp[id][wei]=max(a,b);
}

int main() {
	ios_base::sync_with_stdio(false);
	si(t);
	while(t--) {
		memset(dp, -1, sizeof dp);
		si(n);si(m);
		rep(n) si(w[i]);
		rep(n) si(v[i]);
		pi(rec(0, m));
	}
	return 0;
}
