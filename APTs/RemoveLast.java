public class RemoveLast {
    public ListNode remove(ListNode list) {
        ListNode ret = list;
        if (list == null) return null;
        while (list.next.next != null){
            list = list.next;
        }
        list.next   = null;
        return ret;
    }
}