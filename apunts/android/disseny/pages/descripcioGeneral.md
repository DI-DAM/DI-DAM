---
layout: default
---

# Interfície d'usuari i navegació 

#Disseny

Un disseny defineix l'estructura d'una interfície d'usuari en la teua aplicació, com, per exemple, en una activitat. Tots els elements del disseny es creen usant una jerarquia d'objectes View i ViewGroup. Una [View](https://developer.android.com/reference/android/view/View?hl=es-419) sol mostrar un element que l'usuari pot veure i amb el qual pot interactuar. Per part seua, [ViewGroup](https://developer.android.com/reference/android/view/ViewGroup?hl=es-419) és un contenidor invisible que defineix l'estructura de disseny de View i altres objectes ViewGroup.

![view group](./images/viewgroup.png)

Els objectes View solen dir-se "widgets" i poden ser una de les moltes subclasses, com [Button](https://developer.android.com/reference/android/widget/Button?hl=es-419) o [TextView](https://developer.android.com/reference/android/widget/TextView?hl=es-419). Els objectes ViewGroup es denominen generalment "dissenys" i poden ser de molts tipus que proporcionen una estructura diferent, com [LinearLayout](https://developer.android.com/reference/android/widget/LinearLayout?hl=es-419) o [ConstraintLayout](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout?hl=es-419).

Pots declarar un disseny de dues maneres:

- **Declarar elements de la IU en XML**. Android proporciona un vocabulari XML simple que coincideix amb les classes i subclasses de vistes, com les que s'usen per a widgets i dissenys.

    També pots utilitzar la funció Layout Editor d'Android Studio per a crear el teu disseny XML mitjançant una interfície d'arrossegar i soltar.

- **Crear una instància d'elements de disseny durant el temps d'execució**. La teua aplicació pot crear objectes View i ViewGroup (i manipular les seues propietats) de manera programàtica.

Declarar el teu IU en XML et permet separar la presentació de la teua aplicació del codi que controla el seu comportament. L'ús d'arxius XML també facilita la creació de diferents dissenys per a diferents grandàries de pantalla i orientacions.

El marc de treball d'Android t'ofereix la flexibilitat d'usar un d'aquests mètodes o tots dos per a crear l'IU de la teua aplicació. Per exemple, pots declarar els dissenys predeterminats de la teua aplicació en XML i, després, modificar el disseny durant el temps d'execució.

> Suggeriment: Per a depurar el teu disseny durant el temps d'execució, usa l'eina [Layout Inspector](https://developer.android.com/studio/debug/layout-inspector?hl=es-419).

## Escriu en XML

En usar vocabulari XML d'Android, pots crear ràpidament dissenys d'IU i dels elements de pantalla que contenen, de la mateixa manera que cregues pàgines web en HTML, amb una sèrie d'elements niats.

Cada arxiu de disseny ha de contindre exactament un element arrel, que ha de ser un objecte View o ViewGroup. Una vegada que hages definit l'element arrel, pots agregar ginys o objectes de disseny addicionals com a elements secundaris per a crear gradualment una jerarquia de vistes que definisca el teu disseny. Per exemple, ací et vam mostrar un disseny XML que usa un LinearLayout vertical per a incloure una TextView i un Button:

~~~
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:orientation="vertical" >
    <TextView android:id="@+id/text"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Hello, I am a TextView" />
    <Button android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello, I am a Button" />
</LinearLayout>
~~~

Després de declarar el teu disseny en XML, guarda l'arxiu amb l'extensió .xml en el directori cap de bestiar/layout/ del teu projecte d'Android perquè puga compilar-se correctament.

Pots trobar més informació sobre la sintaxi per a un arxiu de disseny XML en el document Recursos de disseny.

## Càrrega el recurs XML

Quan compiles la teua aplicació, cada arxiu de disseny XML es compila en un recurs View. Has de carregar el recurs de disseny des del codi de la teua aplicació, en la implementació de devolució de la cridada a [Activity.onCreate()](https://developer.android.com/reference/android/app/Activity?hl=es-419#onCreate(android.os.Bundle)). Per a això, crida a [setContentView()](https://developer.android.com/reference/android/app/Activity?hl=es-419#setContentView(int)) passant la referència al teu recurs de disseny en forma de R.layout.layout_file_name. Per exemple, si el teu disseny XML es guarda com main_layout.xml, els carregaràs per a la teua activitat de la mateixa manera:

~~~
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
}
~~~

El marc de treball d'Android crida al mètode de devolució anomenat onCreate() en la teua activitat quan aquesta es llança.

## Atributs

Cada objecte View i ViewGroup admet la seua pròpia varietat d'atributs XML. Alguns atributs són específics d'un objecte View (per exemple, TextView admet l'atribut textSize), encara que aquests atributs també són heretats per qualsevol objecte View que puga estendre aquesta classe. Alguns són comuns per a tots els objectes View, perquè s'hereten de la classe arrel View (com l'atribut id). Altres atributs es consideren "paràmetres de disseny" i són atributs que descriuen unes certes orientacions de disseny de l'objecte View, tal com el defineix l'objecte principal ViewGroup d'aqueix objecte.

## ID

Qualsevol objecte View pot tindre un ID enter associat per a identificar-se de manera única dins de l'arbre. Quan es compila l'aplicació, es fa referència a aquest ID com un nombre enter, però l'ID s'assigna normalment en l'arxiu XML de disseny com una string de l'atribut id. Aquest és un atribut XML comú per a tots els objectes View (definit per la classe View) i l'utilitzaràs molt sovint La sintaxi d'un ID dins d'una etiqueta XML és la següent:

~~~
android:id="@+id/my_button"
~~~

El símbol arrova (**@**) al començament de la string indica que l'analitzador de XML ha d'analitzar i expandir la resta de la string de ID i identificar-la com un recurs d'ID. El símbol més (**+**) significa que és un nou nom de recurs que s'ha de crear i agregar als nostres recursos (en l'arxiu R.java). El marc de treball d'Android ofereix altres recursos d'ID. En fer referència a un ID de recurs d'Android, no necessites el símbol més, però has d'agregar l'espai de noms de paquet android de la següent manera:

~~~
android:id="@android:id/empty"
~~~

Amb l'espai de noms de paquet android establit, ara fem referència a un ID de la classe de recursos android.R, en lloc de la classe de recursos local.

Per a crear vistes i fer referència a elles des de l'aplicació, pots seguir aquest patró comú:

Definir una vista o un widget en l'arxiu de disseny i assignar-li un ID únic:

~~~
Button android:id="@+id/my_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/my_button_text"/>
~~~

Després, crear una instància de l'objecte View i capturar-la des del disseny (generalment en el mètode onCreate()):

~~~
Button myButton = (Button) findViewById(R.id.my_button);
~~~

Definir ID per a objectes View és important quan es crea un [RelativeLayout](https://developer.android.com/reference/android/widget/RelativeLayout?hl=es-419). En un disseny relatiu, les vistes del mateix nivell poden definir el seu disseny en funció d'una altra vista del mateix nivell, que s'identifica amb un ID únic.

No és necessari que un ID siga únic en tot l'arbre, però ha de ser únic dins de la part de l'arbre en la qual estàs buscant (que sovint pot ser l'arbre complet, per la qual cosa és millor que, en la mesura del possible, siga sempre únic).

## Paràmetres de disseny

Els atributs de disseny XML denominats *layout_something* defineixen paràmetres de disseny per a l'objecte View que són adequats per a l'objecte ViewGroup en el qual resideix.

Cada classe ViewGroup implementa una classe aniada que estén [ViewGroup.LayoutParams](https://developer.android.com/reference/android/view/ViewGroup.LayoutParams?hl=es-419). Aquesta subclasse conté tipus de propietat que defineixen la grandària i la posició de cada vista secundària, segons resulte apropiat per al grup de vistes. Com pots veure en la figura, el grup de vistes principal defineix paràmetres de disseny per a cada vista secundària (inclòs el grup de vistes secundari).

![view group](./images/disseny.png)

Figura: Visualització d'una jerarquia de vistes amb paràmetres de disseny associats amb cada vista

Tingues en compte que cada subclasse LayoutParams té la seua pròpia sintaxi per a configurar valors. Cada element secundari ha de definir LayoutParams adequats per al seu element primari, encara que també pot definir diferents LayoutParams per als seus propis elements secundaris.

Tots els grups de vistes inclouen un ample i una altura (**layout_width** i **layout_height**), i cada vista ha de definir-los. Molts LayoutParams també inclouen marges i vores opcionals.

Pots especificar l'ample i l'altura amb mesures exactes, encara que probablement no vols fer-ho amb molta freqüència. Generalment, usaràs una d'aquestes constants per a establir l'ample o l'altura:

- **wrap_content** indica a la teua vista que modifique la seua grandària conforme als requisits d'aquest contingut.
- **match_parent** indica a la teua vista que s'engrandisca tant com ho permeta el seu grup de vistes principal.

En general, no es recomana especificar l'ample ni l'altura d'un disseny amb unitats absolutes com a píxels. En canvi, l'ús de mesures relatives com a **unitats de píxels independents de densitat (dp), wrap_content o match_parent** és un millor enfocament, ja que ajuda a garantir que la teua aplicació es mostre correctament en dispositius amb pantalles de diferents grandàries. Els tipus de mesures acceptats es defineixen en el document Recursos disponibles.

## Posició del disseny

La geometria d'una vista és la d'un rectangle. Una vista té una ubicació, expressada com un parell de coordenades esquerra i superior, i dues dimensions, expressades com un ample i una altura. La unitat per a la ubicació i les dimensions és el píxel.

És possible recuperar la ubicació d'una vista en invocar els mètodes [getLeft()](https://developer.android.com/reference/android/view/View?hl=es-419#getLeft()) i [getTop()](https://developer.android.com/reference/android/view/View?hl=es-419#getTop()). El primer mostra la coordenada esquerra, o X, del rectangle que representa la vista. El segon mostra la coordenada superior, o Y, del rectangle que representa la vista. Tots dos mètodes retornen la ubicació de la vista respecte del seu element primari. Per exemple, quan getLeft() mostra 20, significa que la vista es troba a 20 píxels a la dreta de la vora esquerra del seu element primari directe.

A més, s'ofereixen diversos mètodes convenients per a evitar càlculs innecessaris, denominats [getRight()](https://developer.android.com/reference/android/view/View?hl=es-419#getRight()) i [getBottom()](https://developer.android.com/reference/android/view/View?hl=es-419#getBottom()). Aquests mètodes mostren les coordenades de les vores dret i superior del rectangle que representa la vista. Per exemple, cridar a getRight() és similar al següent càlcul: getLeft() + getWidth().

## Grandària, farciment i marges

La grandària d'una vista s'expressa amb un ample i una altura. En realitat, una vista té dos parells de valors d'ample i altura.

El primer parell es coneix com a **ample mesurat** i **altura mesurada**. Aquestes dimensions defineixen **que gran vol ser una vista dins del seu element primari**. Les dimensions mesurades es poden obtindre cridant a [getMeasuredWidth()](https://developer.android.com/reference/android/view/View?hl=es-419#getMeasuredWidth()) i a [getMeasuredHeight()](https://developer.android.com/reference/android/view/View?hl=es-419#getMeasuredHeight()).

El segon parell es coneix simplement com a **ample i altura**, o, algunes vegades, ample de dibuix i altura de dibuix. Aquestes dimensions defineixen la **grandària real de la vista en la pantalla en el moment de dibuixar-les i després del disseny**. Aquests valors poden ser diferents de l'ample i l'altura mesurats, però no necessàriament. L'ample i l'altura es poden obtindre cridant a [getWidth()](https://developer.android.com/reference/android/view/View?hl=es-419#getWidth()) i [getHeight()](https://developer.android.com/reference/android/view/View?hl=es-419#getHeight()).

Per a mesurar aquestes dimensions, una vista considera el seu farciment. El farciment s'expressa en píxels per a les parts esquerra, superior, dreta i inferior de la vista. El farciment es pot usar per a desplaçar el contingut de la vista una determinada quantitat de píxels. Per exemple, un farciment esquerre de 2 espenta el contingut de la vista 2 píxels cap a la dreta de la vora esquerra. El farciment es pot ajustar usant el mètode [setPadding(int, int, int, int)](https://developer.android.com/reference/android/view/View?hl=es-419#setPadding(int,%20int,%20int,%20int)) i es pot consultar cridant a [getPaddingLeft()](https://developer.android.com/reference/android/view/View?hl=es-419#getPaddingLeft()), [getPaddingTop()](https://developer.android.com/reference/android/view/View?hl=es-419#getPaddingTop()), [getPaddingRight()](https://developer.android.com/reference/android/view/View?hl=es-419#getPaddingRight()) i [getPaddingBottom()](https://developer.android.com/reference/android/view/View?hl=es-419#getPaddingBottom()).

Si bé una vista pot definir un farciment, no proporciona cap mena de compatibilitat per a marges. No obstant això, els grups de vistes sí que la proporcionen. Consulta ViewGroup i [ViewGroup.MarginLayoutParams](https://developer.android.com/reference/android/view/ViewGroup.MarginLayoutParams?hl=es-419) per a obtindre més informació.

Per a obtindre més informació sobre les dimensions, llig [Valors de dimensió](https://developer.android.com/guide/topics/resources/more-resources?hl=es-419#Dimension).

## Dissenys comuns

Cada subclasse de la classe ViewGroup proporciona una manera única de mostrar les vistes que aniden en ella. Ací tens alguns dels tipus de disseny més comuns integrats en la plataforma Android.

> Nota: Si bé pots anidar un o més dissenys dins d'un altre disseny per a crear la presentació de la IU, has d'esforçar-te per mantindre la teua jerarquia de disseny el més senzilla possible. El teu disseny es processa més ràpid si té menys dissenys anidats (una jerarquia de vistes ampla és millor que una de vista profunda).


- [**Disseny lineal**](https://developer.android.com/guide/topics/ui/layout/linear?hl=es-419): Un disseny que organitza els seus elements secundaris en una sola fila horitzontal o vertical. Si la longitud de la finestra supera la de la pantalla, crea una barra de desplaçament.

![linear](./images/linearlayout.png)

- [**Disseny relatiu**](https://developer.android.com/guide/topics/ui/layout/relative?hl=es-419): Et permet especificar la ubicació dels objectes secundaris en funció d'ells mateixos (l'objecte secundari A a l'esquerra de l'objecte secundari B) o en funció de l'element primari (alineat amb la part superior de l'element primari).

![relative](./images/relativelayout.png)

- [**Vista web**](https://developer.android.com/guide/webapps/webview?hl=es-419): Mostra pàgines web.

![web](./images/webview.png)

## Creació de dissenys amb un adaptador

Quan el contingut del teu disseny siga dinàmic o no siga predeterminat, pots usar un disseny amb la subclasse [AdapterView](https://developer.android.com/reference/android/widget/AdapterView?hl=es-419) per a completar el disseny amb vista durant el temps d'execució. Una subclasse de la classe AdapterView usa un [Adapter](https://developer.android.com/reference/android/widget/Adapter?hl=es-419) per a enllaçar dades amb el seu disseny. Adapter es comporta com a intermediari entre la font de dades i el disseny AdapterView; Adapter recupera les dades (d'una font com una matriu o una consulta a la base de dades) i converteix cada entrada en una vista que pots agregar al disseny AdapterView.

Els dissenys comuns recolzats per un adaptador inclouen:

- [Vista de llista](https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=es-419): Mostra una sola llista de columnes desplaçable.

- [Vista de quadrícula](https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=es-419): Mostra una quadrícula desplaçable de columnes i files.

### Farciment d'una vista de l'adaptador amb dades

Pots completar una AdapterView, com [ListView]()( o [GridView](), enllaçant la instància AdapterView amb un Adapter, que recupera dades d'una font externa i crea una View que representa cada entrada de dades.

Android proporciona diverses subclasses de Adapter que resulten útils per a recuperar diferents tipus de dades i generar vistes per a una AdapterView. Els dos adaptadors més comuns són els següents:

#### [ArrayAdapter](https://developer.android.com/reference/android/widget/ArrayAdapter?hl=es-419)

Usa aquest adaptador quan la font de dades siga una matriu. Segons la configuració predeterminada, ArrayAdapter crea una vista per a cada element de la matriu cridant a [toString()](https://developer.android.com/reference/java/lang/Object?hl=es-419#toString()) en cada element i disposant els continguts en una TextView.

Per exemple, si hi ha una matriu de strings que desitges visualitzar en una ListView, inicialitza un nou ArrayAdapter usant un constructor per a especificar el disseny de cada string i la matriu de strings:

~~~
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
android.R.layout.simple_list_item_1, myStringArray);
~~~

Els arguments per a aquest constructor són els següents:

- El [Context](https://developer.android.com/reference/android/content/Context?hl=es-419) de la teua app
- El disseny que conté una TextView per a cada string de la matriu
- La matriu de strings

Després, simplement, crida a setAdapter() en la teua ListView:

~~~
ListView listView = (ListView) findViewById(R.id.listview);
listView.setAdapter(adapter);
~~~

Per a personalitzar l'aspecte de cada element, pots anul·lar el mètode toString() dels objectes de la teua matriu. Com a alternativa, si desitges crear una vista per a cada element que no siga una TextView (per exemple, si desitges una ImageView per a cada element de la matriu), estén la classe de ArrayAdapter i anul·la getView() a fi de mostrar el tipus de vista que desitges per a cada element.

#### [SimpleCursorAdapter](https://developer.android.com/reference/android/widget/SimpleCursorAdapter?hl=es-419)

Usa aquest adaptador quan les teues dades provinguen d'un Cursor. Quan uses SimpleCursorAdapter, has d'especificar un disseny per a cada fila en el Cursor i quines columnes de Cursor s'han d'inserir en quines vistes del disseny. Per exemple, si desitges crear una llista de noms i números de telèfon de persones, pots realitzar una consulta que mostre un Cursor amb una fila per a cada persona i columnes per als noms i els números. Després, crearàs una matriu de strings que especifique les columnes del Cursor que desitges en el disseny per a cada resultat i una matriu amb valors sencers que especifique les vistes corresponents en les quals s'haja de col·locar cada columna:

~~~
String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME,
ContactsContract.CommonDataKinds.Phone.NUMBER};
int[] toViews = {R.id.display_name, R.id.phone_number};
~~~

Quan crees una instància del SimpleCursorAdapter, passa el disseny que s'ha d'usar per a cada resultat, el [Cursor](https://developer.android.com/reference/android/database/Cursor?hl=es-419) que conté els resultats i aquestes dues matrius:


~~~
SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
R.layout.person_name_and_number, cursor, fromColumns, toViews, 0);
ListView listView = getListView();
listView.setAdapter(adapter);
~~~

Després, el SimpleCursorAdapter crea una vista per a cada fila en el Cursor usant el disseny proporcionat en inserir cada element **fromColumns** en la vista **toViews** corresponent.

## Com manejar esdeveniments de clic

Pots respondre a esdeveniments de clic en cada element d'una AdapterView en implementar la interfície AdapterView.OnItemClickListener[AdapterView.OnItemClickListener](https://developer.android.com/reference/android/widget/AdapterView.OnItemClickListener?hl=es-419).
Per exemple:

~~~
// Create a message handling object as an anonymous class.
private OnItemClickListener messageClickedHandler = new OnItemClickListener() {
public void onItemClick(AdapterView parent, View v, int position, long aneu) {
// Do something in response to the clic
}
};

listView.setOnItemClickListener(messageClickedHandler);
~~~




[back](../..)