## Resultados de Profiling (Rendimiento)

Para evaluar la eficiencia de la implementación del Árbol Binario de Búsqueda (BST), se realizó un profiling utilizando un dataset generado dinámicamente de **100,000 elementos** aleatorios.

| Operación | Cantidad de Elementos | Tiempo de Ejecución |
| :--- | :--- | :--- |
| **Inserción** | 100,000 asociaciones | `222 ms` |
| **Búsqueda** | 1 elemento (promedio) | `1490 ns` |

**Conclusión del Profiling:** Los resultados demuestran la eficiencia de la estructura BST. A pesar de tener 100,000 registros, el tiempo de búsqueda por elemento se mantiene en el orden de los nanosegundos gracias a que la complejidad algorítmica de búsqueda en un árbol (idealmente balanceado) tiende a O(log n).
