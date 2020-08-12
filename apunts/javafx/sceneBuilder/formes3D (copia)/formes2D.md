---
layout: default
---

# Java FX - Formes 2D

En algunes de les aplicacions, necessitem mostrar formes bidimensionals a l'usuari. No obstant això, JavaFX ofereix la flexibilitat de crear les nostres pròpies formes 2D en la pantalla.

Hi ha diverses classes que es poden utilitzar per a implementar formes 2D en la nostra aplicació. Totes aquestes classes resideixen en el paquet javafx.scene.shape.

Aquest paquet conté les classes que representen diferents tipus de maneres 2D. Hi ha diversos mètodes en les classes que s'ocupen de les coordenades relacionades amb la creació de maneres 2D.

### Què són les formes 2D?

En general, una forma bidimensional es pot definir com la figura geomètrica que es pot dibuixar en el sistema de coordenades que consta de plans X e Y. Tanmateix, això és diferent de les formes 3D en el sentit que cada punt de la forma 2D sempre consta de dues coordenades (X, Y).

Usant JavaFX, podem crear formes 2D com a Línia, Rectangle, Cercle, El·lipse, Polígon, Corba cúbica, corba quàdruple, Arc, etc. La classe javafx.scene.shape.Shape és la classe base per a totes les classes de formes.

### Com crear formes 2D?

Com esmentem anteriorment, cada forma està representada per una classe específica del paquet javafx.scene.shape. Per a crear una forma bidimensional, s'han de seguir les següents instruccions.

1. Creu una instància de la classe respectiva: per
 exemple, `Rectangle rect = new Rectangle()`

2. Estableix les propietats necessàries per a la classe utilitzant mètodes d'establiment d'instàncies: per exemple,

~~~
rect.setX (10);
rect.setY (20);
rect.setWidth (100);
rect.setHeight (100);
~~~

3. Afegeix un objecte de classe al disseny de grup: per exemple,

~~~
Group root = new Group();
     root.getChildren().add(rect);
~~~

Seguidament es mostren de les classes de formes JavaFX juntament amb les seues descripcions.

- **Línia** En general, Línia és la figura geomètrica que uneix dos punts (X, Y) en un sistema de coordenades 2D. En JavaFX, és necessari crear una instància de la classe javafx.scene.shape.Line per a crear línies.
- **Rectangle** En general, Rectangle és la figura geomètrica amb dos parells de dos costats iguals i quatre angles rectes en la seua unió. En JavaFX, és necessari crear una instància de la classe javafx.scene.shape.Rectangle per a crear Rectangles.
- **El·lipse** En general, l'el·lipse es pot definir com una corba amb dos punts focals. La suma de les distàncies als punts focals és constant des de cada punt de l'el·lipse. En JavaFX. S'ha de crear una instància de la classe javafx.scene.shape.Ellipse per a crear Ellipse.
- **Arc** es pot definir com la part de la circumferència del cercle de l'el·lipse. En JavaFX, s'ha de crear una instància de la classe javafx.scene.shape.Arc per a poder crear Arcs.
- **Cercle** Un cercle és el tipus especial d'El·lipse que té tots dos punts focals en la mateixa ubicació. En JavaFX, Circle es pot crear instanciando la classe javafx.scene.shape.Circle.
- **Polígon** Polígon és una figura geomètrica que es pot crear unint els múltiples segments de línia del Co-planificador. En JavaFX, javafx.scene.shape. És necessari crear una instància de la classe Pollygon per a crear un polígon.
- **Corba cúbica** Una corba cúbica és una corba de grau 3 en el pla XY. En Javafx, s'ha de crear una instància de la classe javafx.scene.shape.CubicCurve per a crear corbes cúbiques.
- **Corba quadrada** Una Quad Corbe és una corba de grau 2 en el pla XY. En JavaFX, és necessari crear una instància de la classe javafx.scene.shape.QuadCurve per a crear QuadCurve.

## Propietats de la forma

https://www.javatpoint.com/javafx-shape-properties




[back](../../javafx.html)