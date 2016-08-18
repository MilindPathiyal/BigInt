public interface Number 
{
    String toString();
    int compareTo(Number num);
    Number multiply(Number b);
    Number divide(Number b);
    Number add(Number b);
    Number subtract(Number b);
}