package com.udalmik.algs.interviewbit.hash;

public class CopyRandomLinkedList {

    /**
     * Definition for singly-linked list with a random pointer.
     * class RandomListNode {
     * int label;
     * RandomListNode next, random;
     * RandomListNode(int x) { this.label = x; }
     * };
     */
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        // create copy with populated label and next
        RandomListNode listCurrentNode = head;
        RandomListNode copyHead = null;
        RandomListNode prevCopy = null;

        while (listCurrentNode != null) {
            RandomListNode copy = new RandomListNode(listCurrentNode.label);
            copy.random = listCurrentNode;
            if (prevCopy != null) {
                prevCopy.next = copy;
            } else {
                // first node
                copyHead = copy;
            }
            prevCopy = copy;
            listCurrentNode = listCurrentNode.next;
        }


        // point nexts of existing list to corresponding nodes of copied

        listCurrentNode = head;
        RandomListNode copyListPointer = copyHead;

        while (listCurrentNode != null) {

            RandomListNode temp = listCurrentNode.next;
            listCurrentNode.next = copyListPointer;

            copyListPointer = copyListPointer.next;
            listCurrentNode = temp;

        }

        // assign copy.random = copy.random.random.next to get new nodes

        copyListPointer = copyHead;
        while (copyListPointer != null) {
            if (copyListPointer.random.random != null) {
                copyListPointer.random = copyListPointer.random.random.next;
            } else {
                copyListPointer.random = null;
            }
            copyListPointer = copyListPointer.next;
        }

        return copyHead;
    }

}

class RandomListNode {

    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

