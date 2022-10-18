import java.util.*;
public class Calculator_1 {
    public static void main(String[] args) throws  ArithmeticException, ArrayIndexOutOfBoundsException,Exception {
        Scanner scan = new Scanner(System.in);// место в памяти для ввода данных
        System.out.println("Введите пример");
        String example = scan.nextLine();  // переменная-строка-ввод строки

        int index = example.indexOf(" ");
        try {
            if (index == -1) {
                throw new ArrayIndexOutOfBoundsException("Неправильный ввод без пробелов");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Неправильный ввод без пробелов");
        }

        String[] example_1 = example.split(" ");// массив строк разделенных по пробелу


        try {
            if (example.length() < 5 || example_1.length > 3) {
                throw new Exception("Пользователь ввел некорректную строку");
            }
        } catch (Exception e) {
            System.out.println("Пользователь ввел некорректную строку");

        }




        Flagi flag = new Flagi(); // класс для проверки принадлежности массиву
        flag.alfa = example_1[0];
        flag.betta = example_1[1];
        flag.gamma = example_1[2];
        int f = flag.general_array();// код 1, 2,3.....4 определения типа введенных данных





        try{
            if (f == 0) {
                throw new Exception("Некорректный ввод данных");
            }
        }catch (Exception e){
            System.out.println("Некорректный ввод данных");
        }


        try {
            if (f == 4) {
                throw new Exception("Числа разных систем счисления");
            }
        }catch(Exception e){
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
        }




        String alfa = example_1[0];
        String betta = example_1[1];
        String gamma = example_1[2];


        String[] arabs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] romeTens = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] romeHundreds = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"};
        String[] operators = {"+", "-", "*", "/"}; // массив операторов



        if (f == 2) {  // блок работы с арабскими числами

            Algebra cifra = new Algebra(); // класс для вычислений
            cifra.alfa = Integer.valueOf(alfa); // преобразуем в числовой тип
            cifra.gamma = Integer.valueOf(gamma);

            if (betta.equals("+")) {
                System.out.println("Результат сложения = " + cifra.suma());
            }
            if (betta.equals("-")) {
                System.out.println("Результат вычитания равен   " + cifra.razn());
            }
            if (betta.equals("*")) {
                System.out.println("Результат умножения равен   " + cifra.multiplication());
            }
            if (betta.equals("/")) {
                try {
                    if (gamma == "0") {
                        throw new ArithmeticException("Делить на 0 нельзя");
                    } else {
                        System.out.println("Результат деления равен   " + cifra.division());
                    }
                } catch (ArithmeticException e) {
                    System.out.println("Делить на 0 нельзя");
                }
            }
        }



        Map<String, String> romeDictionary = new HashMap<String, String>(); // словарь арабско-римских числел1 + 4
        Map<String, String> romeArabDictionary = new HashMap<String, String>();// римско-арабский


        for (int i = 1; i < 1001; i++) {
            if (i < 10) {
                romeDictionary.put(arabs[i - 1], rome[i - 1]); // числа от 1 до 9
            }
            if (Integer.toString(i).length() == 2 && i % 10 == 0) { // если длина строки==2 круглые десятки
                romeDictionary.put(Integer.toString(i), romeTens[i / 10 - 1]);
            }
            if (i % 10 > 0 && i > 10) {   // двузначные числа единицы не равны 0
                if (Integer.toString(i).length() == 2) {
                    String n = Integer.toString(i);  // строковая переменная
                    String[] n1 = n.split(""); // разбитие строки на массив букв---строковых чисел
                    int s = Integer.valueOf(n1[0]);  // забираем элемент строки по индексу и преобразуем в числовой тип
                    int s1 = Integer.valueOf(n1[1]);
                    romeDictionary.put(Integer.toString(i), romeTens[s - 1] + rome[s1 - 1]); // заполняем словарь ключ-зачение
                }
            }
            if (Integer.toString(i).length() == 3 && i % 100 == 0) { // если длина строки 3 элем и... сотни
                romeDictionary.put(Integer.toString(i), romeHundreds[i / 100 - 1]); // зполняем словарь сотнями из массива по индексу
            }

            if (Integer.toString(i).length() == 3 && i % 10 == 0) { // длина == 3 и заканчивается на "0"
                String n = Integer.toString(i);
                String[] n1 = n.split("");
                int s = Integer.valueOf(n1[0]);
                int s1 = Integer.valueOf(n1[1]);
                if (s1 > 0) {
                    romeDictionary.put(Integer.toString(i), romeHundreds[i / 100 - 1] + romeTens[s1 - 1]);
                }
            }
            if (i > 100 && i % 10 > 0) {
                if (Integer.toString(i).length() == 3) {
                    String n = Integer.toString(i);
                    String[] n1 = n.split("");
                    int s = Integer.valueOf(n1[0]);
                    int s1 = Integer.valueOf(n1[1]);
                    int s2 = Integer.valueOf(n1[2]);

                    if (s1 == 0) {  // если второй элемент == "0" пропускаем десятки в заполнении
                        romeDictionary.put(Integer.toString(i), romeHundreds[i / 100 - 1] + rome[s2 - 1]);
                    }
                    if (s1 > 0) {  // если второй элемент в массиве строк > 0 .... с десятками
                        romeDictionary.put(Integer.toString(i), romeHundreds[i / 100 - 1] + romeTens[s1 - 1] + rome[s2 - 1]);
                    }
                }
            }
            if (Integer.toString(i).length() == 4 && i % 100 == 0) {  // тысяча
                romeDictionary.put(Integer.toString(i), romeHundreds[i / 100 - 1]);
            }

        }

