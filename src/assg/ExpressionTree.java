package assg;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by libsys on 1/6/2023.
 */
public class ExpressionTree {
    public static final String  delim = "\\s";
    public static Set<String> operators;
    class TreeNode{
        boolean isOperator;
        String operator;
        int operand;
        TreeNode left,right;
        public TreeNode(String el,boolean isOperator){
            this.isOperator = isOperator;
            if(isOperator)  this.operator = el;
            else            this.operand = Integer.parseInt(el) ;
        }
    }
    TreeNode root;
    private boolean isOperator(String operator){
        return operators.contains(operator);
    }
    public void initOperators(String ... args){
        operators= new HashSet<>();
        for(String op:args) operators.add(op);

    }
    public ExpressionTree(String postfix){

        initOperators("+","-","*","/");
        String[] parts =  postfix.split(delim);
        Stack<TreeNode> stack = new Stack<>();


        for(String part:parts){
            TreeNode node = null;
            if(isOperator(part)){
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                node = new TreeNode(part,true);
                node.left = left;
                node.right = right;
            } else {
                node = new TreeNode(part,false);
            }
            stack.push(node);
        }
        root = stack.pop();
    }
    public int eval(){
        return evalHelper(root);
    }
    public int evalHelper(TreeNode node){
        if(node == null)    return 0;
        if(node.left == null && node.right == null) return node.operand;
        int leftResult = evalHelper(node.left);
        int rightResult = evalHelper(node.right);
        switch (node.operator){
            case "+":   return leftResult+rightResult;
            case "-":   return leftResult-rightResult;
            case "/":   return leftResult/rightResult;
            case "*":   return leftResult*rightResult;
        }
        return 0;
    }

    public String postfix(){
        return postfixHelper(root);
    }
    public String postfixHelper(TreeNode node){
        StringBuilder sb = new StringBuilder();
        if(node == null)    return "";
        if(node.left == null && node.right == null)    return node.isOperator ? node.operator :  String.valueOf(node.operand);
        sb.append(postfixHelper(node.left));
        sb.append(postfixHelper(node.right));
        sb.append(" "+(node.isOperator ? String.valueOf(node.operator) : node.operand)+" ");
        return sb.toString();
    }

    public String infix(){
        return infixHelper(root);
    }
    public String infixHelper(TreeNode node){
        StringBuilder sb = new StringBuilder();
        if(node == null)    return "";
        if(node.left == null && node.right == null)    return node.isOperator ? node.operator :  String.valueOf(node.operand);
        sb.append(infixHelper(node.left));
        sb.append(" "+(node.isOperator ? String.valueOf(node.operator) : node.operand)+" ");
        sb.append(infixHelper(node.right));
        return sb.toString();
    }
    public String prefix(){
        return prefixHelper(root);
    }
    public String prefixHelper(TreeNode node){
        StringBuilder sb = new StringBuilder();
        if(node == null)    return "";
        if(node.left == null && node.right == null)    return node.isOperator ? node.operator :  String.valueOf(node.operand);
        sb.append(" "+(node.isOperator ? String.valueOf(node.operator) : node.operand)+" ");
        sb.append(infixHelper(node.left));
        sb.append(infixHelper(node.right));
        return sb.toString();
    }

    public  static void main(String[] args){
        ExpressionTree expressionTree = new ExpressionTree("34 2 - 5 *");
        System.out.println(expressionTree.eval());
        System.out.println(expressionTree.prefix());
        System.out.println(expressionTree.infix());
        System.out.println(expressionTree.postfix());

    }
}
