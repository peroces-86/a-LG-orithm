# 약수 구하기 함수
def getMyDivisor(n):

    divisorsList = []

    for i in range(1, int(n**(1/2)) + 1):
        if (n % i == 0):
            divisorsList.append(i) 
            if ( (i**2) != n) : 
                divisorsList.append(n // i)

    divisorsList.sort()
    return divisorsList
        
def solution(brown, yellow):
    answer = []
    
    # 노란색 개수로 약수 리스트 
    for i in getMyDivisor(yellow):
        
        # (노란색 가로 길이 + 2) x 2 
        # + (노란색 세로 길이) X 2 의 개수가 갈색 개수랑 똑같으면 
        # 노란색 가로 + 2 , 노란색 세로 + 2 행렬이 됨
        if( (((i+2) * 2) + (yellow // i) *2) == brown ) :
            answer.append(i+2)
            answer.append((yellow // i) + 2)
            break
    
    # 내림차순으로 정렬 해서 리턴
    answer.sort(reverse=True)

    return answer