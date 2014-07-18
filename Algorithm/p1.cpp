#include <iostream>
#include <fstream>
#include <algorithm>
#include <functional>
#include <vector>

const float   FLT_EPSILON  = 1.192092896e-07F;

#define FLOAT_EQ(x,v) (((v - FLT_EPSILON) < x) && (x <( v + FLT_EPSILON)))

using namespace std;

class myclass {
        public:
        myclass(int index,int a, int b):i(index),w(a), l(b){d=w-l;di=1.0*w/l;}
		int i;// index
        int w;//weight
        int l;//length
		int d;//diff
		float di;
        bool operator > (const myclass &m)const {
			if(d > m.d){
				return true;
			}
			else if(d == m.d){
				return w > m.w;
			}
			else{
				return false;
			}
        }
		bool operator < (const myclass &m)const {
			return ( m > *this );
		}
};

bool greater_second(const myclass & m1, const myclass & m2) {
			if(m1.d > m2.d){
				return true;
			}
			else if(m1.d == m2.d){
				if(m1.w != m2.w){
					return m1.w>m2.w;
				}
				else {
					return m1.i < m2.i;
				}
			}
			else{
				return false;
			}
}

bool greater_third(const myclass & m1, const myclass & m2) {
			if(m1.di > m2.di){
				return true;
			}
			else if(FLOAT_EQ(m1.di,m2.di)){
				if(m1.w != m2.w){
					return m1.w>m2.w;
				}
				else {
					return m1.i < m2.i;
				}
			}
			else{
				return false;
			}
}

void getSUM(vector< myclass > &vect){
		int totalL =0;
		long long sum = 0;
		for(int i = 0 ; i < vect.size(); i ++) {
			totalL += vect[i].l;
			sum += vect[i].w * totalL;
			cout<<i<<" "<<vect[i].i<<" "<<"length:"<<vect[i].l<<" total l: "<<totalL<<" Sum: w*l="<<vect[i].w * totalL<< " SUM:"<<sum<<endl;
		}
		cout<<"Sum: "<<sum<<endl;
		cout<<" ok"<<sizeof(long long)<<endl;
}


int main(int argc, char*argv[]) {
        if(argc <2)
		{
			cout<<"Please input the jobs.txt as argument 1. "<<endl<<"Usage: "<<argv[0]<<" /your path/jobs.txt"<<endl;
			return 0;
		}
		ifstream infile(argv[1],ios::in);
		int total;
//		int w,l;
		infile>>total;
//		infile>>w>>l;
		cout<<total<<endl;
        vector< myclass > vect;
        for(int i = 0 ; i < total ; i ++){
			int w,l;
			infile>>w>>l;
            myclass my(i+1,w, l);
            vect.push_back(my);
        }
        for(int i = 0 ; i < vect.size(); i ++) 
        cout<<"("<<vect[i].i<<","<<vect[i].w<<","<<vect[i].l<<")\n";
//        sort(vect.begin(), vect.end());
//        cout<<"after sorted by first:"<<endl;
//        for(int i = 0 ; i < vect.size(); i ++) 
//        cout<<"("<<vect[i].i<<","<<vect[i].w<<","<<vect[i].l<<")\n";
//        cout<<"after sorted by second:"<<endl;
        sort(vect.begin(), vect.end(), greater_second);
        for(int i = 0 ; i < vect.size(); i ++) 
        cout<<"("<<vect[i].i<<","<<vect[i].w<<","<<vect[i].l<<")\n";
		getSUM(vect);
		
        sort(vect.begin(), vect.end(), greater_third);
//        for(int i = 0 ; i < vect.size(); i ++) 
//        cout<<"("<<vect[i].i<<","<<vect[i].w<<","<<vect[i].l<<")\n";
		getSUM(vect);
        return 0 ;
}