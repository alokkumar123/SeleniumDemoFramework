package com.qait.Trust.automation.tests;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int x=0, y=1,z,i,count=5;
System.out.println(x+""+y);
for(i=2;i<=count;++i)
{
	z=x+y;
	System.out.print(z);
	x=y;
	y=z;
}

}
}