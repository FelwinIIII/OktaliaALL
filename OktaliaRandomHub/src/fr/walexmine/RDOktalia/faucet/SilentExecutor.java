package fr.walexmine.RDOktalia.faucet;

/**
 * Simple class that silences exceptions
 */
public abstract class SilentExecutor {
    public SilentExecutor() {
        try {
            execute();
        } catch (Exception e) {
            //Nothing to do
        }
    }

    public abstract void execute() throws Exception;
}
