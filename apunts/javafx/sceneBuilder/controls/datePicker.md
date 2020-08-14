---
layout: default
---

# Date Picker

DatePicker permet seleccionar la data del calendari emergent o escriure el text manualment en el camp de text del selector de data.

Els constructors de la classe DatePicker són:

- **DatePicker()**: crea una instància predeterminada de DatePicker amb un valor de data nul establit.
- **DatePicker(LocalDate l)**: crea una instància de DatePicker i estableix el valor en la data donada.

Mètodes d'ús comú:
- **getChronology()**: Obté el valor de la cronologia de la propietat.
- **getEditor()**: retorna l'editor de text del selector de data
- **isShowWeekNumbers()**: retorna si el número de setmana es mostra o no
- **setChronology(Chronology v)**: Estableix el valor de la cronologia de la propietat.
- **setShowWeekNumbers(boolean v)**: estableix el selector de data per a mostrar el número de setmana si el valor vertader es passa com a argument

En el següent exemple es crea un datePicker i se li asigna el dia, mes i any a un label. Per extraure aquestos tres valors utilitzem:

![DatePicker1](./images/datePicker1.gif) 

~~~
// Per utilitzar botó similar a SplitMenuButton
colorPicker.getStyleClass().add("split-button");
 
// Per utilitzar botó similar a MenuButton
colorPicker.getStyleClass().add("button");
~~~



[back](../../javafx.html)

