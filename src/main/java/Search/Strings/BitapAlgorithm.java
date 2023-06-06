package Search.Strings;

import java.util.ArrayList;
import java.util.List;

public class BitapAlgorithm {

    public static List<Integer> fuzzyBitapSearch(String text, String pattern, int maxErrors) {
        int m = pattern.length(); // Długość wzorca
        int n = text.length(); // Długość tekstu

        int[] lastRow = new int[n + 1]; // Poprzedni wiersz w macierzy bitowej
        int[] currentRow = new int[n + 1]; // Aktualny wiersz w macierzy bitowej

        int mask = 1; // Maska bitowa reprezentująca obecność znaku w wzorcu

        for (int i = 0; i < m; i++) {
            mask |= (1 << i); // Ustawienie odpowiednich bitów w masce
        }

        List<Integer> matches = new ArrayList<>(); // Lista przechowująca indeksy dopasowań

        for (int i = 0; i <= n; i++) {
            lastRow[i] = mask; // Inicjalizacja poprzedniego wiersza maską
        }

        for (int i = 0; i < m; i++) {
            currentRow[0] = (lastRow[0] << 1) | 1; // Przesunięcie wiersza o 1 w lewo i ustawienie najmłodszego bitu na 1

            for (int j = 1; j <= n; j++) {
                int deletion = lastRow[j] << 1; // Przesunięcie wiersza o 1 w lewo (usunięcie znaku)
                int insertion = currentRow[j - 1] << 1; // Przesunięcie wiersza o 1 w lewo (wstawienie znaku)
                int substitution = lastRow[j - 1] << 1; // Przesunięcie wiersza o 1 w lewo (zamiana znaku)

                if (pattern.charAt(i) != text.charAt(j - 1)) {
                    substitution |= 1; // Jeśli znaki się różnią, ustawienie najmłodszego bitu na 1 w wierszu zamiany
                }

                currentRow[j] = deletion & insertion & substitution; // Aktualizacja wartości w bieżącym wierszu

                if ((currentRow[j] & (1 << (m - 1))) != 0) {
                    matches.add(j - m); // Jeśli najstarszy bit w bieżącym wierszu jest ustawiony, dodaj indeks dopasowania
                }
            }

            int[] temp = lastRow;
            lastRow = currentRow;
            currentRow = temp;
        }

        // Rozmyte dopasowanie
        if (maxErrors > 0 && matches.isEmpty()) {
            int[] errorCounts = new int[n + 1]; // Tablica zliczająca liczbę błędów w poszczególnych indeksach

            for (int match : lastRow) {
                int errors = Integer.bitCount(match ^ mask); // Obliczanie liczby różniących się bitów między dopasowaniem a maską
                errorCounts[errors]++; // Zwiększanie licznika błędów dla danej liczby różniących się bitów
            }

            int totalErrors = 0;
            for (int errors = 1; errors <= maxErrors; errors++) {
                totalErrors += errorCounts[errors]; // Sumowanie łącznej liczby błędów dla danej liczby różniących się bitów

                if (totalErrors > 0) {
                    for (int j = m; j <= n; j++) {
                        if (errorCounts[errors] > 0 && lastRow[j] == (mask ^ (1 << (m - 1)))) {
                            matches.add(j - m); // Dodawanie indeksów dopasowań dla błędów poniżej maksymalnej liczby
                            errorCounts[errors]--;
                            totalErrors--;
                        }
                    }
                }
            }
        }
        return matches;
    }



}

