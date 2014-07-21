#include <iostream>
#include <fstream>
#include <algorithm>
#include <functional>
#include <vector>
#include <map>
#include <set>

#define VEX_NUM 500
using namespace std;

class Edge{
public:
	Edge(int _v1,int _v2,int _cost):v1(_v1),v2(_v2),cost(_cost){};
	bool operator < (const Edge &e)const {
		return this->cost < e.cost;
	}
	int v1,v2,cost;
};

typedef struct ConCom_ITEM {
	int v;
	ConCom_ITEM *p;
} ConCom_ITEM;
/*
class ConnectedComponent{
public:
	ConnectedComponent(){};
	void Init(){
		componentNum = VEX_NUM;
		for(int i=0;i<VEX_NUM;i++){
			m_ccItems[i].v = i+1;
			m_ccItems[i].p = &m_ccItems[i];
		}
		for(int i=0;i<VEX_NUM;i++){
			ConCom_ITEM* p = m_ccItems+i;
			cout<<" v1:"<<p->v<<" com:"<<p->p->v<<endl; 
		}
	};
	int Find(int v){
		ConCom_ITEM* p1 = m_ccItems+v-1;
		while(p1->v != p1->p->v){
			p1=p1->p;
		}
		cout<<"Find: "<<"v: "<<v<<" Comp:"<<p1->v<<endl;
		return p1->v;
	};
	void Union(int v1,int v2){
		ConCom_ITEM* p1 = m_ccItems+v1-1;
		ConCom_ITEM* p2 = m_ccItems+v2-1;
		while(p1->v != p1->p->v){
			cout<<"Union: "<<p1->v<<" p1->p->v"<<p1->p->v<<endl;
			p1 = p1->p;
		}
		while(p2->v != p2->p->v){
			p2 = p2->p;
		}
		
		p1->p = p2;
		cout<<"Union: p1->v"<<p1->v<<" After Union: p1->p->v:"<<p1->p->v<<endl;
		componentNum--;
	};
	int getComponentNum(){
		return componentNum;
	};
	
	map<int,set<int> > getSubComponent(){
		map<int,set<int> > result;
		for(int i=0;i<VEX_NUM;i++){
			set<int> setItem;
			int iFind = Find(i+1);
			if(result.find(iFind) != result.end()){
				setItem = result[iFind];
				cout<<"setItem.size:"<<setItem.size()<<endl;
			}
			ConCom_ITEM* p = &m_ccItems[i];
			while(p->v != p->p->v){
				cout<<"getSubComponent i= "<<i<<" p->v: "<<p->v<<" p->p->v "<<p->p->v<<endl;
				setItem.insert(p->v);
				p=p->p;
			}
			cout<<"getSubComponent p->v: "<<p->v<<endl;
			setItem.insert(p->v);
			result[iFind] = setItem;
		}
		return result;	
	}
	
private:
	int componentNum;
	ConCom_ITEM m_ccItems[VEX_NUM];
};
*/

class ConnectedComponent{
public:
	ConnectedComponent(){};
	void Init(){
		componentNum = VEX_NUM;
		for(int i=0;i<VEX_NUM+1;i++){
			m_ccItems[i] = i;
		}
	};
	int Find(int v){
		int tmp =v;
		while(tmp!=m_ccItems[tmp]){
			tmp=m_ccItems[tmp];
		}
		cout<<"Find: "<<"v: "<<v<<" Comp:"<<tmp<<endl;
		return tmp;
	};
	void Union(int v1,int v2){
		int tmp1 = v1;
		int tmp2 = v2;
		while(tmp1 != m_ccItems[tmp1]){
			tmp1 = m_ccItems[tmp1];
		}
		while(tmp2 != m_ccItems[tmp2]){
			tmp2 = m_ccItems[tmp2];
		}
		
		m_ccItems[tmp1] = tmp2;
		cout<<"Union: v1"<<tmp1<<" After Union: v2:"<<tmp2<<endl;
		componentNum--;
	};
	int getComponentNum(){
		return componentNum;
	};
	
