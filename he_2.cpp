#include <iostream>
#include <vector>
#include <stdlib.h>
#include <queue>
#include <cstring>
using namespace std;
#define sc(n) scanf("%d", &n)
#define pr(n) printf("%d\n", n)
#define ll long long;

int main()
{
    int t;sc(t);
	while(t--) {
		int n, m;sc(n);sc(m);
		int in[n+1];
		memset(in, 0, sizeof in);
		vector<int> l[n+1];
		
		for(int i=1; i<=m; i++) {
			int u, v;
			sc(u);sc(v);
			l[u].push_back(v);
			in[v]+=1;
		}
		queue<int> q;
		bool vis[n+1];
		memset(vis, false, sizeof vis);
		for(int i=1; i<=n; i++)
			if(in[i]==0) {
					q.push(i);
					vis[i]=true;
			}
			
		while(!q.empty()) {
			int u=q.front();
			q.pop();
			
			for(int i=0; i<l[u].size(); i++) {
				if(vis[l[u][i]]==false) {
					in[l[u][i]]-=1;
					if(in[l[u][i]]==0)
						q.push(l[u][i]);
						vis[l[u][i]]=true;
				}
			}
		}
		int i;
		for(i=1; i<=n; i++)
			if(vis[i]==false) break;
		if(i==n+1)
			pr(1);
		else
			pr(0);
	}
    return 0;
}

