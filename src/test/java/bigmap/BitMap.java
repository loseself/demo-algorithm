package bigmap;

/**
 * 位图, 长度是位的长度, 值是0, 1
 * 使用char实现
 * Java 中 char 类型是 2 个字节, 占 16bit
 */
public class BitMap {

  /**
   * char实现的位数组
   * char是2个字节, 16位
   * 假如: 数组的长度是2, 2个char, 则有32位
   */
  private final char[] bitArray;

  /**
   * 位数组的长度
   * 假如你声明, 长度为16, 则只需要声明长度为1的char数组即可
   */
  private final int bitArrayLength;

  /**
   * 构造函数
   *
   * @param bitArrayLength 位数组长度
   */
  public BitMap(int bitArrayLength) {
    // 位数组长度赋值
    this.bitArrayLength = bitArrayLength;

    // 用char实现, 一个char, 16位, 所以以16位为一个单位
    // + 1 的意思是, 至少一个长度的char数组, 也就是至少16位
    this.bitArray = new char[bitArrayLength / 16 + 1];
  }

  /**
   * 位图赋值
   * 把当前传入的关键字放入位图中
   * 对应的位, 标记为1, 说明存在
   *
   * @param k 关键字
   */
  public void set(int k) {
    // 如果超过位数组长度, 则不标记
    if (k > bitArrayLength) {
      return;
    }

    // 除法
    // 该k放到那个char当中
    // 假如k是0~15, 则放到第一个char中
    // 假如k=16, 则放在第二个char中, charIndex=1
    // charIndex从0开始
    // 所以说明这个k, 以"位"的长度来衡量
    int charIndex = k / 16;

    // 取余
    // 该k, 在16位中的位置, 从0开始
    // 比如k=15, 则在16位中的第15位, 如果k=16, 则在16位的第0位
    // 如果k=17, 则在16位的第1位
    int bitIndex = k % 16;

    // 假设k=17, charIndex=1, bitIndex=1, 则1的二进制0001左移1位, i为0010, 十进制为2
    // 为什么要左移, 首先代码走到这里, 说明该16个位上肯定会有1出现
    // 现在bitIndex为1, 则在第1位
    // 说明, 该k, 在该16位的第一位标记为1, 0000 0000 0000 0010
    int i = 1 << bitIndex;

    // 赋值
    // | 按位或, 相对应位只要有一个为1，其值为1
    // A|=B ---> A = A | B
    // 为什么使用按位或, 假如在同一个char的下标, charIndex相同
    // bitIndex相同时, 根据按位或的计算公式, 则可保留该位上的1
    // bitIndex不相同时, 则保留之前位的1, 其他位仍可变为1

    // 第一次进来, k = 17, charIndex=1, bitIndex=1
    // char 默认为 0
    // 0000 0000 0000 0000 | 0000 0000 0000 0010 = 0000 0000 0000 0010
    // 假如第二次进来, k = 18, charIndex=1, bitIndex=2
    // 之前的 0000 0000 0000 0010 | 0000 0000 0000 0100 = 0000 0000 0000 0110
    bitArray[charIndex] |= i;
  }

  /**
   * 判断是否存在
   *
   * @param k 关键字
   * @return 是否存在, true 存在, 反之
   */
  public boolean get(int k) {
    // 同样, 如果k超过了位数组, 则直接不存在
    if (k > bitArrayLength) {
      return false;
    }

    // 获取哪个char, 哪个位
    int charIndex = k / 16;
    int bitIndex = k % 16;

    // 转换成二进制, 看该k在哪个位上是1
    int i = 1 << bitIndex;

    // & 按位与, 如果相对应位都是1，则结果为1，否则为0
    // 通过按位与运算规则, 说明如果计算结果为1, 则数组中就已存在
    // 0000 0000 0000 0010 & 0000 0000 0000 0010 = 0000 0000 0000 0010
    // 0000 0000 0000 0010 --> 2 --> 2 != 0
    return (bitArray[charIndex] & i) != 0;
  }

  /**
   * 测试
   *
   * @param args 入参
   */
  public static void main(String[] args) {
    BitMap bitMap = new BitMap(32);
    bitMap.set(17);
    bitMap.set(18);

    if (bitMap.get(17)) {
      System.out.println("true");
    }

  }
}