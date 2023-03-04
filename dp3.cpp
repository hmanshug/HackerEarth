#include <iostream>
#include <algorithm>
#include <cstring>
#include <stdlib.h>
using namespace std;
#define sc(n) scanf("%s", &n)
#define pr(n) printf("%d\n", n);
#define ll long long;


int main()
{
    string n;cin>>n;
    int dp[51][51];
    memset(dp, -1, sizeof dp);
    int len=n.length(), count=0;
    for(int i=len;i>=1; i--) {
    	for(int j=i; j<=len; j++) {
    		if(i==j) {
    			dp[i][j]=1;count++;
			} else {
				if(n.at(i-1)==n.at(j-1) && i==j-1) {
					dp[i][j]=1;count++;
				} else if(dp[i+1][j-1] ==1 && n.at(i-1)==n.at(j-1)){
					dp[i][j]=1;count++;
				}
			}
		}
	}
	pr(count);
	
    return 0;
}

