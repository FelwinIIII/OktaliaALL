package fr.walexmine.OktaliaAuth.tasks;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import fr.walexmine.OktaliaAuth.AuthPlugin;
import fr.walexmine.OktaliaAuth.data.DataUser;

public class DeleteRedundantUsersFromMemoryTask
  implements Runnable
{
  public void run()
  {
    Iterator localIterator = AuthPlugin.INSTANCE.getUsers().values().iterator();
    while (localIterator.hasNext())
    {
      DataUser localDataUser = (DataUser)localIterator.next();
      if (!localDataUser.isOnline()) {
        if ((!localDataUser.isActiveSession()) || ((!localDataUser.isRegister()) && (localDataUser.mustRegister()))) {
          localIterator.remove();
        }
      }
    }
  }
}
