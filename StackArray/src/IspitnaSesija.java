import java.util.Scanner;

class CBHT<K extends Comparable<K>, E> {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is equal to targetKey.
        // Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(targetKey)) return currNode;
            else currNode = currNode.succ;
        }
        return null;
    }

    public void insert(K key, E val) {
        // Insert the entry <key, val> into this CBHT.
        // If entry with same key exists, overwrite it.
        MapEntry<K, E> newEntry = new MapEntry<>(key, val);
        int b = hash(key);
        SLLNode<MapEntry<K, E>> currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                // Make newEntry replace the existing entry ...
                currNode.element = newEntry;
                return;
            } else currNode = currNode.succ;
        }
        // Insert newEntry at the front of the SLL in bucket b ...
        buckets[b] = new SLLNode<>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        SLLNode<MapEntry<K, E>> predNode = null, currNode = buckets[b];
        while (currNode != null) {
            MapEntry<K, E> currEntry = currNode.element;
            if (currEntry.key.equals(key)) {
                if (predNode == null) buckets[b] = currNode.succ;
                else predNode.succ = currNode.succ;
                return;
            } else {
                predNode = currNode;
                currNode = currNode.succ;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            SLLNode<MapEntry<K, E>> curr = buckets[i];
            while (curr != null) {
                temp += curr.element.toString() + " ";
                curr = curr.succ;
            }
            temp += "\n";
        }
        return temp;
    }
    public int tableSize() {
        // Calculates and returns the total number of elements in the hash table
        int size = 0;
        for (int i = 0; i < buckets.length; i++) {
            SLLNode<MapEntry<K, E>> currNode = buckets[i];
            while (currNode != null) {
                size++;
                currNode = currNode.succ;
            }
        }
        return size;
    }

}

class MapEntry<K extends Comparable<K>, E> {
    // Each MapEntry object is a pair consisting of a key (a Comparable object)
    // and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}


public class IspitnaSesija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        CBHT<String,Integer> tabela=new CBHT<>(2*N-1);
        ArrayStack<String> stack=new ArrayStack<>(100);
        ArrayStack<String> pecatenje=new ArrayStack<>(100);
        ArrayStack<String> otprevrti=new ArrayStack<>(100);
        for (int i = 0; i < N; i++) {
            String kniga=sc.next();
            tabela.insert(kniga, 0);
            stack.push(kniga);
            pecatenje.push(kniga);
        }
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            String ispit=sc.next();
            ArrayStack<String> pom=new ArrayStack<>(100);
            while (!stack.isEmpty()) {
                if (!stack.peek().equals(ispit)) {
                    pom.push(stack.pop());
                }else{
                   String baranaKniga=stack.pop();
                   break;
                }
            }
            while (!pom.isEmpty()){
                String tekovnaKniga=pom.pop();
                SLLNode<MapEntry<String,Integer>> dvizi=tabela.search(tekovnaKniga);
                int value=dvizi.element.value+1;
                tabela.insert(tekovnaKniga,value);
                stack.push(tekovnaKniga);
            }
            SLLNode<MapEntry<String,Integer>> dvizi=tabela.search(ispit);
            int value=dvizi.element.value+1;
            tabela.insert(ispit,value);
            stack.push(ispit);
        }
        while (!pecatenje.isEmpty()) {
            otprevrti.push(pecatenje.pop());
        }

        for (int i = 0; i < N; i++) {
            String kniga=otprevrti.pop();
            SLLNode<MapEntry<String,Integer>> dvizi=tabela.search(kniga);
            System.out.println(kniga+" "+dvizi.element.value);
        }
    }
}
