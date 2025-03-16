package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @author longnguyen on 04/02/2025
 * @product IntelliJ IDEA
 * @project demo-jdbc-1
 */
@Getter
@Setter
@ToString
public class Book {

    private Integer id;

    private String title;

    private LocalDate publishedDate;
}
