#include<iostream>
#include<set>
#include<map>
#include<limits>
#include<fstream>

#include <cmath>

using namespace std;

void cmb (int depth, int index, int n, int m, int* buffer,set<int> &result)
{
    if (depth > m-1)
    {
        unsigned long int num = 0;
        for (int j=0; j<m; j++)
        {
            //cout << buffer[j];
             //generate an integer corresponding to this element
            num = num | (1<<(buffer[j]-1));
        }
		num = ((num<<1)|1);
       //cout << ": " << num << endl;
	   result.insert(num);
    }
    else
    {
        for (int p=index; p < n-m+1 + depth; p++)
        {
            buffer[depth] = p+1;
            cmb(depth+1, p+1, n, m, buffer,result);
        }
    }
}

set<int> getSubSet(int n,int k)
{
	int buffer[32] = {0};
	set<int> ret;
	cmb(0,0,n-1,k-1,buffer,ret);
	return ret;
}

typedef struct point_t{
	double x;
	double y;
} POINT;

double getDist(POINT p1, POINT p2)
{
	double ret = 0.0f;
	ret = sqrt(pow(p1.x-p2.x,2)+pow(p1.y-p2.y,2));
	return ret;
}

int getKey(int s, int k,int verticeNum){
	int key;
	key = k;
	key = key<<verticeNum;
	key = key | s;
	return key;
}

int getSet_s_without_k(int s, int k){
	int t = s;
	int p = 1<<(k-1);
	if(t&p){
		t = t & (~p);
	}
	return t;
}

class MyStoreItem{
public:
	int m;
	map<int,double> A;
};


int main(int argc, char* argv[])
{
    if(argc < 2){
        cout<<"Please input file."<<endl<<"Usage: "<<argv[0]<<" /your path/tsp.txt"<<endl;
        return 0;
    }

	
	int verticeNum = 0;
	ifstream infile(argv[1],ios::in);
	infile>>verticeNum;
	cout<<"Vertice Number: "<<verticeNum<<endl;
	POINT* point = new POINT[verticeNum+1];
	double **dist = new double* [verticeNum+1];
	for(int i=0;i<= verticeNum;i++){
		dist[i] = new double[verticeNum+1];
	}
	
	for(int i=1;i<=verticeNum;i++){
		infile>>point[i].x>>point[i].y;
		cout<<"x: "<<fixed<<point[i].x<<" y: "<<fixed<<point[i].y<<endl;
	}
	
	infile.close();
	
	for(int i=1;i<=verticeNum;i++){
		for(int j=1;j<=verticeNum;j++){
			if(i == j){
				dist[i][j] = 0.0f;
			}
			else{
				dist[i][j] = getDist(point[i],point[j]);
			}
			cout<<i<<" -- "<<j<<"  distance: "<<dist[i][j]<<endl;
		}
	}
	
	MyStoreItem **pmsi = new MyStoreItem* [2];
	pmsi[0] = new MyStoreItem;
	pmsi[0]->m = 1;
	pmsi[0]->A[getKey(1,1,verticeNum)] = 0.0f;
//	map<int,double > A;
//	A[getKey(1,1,verticeNum)] = 0.0f;
	
	for(int m=2;m<=verticeNum;m++){
		cout<<"m= "<<m<<endl;
		MyStoreItem *ps = new MyStoreItem;
		ps->m = m;
		if(m>2){
			delete pmsi[0];
			pmsi[0] = pmsi[1];
		}
		pmsi[1] = ps;
		set<int> subSet = getSubSet(verticeNum,m);
		for(set<int>::iterator iterSet = subSet.begin();iterSet != subSet.end();iterSet++){
			int setInt = *iterSet;
			for(int j = 2;j<=verticeNum;j++){
				if(setInt &(1<<(j-1))){
					int jKey = getKey(setInt,j,verticeNum);
					double min = numeric_limits<double>::max();
					for(int k = 1;k<=verticeNum;k++){
						if(setInt &(1<<(k-1))){
							if(k != j){
								int kkey = getKey(getSet_s_without_k(setInt,j),k,verticeNum);
								if(pmsi[0]->A.find(kkey) != pmsi[0]->A.end()){
									if(min > pmsi[0]->A[kkey] + dist[k][j]){
										min = pmsi[0]->A[kkey]+ dist[k][j];
									}
								}
							}
						}
					}
					pmsi[1]->A[jKey] = min;
				}
			}
		}
		
	}
	cout<<"To calculate the min value. "<<endl;
	set<int> subret = getSubSet(verticeNum,verticeNum);
	for(set<int>::iterator iter = subret.begin();iter != subret.end();iter++){
		int setInt = *iter;
		cout<<" C(25,25)"<<setInt<<endl;
		double minDist = numeric_limits<double>::max();
		for(int j =2;j<=verticeNum;j++){
			int jkey = getKey(setInt,j,verticeNum);
			if(pmsi[1]->A.find(jkey) != pmsi[1]->A.end()){
				if(minDist > pmsi[1]->A[jkey]+ dist[j][1]){
					minDist = pmsi[1]->A[jkey]+ dist[j][1];
				}
			}
		}
		cout<<"Min Distance = "<<minDist<<endl;
	}
	
	
	
	for(int i=0;i<= verticeNum;i++){
		delete[] dist[i];
	}
	delete[] dist;
	delete[] point;
	
	delete pmsi[0];
	delete pmsi[1];
	delete[] pmsi;
    return 0;
}

