package com.koala;

import java.util.List;

public class DAOUtils {

  public static <T> T getFirstOrNull(List<T> array) {
    if (array == null || array.isEmpty())
      return null;
    return array.get(0);
  }
}
