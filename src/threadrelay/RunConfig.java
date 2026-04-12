package threadrelay;

//classe CONFIG di Runner per il form Settings.java
//(questo per modificare accelerazione, velocità costante e decelerazione)
//(è più facile passare questa classe piuttosto che l'intero Runner)
public class RunConfig{
    public final int msAcc;
    public final int msCost;
    public final int msDec;
        
    public RunConfig(int msAcc, int msCost, int msDec){
        this.msAcc = msAcc;
        this.msCost = msCost;
        this.msDec = msDec;
    }
    //non c'è bisogno dei getter perché i valori sono immutabili
}