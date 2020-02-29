package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[]{};
        }

        int tmp = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 1; i > 0; i--) {
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[0] = tmp;
        return inputArray;

    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        int max = -999999999;
        int tmpq = -1;
        int max2 = -999999999;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max) {
                max = inputArray[i];
                tmpq = i;
            }
            if (inputArray[i] > max2 && i != tmpq) {
                max2 = inputArray[i];
            }
        }
        return max * max2;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        double val = 0;
        if (input == null) {
            return 0;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'A' || input.charAt(i) == 'a' || input.charAt(i) == 'b' || input.charAt(i) == 'B') {
                val++;
            }
        }
        return (int) (val / input.length() * 100);
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) == input.charAt(input.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        input += " ";
        String anw = "";
        int q = 1;
        int i = 1;
        while (i < input.length()) {
            while (input.charAt(i) == input.charAt(i - 1)) {
                q++;
                i++;
            }
            anw += input.charAt(i - 1) + Integer.toString(q);
            q = 1;
            i++;
        }

        return anw;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() == 0 || two.length() == 0) {
            return false;
        }
        char[] array1 = one.toCharArray();
        char[] array2 = two.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return (Arrays.equals(array1, array2));
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] array1 = s.toCharArray();
        Arrays.sort(array1);
        for (int i = 1; i < array1.length; i++) {
            if (array1[i] == array1[i - 1]) {
                return false;
            }
        }
        return true;

    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m.length == 0) {
            return new int[][]{{}, {}};
        }
        for (int i = 0; i < m[0].length; i++) {
            for (int j = i + 1; j < m[0].length; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        String answ = "";
        if (inputStrings == null || inputStrings == new String[]{}) {
            return answ;
        }
        if (separator == null) {
            separator = ' ';
        }
        int i;
        for (i = 0; i < inputStrings.length - 1; i++) {
            answ += inputStrings[i] + separator;
        }
        if (i < inputStrings.length) {
            answ += inputStrings[i];
        }
        return answ;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || inputStrings.length == 0|| prefix==null) {
            return 0;
        }
        int answ = 0;
        for (int i = 0; i < inputStrings.length; i++) {

            for (int j = 0; j < prefix.length(); j++) {
                if (inputStrings[i].charAt(j) != prefix.charAt(j)) {
                    break;
                }
                if (j == prefix.length() - 1) {
                    answ++;
                }
            }
        }
        return answ; // TODO solve
    }
}
