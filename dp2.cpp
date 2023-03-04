#include <iostream>
#include <cstring>
#include <map>
#define ll long long
using namespace std;
#define pr(n) printf("%d\n", n);
int A[1000], M[1000], N;

int dp[1005][1005];
int findMaxApples(ll power, int apples, int farm) {
    if(power==0 || farm>=N)
        return apples;
	if(dp[farm][power]!=-1) {
		return dp[farm][power]; 
	
    } else { 
        int X=findMaxApples(power-1, apples+A[farm], farm+1);
        int Y=findMaxApples(((power-1+M[farm])>N)?N:(power-1+M[farm]), apples, farm+1);
        if(X>Y) dp[farm][power]=X;
		else dp[farm][power]=Y;
		return dp[farm][power];
    }   
}

int main()
{
    int test;
    cin>>test;
    while(test--) {
         
        memset(dp, -1, sizeof dp);
        ll P;
        cin>>N>>P;
        for(int i=0; i<N; i++)
            cin>>M[i];
        for(int i=0; i<N; i++)
            cin>>A[i];
		if(P>N) P=N;
        cout<<findMaxApples(P, 0, 0)<<endl;
        for(int i=0; i<=N; i++)
        	for(int j=0; j<=N; j++)
        		pr(dp[i][j]);
        
    }
    return 0;
}

