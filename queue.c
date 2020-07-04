#include<stdio.h>
#include<stdlib.h>
#define MAX 5
int rear,front;
int queue[MAX];
void init()
{
	int i;
	rear=-1;
	front=-1;
	for(i=0;i<MAX;++i)
		queue[i]=-1;
}
int isfull()
{
	if(rear==MAX-1)
		return 1;
	else
		return 0;
}
int isempty()
{
	if(rear == front)
		return 1;
	else
		return 0;
}
void push(int val)
{
	rear=rear+1;
	queue[rear]=val;
	printf("IN PUSH rear value %d\n",rear); 
}
void pop()
{
	front=front+1;
	queue[front]=-1;
	printf("IN POP front value %d\n",front);
}
int peek()
{
	return queue[front+1];
}
void displaylist()
{
	int i;
	for(i=0;i<=rear;++i)
		printf("Elemennts are : %d\n",queue[i]);
}
int main()
{
	int choice,element,val,r;
	init();
	do
	{
		printf("1.Push\n2.POP\n3.PEEK\n4.Display All Numbers\n5.Exit\n");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				if(isfull())
					printf("Queue If Full\n");
				else
				{
					printf("Enter The Element u want to insert\n");
					scanf("%d",&element);
					push(element);
					printf("Element Inserted\n");
				}
				break;
			case 2:
				if(isempty())
					printf("Queue is empty\n");
				else
				{
					val=peek();
					pop();
					printf("Element POP value is %d\n",val);
				}
				break;
			case 3:
				r=peek();
				printf("Value at PEEK %d\n",r);
				break;
			case 4:
				displaylist();
				break;
			case 5:
				exit(0);
				break;
		}
	}while(choice!=5);
}



























