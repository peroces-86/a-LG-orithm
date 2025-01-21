def solution(nums):
    answer = 0
    
    # 중복을 제거한 list = 포켓몬 종류의 개수
    s = list(set(nums))
    

    # 가져갈 수 있는 포켓몬 수 (len(nums)//2) 보다 포켓몬 종류의 수가 많으면 :
    # 가져갈 수 있는 포켓몬 수가 최대 종류의 개수
    if len(s) >= len(nums)//2 :
        return len(nums) // 2
    # 반대로 적으면
    # 최대 종류의 수만 리턴
    else :
        return len(s)
    
    #  다른 사람 풀이 
    #  return min(len(ls)/2, len(set(ls)))
    #  반복문 말고 min()으로 더 작은 값 리턴
    
