package cs310davis;

public class HashEntry {
      private int key;
      private int value;
 
      HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
      }
 
      public int getValue() {
            return value;
      }
 
      public void setValue(int value) {
            this.value = value;
      }
 
      public int getKey() {
            return key;
      }
}