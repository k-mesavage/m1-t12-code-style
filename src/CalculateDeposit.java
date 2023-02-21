import java.util.Scanner;

public class CalculateDeposit { // Класс лучше назвать DepositCalculator. Сейчас имя класса начинается с глагола, как метод
    double calculateComplexPercent(double a, double y, int d) { // имена переменных не информативны, можно сделать как в методе calculateSimplePercent
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void doImportantJob() { // Имя метода не информативное, непонятно по названию что делает этот метод
        int period;
        int action; // блок объявления переменных вроде тоже желательно отделять пустой строкой, как и методы
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt(); // Здесь лучше оставить инициализацию переменной, а объявить ее в блоке объявления переменных выше
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double out = 0;
        if (action == 1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new CalculateDeposit().doImportantJob(); // Эта строка изменится при переименовании имени класса и метода
    }
}
