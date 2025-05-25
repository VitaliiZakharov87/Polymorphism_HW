import deals.Deal;
import deals.Expenditure;
import deals.Sale;
import taxes.USNDebit;
import taxes.USNDebitMinusCredit;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("УВардана", new USNDebit());
        company.applyDeals(new Deal[]{
                new Sale("Кукуруза", 400),
                new Expenditure("«Хачапури» ", 300),
                new Sale("Кукуруза", 600)

        });

        company.setTaxSystem(new USNDebitMinusCredit());
        company.applyDeals(new Deal[]{
                new Sale("Кукуруза", 400),
                new Expenditure("«Хачапури» ", 300),
                new Sale("Кукуруза", 600)

        });
    }
}