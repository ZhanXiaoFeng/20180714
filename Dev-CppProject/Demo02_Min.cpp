#include<stdio.h>
int main(){
	int i,j, row=0,colum=0,min;
	//�������Ϊa[3][4]��һ����ά���� 
	int a[][4]={{1,2,3,4},{9,8,7,6},{-10,10,-5,2}};
	//����һ��ʼ��С��һ����Ϊa[0][0],��Ϊ�����еĵ�һ���� 
	min=a[0][0];
	for(i=0;i<3;i++) //����i<=2 
		for(j=0;j<4;j++)
			if(min>a[i][j]){//�õ�ǰ��minֵ��a[i][j]���αȽ� 
				min=a[i][j];
				row=i;
				colum=j;
			}
	printf("min=%d\nrow=%d\ncolum=%d\n",min,row,colum);
	return 0;
} 
