package domain.factories;

/**
 * Created by usuario on 11/06/2016.
 */
public class ServiceLocator {
    private static ServiceLocator ourInstance = new ServiceLocator();

    public static ServiceLocator getInstance() {
        return ourInstance;
    }

    private ServiceLocator() {

    }
}
