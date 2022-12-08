package databaseBoundaries;

public interface ItemDBBoundary {
    String getName();
    String  getType();
    int getPrice();
    boolean isUnlocked();
    String getIcon();
}
