public class MergeLists {
    public ListNode weave (ListNode a, ListNode b) {
        ListNode ret = a;
        while (a != null){
            a.next = new ListNode(b.info, a.next);
            a = a.next.next;
            b = b.next;
        }
        return ret;
    }
}