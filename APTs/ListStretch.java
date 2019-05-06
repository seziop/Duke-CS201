public class ListStretch {
    public ListNode stretch (ListNode list, int amount){
        if (list == null) return null;
        ListNode ret = list;
        while (list != null){
            for (int k = 1; k < amount; k++) {
                list.next = new ListNode(list.info, list.next);
            }
            for (int k = 0; k < amount; k++) {
                list = list.next;
            }
        }
        return ret;
    }
}