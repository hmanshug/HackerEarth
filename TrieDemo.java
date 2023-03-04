package dummypkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TrieDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String > al=new ArrayList<>();
		al.add("ram_is_god_father");
		al.add("ram_is_father");
		al.add("ram_is_father_god_god_godgod");
		System.out.println(new Solution().solve("god_father", al));
	}

}
class Solution {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        Node good= buildTrie(A);
        ArrayList<Pair> ans=new ArrayList<>();
        for(int i=0; i<B.size(); i++) {
            String temp[]=B.get(i).split("_");
            
            int wordCount=0;
            for(int j=0; j<temp.length; j++) {
            	System.out.print(temp[j] + " ");
            	Node cur=good;
                int k;
                for(k=0; k<temp[j].length(); k++) {
                	
                    char ch=temp[j].charAt(k);
                    if(cur.next[ch-'a']==null) break;
                    else cur=cur.next[ch-'a'];
                }
                if(k==temp[j].length() && cur.end) {
                	System.out.print(temp[j]+"--");
                	wordCount++;
                }
                    
                
            }
            System.out.println(wordCount);
            ans.add(new Pair(i, wordCount));
        }
        Collections.sort(ans, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return b.count.compareTo(a.count);
            }
        });
        ArrayList<Integer> ans1=new ArrayList<Integer>();
        for(Pair p: ans) {
            ans1.add(p.index);
        }
        return ans1;
    }
    
    public static Node buildTrie(String A) {
        Node root=new Node('@'), cur=null;
        String[] words=A.split("_");
        
        for(int i=0; i<words.length; i++) {
            cur=root;
            for(int j=0; j<words[i].length(); j++) {
                char ch= words[i].charAt(j);
                if(cur.next[ch-'a']==null)
                        cur.next[ch-'a']=new Node(ch);
                cur=cur.next[ch-'a'];
            }
            cur.end=true;
        }
        return root;
    }
    static class Node {
        Character val;
        boolean end;
        Node[] next=new Node[26];
        
        Node(Character c) {
            val=c;
            end=false;
        }
    }
    static class Pair {
        Integer index, count;
        Pair(Integer x, Integer y) {
            index=x;
            count=y;
        }
    }
}