	map<int,set<int> > getSubComponent(){
		map<int,set<int> > result;
		for(int i=1;i<VEX_NUM+1;i++){
			set<int> setItem;
			int iFind = Find(i);
			if(result.find(iFind) != result.end()){
				setItem = result[iFind];
				cout<<"setItem.size:"<<setItem.size()<<endl;
			}
			int tmp = i;
			while(tmp != m_ccItems[tmp]){
				cout<<"getSubComponent i= "<<i<<" tmp "<<tmp<<endl;
				setItem.insert(tmp);
				tmp=m_ccItems[tmp];
			}
			cout<<"getSubComponent com: "<<tmp<<endl;
			setItem.insert(tmp);
			result[iFind] = setItem;
		}
		return result;	
	}
	
private:
	int componentNum;
	int m_ccItems[VEX_NUM+1];
};

int main(int argc, char* argv[]){
	if(argc <2)
	{
		cout<<"Please input the clustering1.txt as argument 1. "<<endl<<"Usage: "<<argv[0]<<" /your path/clustering1.txt"<<endl;
		return 0;
	}
	int Graph[VEX_NUM+1][VEX_NUM+1]={0};
	ConnectedComponent myCC;
	myCC.Init();
	
	ifstream infile(argv[1],ios::in);
	int total;
	infile>>total;
	cout<<total<<endl;
	vector< Edge > vectEdge;
    while(!infile.eof()){
		int v1,v2,cost;
		infile>>v1>>v2>>cost;
		if(cost > 0){
			Edge m(v1,v2,cost);
//			cout<<v1<<" "<<v2<<" "<<cost<<endl;
			vectEdge.push_back(m);
			Graph[v1][v2] = cost;
			Graph[v2][v1] = cost;
		}
		cost = -1;
    }
	cout<<"total edges: "<<vectEdge.size()<<endl;
	sort(vectEdge.begin(), vectEdge.end());
	vector<Edge> vectMST;
	for(int i=0;i<vectEdge.size();i++){
		if(myCC.getComponentNum() == 1){
			break;
		}
		int v1 = myCC.Find(vectEdge[i].v1);
		int v2 = myCC.Find(vectEdge[i].v2);
		cout<<"v1 "<<v1<<" v2 "<<v2<<endl;
		if(v1!=v2){
			myCC.Union(v1,v2);
			vectMST.push_back(vectEdge[i]);
		}
				
	}
	
	cout<<"getComponentNum: "<<myCC.getComponentNum()<<endl;
	map<int,set<int> > ret = myCC.getSubComponent();
	cout <<"Size: "<<ret.size()<<endl;
	map<int,set<int> >::iterator iter  = ret.begin();
	for(;iter!=ret.end();iter++){
		cout<<"iter: "<<iter->first<<endl;
		set<int> setItem = iter->second;
		cout<<"iter: second size:"<<setItem.size()<<endl;
		set<int>::iterator itSet = setItem.begin();
		for(;itSet!=setItem.end();itSet++){
			cout<<" "<<*itSet<<";";
		}
		cout<<endl;
	}
	
	cout<<"MST size:"<<vectMST.size()<<endl;
	long long costMst = 0;
	for(int i=0;i<vectMST.size();i++){
		costMst+=vectMST[i].cost;
		cout<<"Last edge : v1 "<<vectMST[i].v1<<" v2: "<<vectMST[i].v2<<" cost: "<<vectMST[i].cost<<endl;
	}
	cout<<"Last edge : v1 "<<vectMST[vectMST.size()-1].v1<<" v2: "<<vectMST[vectMST.size()-1].v2<<" cost:"<<vectMST[vectMST.size()-1].cost<<endl;
	cout<<"Total Cost of MST:"<<costMst<<endl;
	
	
	return 0;
}