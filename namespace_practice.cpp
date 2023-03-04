#include <iostream>

int p=1000;
namespace A{
	int p=10;
	
	
	//	int p=100;
		const int foo() {
			int p=5;
			std::cout<<"inner namespace - "<<::p<<std::endl;
			return p++;
		}
	
}

using namespace std;
int main() {
	cout<<::p<<endl;
	cout<<A::p<<endl;
	int t= A::foo();
	cout<<++t;
	return 0;
}
