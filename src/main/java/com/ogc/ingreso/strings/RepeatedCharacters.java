package com.ogc.ingreso.strings;

import java.util.HashMap;
import java.util.Map;

public class RepeatedCharacters {

	/**
	 * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple
	 * con alguna de las siguientes propiedades: 1- Todos los caracteres aparecen la
	 * misma cantidad de veces. Ejemplos: "aabbcc", "abcdef", "aaaaaa" 2- Todos los
	 * caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece
	 * un vez mas o una vez menos. Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
	 * 
	 * @param cadena la cadena a evaluar
	 * @return booleano indicando si la cadena cumple con las propiedades
	 */
	public Boolean isValid(String cadena) {
		// Eliminar espacios de la cadena
		cadena = cadena.replace(" ", "");

		// Crear un mapa para contar la frecuencia de cada carácter
		Map<Character, Integer> charCountMap = new HashMap<>();

		// Contar las apariciones de cada carácter
		for (char c : cadena.toCharArray()) {
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}

		// Crear un mapa auxiliar para contar las frecuencias de los valores
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int count : charCountMap.values()) {
			frequencyMap.put(count, frequencyMap.getOrDefault(count, 0) + 1);
		}

		// Si todos los caracteres tienen la misma frecuencia, condición 1
		if (frequencyMap.size() == 1) {
			return true;
		}

		// Si hay exactamente dos frecuencias diferentes, evaluar condición 2
		if (frequencyMap.size() == 2) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			for (int key : frequencyMap.keySet()) {
				min = Math.min(min, key);
				max = Math.max(max, key);
			}

			// Verificar si la diferencia entre max y min es 1 y max ocurre solo una vez
			if (max - min == 1 && frequencyMap.get(max) == 1) {
				return true;
			}

			// Verificar si min es 1 y ocurre solo una vez
			if (min == 1 && frequencyMap.get(min) == 1) {
				return true;
			}
		}

		// Si no cumple ninguna condición
		return false;
	}

}
