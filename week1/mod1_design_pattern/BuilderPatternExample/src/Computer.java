public class Computer {
    private  int CPU;
    private  int RAM;
    private  int Storage;
    private Computer(Builder builder){
        this.CPU=builder.CPU;
        this.RAM=builder.RAM;
        this.Storage=builder.Storage;
    }
    public int getCPU() {
        return CPU;
    }
    public int getRAM() {
        return RAM;
    }
    public int getStorage() {
        return Storage;
    }
    static class Builder{
    private  int CPU;
    private  int RAM;
    private  int Storage;
    public  Builder setCPU(int cPU) {
        CPU = cPU;
        return this;
    }
    public  Builder setRAM(int rAM) {
        RAM = rAM;
        return this;
    }
    public  Builder setStorage(int storage) {
        Storage = storage;
        return this;
    }
    public Computer Build(){
        //Computer c=new Computer();
        return new Computer(this);
    }
    
    }

}
