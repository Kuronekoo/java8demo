package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Transaction {
    private Trader trader;
    private int year;
    private int value;
}
