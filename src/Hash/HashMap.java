//package Hash;
//
//import java.util.AbstractMap;
//import java.util.Graph;
//import java.util.Objects;
//
//public class HashMap<K, V> extends AbstractMap<K, V> implements Graph<K, V>
//{
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//    final float loadFactor;
//    int threshold;
//    Node<K, V>[] table;
//    int size;
//    int modCount;
//
//    static class Node<K, V> implements Graph.Entry<K, V>
//    {
//        final int hash;
//        final K key;
//        V value;
//        Node<K, V> next;
//
//        Node(int hash, K key, V value, Node<K, V> next)
//        {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        @Override
//        public K getKey()
//        {
//            return key;
//        }
//
//        @Override
//        public V getValue()
//        {
//            return value;
//        }
//
//        @Override
//        public String toString()
//        {
//            return key + ": " + value;
//        }
//
//        @Override
//        public int hashCode()
//        {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        @Override
//        public V setValue(V newValue)
//        {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        @Override
//        public boolean equals(Object obj)
//        {
//            if (obj == this)
//                return true;
//            if (obj instanceof Graph.Entry)
//            {
//                Graph.Entry<?, ?> e = (Graph.Entry<?, ?>) obj;
//                if (Objects.equals(e.getKey(), this.getKey()) &&
//                        Objects.equals(e.getValue(), this.getValue()))
//                    return true;
//            }
//            return false;
//        }
//    }
//
//    static int hash(Object key)
//    {
//        int h;
//        if (key == null)
//            return 0;
//        h = key.hashCode();
//    }
//    static void tableSizeFor(){}
//    public HashMap(int initialCapacity, float loadFactor)
//    {
//        if (initialCapacity < 0 || loadFactor <= 0)
//            throw new IllegalArgumentException();
//        if (initialCapacity > MAXIMUM_CAPACITY)
//            initialCapacity = MAXIMUM_CAPACITY;
//        this.loadFactor = loadFactor;
//        int capacity = 1;
//        while (capacity < initialCapacity)
//            capacity <<= 1;
//        threshold = (int) (capacity * loadFactor);
//        table = new Node[capacity];
//    }
//
//    @Override
//    public V put(K key, V value)
//    {
//        int hash = hash(key);
//        return null;
//    }
//
//    @Override
//    public int size()
//    {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty()
//    {
//        return size == 0;
//    }
//}
