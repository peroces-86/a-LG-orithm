def solution(n, lost, reserve):
    cnt = 0 
    
    lost.sort()
    reserve.sort()
    
    
    for l in lost[:] : # 파이썬 얕은 복사
        # 여벌 체육복 가진 학생이 도난 당한 경우 check
        if l in reserve :
            lost.remove(l)
            reserve.remove(l)
            
    # 체육복 빌려주기
    for r in reserve :
        # 앞번호 한테 빌려주기
        if r-1 in lost :
            lost.remove(r-1)
        # 뒷번호 빌려주기
        elif r+1 in lost :
            lost.remove(r+1)
            
    return n - len(lost)