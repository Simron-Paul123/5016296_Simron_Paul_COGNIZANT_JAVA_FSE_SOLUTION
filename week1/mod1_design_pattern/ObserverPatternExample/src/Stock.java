interface Stock {
    public void register(Observer observer);
    public void deregister(Observer observer);
    public void Notify();
}
