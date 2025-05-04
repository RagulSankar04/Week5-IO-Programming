class LegacyAPI{
    @Deprecated
    public void oldFeature() {
        System.out.println("Warning: oldFeature() is deprecated and should not be used.");
    }

    public void newFeature() {
        System.out.println("newFeature() is the recommended method.");
    }
}
public class UseDeprecated {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
