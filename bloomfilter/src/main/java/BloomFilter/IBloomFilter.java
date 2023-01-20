package BloomFilter;

public interface IBloomFilter {

    public <T> void addElement(T element);
    public <T> boolean isPresent(T element);

}
