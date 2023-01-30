package sets;

class ArcoÍris implements Comparable<ArcoÍris> {
    private String cor;

    public ArcoÍris(String cor) { //constructor
        this.cor = cor;
    }
    public String getCor(){ //get()
        return cor;
    }
    //sobrescrita
    @Override
    public String toString(){ 
        return "{" + cor + "}";
    }
    @Override
    public int compareTo(ArcoÍris o) {
        return 0;
    }

}
