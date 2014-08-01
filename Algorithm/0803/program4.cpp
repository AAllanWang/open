#include<iostream>
#include<limits>
#include<fstream> 

using namespace std;

int main(int argc, char* argv[]){
    if(argc < 2){
        cout<<"Please input the graph file."<<endl<<"Usage: "<<argv[0]<<" /your path/graph.txt"<<endl;
        return 0;
    }

    static int dist[1000][1000]={numeric_limits<int>::max()};
    cout<<dist[0][100]<<endl;
    cout<<numeric_limits<int>::max()<<endl;

    for(int i=0;i<1000;i++)
        for(int j=0;j<1000;j++){
            dist[i][j] = numeric_limits<int>::max();
        }

    for(int i=0;i<1000;i++){
        dist[i][i] = 0;
    }

    ifstream infile(argv[1],ios::in);

    int verticeNum =0;
    int edgeNum =0;
    infile>>verticeNum>>edgeNum;
    cout<<"Vertice Num is "<<verticeNum<<" .Edge num is "<<edgeNum<<endl;

    int from = 0;
    int to = 0;
    int weight = 0;
    for(int i=0;i<edgeNum;i++){
       infile>>from>>to>>weight;
       dist[from-1][to-1] = weight;
//       cout<<"("<<from<<","<<to<<") = "<<weight<<endl; 
    }

   
     

    for(int k=0;k<verticeNum;k++)
        for(int i=0;i<verticeNum;i++)
            for(int j=0;j<verticeNum;j++){
                if(dist[i][k] != numeric_limits<int>::max() && dist[k][j] != numeric_limits<int>::max()){
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }

    int min = numeric_limits<int>::max();
    for(int i = 0;i<verticeNum;i++){
        for(int j = 0;j<verticeNum;j++){
            if(i != j){
                if(min>dist[i][j]){
                    min = dist[i][j];
                } 
            }
        }
    }
    

    cout<<"Mininum shortest is "<<min<<endl;
    for(int i=0;i<verticeNum;i++){
        if(dist[i][i] < 0){
            cout<<"This graph has negative cost cycle! "<<i<<" "<<dist[i][i]<<endl;
//            break;
        }
    }
    infile.close();
    return 0;
}
