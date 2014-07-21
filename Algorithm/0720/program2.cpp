#include <iostream>
#include <fstream>
#include <algorithm>
#include <functional>
#include <vector>
#include <map>
#include <set>
#include <time.h>

#define VEX_NUM 200000
using namespace std;

class Edge{
public:
	Edge(int _v1,int _v2,int _cost):v1(_v1),v2(_v2),cost(_cost){};
	bool operator < (const Edge &e)const {
		return this->cost < e.cost;
	}
	int v1,v2,cost;
};


class ConnectedComponent{
public:
	ConnectedComponent(){};
	void Init(){
		componentNum = VEX_NUM;
		for(int i=0;i<VEX_NUM;i++){
			m_ccItems[i] = i;
		}
	};
	int Find(int v){
		int tmp =v;
		while(tmp!=m_ccItems[tmp]){
			tmp=m_ccItems[tmp];
		}
		m_ccItems[v] = tmp;
		//cout<<"Find: "<<"v: "<<v<<" Comp:"<<tmp<<endl;
		return tmp;
	};
	void Union(int v1,int v2){
		int tmp1 = Find(v1);
		int tmp2 = Find(v2);
		if(tmp1 != tmp2){
			m_ccItems[tmp1] = tmp2;
			//cout<<"Union: v1"<<tmp1<<" After Union: v2:"<<tmp2<<endl;
			componentNum--;
		}
	};
	int getComponentNum(){
		return componentNum;
	};
	
	set<int> getSubSet(){
		set<int> setRet;
		for(int i=0;i<VEX_NUM;i++){
			setRet.insert(Find(i));
		}
		return setRet;
	
	}
	map<int,set<int> > getSubComponent(){
		map<int,set<int> > result;
		for(int i=0;i<VEX_NUM;i++){
			set<int> setItem;
			int iFind = Find(i);
			if(result.find(iFind) != result.end()){
				setItem = result[iFind];
				//cout<<"setItem.size:"<<setItem.size()<<endl;
			}
			int tmp = i;
			while(tmp != m_ccItems[tmp]){
				//cout<<"getSubComponent i= "<<i<<" tmp "<<tmp<<endl;
				setItem.insert(tmp);
				tmp=m_ccItems[tmp];
			}
			//cout<<"getSubComponent com: "<<tmp<<endl;
			setItem.insert(tmp);
			result[iFind] = setItem;
		}
		return result;	
	}
	
private:
	int componentNum;
	int m_ccItems[VEX_NUM];
};

class Utility{
public:
	int getReverseBitData(int data,int bitPos){
		int ret = 0;
		int mask = (1<<bitPos);
		if(data & mask){
			ret = ((~mask)&data)&0xFFFFFF;
		}
		else{
			ret = (mask | data)&0xFFFFFF;
		}
		return ret;
	};
	
	vector<int> getDistance1Data(int data){
		vector<int> vecRet ;
		for(int i=0;i<24;i++){
			int val = getReverseBitData(data,i);
			vecRet.push_back(val);
		}
		return vecRet;
	};
	
	vector<int> getDistance2Data(int data){
		vector<int> vecRet;
		for(int i=0;i<24;i++){
			for(int j = i+1;j<24;j++){
				int val = getReverseBitData(data,i);
				val = getReverseBitData(val,j);
				vecRet.push_back(val);
			}
		}
		return vecRet;
	};
	
};

