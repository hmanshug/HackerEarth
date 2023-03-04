#include <iostream>
#include <cstring>
#include <stdlib.h>
using namespace std;
#define sc(n) scanf("%lld", &n)
#define ss(a) scanf("%s", &a)
#define pr(n) printf("%d\n", n)
#define ll unsigned long long
#define MAX 99999999

bool check(ll n) {
	ll t,l=n%10;n/=10;
	while(n!=0) {
		t=n%10;
		if(l<t) return false;
		else l=t;
		n/=10;
	}
	return true;
}
int main() {
	int test;sc(test);
	for(int t=1; t<=test; ++t) {
		ll num, i;sc(num);
		
		for(i=num; i>=1; --i) {
			if(check(i)==true)
				break;
		}
		printf("CASE #%d: %lld\n", t, i);
	}
}

