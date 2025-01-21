def solution(s):
    # answer str으로 선언
    answer = ''
    
    # eng_list 선언
    eng_list = ['zero','one','two','three',
               'four','five','six','seven',
               'eight','nine']
    
    # 영어로 되어 있는거 숫자로 반환할 str 선언
    engton = ''
    
    # 문자열 앞에서 부터
    for i in s :
        
        # 알파벳이면
        if i.isalpha():
            
            # 영어 문자열에 추가해주고
            engton += i
            
            # 해당 영문자가 eng_list 에 포함되어 있으면 
            if engton in eng_list :
                
                # 해당 영문자의 인덱스를 문자열로 추가해주기
                answer += str(eng_list.index(engton))
                # 다음 영문자를 숫자로 변환하기 위해 비워주기
                engton = ''
                
        # 알파벳 아니고 숫자면
        else : 
            # 그냥 추가
            answer += i
            
        
    return int(answer)