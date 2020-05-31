
    import java.util.*;

    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            int size = phone_book.length;
            int minSize = phone_book[0].length();
            int minIndex = 0;

            for(int i=1; i<size; i++) {
                if(phone_book[i].length()<minSize)  {
                    minSize = phone_book[i].length();
                    minIndex = i;
                }
            }

            for(int j=0; j<size; j++) {
                if(j==minIndex) {// 자기면 패스

                }
                else { // 다른 번호일때
                    String minNum = phone_book[minIndex];
                    String temp = phone_book[j].substring(0,minSize);

                    if(minNum.equals(temp)){ //앞 부분이 같으면
                        answer = false;
                        return answer;
                    } else {

                    }
                }
            }


            return answer;
        }
    }

