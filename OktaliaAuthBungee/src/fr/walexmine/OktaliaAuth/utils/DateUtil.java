package fr.walexmine.OktaliaAuth.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil
{
  public static long parseDateDiff(String paramString)
  {
    Pattern localPattern = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?", 2);
    Matcher localMatcher = localPattern.matcher(paramString);
    long l = 0L;
    int i = 0;
    while (localMatcher.find()) {
      if ((localMatcher.group() != null) && (!localMatcher.group().isEmpty()))
      {
        for (int j = 0; j < localMatcher.groupCount(); j++) {
          if ((localMatcher.group(j) != null) && (!localMatcher.group(j).isEmpty()))
          {
            i = 1;
            break;
          }
        }
        if (i != 0)
        {
          if ((localMatcher.group(1) != null) && (!localMatcher.group(1).isEmpty())) {
            l += 31556926 * Integer.parseInt(localMatcher.group(1));
          }
          if ((localMatcher.group(2) != null) && (!localMatcher.group(2).isEmpty())) {
            l += 2629743 * Integer.parseInt(localMatcher.group(2));
          }
          if ((localMatcher.group(3) != null) && (!localMatcher.group(3).isEmpty())) {
            l += 604800 * Integer.parseInt(localMatcher.group(3));
          }
          if ((localMatcher.group(4) != null) && (!localMatcher.group(4).isEmpty())) {
            l += 86400 * Integer.parseInt(localMatcher.group(4));
          }
          if ((localMatcher.group(5) != null) && (!localMatcher.group(5).isEmpty())) {
            l += 3600 * Integer.parseInt(localMatcher.group(5));
          }
          if ((localMatcher.group(6) != null) && (!localMatcher.group(6).isEmpty())) {
            l += 60 * Integer.parseInt(localMatcher.group(6));
          }
          if ((localMatcher.group(7) != null) && (!localMatcher.group(7).isEmpty())) {
            l += Integer.parseInt(localMatcher.group(7));
          }
        }
      }
    }
    if (i == 0) {
      return -1L;
    }
    return l * 1000L;
  }
}