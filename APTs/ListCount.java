public class ListCount {
    public int count (ListNode list) {
        int sum = 0;
        int count = 0;
        while (list != null){
            sum += list.info;
            list = list.next;
            count ++;
        }
        return count;
    }
}