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
    print(getMyDivisor(yellow))
    for i in getMyDivisor(yellow):
        print((((i+2) * 2) + (yellow // i) *2) )
        if( (((i+2) * 2) + (yellow // i) *2) == brown ) :
            answer.append(i+2)
            answer.append((yellow // i) + 2)
            break
    
    answer.sort(reverse=True)

    return answer