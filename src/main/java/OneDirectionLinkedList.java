public class OneDirectionLinkedList<T> {
    private ListElement<T> first;

    public OneDirectionLinkedList() {
        first = null;
    }

    public boolean empty() {
        return (first == null);
    }

    public void add(T elem) {
        ListElement<T> el = new ListElement<>(elem);
        el.setNext(first);
        this.first = el;
    }

    public ListElement<T> fetch(T elemToFind) {
        ListElement<T> finding = new ListElement<>(elemToFind);
        ListElement<T> el = first;
        while (el != null) {
            if (el.getData().equals(finding.getData())) {
                return el;
            }
            el = el.getNext();
        }
        return null;
    }

    public ListElement<T> fetchPrevious(ListElement<T> elemToFind) {
        if (elemToFind.equals(this.first)) {
            return this.first;
        } else {
            ListElement<T> el = first;
            while (el != null) {
                if (el.getNext().getData().equals(elemToFind.getData())) {
                    return el;
                }
                el = el.getNext();
            }
            return null;
        }
    }

    public boolean inList(T elem) {
        return fetch(elem) != null;
    }

    public void rem(T elem) {
        ListElement<T> elemToRemove = fetch(elem);
        ListElement<T> elemPrev = fetchPrevious(elemToRemove);
        if (elemToRemove != elemPrev) {
            elemPrev.setNext(elemToRemove.getNext());
        }
        else {
            this.first = elemToRemove.getNext();
        }
    }

    public void print() {
        ListElement<T> elem = first;
        if (elem == null) {
            System.out.println("[]");
            return;
        }
        StringBuilder display = new StringBuilder("[");
        while (elem != null) {
            display.append(String.valueOf(elem.getData())).append(", ");
            elem = elem.getNext();
        }
        display.delete(display.length()-2, display.length());
        display.append("]");
        System.out.println(display.toString());
    }


}
