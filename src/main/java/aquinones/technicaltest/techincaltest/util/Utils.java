package aquinones.technicaltest.techincaltest.util;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static LocalDateTime convertStringToLocalDateTime(String strDate) {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
          LocalDateTime formatDateTime = LocalDateTime.parse(strDate, formatter);
          return formatDateTime;
      }

      public static String convertLocalDateTimeToString(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        String formattedDateTime = date.format(formatter);
        return formattedDateTime;
      }
}
