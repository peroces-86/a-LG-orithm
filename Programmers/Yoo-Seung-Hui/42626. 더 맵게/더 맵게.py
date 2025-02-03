import heapq

def solution(scoville, K):
    answer = 0
    
    # 최소 힙 (최소로 정렬)
    heapq.heapify(scoville)
    
    # 모든 음식을 다 섞을때까지 반복
    while len(scoville) > 1 :
        
        # 가장 맵지 않은 음식 추출
        first = heapq.heappop(scoville)
        
        # K보다 크면 바로 리턴
        if first >= K :
            return answer
        
        # 두 번째로 매운 음식 
        second = heapq.heappop(scoville)
        
        # 섞어
        scov = first + (second * 2)
        answer +=1
        
        # 힙에 넣어
        heapq.heappush(scoville, scov)
        
        if scoville[0] >= K :
            return answer

    
    return -1
    
#     while len(scoville) > 1:
#         scoville.sort()


#         if scoville[0] + (scoville[1] * 2) >= K :
#             answer += 1
#             return answer
#         else :
#             answer += 1
#             scoville.append(scoville[0] + (scoville[1] * 2))
#             scoville = scoville[2:]
        
        
#     return -1