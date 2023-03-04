#include<iostream>
#define sc(a) scanf("%d", &a);
#define ss(a) scanf("%s", &a);
using namespace std;
bool check(char *str) {
	for(int i=0; str[i]!='\0'; ++i) {
		if(str[i]=='-')
			return false;
	}
	return true;
}

int find(char *str) {
	int side=0, length=0; //left=0 and right=1
	int count=0;
	for(; str[length]!='\0'; ++length);
	
	while(1) {
		bool flag=false;
		
		if (check(str)==true)
			return count;
			
		for(int i=length-1; i>=0; i--) {
			if(str[i]=='-')
				flag=true;
			if(flag==true)
				str[i]=str[i]=='-'?'+':'-';
		}
		count++;
		side=1;
	
	}
		
}
int main() {
	int test;sc(test);
	for(int t=1; t<=test; ++t) {
		char str[100];ss(str);
		printf("CASE #%d: %d\n", t, find(str));
	}
}