        for (int i = 1; i < romeDictionary.size() + 1; i++) {
            romeArabDictionary.put(romeDictionary.get(Integer.toString(i)), Integer.toString(i));
        }




        if (f == 6) {                     // блок работы с римскими цифрами
            Algebra cifra = new Algebra(); // класс для вычислений
            cifra.alfa = Integer.valueOf(romeArabDictionary.get(alfa)); // преобразуем  римскуие цифры в арабские числовой тип
            cifra.gamma = Integer.valueOf(romeArabDictionary.get(gamma));

            int alfa_6 = cifra.alfa; // трансформированные римские числа в арабские тип инт
            int gamma_6 = cifra.gamma;

            try {
                if (alfa_6 < gamma_6 && betta.equals("-") ) {
                    throw new Exception("т.к. в римской системе нет отрицательных чисел");
                }
            } catch (Exception e) {
                System.out.println("т.к. в римской системе нет отрицательных чисел");
            }

            if (f == 6){//(Integer.valueOf(romeArabDictionary.get(alfa)) > Integer.valueOf(romeArabDictionary.get(gamma))) {

                if (betta.equals("+")) {
                    System.out.println("Результат сложения = " + romeDictionary.get(Integer.toString(cifra.suma())));
                }
                if (betta.equals("-") && alfa_6 > gamma_6) {
                    System.out.println("Результат вычитания равен   " + romeDictionary.get(Integer.toString(cifra.razn())));
                }
                if (betta.equals("*")) {
                    System.out.println("Результат умножения равен   " + romeDictionary.get(Integer.toString(cifra.multiplication())));
                }

            try {
                if (betta.equals("/")) {
                    if (cifra.division() < 1) {
                        throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    } else {
                        System.out.println("Результат деления равен   " + romeDictionary.get(Integer.toString(cifra.division())));
                    }
                }
            }catch (Exception e){
                System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
            }

            }
        }

        }

    }

    class Algebra {    // класс с методами  калькулятора
        int alfa;
        int gamma;
        int suma(){                        // метод сложения
            int result = alfa + gamma;
            return result;
        }
        int razn() {                       //метод вычитания
            int result = alfa - gamma;
            return result;
        }
        int multiplication() {             //метод умножения
            int result = alfa * gamma;
            return result;
        }
        int division() {                   // метод деления
            int result = alfa / gamma;
            return result;
        }
    }

    class Flagi {
        String alfa;
        String betta;
        String gamma;
        String[] arabs = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ;
        String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int general_array() {
            int flag1 = 0;
            if (alfa.equals("X")) {
                flag1 += 3;
            }
            if (gamma.equals("X")) {
                flag1 += 3;
            }
            if (alfa.equals("10") || (alfa.equals("0"))) {
                flag1 += 1;
            }
            if (gamma.equals("10") || (gamma.equals("0"))){
                flag1 += 1;
            }


            for (String x : arabs) {
                if (x.equals(alfa)) {
                    flag1 += 1;
                }
                if (x.equals(gamma)) {
                    flag1 += 1;
                }
            }
            for (String x : rome) {
                if (x.equals(alfa)) {
                    flag1 += 3;
                }

                if (x.equals(gamma)) {
                    flag1 += 3;
                }
            }
            int flag2 = flag1;
            return flag2;
        }

    }

