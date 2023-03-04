#include <iostream>
#include <map>
#include<vector>
#include<string>
#include<algorithm>

using namespace std;


vector<vector<int> > anagrams( vector<string> &A) {
    
    map<string, vector<int> > hash;
    
    for(int i=0; i<A.size(); i++) {
        sort(A[i].begin(), A[i].end());
        if(hash.find(A[i])!=hash.end()) {
            hash[A[i]].push_back(i+1);
        } else {
            vector<int> temp;
            temp.push_back(i+1);
            hash[A[i]]=temp;
        }
    }
    vector<vector<int> > ans;
    for(map<string, vector<int> >::iterator itr=hash.begin(); itr!=hash.end(); itr++) {
        ans.push_back(itr->second);
    }
    return ans;
}

int main() {
	
	
	
}
