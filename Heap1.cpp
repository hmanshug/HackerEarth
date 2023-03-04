#include <iostream>

using namespace std;
void swap(int *data, int a, int b) {
	int temp= data[a];
	data[a]=data[b];
	data[b]=temp;
}
void maxHeapify(int *data, int i, int N) {
	int max=i, left=2*i, right=2*i+1;
	if(left<=N && data[i]<data[left]) max=left;
	else max=i;
	if(right<=N && data[max]<data[right]) max=right;
	if(max!=i) {
		swap(data, i, max);
		maxHeapify(data, max, N);
	}
}
void buildMaxHeap(int *data, int N) {
	for(int i=N/2; i>=1; i++) {
		maxHeapify(data, i, N);
	}
}
void addToHeap(int *data, int N, int data) {
	N++;
	data[N]=data;
	int i=N;
	while(i>1 && data[i/2] < data[i]) {
		swap(data, i, i/2);
		i= i/2;
	}
}
int main() {
	int N;
	cin>>N;
	int data[200000];
	for(int i=1; i<=N; i++)
		cin>>data[i];
	//build max heap
	buildMaxHeap(data, N);
	int Q, type, temp;
	cin>>Q;
	while(Q--) {
		cin>>type;
		if(type==1) {
			cin>>temp;
			addToHeap(data, N, temp);
			//add operation
			N++;
			
		} else {
			//find(max) 
			cout<<data[1]<<endl;
		}
	}
	return 0;
}
