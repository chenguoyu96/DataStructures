package org.chenguoyu.datastructure.stack;

/**
 * @author chenguoyu
 * @date 2018-11-27
 * @program DataStructures
 */
public class StackTest {
    public static void main(String[] args) {
//        ArrayStack<Integer> stack = new ArrayStack<>();
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
