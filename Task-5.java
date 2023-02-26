//1.
public void onClick(View view) {
    Random random = new Random(30);
    SortedSet<Integer> numberSet = new TreeSet<>();

    for(int i = 0; i < 1000; i++)
        numberSet.add(random.nextInt(10));
    mInfoTextView.setText(numberSet.toString());
}

//2.
class MultiMap<K, V> 
{
  private final Map<K,Collection<V>> map = new HashMap<>();

  public Collection<V> get(K key) 
  {
    return map.getOrDefault(key, Collections.<V> emptyList());
  }
  public void put(K key,V value )
  {
    map.computeIfAbsent( key, k -> new ArrayList<>()).add( value );
  }
}

// второе множество
import java.util.*;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Set set1 = new Set(1, 2, 3);
        Set set2 = new Set(2, 3, 4, 5);
 
        System.out.println("Intersection: " + set1.intersect(set2));
        System.out.println("Union: " + set1.unify(set2));
    }
}
     class Set {
    private  List<Integer> elements;
 
    public Set(Integer... elements) {
        this(Arrays.asList(elements));
    }
 
    private Set(List<Integer> elements) {
        this.elements = elements;
    }
 
    public Set intersect(Set other) {
        return new Set(elements.stream()
                .filter(other.elements::contains)
                .collect(Сollectors.toList()));
    }
 
    public Set unify(Set other) {
        return new Set(Stream.concat(this.elements.stream(), other.elements.stream())
                .distinct()
                .collect(Сollectors.toList()));
    }
 
    @Override
    public String toString() {
        return "Elements=" + elements;
    }
}
