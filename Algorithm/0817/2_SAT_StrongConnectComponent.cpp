#include<iostream>
#include<fstream>
#include<set>
#include<map>
#include <time.h>
using namespace std;

enum _CLOCK{
	WHITE=0,
	GRAY,
	BLACK
};

class My_2SAT{

private:
	map<int,set<int> > G;
	map<int,set<int> > G_t;
	map<int,int>f;
	map<int,_CLOCK> color;
	map<int,int> pi;
	map<int,set<int> > scc; //Strong Connect Component
	int t;

void DFS_VISIT_G(int u){
	color[u] = GRAY;
	t +=1;
	set<int>::iterator iter=G[u].begin();
	for(;iter != G[u].end();iter++){
		if(color[*iter] == WHITE){
			DFS_VISIT_G(*iter);
		}
	}
	color[u] = BLACK;
	t+=1;
	f[t]=u;
};

void DFS_G(){
	map<int,enum _CLOCK>::iterator iter = color.begin();
	for(;iter!=color.end();iter++){
		if(iter->second == WHITE){
			DFS_VISIT_G(iter->first);
		}
	}
};

void DFS_VISIT_G_t(int u){
	color[u] = GRAY;
	set<int>::iterator iter=G_t[u].begin();
	for(;iter != G_t[u].end();iter++){
		if(color[*iter] == WHITE){
			pi[*iter] = u;
			DFS_VISIT_G_t(*iter);
		}
	}
	color[u] = BLACK;
}

void DFS_G_t(){
	//initialize all to White
	map<int,_CLOCK>::iterator iter_color = color.begin();
	for(;iter_color!=color.end();iter_color++){
		iter_color->second = WHITE;
	}
	map<int, int>::reverse_iterator  iter = f.rbegin();
	for(; iter != f.rend(); iter++){
		//cout<<"first = "<<iter->first<<" second = "<<iter->second<<endl;
		if(color[iter->second] == WHITE){
			DFS_VISIT_G_t(iter->second);
		}
		
	}
}


void getSCC(){
	map<int,int>::iterator iter = pi.begin();
	for(;iter!=pi.end();iter++){
		int u = iter->first;
		int v = iter->second;
		while(pi.find(v) !=pi.end()){
			v = pi[v];
		}
		
		map<int,set<int> >::iterator iter_scc = scc.find(v);
		if( iter_scc!= scc.end()){
			iter_scc->second.insert(u);
			iter_scc->second.insert(v);
		}
		else{
			set<int> s;
			s.insert(u);
			s.insert(v);
			scc[v] = s;
		}
	}
}

int isSCC_2SAT(){
	bool ret = 1;
	map<int,set<int> >::iterator iter = scc.begin();
	for(;iter != scc.end();iter++){
		set<int> &s = iter->second;
		int size_b = s.size();
		set<int>::iterator iterSet = s.begin();
		for(;iterSet != s.end();iterSet++){
			int u = *iterSet;
			u= 0-u;
			if(s.find(u) != s.end()){
				return 0;
			}
		}

	}
	return ret;
}

void addEdgeToGraph(int u,int v,map<int,set<int> > &G){
	map<int,set<int> >::iterator iter = G.find(u);
	if(iter != G.end()){
		iter->second.insert(v);
	}
	else{
		set<int> s;
		s.insert(v);
		G[u] = s;
	}
}

public:
	My_2SAT(){
		t = 0;
	};
	~My_2SAT(){
		G.clear();
		G_t.clear();
		f.clear();
		color.clear();
		pi.clear();
		scc.clear();
	};
int do_main(char* filePath){
	int num = 0;
	ifstream infile(filePath,ios::in);
	infile>>num;
//	cout<<"Number: "<<num<<endl;
	
	for(int i=0;i<num;i++){
		//read data from file ,and generate G and G_t;
		//As well, initialize color;
		int u = 0;
		int v = 0;
		infile>>u>>v;
		//cout<<"u="<<u<<" v="<<v<<endl;
		addEdgeToGraph(0-u,v,G);
		addEdgeToGraph(0-v,u,G);
		addEdgeToGraph(v,0-u,G_t);
		addEdgeToGraph(u,0-v,G_t);
		
		color[u] = WHITE;
		color[v] = WHITE;
		color[0-u] = WHITE;
		color[0-v] = WHITE;
	}
	
	//prepare to get SCC
	DFS_G();
	DFS_G_t();
	getSCC();
	int result = isSCC_2SAT();
//	cout<<"Result: "<<result<<endl;
	infile.close();
	return result;
}

};

int main(int argc, char* argv[]){

	if(argc < 2){
        cout<<"Please input file."<<endl<<"Usage: "<<argv[0]<<" /your path/2sat.txt /your path/2sat.txt /your path/2sat.txt ..."<<endl;
        return 0;
    }
	time_t tBegin = time(NULL);
	cout<<"The Result is "<<endl;
	for(int i = 1;i<argc;i++){
		My_2SAT* pMy_2SAT = new My_2SAT();
		cout<<pMy_2SAT->do_main(argv[i]);
		delete pMy_2SAT;
	}
	cout<<endl;

	time_t tEnd = time(NULL);
	cout<<"Seconds:"<<tEnd-tBegin<<endl;
	cout<<"Used Minutes:"<<(tEnd-tBegin)/60<<" Seconds:"<<((tEnd-tBegin)%60)<<endl;
	return 0;
}