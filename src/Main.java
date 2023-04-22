public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().romanToInt("III"));
        System.out.println(new Main().romanToInt("LVIII"));
        System.out.println(new Main().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String string) {
        int result = 0;
        char[] chars = string.toCharArray();
        for (int e = 0; e < chars.length; e++) {
            String tmpStart = String.valueOf(chars[e]);
            String tmpFinish;
            if (e + 1 < chars.length) {
                tmpFinish = tmpStart + (chars[e + 1]);
            } else {
                tmpFinish = tmpStart;
            }
            switch (tmpFinish) {
                case "IV" -> {
                    result = result + 4;
                    e++;
                }
                case "IX" -> {
                    result = result + 9;
                    e++;
                }
                case "XL" -> {
                    result = result + 40;
                    e++;
                }
                case "XC" -> {
                    result = result + 90;
                    e++;
                }
                case "CD" -> {
                    result = result + 400;
                    e++;
                }
                case "CM" -> {
                    result = result + 900;
                    e++;
                }
                default -> {
                    switch (chars[e]) {
                        case 'I' -> result++;
                        case 'V' -> result = result + 5;
                        case 'X' -> result = result + 10;
                        case 'L' -> result = result + 50;
                        case 'C' -> result = result + 100;
                        case 'D' -> result = result + 500;
                        case 'M' -> result = result + 1000;
                    }
                }
            }
        }
        return result;
    }
}

