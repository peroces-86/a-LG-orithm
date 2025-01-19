class Solution {
    public int solution(String s) {

        String answer = "";
        // 'a' 보다 크면 무조건 알파벳
        for(int i = 0; i < s.length();){
            char c = s.charAt(i);
            if(c >= 'e'){
                if(c >= 'f'){
                    if(c >= 'n'){
                        if(c >= 'o'){
                            if(c >= 's'){
                                if(c >= 't'){
                                    // 0
                                    if(c == 'z') {
                                        answer += "0";
                                        i += 4;
                                        continue;
                                    }
                                    // two or three
                                    else{
                                        if(s.charAt(i+1) == 'w'){
                                            answer += "2";
                                            i += 3;
                                            continue;
                                        }
                                        else{
                                            answer += "3";
                                            i += 5;
                                            continue;
                                        }
                                    }
                                }
                                // six or seven
                                else{
                                    if(s.charAt(i+1) == 'i'){
                                        answer += "6";
                                        i += 3;
                                        continue;
                                    }
                                    else{
                                        answer += "7";
                                        i += 5;
                                        continue;
                                    }
                                    
                                }
                                
                            }
                            // 무조건 1
                            else{
                                answer += "1";
                                i += 3;
                                continue;
                            }
                        }
                        // 무조건 nine
                        else{
                            answer += "9";
                            i += 4;
                            continue;
                        }
                        
                    }
                    // five or four
                    else{
                        if(s.charAt(i+1) == 'o'){
                            answer += "4";
                        }
                        else{
                            answer += "5";
                        }
                        i += 4;
                        continue;
                    }
                }
                // 무조건 eight
                else{
                    answer += "8";
                    i += 5;
                    continue;
                }
            }
            else{
                answer += String.valueOf(s.charAt(i));
                i++;
            }
        }
        
        return Integer.parseInt(answer);
    }
}