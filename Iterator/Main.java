// Exemplo simples do padrão Iterator em Java

// --- Interface Iterator ---
interface Iterator {
    boolean hasNext();
    Object next();
}

// --- Interface Aggregate ---
interface Aggregate {
    Iterator createIterator();
}

// --- ConcreteIterator ---
class ConcreteIterator implements Iterator {
    private ConcreteCollection collection;
    private int current = 0;

    public ConcreteIterator(ConcreteCollection collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return current < collection.count();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return collection.getItem(current++);
        }
        return null;
    }
}

// --- ConcreteCollection ---
class ConcreteCollection implements Aggregate {
    private String[] items = new String[10];
    private int index = 0;

    public void addItem(String item) {
        if (index < items.length) {
            items[index++] = item;
        }
    }

    public String getItem(int position) {
        if (position < index) {
            return items[position];
        }
        return null;
    }

    public int count() {
        return index;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
}

// --- Programa Principal ---
public class Main {
    public static void main(String[] args) {
        ConcreteCollection collection = new ConcreteCollection();
        collection.addItem("Item 1");
        collection.addItem("Item 2");
        collection.addItem("Item 3");
        collection.addItem("Item 4");

        Iterator iterator = collection.createIterator();

        System.out.println("Percorrendo a coleção:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
