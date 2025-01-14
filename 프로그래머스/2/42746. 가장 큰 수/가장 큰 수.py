def solution(numbers):
    answer = ''
    
    ## 첫번째 풀이 : 조합으로 최댓값 찾기 했지만 런타임에러로 제출 실패 ㅜ
    # from itertools import permutations
    # nums = list(permutations(numbers, len(numbers)))
    # num_list = list(''.join(map(str,n))  for n in nums)

    
    # 두번째 풀이 : (블로그 참고)
    # [3,30,34] 처럼 숫자의 길이가 달라 정렬 시키면 [34,30,3] -> 34303 으로 나와서 땡
    # 각 숫자마다 3번씩 반복 시킴 [343434,303030,333] 여기서 앞 세자리로 비교하는 것으로 구현
    # numbers.sort(key = lambda x : (str(x)*3), reverse = True)
    # for n in numbers :
    #       answer += str(n)
    

    numbers = list(map(str, numbers))               # string으로 바꾸어서 비교
    numbers.sort(key = lambda x : x*3,reverse=True)  # 3번씩 반복하면 붙였을때 큰수 찾기 가능
    
    for i in numbers:             # 정렬된 리스트를 answer에 순서대로 더해줌
        answer += i

    return str(int(answer))