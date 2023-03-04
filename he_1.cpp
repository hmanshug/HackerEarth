#include <iostream>
#include <cmath>
#include <stdlib.h>
using namespace std;
#define sc(n) scanf("%d", &n)
#define pr(n) printf("%d\n", n)
#define ll long long;

int main()
{
    int t;sc(t);
    while(t--) {
    	int n;sc(n);
    	int count=2, loc=0;
    	int sq=sqrt(n);
    	for(int i=2; i<sq; ++i) {
    		if(n%i==0 ){
    			loc+=2;
			}
			if(count==loc) {
				count+=loc;
				loc=0;
			}
		}
		if(sq*sq!=n && n%sq==0)
			loc+=2;
		if(count==loc) {
			count+=loc;
			loc=0;
		}
		if(n!=1) pr(count);
		else pr(0);
		
	}
	
    return 0;
}

