import java.util.Scanner;

public class SiteFunkciiZaDrva {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        sc.nextLine();
        BTree<String> drvo=new BTree<>();
        for (int i=0;i<n+q;i++){
            String line=sc.nextLine();
            String[] parts=line.split(" ");
            String command=parts[0];
            if (command.equals("root")){
                drvo.makeRoot(parts[1]);
            }else if (command.equals("add")){
                BNode<String> parentNode= find(drvo.root,parts[1]);
                if (parts[3].equals("LEFT")){
                    drvo.addChild(parentNode,BNode.LEFT,parts[2]);
                }else{
                    drvo.addChild(parentNode,BNode.RIGHT,parts[2]);
                }
            }else if (command.equals("ask")){
                BNode<String> node= find(drvo.root,parts[1]);
                if (node!=null){
                    //System.out.println(countInsideLeafs(node));//BROIME VNATRESNI JAZLI NA PODDRVOTO
                    //System.out.println(countNodesWith2Childs(node));//BROIME JAZLI KOI IMAAT TOCNO DVE DECA
                    //System.out.println(maxDepth(node)+1);//MERIME MAKSIMALNA DLABOCINA NA PODDRVO
                    //System.out.println(sumChild(node));//MERIME SUMA NA STEPENI NA PODDRVO
                    //System.out.println(depthNode(drvo.root,parts[1],0));//DLABOCINA NA ODREDEN NODE
                    //System.out.println(countLeafs(node));//LISTOVI NA PODRVO
                    System.out.println(smallerT(drvo.root,parts[1]));//KOLKU ELEMENTI SE POGOLEMI OD T
                }
            }
        }
    }
    private static int countNodes(BNode<String> node){
        if (node==null) return 0;
        return 1+countNodes(node.left)+countNodes(node.right);
    }
    private static int countNodesDepthSum(BNode<String> node,int depth){
        if (node==null){
            return 0;
        }
        int depthLeft=countNodesDepthSum(node.left,depth+1);
        int depthRight=countNodesDepthSum(node.right,depth+1);
        return depthLeft + depthRight + depth;
    }
    private static int smallerT(BNode<String> node, String part) {
        if (node==null) return 0;

        if (node.info.compareTo(part)>0){
            return 1;
        }

        return smallerT(node.left,part)+smallerT(node.right,part);
    }

    private static int countLeafs(BNode<String> node){
        if (node==null) return 0;

        if (node.left==null && node.right==null) return 1;

        if (node.left!=null || node.right!=null){
            return countLeafs(node.left)+countLeafs(node.right);
        }

        return 0;
    }

    private static int depthNode(BNode<String> node,String elem,int depth) {
        if (node==null){
            return -1;
        }
        if (node.info.equals(elem)){
            return depth;
        }
        int levoSubTreeDepth=depthNode(node.left,elem,depth+1);
        if (levoSubTreeDepth!=-1){
            return levoSubTreeDepth;
        }
        return depthNode(node.right,elem,depth+1);

    }

    private static int sumChild(BNode<String> node) {
        if (node==null){
            return 0;
        }

        if (node.left!=null && node.right!=null){
            return 2+sumChild(node.left)+sumChild(node.right);
        }
        if (node.left!=null || node.right!=null){
            return 1+sumChild(node.left)+sumChild(node.right);
        }

        return 0;
    }

    private static int maxDepth(BNode<String> node) {
        if (node==null){
            return 0;
        }

        if (node.left!=null || node.right!=null){
            return 1+Math.max(maxDepth(node.left),maxDepth(node.right));
        }

        return 0;
    }

    private static int countNodesWith2Childs(BNode<String> node) {
        if (node==null) return 0;

        if (node.left!=null && node.right!=null){
            return 1+countNodesWith2Childs(node.left) + countNodesWith2Childs(node.right);
        }

        if (node.left!=null || node.right!=null){
            return countNodesWith2Childs(node.left) + countNodesWith2Childs(node.right);
        }

        return 0;
    }

    private static int countInsideLeafs(BNode<String> node) {
        if (node==null) return 0;

        if (node.left!=null || node.right!=null){
            return 1+countInsideLeafs(node.left)+countInsideLeafs(node.right);
        }

        return 0;
    }

    public static BNode<String> find(BNode<String> node,String key){
        if (node==null) return null;

        if(node.info.equals(key)) return node;

        BNode<String> levo=find(node.left,key);
        BNode<String> desno=find(node.right,key);

        if (levo!=null) {
            return levo;
        }
        else{
            return desno;
        }
    }
}
