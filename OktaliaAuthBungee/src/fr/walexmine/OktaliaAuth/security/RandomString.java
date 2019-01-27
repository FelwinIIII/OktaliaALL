package fr.walexmine.OktaliaAuth.security;

import java.util.Random;

public class RandomString
{
  private static final char[] chars = new char[36];
  
  static
  {
    for (int i = 0; i < 10; i++) {
      chars[i] = ((char)(48 + i));
    }
    for (int i = 10; i < 36; i++) {
      chars[i] = ((char)(97 + i - 10));
    }
  }
  
  private final Random random = new Random();
  private final char[] buf;
  
  public RandomString(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("length < 1: " + paramInt);
    }
    this.buf = new char[paramInt];
  }
  
  public String nextString()
  {
    for (int i = 0; i < this.buf.length; i++) {
      this.buf[i] = chars[this.random.nextInt(chars.length)];
    }
    return new String(this.buf);
  }
}
