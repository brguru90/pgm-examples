#include<stdio.h>

bool check_prime(int n);
int main()
{
	int n,i,j=2,f1=1,f2=1,f;
	scanf("%d",&n);
//	printf("%d ",1);
//	printf("%d ",j);
//	printf("%d ",1);
	
	for(i=3;i<n;i++)
	{		
		
		if(i%2==1)
		{			
			while(!check_prime(++j));
			if(i==n-1)
			printf("%d ",j);
		}
		else
		{
			f=f1+f2;
			f1=f2;
			f2=f;
			if(i==n-1)
			printf("%d ",f);
		}
		
	}
	return 0;
}
bool check_prime(int n)
{
	int i;
	bool flag=true;
	for(i=2;i<=n/2;i++)
		if(n%i==0)
			flag=false;
	return flag;
}
