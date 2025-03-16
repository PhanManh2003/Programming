package training.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Transaction {
    private int transactionId;
    private int userId;
    private double amount;
    private String category;
    private String type;
    private Date date;
    private String description;

    @Override
    public String toString() {
        String str = String.format("%5d%5d%6f%15s%10s%10s%15s",
                transactionId, userId, amount, category,
                type, date.toString(), description);
        return str;
    }
}
