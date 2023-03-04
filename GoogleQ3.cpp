#include <iostream>
#include <cstring>
#include <stdlib.h>
#include <algorithm>
using namespace std;
#define sc(n) scanf("%lld", &n)
#define pr(n) printf("%lld\n", n)
#define ll unsigned long long
#define MAX 999999

ll vis[MAX], le[MAX], ri[MAX];
ll n, k;
void start() {
	for(int i=1, j=0, k=n-1; i<=n; ++i){
		vis[i]=-1;
		le[i]=j++;
		ri[i]=k--;
		//cout<<"--"<<vis[i]<<"--"<<le[i]<<"--"<<ri[i]<<endl;
	}
}
ll findmin() {
	bool f=false;
	ll cmin, cmax, cptr;
	for(int i=1; i<=n; ++i) {
		//first one
		if(vis[i]==-1 && f==false) {
			f=true;
			cmin=min(le[i], ri[i]);
			cmax=max(le[i], ri[i]);
			cptr=i;
		}
		if(vis[i]==-1 && f==true) {
			int tmin, tmax;
			tmin=min(le[i], ri[i]);
			tmax=max(le[i], ri[i]);
			if(tmin>cmin) {
				cmin=tmin;cmax=tmax;cptr=i;
			} else if(tmin==cmin) {
				if(tmax>cmax) {
					cmax=tmax;cptr=i;
				}	
			}
		}
	}
	return cptr;
}
void stable(ll id) {
	
	for(ll i=id+1; i<=n; i++) {
		if(vis[i]==1) break;
		le[i]-=le[id]+1;
	}
	for(ll i=id-1; i>=1; i--) {
		if(vis[i]==1) break;
		ri[i]-=ri[id]+1;
	}
}
ll algo() {
	for(ll i=1; i<=k; ++i) {
		ll sel=findmin();
		vis[sel]=1;
		if(i==k) {
			return sel;
		}
		stable(sel);
	}
	
}
int main() {
	int test;sc(test);
	for(int t=1; t<=test; ++t) {
		sc(n);sc(k);
		start();
		ll sel=algo();
	//	cout<<sel<<"--"<<endl;
	//	for(int i=1; i<=n; i++)
	//		cout<<le[i]<<" -- "<<ri[i]<<endl;
		int m=max(le[sel], ri[sel]);
		int n=min(le[sel], ri[sel]);
		printf("CASE #%d: %lld %lld\n", t, m, n);
	}
}

