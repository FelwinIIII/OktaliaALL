package fr.walexmine.OktaliaAuth.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil
{
  public static String fixMessage(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace("&", "§");
  }
  
  public static String[] fixMessages(String... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (String str : paramVarArgs) {
      localArrayList.add(str.replace("&", "§"));
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static List<String> fixMessages(List<String> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (String str : paramList) {
      localArrayList.add(str.replace("&", "§"));
    }
    return localArrayList;
  }
}
