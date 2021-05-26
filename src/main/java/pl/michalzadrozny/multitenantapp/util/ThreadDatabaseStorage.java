package pl.michalzadrozny.multitenantapp.util;

public class ThreadDatabaseStorage {

    private ThreadDatabaseStorage() {
    }

    private static final ThreadLocal<String> currentDatabase = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        currentDatabase.set(tenantId);
    }

    public static String getTenantId() {
        return currentDatabase.get();
    }

    public static void clear() {
        currentDatabase.remove();
    }
}
