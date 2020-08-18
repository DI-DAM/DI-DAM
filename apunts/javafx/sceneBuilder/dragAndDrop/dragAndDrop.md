---
layout: default
---

# Java FX - Drag And Drop

Arrossegar i soltar permet la transferència de dades entre diversos components en la seua aplicació javafx. Permet transferir dades entre els seus nodes interns o entre dues aplicacions.

Un gest d'arrossegar i soltar ocorre de la següent manera:

- l'usuari fa clic amb el botó del mouse en una font de gestos
- arrossega el mouse 
- solta el botó del mouse en un objectiu de gestos. 

Mentre arrossega les dades, l'usuari obté retroalimentació visual, que indica ubicacions que no accepten les dades i, quan es troba sobre un objectiu que accepta les dades, dóna una pista d'on col·locar les dades.

**Les dades es transfereixen mitjançant un tauler d'arrossegament**, que té la mateixa interfície que un portapapers del sistema, però només s'utilitza per a la transferència de dades d'arrossegar i soltar. 
Es poden transferir diversos tipus de dades, com:

- text
- imatges
- URL
- arxius
- bytes
- Strings

## Rebre dades d'altres aplicacions

Rebre dades d'altres aplicacions a través d'arrossegar i soltar és molt simple en JavaFX. El mètode setOnDragOver de node permet controlar el que succeeix quan alguna cosa s'arrossega sobre el node. 

~~~
imageView.setOnDragOver(new EventHandler() {
   public void handle(DragEvent event) {
      if (event.getDragboard().hasFiles()) {
         event.acceptTransferModes(TransferMode.ANY); 
      }
      event.consume();
   }
});
~~~

En aquest codi, he agregat un controlador d'esdeveniments per a la vista d'imatge per al cas d'arrossegament. El mètode getDragboard proporciona l'objecte Dragboard que conté els arxius que es transfereixen. S'invoca el mètode hasFiles () per a assegurar-se que el contingut arrossegat siga un arxiu. Això es fa per a evitar que s'arrossegue alguna cosa que no siguen arxius, com a cadenes o contingut de text enriquit.

~~~
event.acceptTransferModes(TransferMode.ANY);
~~~

Aquesta línia fa que el component estiga llest per a acceptar les dades entrants. Com a resultat, obtindrem una mà amb un símbol més quan s'arrossegue sobre la vista d'imatge.

L'últim que hem de fer és acceptar els arxius quan se solten. El mètode setOnDragDropped permet aconseguir això. 

~~~
imageView.setOnDragDropped(new EventHandler&lt;DragEvent&gt;() {
    public void handle(DragEvent event) {
        List&lt;File&gt; files = event.getDragboard().getFiles();
        System.out.println("Got " + files.size() + " files");
        imageView.setImage(new Image(new FileInputStream(files.get(0))));
         
        event.consume();
     }
});
~~~

En aquest codi, la llista d'arxius entrants es pren usant el mètode event.getDragboard().GetFiles(). Llavors podem enviar una llista d'arxius en lloc d'un només. A partir dels arxius rebuts, hem de crear una imatge i configurar-la com a imatge per a la vista d'imatges.
Llavors, això és tan simple com una operació d'arrossegar i soltar. Ara vegem com podem implementar arrossegar i soltar per a dos nodes interns.

## Arrossegar i soltar entre dos components interns

Per a fer que un node estiga llest per a ser arrossegat, podem usar el mètode **setOnDragDetected**. Aquesta funció es dirà sempre que es realitze una operació d'arrossegament en el component. Ací, la font és una variable de text que conté una mica de text.

Quan s'arrossega la font, la classe Dragboard de javafx.scene.input.Dragboard es construeix cridant al mètode source.startDragAndDrop(). Les maneres de transferència defineixen el tipus de transferència que ocorre entre la font del gest i el destí del gest. Les maneres de transferència disponibles inclouen CÒPIA, MOURE i ENLLAÇ.
Per a enviar dades des de la font, s'usa una instància de ClipboardContent. Com estem enviant dades String, s'usa el mètode putString. Després de configurar el contingut, s'associa amb Dragboard db.
Ara la font permetrà arrossegar dades de cadena. és a dir, actua com a font.

~~~
source.setOnDragDetected(new EventHandler&lt;MouseEvent&gt;() {
    public void handle(MouseEvent event) {
        Dragboard db = source.startDragAndDrop(TransferMode.ANY);
         
        ClipboardContent content = new ClipboardContent();
        content.putString(source.getText());
        db.setContent(content);
         
        event.consume();
    }
});
~~~

Ara, necessitem configurar el text en el destí llest per a acceptar la cadena entrant. Això es pot fer usant **setOnDragOver** i **setOnDragDropped**.

