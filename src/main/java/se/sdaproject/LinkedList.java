package se.sdaproject;

// a "box" in our previous picture
class Node {
    // field 1: the data
    // in our case just an integer
    int elem;

    // field 2: the reference to the next node
    Node next;
    Node(int num) {
        this.elem = num;
        this.next = null;
    }
}


public class LinkedList {

    private Node first = null;

    public void add(int num) {
        // int num is available!

        // step 1: is the linked list still empty?
        if (first == null) {
            // in this case, the linked list is empty
            // Diana > if the head is null you just create the head, because this is the 'add' method.
            Node node = new Node(num); // node.next == null
            first = node;
        } else {
            // in this case, the linked list is *not* empty
            // this means, first != null

            // step 2: find the last node
            
            // Key: introduce a temporary variable!
            // we can then update this temporary variable,
            // without changing "first"!
            // important, since "first" should not be changed!

            Node current = first;
            while (current.next != null) { // current is not the last node!
                current = current.next;
            }
            // what do we know about "current"?
            // current.next == null
            // AWESOME!
            // it means, "current" is the last node!

            // step 3: create a new node with the given int "num"
            Node node = new Node(num);

            // step 4: change the reference of the last node to
            // point to the new node
            current.next = node;
        }

    }

        public int search(int elem) {

            // step 1: is the linked list still empty?
            int notFound = -1;
            if (first == null) {
                // it means there are no elements in the LinkedList so return -1
                return notFound;

            } else {

                // there is a first element so we pull this in and update 'first'
                Node current = first;
                while (current.next != null) {
                    // loop all LinkedList before reaching null
                    // if the next.elem after the first is == elem searched then return the index
                    if (current.next.elem == elem) {
                        return current.next;
                    }
                    // what happens if the next.elem is not equal to elem. Then keep looping (updating 'current')
                    current = current.next;
                    // if the first node is NOT null then check if its the same as the elem.
                }
                    if(current.elem == elem)
                    // return the index if first == elemen
                    return current.next;
                } else {
                    // return -1 because the elem is not the one we are searching
                    return notFound;
                }
            }

    // useful for testing!
    public String toString() {
        // goal is to return a string like this:
        // "LinkedList(5,2,10)"

        StringBuilder builder = new StringBuilder();

        // call methods on "builder" to add strings

        builder.append("LinkedList(");
        // append strings for each integer in the list

        if (first == null) {
            // what to do here?
            // string to be returned: "LinkedList()"
            // nothing left to do!
        } else {
            // here, we know that first != null
            // go through the chain of nodes, starting with
            // "first"

            Node current = first;            
            // treat first element specially:
            builder.append("" + current.elem);

            while (current.next != null) {
                current = current.next;
                builder.append("," + current.elem);
            }
            // current.next == null
            // we have already appended the last num!
        }

        // append ")"
        builder.append(")");
        return builder.toString();
    }
}