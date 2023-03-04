#include <iostream>
#include<cstdio>
 
using namespace std;
 
struct node{
    long best,sum,lft,ryt;
    void init(long a){
        best = a;
        sum = a;
        lft = a;
        ryt = a;
    }
    void merge(node a,node b){
        lft = max(a.lft,a.sum+b.lft);
        ryt = max(b.ryt,b.sum+a.ryt);
        sum = a.sum + b.sum;
        best = max( max(a.best,b.best), a.ryt+b.lft);
    }
} segtree[200005];
 
int sn,n,arr[50005];
 
 
node query(int t,int i,int j,int ri,int rj){
    if(ri==i && rj==j){
        return segtree[t];
    }
    int l = 2*t,mid = (i+j)/2;
    if(rj<=mid)
        return query(l,i,mid,ri,rj);
    if(ri>mid)
        return query(l+1,mid+1,j,ri,rj);
    node a,b,temp;
    a = query(l,i,mid,ri,mid);
    b = query(l+1,mid+1,j,mid+1,rj);
    temp.merge(a,b);
    return temp;
}
 
node build(int t,int i,int j){
    if(i == j){
        segtree[t].init(arr[i]);
        return segtree[t];
    }
    node a,b;
    int l=2*t,mid = (i+j)/2;
    a = build(l,i,mid);
    b = build(l+1,mid+1,j);
    segtree[t].merge(a,b);
    return segtree[t];
}
 
 
int main()
{
    int q,a,b;
    node temp;
   scanf("%d",&n);
   for(int i=1;i<=n;i++)
        scanf("%d",&arr[i]);
   build(1,1,n);
   scanf("%d",&q);
   while(q--){
       scanf("%d%d",&a,&b);
       temp = query(1,1,n,a,b);
       printf("%ld\n",temp.best);
   }
   return 0;
}
