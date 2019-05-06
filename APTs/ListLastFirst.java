public class ListLastFirst {
    public ListNode move(ListNode list) {
        if (list == null) return null;
        if (list.next == null) return list;
        int lastVal = lastVal(list).info;
        ListNode head = list;

        while (list.next.next != null){
            list = list.next;
        }
        list.next = null;

        return new ListNode(lastVal, head);
    }

    public ListNode lastVal(ListNode list){
        while (list.next != null){
            list = list.next;
        }
        return list;
    }

}