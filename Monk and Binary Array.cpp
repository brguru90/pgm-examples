#include<iostream>
#include<math.h>
using namespace std;

int main()
{
	int n;
	long c=0;
	cin>>n;
	int a[n];
	bool b=true;
	for(int i=0;i<n;i++)
		cin>>a[i];
	
	for(int i=0;i<n;i++)
	{
		if(a[i]==0 && a[i+1]==1 && i+1<n && b)
		{
			a[i]=1;
			a[i+1]=0;
			b=false;
			cout<<"Flip"<<endl;
		}
		if(a[i]==1)
			c+=pow(2,n-i-1);
	}
	for(int i=0;i<n;i++)
	cout<<a[i]<<" ";
	cout<<endl<<c;
	return 0;
}
