#include <iostream>
#include <cstring>

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
void minHeapify(int *data, int i, int N) {
	int min=i, left=2*i, right=2*i+1;
	if(left<=N && data[i]>data[left]) min=left;
	else min=i;
	if(right<=N && data[min]>data[right]) min=right;
	if(min!=i) {
		swap(data, i, min);
		minHeapify(data, min, N);
	}
}
void buildMaxHeap(int *data, int N) {
	for(int i=N/2; i>=1; i--) {
		maxHeapify(data, i, N);
	}
}
void buildMinHeap(int *data, int N) {
	for(int i=N/2; i>=1; i--) {
		minHeapify(data, i, N);
	}
}
void addToHeapMax(int *data, int *N, int val) {
	(*N)++;
	data[*N]=val;
	int i=*N;
	while(i>1 && data[i/2] < data[i]) {
		swap(data, i, i/2);
		i= i/2;
	}
}
void addToHeapMin(int *data, int *N, int val) {
	(*N)++;
	data[*N]=val;
	int i=*N;
	while(i>1 && data[i/2] > data[i]) {
		swap(data, i, i/2);
		i= i/2;
	}
}
void deleteFromHeapMin(int *data, int *N) {
	data[1]=data[*N];
	(*N)--;
	if(*N>1)
	minHeapify(data, 1, *N);	
}
void deleteFromHeapMax(int *data, int *N) {
	data[1]=data[*N];
	(*N)--;
	if(*N>1)
	maxHeapify(data, 1, *N);	
}
void deleteFromHeapMinValue(int *data, int value, int *N) {
    int max=data[(*N/2)+1], maxi=1;
    for(int i=(*N/2)+2; i<=*N; i++) {
        if(data[i]>max) {
            max=data[i];
            maxi=i;
        }
    }
    data[maxi]=data[*N];
    (*N)--;
    minHeapify(data, maxi, *N);
}
void deleteFromHeapMaxValue(int *data, int value, int *N) {
    int min=data[(*N/2)+1], mini=1;
    for(int i=(*N/2)+2; i<=*N; i++) {
        if(data[i]<min) {
            min=data[i];
            mini=i;
        }
    }
    data[mini]=data[*N];
    (*N)--;
    maxHeapify(data, mini, *N);
}
int main() {
	
	int data1[200000];
	int data2[200000];
	int Q, N1=0,N2=0, temp;
	char type[20];
	cin>>Q;
	while(Q--) {
		cin>>type;
		if(strcmp(type, "Push")==0) {
			cin>>temp;
			addToHeapMin(data1, &N1, temp);
			addToHeapMax(data2, &N2, temp);
		} else if(strcmp(type, "Diff")==0){
		    //cout<<"--"<<N1<<"--"<<N2<<endl;
			if(N1==0)
				cout<<"-1"<<endl;
			else {
				cout<<data2[1]-data1[1]<<endl;
				if(data1[1]==data2[1]) {
				    deleteFromHeapMin(data1, &N1);
				    deleteFromHeapMax(data2, &N2);
				} else {
				    deleteFromHeapMaxValue(data2, data1[1], &N2);
				    deleteFromHeapMinValue(data1, data2[1], &N1);
				    deleteFromHeapMin(data1, &N1);
				    deleteFromHeapMax(data2, &N2);
				    
				}
				
			}
				
		} else if(strcmp(type, "CountHigh")==0){
			int count=0, temp=data2[1];
			for(int i=1; i<=N2; i++) {
			    //cout<<"--"<<data2[i]<<endl;
				if(data2[i]== temp)
					count++;
			}
			if(count==0) count=-1;
			cout<<count<<endl;
			
		} else if(strcmp(type, "CountLow")==0){
			int count=0, temp=data1[1];
			for(int i=1; i<=N1; i++) {
			    //cout<<"--"<<data1[i]<<endl;
				if(data1[i]== temp)
					count++;
			}
			if(count==0) count=-1;
			cout<<count<<endl;
		}
	}
	return 0;
}
