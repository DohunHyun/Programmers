
import java.util.*;

class Solution {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "hhh";
        String[] words = {"hhh", "hht"};
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {

        int[] check = new int[words.length];

        return find(begin, target, words, 0, check);
    }

    public static class Node {
        String word;
        int edge;
        public  Node (String word, int edge) {
            this.edge = edge;
            this.word = word;
        }
    }

    public static int find(String begin, String target, String[] words, int num, int[] check) {

        LinkedList<Node> queue = new LinkedList();
        queue.add(new Node(begin, 0));

        while(queue.size() != 0) {
            Node temp = queue.poll();

            if(target.equals(temp.word)) {
                return temp.edge;
            }

            String[] start = (temp.word).split("");


            for(int i=0; i<words.length; i++) {
                String[] tempArray = words[i].split("");
                if(check[i] == 0 && howmany(start, tempArray)) {
                    check[i] = 1;
                    queue.add(new Node(words[i], temp.edge+1));

                }
            }

        }

        return 0;
    }

    public static boolean howmany(String[] start, String[] tempArray) {
        int number = 0;
        for(int i=0; i<start.length; i++) {
            if(start[i].equals(tempArray[i])) number++;
        }
        if(number == start.length-1) return true;
        else return false;

    }
}