#include <cstdio>
#include <algorithm>
#include <iostream>
using namespace std;
 
struct node {
    long val;
};
 
int n;
long q[1000003];
node tree[2000003];
 
node makeNode(long val) {
    node tmp;
    tmp.val = val;
    return tmp;
}
 
node combine (node l, node r) {
    return makeNode(l.val^r.val);
}
 
node build(int from, int to, int index) {
    if (from == to) {
        tree[index] = makeNode(q[from]);
        return tree[index];
    }
    int mid = (from+to)/2;
    node l = build(from,mid, (index<<1));
    node r = build(mid+1,to, (index<<1)+1);
 
    tree[index] = combine(l,r);
    return tree[index];
}
 
node ans(int index, int from, int to, int a, int b) {
    if (from == a && to == b) {
        return tree[index];
    }
    int mid = (from+to)/2;
    if (b <= mid) {
        return ans((index<<1), from, mid, a, b);
    }
    if (a > mid) {
        return ans((index<<1) + 1, mid+1,to,a,b);
    }
    node l = ans((index<<1), from, mid, a, mid);
    node r = ans((index<<1) + 1, mid+1,to,mid+1,b);
    return combine(l,r);
}

void change(int index, int from, int to, int a, int b) {
    if (a>=from && a<=to) {
        tree[index].val=tree[index].val ^ b;
    }
    if(from==to) return;
    
    int mid = (from+to)/2;
    if (a <= mid) {
        change((index<<1), from, mid, a, b);
    }
    if (a > mid) {
        change((index<<1) + 1, mid+1,to,a,b);
    }
    return;
}
 
int main() {
    scanf("%d",&n);
    for (int i = 1; i <= n; ++i) scanf("%d",&q[i]);
    build(1,n,1);
    int t;
    scanf("%d",&t);
    int test,a,b;
    for (int i = 0; i < t; ++i) {
        scanf("%d%d%d",&test, &a,&b);
        if(test==0)
        	printf("%ld\n", ans(1,1,n,a,b).val);
        else
			change(1,1,n,a,b);	
        
    }
    return 0;
}
