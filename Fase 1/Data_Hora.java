
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
public class Data_Hora {
  public static void main(String[] args) {
    LocalDateTime a = LocalDateTime.now();
    DateTimeFormatter fmt1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    System.out.println(fmt1.format(a));
    /*
    System.out.println(a);
    
    OU
    
    DateTimeFormatter fmt = DateTimeFormatter
        .ofLocalizedDateTime(FormatStyle.dateTimeStyle); // DÁ ERRO!!!
    System.out.println(fmt.format(a));
    
    OU
    
   DateTimeFormatter fmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(
        new Locale("en", "IN"));
    System.out.println(fmt.format(a));
    */
  }
}
