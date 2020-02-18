public class MyListNode {
    public Player data;
    public MyListNode next;

    public MyListNode() {
        this(new Player(), null);
    }

    public MyListNode(Player data) {
        this(data, null);
    }

    public MyListNode(Player data, MyListNode next) {
        this.data = data;
        this.next = next;
    }
}
