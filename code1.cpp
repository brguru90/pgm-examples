#include<stdio.h>

int main()
{
	int n=36;
	int i,j,a=0,c=0;
	for(i=1;i<n;i++)
	{
		for(j=1;j<n;j++)
		{
			if((i*j)%n==1)
			{
				printf("%d ",j);
				c++;
			}
		}
	}
	printf("\n%d",c);
	return 0;
}
