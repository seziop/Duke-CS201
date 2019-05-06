public class RemoveMin {
    public ListNode remove (ListNode list) {
        if (list == null) return null;
        if (list.next == null) return null;

        ListNode ret = list;
        int minValue = findMin(list);

        if (list.info == minValue) {
            list.info = list.next.info;
            list.next = list.next.next;
        } else {
            while (list.next != null) {
                if (list.next.info == minValue) {
                    list.next = list.next.next;
                    break;
                }
                list = list.next;
            }
        }
        return ret;
    }
    public int findMin(ListNode list){
        int min = list.info;
        while (list != null){
            if (list.info <= min) min = list.info;
            list = list.next;
        }
        return min;
    }
}