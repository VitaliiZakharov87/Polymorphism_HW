package taxes;

public class USNDebit extends TaxSystem{
    @Override
    public int calcTaxFor(int debit, int credit) {
        return 6*debit/100;
    }
}
