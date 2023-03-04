#include<iostream>
#define sc(a) scanf("%d", &a);
using namespace std;
bool cd[10];

bool check(int num) {
	while(num!=0) {
		cd[num%10]=1;
		num/=10;
	}
	for(int i=0; i<10; i++) {
		if(cd[i]==false)
			return false;
	}
	return true;
}
int find(int num) {
	for(int i=0; i<10; i++) cd[i]=false;
	for(int i=1;;++i) {
		if(check(i*num)==true)
			return i*num;
	}
}
int main() {
	int test;sc(test);
	for(int t=1; t<=test; ++t) {
		int num;sc(num);
		 if(num==0)
		 	printf("CASE #%d: %s\n", t, "INSOMNIA");
		else
			printf("CASE #%d: %d\n", t, find(num));
	}
}
