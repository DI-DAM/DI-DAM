---
layout: default
---


# Checkbox

Checkbox forma part del paquet JavaFX. És una casella amb una marca quan està seleccionada i buida quan no està seleccionada. Al principi, les caselles de verificació poden semblar similars als radio Button, però existeix la diferència entre elles que les caselles de verificació no es poden combinar en grups d'alternança, la qual cosa significa que no podem seleccionar diverses opcions al mateix temps.

![checkbox](./images/checkbox1.gif)

El checBox pot estar en els següents estats:
- **Checked**: quan indeterminat és fals i marcat és vertader
- **Unchecked**: quan indeterminat és fals i marcat és fals
- **Undefined**: quan indeterminat és vertader

Els constructors de la classe són:

1. CheckBox(): crea una casella de verificació amb una cadena buida per a la seua etiqueta.
2. ChecBox(String t): crea una casella de verificació amb el text donat com a etiqueta.

Els mètodes més utilitzats són:

- **isIndeterminate()**: Obté el valor de la propietat indeterminat.
- **isSelected()**: Obté el valor de la propietat selected.
- **selectedProperty()**: Indica si aquesta casella de verificació està marcada.
- **setIndeterminate(boolean v)**: Estableix el valor de la propietat indeterminat.
- **setSelected(boolean v)**: Estableix el valor de la propietat seleccionada.

El codi fxml del checkbox seria:

~~~
<CheckBox fx:id="cbgroc" mnemonicParsing="false" text="Grog">
</CheckBox>
~~~



[back](../../javafx.html)

