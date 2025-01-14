#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;

    answer.push_back(arr.front());
    
    for(vector<int>::iterator itr = arr.begin()+1; itr != arr.end(); itr++){
        if(answer.back()!=*itr){
            answer.push_back(*itr);
        }
    }

    return answer;
}