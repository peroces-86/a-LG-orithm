def solution(sizes):
    wmax = 0
    hmax = 0
    for s in sizes:
        s.sort()
        
        if wmax < s[0]:
            wmax = s[0]
        
        if hmax < s[1]:
            hmax = s[1]
        
    return wmax * hmax