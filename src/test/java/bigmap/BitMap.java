package bigmap;

public class BitMap {

  private final char[] bitArray;

  private final int bitArrayLength;

  public BitMap(int bitArrayLength) {
    this.bitArrayLength = bitArrayLength;
    this.bitArray = new char[bitArrayLength / 16 + 1];
  }

  public void set(int k) {
    if (k > bitArrayLength) {
      return;
    }

    int charIndex = k / 16;
    int bitIndex = k % 16;
    int i = 1 << bitIndex;
    bitArray[charIndex] |= i;
  }

  public boolean get(int k) {
    if (k > bitArrayLength) {
      return false;
    }

    int charIndex = k / 16;
    int bitIndex = k % 16;
    int i = 1 << bitIndex;
    return (bitArray[charIndex] & i) != 0;
  }

}