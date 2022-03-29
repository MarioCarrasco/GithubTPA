package TablaHash;

public class TablaHashLineal extends TablaHash {
    TablaHashLineal(int startSize) {
        super(startSize);
    }

    @Override
    int hash(Integer key, int collision) {
        return (key%this.array.length) + collision;
    }

    public static void main(String[] args) {
        TablaHash tabla = new TablaHashLineal(10);
        tabla.add(4,  10);
        tabla.add(8,  10);
        tabla.add(10,  10);


        tabla = new TablaHash(10) {
            @Override
            int hash(Integer key, int collision) {
                return key%this.array.length + collision^2;
            }
        };
    }
}
