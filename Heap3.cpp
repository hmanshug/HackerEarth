#include <iostream>
#define ll long long

using namespace std;

void swap(ll *data, ll a, ll b) {
	ll temp= data[a];
	data[a]=data[b];
	data[b]=temp;
}
void minHeapify(ll *data, ll i, ll N) {
	ll min=i, left=2*i, right=2*i+1;
	if(left<=N && data[i]>data[left]) min=left;
	else min=i;
	if(right<=N && data[min]>data[right]) min=right;
	if(min!=i) {
		swap(data, i, min);
		minHeapify(data, min, N);
	}
}
void buildMinHeap(ll *data, ll N) {
	for(ll i=N/2; i>=1; i--) {
		minHeapify(data, i, N);
	}
}
void deleteFromHeapMin(ll *data, ll *N) {
	data[1]=data[*N];
	(*N)--;
	minHeapify(data, 1, *N);	
}
ll topFromHeapMin(ll *data) {
	return data[1];	
}
void addToHeapMin(ll *data, ll *N, ll value) {
	(*N)++;
	data[*N]=value;
	ll i=*N;
	while(i>1 && data[i/2] > data[i]) {
		swap(data, i, i/2);
		i= i/2;
	}
}
int main()
{
    ll N;
    cin>>N;
    ll m1[N], m2[N], m3[N];
	ll total[N+1];
    
    for(ll i=0; i<N; i++) {
        cin>>m1[i];
    }
    for(ll i=0; i<N; i++) {
        cin>>m2[i];
    }
    for(ll i=0; i<N; i++) {
        cin>>m3[i];
        total[i+1]= (m1[i]+m2[i]+m3[i]);
    }
    buildMinHeap(total, N);
    
    ll Q;
    cin>>Q;
    while(Q--) {
        ll temp;
        cin>>temp;
        ll dtemp[temp];
        if(temp <= N) {
        	for(ll i=1; i<=temp-1; i++) {
            	dtemp[i]=topFromHeapMin(total);
            	deleteFromHeapMin(total, &N);
			}
			cout<<topFromHeapMin(total)<<endl;
			deleteFromHeapMin(total, &N);
			for(ll i=1; i<=temp-1; i++) {
	        	addToHeapMin(total, &N, dtemp[i]);
			}
		}
		else 
			cout<<-1<<endl;
			
    }
    return 0;
}

