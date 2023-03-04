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

//------VARIABLES------
int t, n, c;
//---------------------
int main() {
	ios_base::sync_with_stdio(false);
	si(t);
	while(t--) {
		si(n);c=0;
		while(n) {
		    if(1 & n) c++;
		    n=n>>1;
		    pi(n);
		}
		pi(c);
	}
	return 0;
}
