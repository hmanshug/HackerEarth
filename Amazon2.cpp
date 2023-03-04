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
#define MAX 999999999
using namespace std;
typedef pair<ll, pair<ll, ll> > PPI;

//------VARIABLES------
int t;
char s[21];
ll n;
//---------------------
inline int compare (const void *a, const void * b) {  return ( *(char *)a - *(char *)b ); }
 
void swap (char* a, char* b) {
    char t = *a; *a = *b; *b = t;
}
int fc (char str[], char first, int l, int h) {
    int j = l;
    for (int i = l+1; i <= h; i++)
      if (str[i] > first && str[i] < str[j])
            j = i;
    return j;
}

char* ans (char str[], ll n) {
    int len = strlen(str);
    qsort(str, len, sizeof(str[0]), compare);
 	ll count=0;
    bool flag = false;
    
    while (!flag) {
		if(++count==n)
			return str;
        int i;
        for (i=len-2; i>=0; --i)
           if(str[i]<str[i+1]) break;
              
        if (i==-1) flag=true;
        else {
            int j=fc(str,str[i],i+1,len-1);
            swap(&str[i],&str[j]);
            qsort(str+i+1,len-i-1,sizeof(str[0]),compare);
        }
    }
}
int main() {
	ios_base::sync_with_stdio(false);
	si(t);
	while(t--) {
		ss(s);sl(n);
		ps(ans(s,n));pn;
	}
	return 0;
}
