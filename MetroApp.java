class Metrocard
{
    private  String cardId;
    private double balance;
    public Metrocard(String cardId, double balance){
        this.cardId= cardId;
        this.balance=balance;

    }
    public void recharge(double amt){
        balance+=amt;

    }
    public boolean deductrecharge(double fare){
        if(balance>=fare){
            balance-=fare;
            return true;
        }
         return false;
    }
    public double getBalance(){return balance;}

}
class metroSystem{
    public void swipe(String station,Metrocard card ){
            double fare=20;
            if(card.deductrecharge(fare)){
                System.out.println("swipe at:"+station+".|fare is RS."+fare);
            }
            else {
                System.out.println("\ninsufficent balance");
            }
    }

}
public class MetroApp {
    public static void main(String[] args) {
        Metrocard card= new Metrocard("ID2356",50);
        metroSystem metro= new metroSystem();
        metro.swipe("central",card);
        System.out.println("remainnig balance:"+card.getBalance());
        card.recharge(30);
        System.out.println("after recharge"+card.getBalance());

    }
}
