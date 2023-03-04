#include <iostream>
#include <cstring>
#include <stdlib.h>
using namespace std;
#define sc(n) scanf("%d", &n)
#define ss(a) scanf("%s", &a);
#define pr(n) printf("%d\n", n);
#define ll long long;
#define MAX 99999999
int len, k;
void change(char *s, int id) {
	for(int i=id, j=id+k-1; i<=j; ++i, --j) {
		char t=s[i];
		s[i]=s[j];
		s[j]=t;
		if(s[i]=='+') s[i]='-'; else s[i]='+';
		if(i!=j)
		if(s[j]=='-') s[j]='+'; else s[j]='-';
	}
}
bool check(char *s) {
	for(int i=0; i<len; ++i) {
		if(s[i]=='-')
			return false;
	}
	return true;
}
int f(int idx, char *s, int count, int z) {
	int ch[11], id=idx;
	for(int i=0; i<10; i++) ch[i]=0;
	while(idx!=0) {
		ch[idx%10]=1;
		idx/=10;
	}
	if(check(s)==true)
		return count;
	if(len-k+1==idx)
		return MAX;
	
	char temp[11];
	strcpy(temp, s);
	change(temp, idx);
	int a;
	for(int i=0; i<len-k+1; i++) {
		if(flg==false && ch[i]!=1) {
			a= f(id*10+i, s, count);
		}
		return min(f(, s, count), f(idx+1, temp, count+1));
	}
	return MAX;
		
}

int main() {
	int test;sc(test);
	for(int t=1; t<=test; ++t) {
		char s[11];ss(s);sc(k);
		
		for(int i=0; s[i]!='\0'; len=++i);
		int ans=f(0, s, 0);
		if(ans==MAX)
		 	printf("CASE #%d: %s\n", t, "IMPOSSIBLE");
		else
			printf("CASE #%d: %d\n", t, ans);
	}
}

