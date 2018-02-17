import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//http://www.spoj.com/problems/ARITH/

public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while ((line = bf.readLine()) != null) {
            String firstDigit = "";
            String secondDigit = "";

            if (line.contains("+")) {
                firstDigit = line.split("\\+")[0];
                secondDigit = line.split("\\+")[1];
                int result = 0;

                try {
                    result = Integer.parseInt(line.split("\\+")[0]) +
                            Integer.parseInt(line.split("\\+")[1]);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    continue;
                }
                String stringResult = String.valueOf(result);

                String dashedLine = "";
                int dashedLineLength = 0;

                if (firstDigit.length() > secondDigit.length() + 1) {
                    secondDigit = "+" + secondDigit;
                    secondDigit = String.format("%1$" + ((firstDigit.length() - secondDigit.length()) + secondDigit.length()) + "s", secondDigit);

                    if (stringResult.length() > firstDigit.length()) {
                        firstDigit = " " + firstDigit;
                        secondDigit = " " + secondDigit;
                        dashedLineLength = stringResult.length();
                    } else {
                        dashedLineLength = stringResult.length();
                    }
                } else if (firstDigit.length() == secondDigit.length() + 1) {
                    secondDigit = "+" + secondDigit;

                    if (stringResult.length() > secondDigit.length()) {
                        firstDigit = " " + firstDigit;
                        secondDigit = " " + secondDigit;
                        dashedLineLength = stringResult.length();
                    } else {
                        dashedLineLength = stringResult.length();
                    }
                } else if (firstDigit.length() < secondDigit.length() + 1) {
                    secondDigit = "+" + secondDigit;
                    firstDigit = String.format("%1$" + ((secondDigit.length() - firstDigit.length()) + firstDigit.length()) + "s", firstDigit);

                    if (stringResult.length() > secondDigit.length()) {
                        firstDigit = " " + firstDigit;
                        secondDigit = " " + secondDigit;
                        dashedLineLength = stringResult.length();
                    } else if (stringResult.length() == secondDigit.length()) {
                        dashedLineLength = secondDigit.length();
                    } else {
                        dashedLineLength = secondDigit.length();
                        stringResult = " " + stringResult;
                    }
                }

                for (int i = 0; i < dashedLineLength; i++) {
                    dashedLine = dashedLine + "-";
                }

                System.out.println(firstDigit);
                System.out.println(secondDigit);
                System.out.println(dashedLine);
                System.out.println(stringResult);
                System.out.println(" ");
            } else if (line.contains("-")) {
                firstDigit = line.split("-")[0];
                secondDigit = line.split("-")[1];

                int result = 0;

                try {
                    result = Integer.parseInt(line.split("-")[0]) -
                            Integer.parseInt(line.split("-")[1]);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    continue;
                }
                String stringResult = String.valueOf(result);

                String dashedLine = "";
                int dashedLineLenght = 0;

                if (firstDigit.length() > secondDigit.length() + 1) {
                    secondDigit = "-" + secondDigit;
                    secondDigit = String.format("%1$" + ((firstDigit.length() - secondDigit.length()) + secondDigit.length()) + "s", secondDigit);

                    if (stringResult.length() == firstDigit.length()) {
                        dashedLineLenght = stringResult.length();
                    } else if (stringResult.length() < firstDigit.length()) {
                        stringResult = String.format("%1$" + ((firstDigit.length() - stringResult.length()) + stringResult.length()) + "s", stringResult);
                        dashedLineLenght = firstDigit.length();
                    }
                } else if (firstDigit.length() == secondDigit.length() + 1) {
                    secondDigit = "-" + secondDigit;

                    if (stringResult.length() == firstDigit.length()) {
                        dashedLineLenght = stringResult.length();
                    } else if (stringResult.length() < firstDigit.length()) {
                        stringResult = String.format("%1$" + ((firstDigit.length() - stringResult.length()) + stringResult.length()) + "s", stringResult);
                        dashedLineLenght = firstDigit.length();
                    }
                } else if (firstDigit.length() < secondDigit.length() + 1) {
                    secondDigit = "-" + secondDigit;
                    firstDigit = String.format("%1$" + ((secondDigit.length() - firstDigit.length()) + firstDigit.length()) + "s", firstDigit);

                    if (stringResult.length() == secondDigit.length()) {
                        dashedLineLenght = stringResult.length();
                    } else if (stringResult.length() < secondDigit.length()) {
                        stringResult = String.format("%1$" + ((secondDigit.length() - stringResult.length()) + stringResult.length()) + "s", stringResult);

                        dashedLineLenght = firstDigit.length();
                    }
                }

                for (int i = 0; i < dashedLineLenght; i++) {
                    dashedLine = dashedLine + "-";
                }

                System.out.println(firstDigit);
                System.out.println(secondDigit);
                System.out.println(dashedLine);
                System.out.println(stringResult);
                System.out.println(" ");
            } else if (line.contains("*")) {
                firstDigit = line.split("\\*")[0];
                secondDigit = line.split("\\*")[1];
                String dashLine = "";
                int dashedLineLength = 0;
                long totalResult = 0;

                if ((firstDigit.length() > 1 && firstDigit.substring(0, 1).equals("0")) ||
                        (secondDigit.length() > 1 && secondDigit.substring(0, 1).equals("0"))) {
                    System.out.println("DIGIT CANNOT START WITH 0!");
                    continue;
                }

                if (firstDigit.equals("0") || secondDigit.equals("0")) {
                    String result = "0";
                    secondDigit = "*" + secondDigit;
                    dashedLineLength = firstDigit.length() > secondDigit.length() ? firstDigit.length() : secondDigit.length();

                    if (firstDigit.length() > secondDigit.length()) {
                        result = String.format("%1$" + ((firstDigit.length() - result.length()) + result.length()) + "s", result);
                        secondDigit = String.format("%1$" + ((firstDigit.length() - secondDigit.length()) + secondDigit.length()) + "s", secondDigit);
                    } else {
                        result = String.format("%1$" + ((secondDigit.length() - result.length()) + result.length()) + "s", result);
                        firstDigit = String.format("%1$" + ((secondDigit.length() - firstDigit.length()) + firstDigit.length()) + "s", firstDigit);
                    }

                    for (int i = 0; i < dashedLineLength; i++) {
                        dashLine = dashLine + "-";
                    }

                    System.out.println(firstDigit);
                    System.out.println(secondDigit);
                    System.out.println(dashLine);
                    System.out.println(result);
                    continue;
                }

                ArrayList<String> results = new ArrayList<>();

                try {
                    totalResult = Long.parseLong(firstDigit) * Long.parseLong(secondDigit);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    continue;
                }

                char[] charArr = secondDigit.toCharArray();

                for (int i = 0; i < charArr.length; i++) {
                    long tempResult = Long.parseLong(firstDigit) * Character.getNumericValue(charArr[i]);
                    String result = String.valueOf(tempResult);
                    results.add(0, result);
                }

                String dashLineTotal = "";
                int dashedLineLengthTotal = String.valueOf(totalResult).length(); // the longest

                for (int i = 0; i < dashedLineLengthTotal; i++) {
                    dashLineTotal = dashLineTotal + "-";
                }

                if (firstDigit.length() > secondDigit.length() + 1) {
                    if (firstDigit.length() == results.get(0).length() || firstDigit.length() > results.get(0).length()) {
                        dashedLineLength = firstDigit.length();
                    } else if (firstDigit.length() < results.get(0).length()) {
                        dashedLineLength = results.get(0).length();
                    }
                } else if (firstDigit.length() == secondDigit.length() + 1) {
                    if (firstDigit.length() == results.get(0).length() || firstDigit.length() > results.get(0).length()) {
                        dashedLineLength = firstDigit.length();
                    } else if (firstDigit.length() < results.get(0).length()) {
                        dashedLineLength = results.get(0).length();
                    }
                } else if (firstDigit.length() < secondDigit.length() + 1) {
                    if (secondDigit.length() + 1 == results.get(0).length()) {
                        dashedLineLength = secondDigit.length() + 1;
                    } else if (secondDigit.length() + 1 < results.get(0).length()) {
                        dashedLineLength = results.get(0).length();
                    } else if (secondDigit.length() + 1 > results.get(0).length()) {
                        dashedLineLength = secondDigit.length() + 1;
                    }
                }

                for (int i = 0; i < dashedLineLength; i++) {
                    dashLine = dashLine + "-";
                }

                System.out.println(String.format("%1$" + ((String.valueOf(totalResult).length() - firstDigit.length()) + firstDigit.length()) + "s", firstDigit));
                System.out.println(String.format("%1$" + ((String.valueOf(totalResult).length() - ("*" + secondDigit).length()) + ("*" + secondDigit).length()) + "s", "*" + secondDigit));
                System.out.println(String.format("%1$" + ((String.valueOf(totalResult).length() - dashLine.length()) + dashLine.length()) + "s", dashLine));

                if (results.size() == 1) {
                    System.out.println(totalResult);
                    System.out.println(" ");
                    continue;
                }

                for (int i = 0; i < results.size(); i++) {
                    String temp = results.get(i);
                    StringBuilder sb = new StringBuilder();

                    for (int a = 0; a < String.valueOf(totalResult).length() - temp.length(); a++) {
                        sb.append(" ");
                    }

                    String readyString = sb.toString() + temp;
                    System.out.println(readyString.substring(i));
                }

                System.out.println(dashLineTotal);
                System.out.println(totalResult);
                System.out.println(" ");
            }
        }
    }
}