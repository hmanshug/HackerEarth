#include <iostream>
#include <cstring>
#include <stdlib.h>
using namespace std;
#define sc(n) scanf("%d", &n)
#define pr(n) printf("%d\n", n);
#define ll long long;

int main()
{
    int t;sc(t);
	while(t--) {
		int n;sc(n);
		int p[n], m[n], a[n];
		for(int i=0; i<n;i++) sc(a[i]);
		//for(int i=0; i<n;i++) pr(a[n]);
		int c=0;
		for(int i=1; i<n-1; i++) {
			if(a[i]==1)
				c++;
			p[i]=c;
			cout<<p[i]<<" ";
		}
		cout<<endl;
		for(int i=n-2, c=0; i>0; i--) {
			if(a[i]==-1)
				c++;
			m[i]=c;
			cout<<m[i]<<" ";
		}
		cout<<endl;
		int ans, min=m[1];
		for(int i=1; i<n-1; i++) {
			if(a[i]==-1) {
				ans=p[i]+m[i]-1;
			} else {
				ans=p[i]+m[i];
			}
			cout<<ans<<" "<<min<<endl;
			if(min>ans) min=ans;	
		}
		
		if(a[0]==1) min++;
		if(a[n-1]==-1) min++;
		pr(min);
	}
	
	
    return 0;
}

