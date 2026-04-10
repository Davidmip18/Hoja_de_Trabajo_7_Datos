public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key; // Palabra en francés
    private V value; // Palabra en español

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    @Override
    public int compareTo(Association<K, V> other) {
        // Ignorar mayúsculas/minúsculas al comparar
        return this.key.toString().toLowerCase().compareTo(other.key.toString().toLowerCase());
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
