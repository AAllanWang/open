#include <iostream>
#include <fstream>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <functional>
#include <vector>
#define MAX 1000
#define MAXCOST 0x7fffffff
using namespace std;
 
int graph[MAX][MAX];

class CloseEdge{
public:
	int x;
	int y;
	int cost;
	CloseEdge(int a,int b, int c):x(a),y(b),cost(c){};
	bool operator < (const CloseEdge &m)const {
		return cost < m.cost;
	}
};

CloseEdge getMinCloseEdge(vector< CloseEdge > &vect){
	CloseEdge ret =vect[0];
	for(int i = 1 ; i < vect.size(); i ++) {
		if(vect[i]<ret){
			ret = vect[i];
		}
	}
	cout<<"x:"<<ret.x<<" y:"<<ret.y<<" cost:"<<ret.cost<<endl;
	return ret;
}

long long Prim(int graph[][MAX], int n)
{
	long long sum = 0;
	int U[MAX] = {0};
	int Vex[MAX] ={0};
	int num = 1;
	U[1] = 1;
	Vex[0]=1;
	vector< CloseEdge > vect_ret;
	for(num = 1;num < n ;){
		vector< CloseEdge > vect;
		for(int index = 0;index < num;index++){
			int i = Vex[index];
			for(int j = 1 ;j <= n;j++){
				if(U[j] == 0){
					CloseEdge ce(i,j,graph[i][j]);
					vect.push_back(ce);
				}
			}
		}
		if(vect.size()!=0)
		{
			CloseEdge ret = getMinCloseEdge(vect);
			vect_ret.push_back(ret);
			U[ret.y] = 1;
			Vex[num++] = ret.y;
			sum+=ret.cost;
		}
		else
		{
			cout <<"num: "<<num<<endl;
			break;
		}
	}
	
	return sum;
}
 
int main(int argc, char*argv[])
{
	int i, j, k, m, n;
	int x, y, cost;

        if(argc <2)
		{
			cout<<"Please input the edges.txt as argument 1. "<<endl<<"Usage: "<<argv[0]<<" /your path/edges.txt"<<endl;
			return 0;
		}
	ifstream infile(argv[1],ios::in);
	int edge;
	infile>>m>>edge;

    cout<<" points num:"<<m<<" edges num:"<<edge<<endl;
	/* 初始化图，所有节点间距离为无穷大 */
	for (i = 1; i <= m; i++)
	{
		for (j = 1; j <= m; j++)
		{
			graph[i][j] = MAXCOST;
		}
	}
 
	/* 读取边信息 */
	for(int i = 0;i<edge;i++){
		infile>>x>>y>>cost;
		cout<<x<<" "<<y<<" "<<cost<<endl;
		graph[x][y] = cost;
		graph[y][x] = cost;
	}
 
 	for (i = 1; i <= m; i++)
	{
		for (j = 1; j <= m; j++)
		{
			//cout<<"( "<<i<<","<<j<<", "<<graph[i][j]<<")"<<endl;
		}
	}
	/* 求解最小生成树 */
	long long Total = Prim(graph, m);
 
	/* 输出最小权值和 */
	printf("Total:%d\n", Total);
 
	return 0;	
}