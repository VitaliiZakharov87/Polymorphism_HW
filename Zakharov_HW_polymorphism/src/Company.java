import deals.Deal;
import taxes.*;

public class Company {
    private TaxSystem taxSystem;
    private String title;
    private int debit;
    private int credit;


    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }
    public void shiftMoney(int amount){
        if (amount>0){
            debit += amount;
        } else if (amount<0) {
            credit += Math.abs(amount);

        }
    }
    public void payTaxes(){
        int tax = taxSystem.calcTaxFor(debit,credit);
        System.out.format("Компания %s уплатила налог в размере: %d руб. \n", title, tax);
        debit = 0;
        credit = 0;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public int applyDeals(Deal[] deals){
        for (Deal deal : deals) {
            shiftMoney(deal.getDebitChange());
            shiftMoney(-deal.getCreditChange());
        }
    int balance = debit -credit;
    payTaxes();
    return balance;

    }

}