int main(int argc, char* argv[]){
	if(argc <2)
	{
		cout<<"Please input the clustering1.txt as argument 1. "<<endl<<"Usage: "<<argv[0]<<" /your path/clustering1.txt"<<endl;
		return 0;
	}
	int HufmanVex[VEX_NUM]={0};
	time_t tBegin = time(NULL);

	ConnectedComponent myCC;
	myCC.Init();
	
	ifstream infile(argv[1],ios::in);
	int vexNum,bitNum;
	infile>>vexNum>>bitNum;
//	cout<<vexNum<<" "<<bitNum<<endl;
	map<int,vector<int> > mapVexValue;
	vector< Edge > vectEdge;
	for(int i=0;i<vexNum;i++){
		int val = 0;
		int input = 0;
		vector<int> vecVex;
		for(int j=0;j<bitNum;j++){
			infile>>input;
			val+=(input<<(bitNum - j -1));
		}
		//cout<<"index :"<<i<<" value: "<<val<<endl;
		HufmanVex[i] = val&0xFFFFFF;
		if(mapVexValue.find(val)!=mapVexValue.end()){
			//cout<<"Exist:"<<" Value:"<<val<<endl;
			vecVex = mapVexValue[val];
			for(int k = 0;k<vecVex.size();k++){
				//the distance 0 edge
				Edge e(i,vecVex[k],0);
				vectEdge.push_back(e);
			}
		}
		vecVex.push_back(i);
		
		mapVexValue[val]=vecVex;
		//cout<<"index:"<<i<<" value: "<<val<<endl;
		
	}
/*
	map<int,vector<int> >::iterator itermap = mapVexValue.begin();
	
	int number = 0;
	for(;itermap!=mapVexValue.end();itermap++){
		vector<int> vecIndex = itermap->second;
		//cout<<"Value: "<<(itermap->first)<<" number:"<<vecIndex.size()<<endl;
		number+=vecIndex.size();
		if(vecIndex.size()>=2){
		//cout<<"Value: "<<(itermap->first)<<" number:"<<vecIndex.size()<<endl;
			for(int i=0;i<vecIndex.size();i++){
				//cout<<"i= "<<i<<" index ="<<vecIndex[i]<<endl;
				for(int j=i+1;j<vecIndex.size();j++){
					Edge e(vecIndex[i],vecIndex[j],0);
					//find the edges , distance = 0
					//cout<<"0 edge v1: "<<e.v1<<" v2: "<<e.v2<<" cost:"<<e.cost<<endl;
					vectEdge.push_back(e);
				}
			}
			//cout<<"Value: "<<(itermap->first)<<" number:"<<vecIndex.size()<<endl;
		}
	}
*/
//	cout<<"size:"<<mapVexValue.size()<<endl;
//	cout<<"total size:"<<number<<endl;

	Utility util;
//	cout<<"Test:"<<util.getReverseBitData(4,0)<<endl;
//	cout<<"Test:"<<util.getReverseBitData(util.getReverseBitData(4,0),0)<<endl;
	
	for(int i=0;i<VEX_NUM;i++){
		vector<int> vDistance1 = util.getDistance1Data(HufmanVex[i]);
//		cout<<"Value:"<<HufmanVex[i]<<" Size: "<<vDistance1.size()<<endl;
		for(int j=0;j<vDistance1.size();j++){
			
			if(mapVexValue.find(vDistance1[j]) != mapVexValue.end()){
				vector<int> vt = mapVexValue[vDistance1[j]];
				for(int k=0;k<vt.size();k++){
					//find the edges , distance = 1
					Edge e(i,vt[k],1);
					vectEdge.push_back(e);
				}
			}
		}
	}
	
	
	
	for(int i=0;i<VEX_NUM;i++){
		vector<int> vDistance2 = util.getDistance2Data(HufmanVex[i]);
		//cout<<"Value:"<<HufmanVex[i]<<" Size: "<<vDistance2.size()<<endl;
		for(int j=0;j<vDistance2.size();j++){
			
			if(mapVexValue.find(vDistance2[j]) != mapVexValue.end()){
				vector<int> vt = mapVexValue[vDistance2[j]];
				for(int k=0;k<vt.size();k++){
					//find the edges , distance = 2
					Edge e(i,vt[k],2);
					vectEdge.push_back(e);
				}
			}
		}
	}
	
	cout<<"total edge size:"<<vectEdge.size()<<endl;
	for(int i=0;i<vectEdge.size();i++){
		int v1 = myCC.Find(vectEdge[i].v1);
		int v2 = myCC.Find(vectEdge[i].v2);
		//cout<<"v1 "<<v1<<" v2 "<<v2<<endl;
		if(v1!=v2){
			myCC.Union(v1,v2);
		}		
	}
	
	//map<int,set<int> > ret = myCC.getSubComponent();
	//cout <<"Component Size: "<<ret.size()<<endl;
	//set<int> setRet = myCC.getSubSet();
	//cout<<"cluster size ="<<setRet.size();
      cout<<"cluster size ="<<myCC.getComponentNum()<<endl;
	
	

	/*
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
	
	*/
	time_t tEnd = time(NULL);
	cout<<"Seconds:"<<tEnd-tBegin<<endl;
	cout<<"Used Minutes:"<<(tEnd-tBegin)/60<<" Seconds:"<<((tEnd-tBegin)%60)<<endl;
	return 0;
}