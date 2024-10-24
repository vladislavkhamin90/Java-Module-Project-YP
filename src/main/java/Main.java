import java.util.Scanner;

//класс для т.с.
class Auto {

    String name; // имя т.с.
    int speed; // скорость т.с.

    // конструктор
    Auto(String name, int speed){

        this.name = name;
        this.speed = speed;

    }
}

// класс для хранения текущего лидера гонок
class Race{

    String raceLeader = ""; // лидер гонки
    int distance = 0; // пройденная дистанция

    // функция для расчета дистанции и выявления лидера
    void findLeader(String nameAuto, int speedAuto){

        if(24 * speedAuto > distance){
            distance = 24 * speedAuto;
            raceLeader = nameAuto;
        }
    }
}


public class Main {

    public static void main(String[] args) {

        // переменные для создания объектов
        Scanner scanner = new Scanner(System.in);
        Auto auto;
        Race race = new Race();

        // цикл для создания трех экземпляров класса Auto
        for(int i = 1; i <= 3; i++ ) {

            System.out.println("Введите название машины №" + i);
            String name = scanner.next();

            System.out.println("Введите скорость машины №" + i);
            // вложенный цикл для обработки значения переменной скорости
            while (true){

                // проверка вводимого значения на принадлежность к Integer
                if(scanner.hasNextInt()){

                    // присвоение вводимого значения переменной скорости
                    int speed = scanner.nextInt();

                    // проверка значения на корректность
                    if ( speed > 0 && speed <=250){

                        // создание экземпляра Auto
                        auto = new Auto(name, speed);
                        // вызов функции для выявления лидера
                        race.findLeader(auto.name,auto.speed);
                        break;

                    }else{
                        System.out.println("Значение скорости должно быть от 1 до 250");
                    }
                }else {
                    System.out.println("Введите корректную скорость");
                    scanner.next();
                }
            }
        }
        System.out.println("Самая быстрая машина: " + race.raceLeader);
    }
}

