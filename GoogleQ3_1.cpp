#include <bits/stdc++.h>
#include <set>
#define sc(n) scanf("%lld", &n)
//#define sc fastscan
#define pr(n) printf("%lld\n", n)
#define ll unsigned long long
#define MP make_pair 
using namespace std;
typedef pair<ll, pair<ll, ll> > PPI;
ll n, k;
set<PPI> ms;

int main() {
	FILE *fp;
	fp = fopen("Out.txt", "w");
	int test;sc(test);
	for(int t=1; t<=test; ++t) {
		sc(n);sc(k);
		ms.insert(make_pair(-k, make_pair(1, n)));
		for(ll i=1; i<=k; ++i) {
			//cout<<"hello"<<endl;
			PPI pp=*ms.begin();
			ms.erase(ms.begin());
			ll s=-pp.first, l=pp.second.first, r=pp.second.second;
			ll mid=(l+r)/2;
			if(i==k) {
				ll mini=min(mid-l, r-mid);
				ll maxi=max(mid-l, r-mid);
				fprintf(fp, "CASE #%d: %lld %lld\n", t, maxi, mini);
				//outfile<<"CASE #"<<t<<": "<<maxi<<" "<<mini<<endl;
				ms.clear();
				break;
			}
			if(mid-l>0)
			ms.insert(MP(-(mid-l), MP(l, mid-1)));
			if(r-mid>0)
			ms.insert(MP(-(r-mid), MP(mid+1, r)));
		}
	}
}

