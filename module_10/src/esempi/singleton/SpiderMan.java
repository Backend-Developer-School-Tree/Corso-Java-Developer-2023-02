package esempi.singleton;

public class SpiderMan {
    private static SpiderMan internalInstance;

    private SpiderMan() {}

    public static SpiderMan getInstance() {
        // l'effettiva creazione dell'istanza avverrà una sola volta alla prima chiamata di getInstance
        if (internalInstance == null)
            internalInstance = new SpiderMan();
        // tutte le chiamate successive ritorneranno direttamente la medesima istanza creata precedentemente
        return internalInstance;
    }
}
