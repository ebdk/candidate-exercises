package com.ogc.ingreso.alphabetSoup;

public class WordSearcher {

	private char soup[][];
    private int rows;
	private int cols;

	public WordSearcher(char soup[][]) {
		this.soup = soup;
		this.rows = soup.length;
		this.cols = soup[0].length;
	}

	/**
	 * El objetivo de este ejercicio es implementar una función que determine si una
	 * palabra está en una sopa de letras.
	 *
	 * ### Reglas - Las palabras pueden estar dispuestas direcciones horizontal o
	 * vertical, _no_ en diagonal. - Las palabras pueden estar orientadas en
	 * cualquier sentido, esto es, de derecha a izquierda o viceversa, y de arriba
	 * para abajo o viceversa. - El cambio de dirección puede estar a media palabra,
	 * de modo que, por ejemplo, parte de la palabra esté horizontal y de izquierda
	 * a derecha, parte esté vertical y de arriba hacia abajo, y otra parte
	 * horizontal de derecha a la izquierda.
	 *
	 * @param word Palabra a buscar en la sopa de letras.
	 *
	 * @return {@link Boolean} true si la palabra se encuentra en la sopa de letras.
	 */
	public boolean isPresent(String word) {
		char[] wordArray = word.toCharArray();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (searchFrom(i, j, wordArray, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean searchFrom(int row, int col, char[] word, int index) {
		// Verificar límites y coincidencia del carácter actual
		if (row < 0 || row >= rows || col < 0 || col >= cols || soup[row][col] != word[index]) {
			return false;
		}

		// Si todos los caracteres coinciden, la palabra está encontrada
		if (index == word.length - 1) {
			return true;
		}

		// Marca la celda como visitada
		char temp = soup[row][col];
		soup[row][col] = '#';

		// Buscar en las 4 direcciones posibles: izquierda, derecha, arriba, abajo
		boolean found = searchFrom(row, col - 1, word, index + 1) || // Izquierda
				searchFrom(row, col + 1, word, index + 1) || // Derecha
				searchFrom(row - 1, col, word, index + 1) || // Arriba
				searchFrom(row + 1, col, word, index + 1);   // Abajo

		// Restaurar la celda original después de la búsqueda
		soup[row][col] = temp;

		return found;
	}

}
