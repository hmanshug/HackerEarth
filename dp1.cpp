#include <iostream>
#include <cstring>
#include <algorithm>
#include <stdlib.h>
using namespace std;
#define sc(n) scanf("%d", &n)
#define pr(n) printf("%d\n", n);
#define ll long long;

int main()
{
    
    int n, m;sc(n);sc(m);
    int a[n][m], r[n][m], c[n][m], b[n][m];
    memset(r, 0, sizeof a);
    memset(c, 0, sizeof a);
    memset(b, 0, sizeof a);
    
    for(int i=0; i<n; ++i) {
        for(int j=0; j<m; ++j) {
            sc(a[i][j]);
            if(j>0){
                 r[i][j]=r[i][j-1]+a[i][j];
            } else {
                r[i][j]=a[i][j];
            }
        }
    }
    for(int j=0; j<m; ++j) {
        for(int i=0; i<n; ++i) {
            if(i>0){
                 c[i][j]=c[i-1][j]+a[i][j];
            } else {
                c[i][j]=a[i][j];
            }
        }
    }
    for(int i=0; i<n; ++i) b[i][0]=c[i][0];
    for(int i=0; i<m; ++i) b[0][i]=r[0][i];
    
    for(int i=1; i<n; ++i) {
        for(int j=1; j<m; ++j) {
            b[i][j]= b[i-1][j-1]+r[i][j-1]+c[i-1][j]+a[i][j];
        }
    }
    for(int i=0; i<n; ++i) {
        for(int j=0; j<m; ++j) {
        	pr(b[i][j]);
        }  
    }
    
	
    return 0;
}

