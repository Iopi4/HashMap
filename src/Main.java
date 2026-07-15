import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Создаём карту, где ключ — Address, значение — цена доставки за 1 кг, веса(например int).

        Map<Address, Integer> costPerAddress = new HashMap<>();
        //Добавим несколько произвольных адресов с ценами.
        costPerAddress.put(new Address("Россия", "Москва"), 150);
        costPerAddress.put(new Address("Россия", "Казань"), 200);
        costPerAddress.put(new Address("США", "Нью-Йорк"), 3000);
        costPerAddress.put(new Address("Германия", "Берлин"), 2500);

        Scanner scanner = new Scanner(System.in);
        int totalCoast = 0; //Общая стоимость доставки

        while (true){
            System.out.println("Заполнение нового заказа.");
            System.out.println("Введите страну: ");
            String country = scanner.nextLine().trim();
            if (country.equals("end")) break;

            System.out.println("Введите город: ");
            String city = scanner.nextLine().trim();

            System.out.println("Введите вес (кг): ");
            int weight = Integer.parseInt(scanner.nextLine());

            // Создаём ключ-адрес
            Address address = new Address(country, city);

            //Проверяем наличие адреса в мапе. Если есть — вычисляем стоимость, добавляем к общей сумме и выводим.
            //Иначе сообщаем об отсутствии доставки.
            if (costPerAddress.containsKey(address)){
                int pricePerKg = costPerAddress.get(address);
                int deliveryCost = pricePerKg * weight;
                totalCoast += deliveryCost;
                System.out.println("Стоимость доставки составит: " + deliveryCost + " руб.");
                System.out.println("Общая стоимость доставки составит: " + totalCoast + " руб.");
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
        }
        scanner.close();

    }
}