Per veure el funcionament de com arrosegar i soltar en javaFX. Tant amb communicacions internes i externes, pot veure aquest [tutorial](https://www.youtube.com/watch?v=f7KGXUrAH0g)


## El gest Drag & Drop

El gest d'arrossegar i soltar, és una acció de l'usuari que combina el moviment del mouse amb un botó del mouse pressionat. S'utilitza per a transferir dades des de la font de gestos a un objectiu de gestos.

Un gest d'arrossegar i soltar permet transferir dades des de:

- Un node a un altre node
- Un node a una escena
- Una escena a una altra escena
- Una escena per a un node

Es requereixen diversos passos per a realitzar un gest d'arrossegar i soltar:

- Es pressiona un botó del mouse en un node.
- El mouse s'arrossega amb el botó pressionat.
- El node rep un esdeveniment de detecció d'arrossegament.
- L'objectiu del gest usa les dades del tauler d'arrossegament (dragboard)
- etc.

### Modes de transferència de dades

Amb un gest d'arrossegar i soltar, les dades es poden transferir en tres maneres:

- **Copy**: les dades es copiaran de l'origen del gest a la destinació del gest. Pot arrossegar un TextField i soltar-ho en un altre TextField. Aquest últim obté una còpia del text contingut en el primer.
- **Move**: les dades es mouran de l'origen del gest a la destinació del gest. Pot arrossegar un TextField i soltar-ho en un altre TextField. El text del primer es mou després al segon.
- **Link**: l'objectiu del gest crearà un enllaç (o referència) a les dades que es transfereixen. El significat real de "enllaç" depén de l'aplicació.

### Dragboard

En una transferència de dades d'arrossegar i soltar, la font del gest i el destí del gest no es coneixen. De fet, poden pertànyer a dues aplicacions diferents. Dues aplicacions JavaFX, o una JavaFX i una nadiua, per exemple. En un gest d'arrossegar i soltar, també s'utilitza un intermediari per a facilitar la transferència de dades.

Un Dragboard actua com a intermediari entre la font del gest i el destí del gest. **Un Dragboard és el dispositiu d'emmagatzematge que conté les dades que es transfereixen**. La font de gestos col·loca les dades en un Dragboard. El Dragboard està disponible per a l'objectiu del gest, per la qual cosa pot inspeccionar el tipus de contingut que està disponible per a transferir. Quan l'objectiu del gest està llest per a transferir les dades, obté les dades del Dragboard.

Una instància de la classe Dragboard representa un tauler d'arrossegament. La classe s'hereta de la classe Portapapers. Una instància de la classe Clipboard representa un portapapers del sistema operatiu. Normalment, un sistema operatiu utilitza un portapapers per a emmagatzemar dades durant les operacions de tallar, copiar i pegar.

## Passos detallats en un gest Drag & Drop

En l'exemple que ens basem,  tindrem dues TextFields mostrats en una escena. Un TextField es denomina node d'origen i l'altre node de destinació. L'usuari pot arrossegar i soltar el node d'origen en el node de destinació. Una vegada completat el gest, el text del node d'origen es transfereix (es copia o es mou) al node de destí.

### Iniciar el gest d'arrossegar i soltar

El primer pas en un gest drag&dropr és convertir un simple gest de `press-drag-release` en un gest `drag-and-drop`. Això s'aconsegueix en el controlador d'esdeveniments detectat en `mouse-drag` per a la font de gestos. Cridar al mètode startDragAndDrop() en l'origen del gest inicia un gest d'arrossegar i soltar. El mètode està disponible en les classes `Node` i `Scene`, per la qual cosa un node i una escena poden ser la font del gest d'un gest d'arrossegar i soltar.

~~~
// Initiate a drag-and-drop gesture
Dragboard dragboard = sourceFld.startDragAndDrop(TransferMode.COPY_OR_MOVE);
~~~

El mètode accepta la llista de modes de transferència admesos per la font de gestos i retorna un Dragboard. La font de gestos ha d'omplir el Dragboard amb les dades que pretén transferir. El següent fragment de codi inicia un gest d'arrossegar i soltar, còpia el text font de TextField en el Dragboard i consumeix l'esdeveniment. El gest d'arrossegar i soltar s'inicia només quan TextField conté text.

~~~
sourceFld.setOnDragDetected(new EventHandler <MouseEvent>() 
{
    public void handle(MouseEvent event) 
    {
        System.out.prinln("Event on Source: drag detected");
        dragDetected(event);
    }
});
 
private void dragDetected(MouseEvent event) 
{
    // User can drag only when there is text in the source field
    String sourceText = sourceFld.getText();
 
    if (sourceText == null || sourceText.trim().equals("")) 
    {
        event.consume();
        return;
    }
 
    // Initiate a drag-and-drop gesture
    Dragboard dragboard = sourceFld.startDragAndDrop(TransferMode.COPY_OR_MOVE);
 
    // Add the source text to the Dragboard
    ClipboardContent content = new ClipboardContent();
    content.putString(sourceText);
    dragboard.setContent(content);
    event.consume();
}
~~~

### Detectar un gest d'arrossegament

Una vegada que s'ha iniciat el gest d'arrossegar i soltar, pot arrossegar la font del gest a qualsevol altre node. La font de gestos ja ha posat les dades en el Dragboard declarant les maneres de transferència que admet. Ha arribat el moment que els possibles objectius de gestos declaren si accepten la transferència de dades oferida per la font de gestos. Tin en compte que podria haver-hi diversos possibles objectius de gestos. Un d'ells es convertirà en l'objectiu del gest real quan la font del gest es deixe caure sobre ell. L'objectiu del gest potencial rep diversos tipus d'esdeveniments d'arrossegament:

- Rep un esdeveniment drag-entered quan la font del gest entra en els seus límits.
- Rep un esdeveniment drag-over quan la font de gestos s'arrossega dins dels seus límits.
- Rep un esdeveniment drag-exited quan la font de gestos ix dels seus límits.
- Rep un esdeveniment drag-dropped quan la font de gestos es col·loca sobre ell soltant el botó del mouse.

En un controlador d'esdeveniments d'arrossegament, l'objectiu del gest potencial ha de declarar que té la intenció de participar en el gest d'arrossegar i soltar cridant al mètode acceptTransferModes(TransferMode ... modes) del DragEvent. Normalment, l'objectiu potencial comprova el contingut del Dragboard abans de declarar si accepta les maneres de transferència. El següent fragment de codi aconsegueix això. El camp de text de destí comprova si hi ha text sense format en el tauler. Conté text sense format, per la qual cosa el destí declara que accepta les maneres de transferència COPY i MOVE.

~~~
targetFld.setOnDragOver(new EventHandler <DragEvent>() 
{
    public void handle(DragEvent event) 
    {
        writelog("Event on Target: drag over");
        dragOver(event);
    }
});
 
private void dragOver(DragEvent event) 
{
    // If drag board has a string, let the event know that
    // the target accepts copy and move transfer modes
    Dragboard dragboard = event.getDragboard();
 
    if (dragboard.hasString()) 
    {
        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
    }
 
    event.consume();
}
~~~

### Deixar caure la font sobre l'objectiu

Si l'objectiu de gestos potencial accepta la manera de transferència admés per la font de gestos, la font de gestos es pot soltar sobre l'objectiu. La caiguda s'aconsegueix soltant el botó del mouse mentre la font del gest encara està sobre l'objectiu. Quan la font del gest es deixa caure sobre un objectiu, l'objectiu es converteix en l'objectiu del gest real. L'objectiu del gest real rep l'esdeveniment d'arrossegar i soltar. Ha d'agregar un controlador d'esdeveniments d'arrossegar i soltar per al destí del gest en el qual realitza dues tasques:

- Accedeix a les dades en el dragboard.
- Crida al mètode setDropCompleted(boolean isTransferDone) de l'objecte DragEvent.

Passar true al mètode indica que la transferència de dades es va realitzar correctament. Si passa false, indica que la transferència de dades no es va realitzar correctament. No es pot accedir al Dragboard després de cridar a aquest mètode. El següent fragment de codi realitza la transferència de dades i estableix la marca de finalització adequada:

~~~
targetFld.setOnDragDropped(new EventHandler <DragEvent>() 
{
    public void handle(DragEvent event) 
    {
        writelog("Event on Target: drag dropped");
        dragDropped(event);
    }
});
 
private void dragDropped(DragEvent event) 
{
    // Transfer the data to the target
    Dragboard dragboard = event.getDragboard();
 
    if (dragboard.hasString()) 
    {
        targetFld.setText(dragboard.getString());
 
        // Data transfer is successful
        event.setDropCompleted(true);
    } 
    else
    {
        // Data transfer is not successful
        event.setDropCompleted(false);
    }
 
    event.consume();
}
~~~

### Completar el gest d'arrossegar i soltar

Una vegada que s'ha soltat la font de gestos, rep un esdeveniment d'arrossegament **drag-done**. L'objecte DragEvent conté un mètode getTransferMode(). Quan es diu des del controlador d'esdeveniments **drag-done**, retorna la manera de transferència utilitzat per a la transferència de dades. Depenent de la manera de transferència, pot esborrar o mantindre el contingut de la font de gestos. Per exemple, si la manera de transferència és MOVE, és millor esborrar el contingut d'origen perquè l'usuari tinga una idea real del moviment de dades.

Si el mètode getTransferMode() retorna null o TransferMode.ONE, indica que no s'ha realitzat cap transferència de dades. El següent fragment de codi maneja l'esdeveniment drag-done per al TextField d'origen. El text d'origen s'esborra si la manera de transferència de dades era MOVE.

~~~
sourceFld.setOnDragDone(new EventHandler <DragEvent>() 
{
    public void handle(DragEvent event) 
    {
        writelog("Event on Source: drag done");
        dragDone(event);
    }
});
 
private void dragDone(DragEvent event) 
{
    // Check how data was transfered to the target. If it was moved, clear the text in the source.
    TransferMode modeUsed = event.getTransferMode();
 
    if (modeUsed == TransferMode.MOVE) 
    {
        sourceFld.setText("");
    }
 
    event.consume();
}
~~~

Examples:

- [Exemple de transferencia d'un text](./dNdExempleText.html)
- [Exemple de transferencia d'una image](./dNdExempleImage.html)



[back](../../javafx.html)