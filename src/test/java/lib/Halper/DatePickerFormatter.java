package lib.Halper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatePickerFormatter {


//    private static String formatCurrentDate() {
//        // Получить текущую дату
//        Date currentDate = new Date();
//
//        // Установить желаемый формат вывода
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("ru"));
//
//        return dateFormat.format(currentDate);
//    }

    public static String formatTomorrowDate() {
        // Получить текущую дату
        Calendar calendar = Calendar.getInstance();

        // Проверить, является ли сегодня последним днем месяца
        boolean isLastDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Если сегодня последний день месяца, то оставить текущую дату без изменений
        if (!isLastDayOfMonth) {
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Добавить 1 день
        }

        // Получить дату (текущую или увеличенную на 1 день)
        Date targetDate = calendar.getTime();

        // Установить желаемый формат вывода
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru"));

        return dateFormat.format(targetDate);
    }

    public static void main(String[] args) {
        String formattedDate = formatTomorrowDate();
        System.out.println(formattedDate);
    }
}
