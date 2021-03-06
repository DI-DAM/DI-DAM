---
layout: default
---

# Disseny Centrat en l'usuari - Disseny d'interfície d'usuari.

# MockUp

Alguns dissenyadors sostenen l'opinió que els MockUp no són necessaris, però són extremadament útils a l'hora d'explorar les decisions de disseny visual abans de començar amb l'etapa de desenvolupament del codi.

## Què és un MockUp?

El Mockup o maqueta en Valencià és una representació més avançada del disseny gràfic i comunicatiu (des d'una visió de navegació) d'un projecte. Hi ha dues escoles de pensament que es diferencien en com conceben la manera de crear un MockUp, aquells que creuen que la maqueta ha de representar el producte final exactament (alta fidelitat), i aquells que veuen la fase de maqueta com més transitori i no ha de prendre massa temps (mitja fidelitat).

Podríem dir que generalment és, una composició gràfica completa que ha utilitzat el wireframe com a plantilla introduint tots els elements gràfics i visuals, convertint-se així en un model a escala d'un producte que s'utilitza per a demostrar i provar un disseny. El mockup és un mitjà de representació de l'aparença del producte, i mostra els fonaments de la seua funcionalitat. Els MockUp inclouen els detalls visuals, com ara colors, tipografia, etc., i són generalment estàtiques. En observar un mockup, s'ha de tindre una bona idea de com es veurà el producte final i una idea aproximada de com podria funcionar (fins i tot si les funcions encara no s'han desenvolupat).

És important distingir un Mockup d'un prototip. Un prototip està destinat a funcionar, encara que siga parcialment, mentre que els Mockup no funcionen. Es componen de les imatges en pantalles estàtiques, només «semblen» la interfície d'usuari real.

S'integren elements amb major detall, visualitzem una aproximació de:

- Continguts (poden ser imatges i textos genèrics que no seran finalment usats en el desenvolupament)
- Paleta de colors, prenent com a referent l'institucional, misional i el públic objectiu del projecte
- Declaracions CSS
- Dimensions d'àrees de contingut i serveis
- Iconografia

------
![Exemple de MocKup](./images/mockup1.png) 

El mockup inclou els elements del sketch i el wireframe, cadascun és una evolució de l'anterior.

-----

Quan presentem un disseny per al client, és necessari tindre un Mockup el més semblant possible al producte final. Els MockUps també es creen per a mostrar al nostre client l'aspecte general de la seua nova pàgina web o programa i és una gran manera de presentar el nostre disseny perquè l'aprove el nostre client. Podríem resumir-ho en; «Els MockUp impressionen, donen un aspecte més professional i venen».

D'altra banda, pensem a més, que quan més clar ho veja el client, menys maldecaps tindrem posteriorment amb canvis en la fase de producció amb possibles modificacions. En aquest moment fins i tot podem realitzar ajustos i millores amb relatiu poc esforç, per tot això és important dedicar-li el temps i l'energia necessària per a la seua creació.

Un MockUp;

- **Permet saber quina informació existeix i on va**: Sabrem on va la informació abans de començar a escriure l'anàlisi funcional.
- **Pot ser utilitzat per a la implementació del disseny**: El que significa que és possible provar el seu concepte de disseny i tendència abans que escriguem una sola línia de codi. Els canvis en el concepte de disseny són fàcils i econòmicament més baixos en aquest pas que si ho fem posteriorment.
- **És més precís per als desenvolupadors**. El desenvolupador pot veure com ha de ser el producte final, la qual cosa significa que el MockUp d'alta fidelitat pot servir com una fulla d'especificacions visual.
- **És una eina flexible**: Fer canvis, eliminar o fins i tot afegir més espais amb les nostres idees i conceptes és possible més fàcilment
- **És més fàcil de presentar als no dissenyadors**. Els clients i parts interessades prefereixen un MockUp d'alta fidelitat perquè el que veuen és el que obtindrà.
- **Pot servir com a part de la nostra proposta de presupost**.si es tracta d'un gran client, i el treball pot resultar lucratiu, de prestigi, o interessant per altres raons, llavors potser ens pot compensar invertir un temps extra i realitzar un mockup per a presentar juntament amb el pressupost com a valor afegit per a aconseguir el projecte. És important en aquest cas que el client ferm un acord pel qual es compromet a no usar tot o en part el nostre concepte o disseny sense pagar per això. No anem a pecar d'ingenus i després portar-nos una sorpresa.

Hem dedicat bastant temps per a parlar de beneficis dels mockup per a presentar el disseny al client i a la importància que té per a les veure les relacions visuals.

Però hi ha una tercera qüestió, no menys significativa, per la qual cosa l'ús dels mockups és important, i és que ens ajuda a elaborar el llibre d'estil. Té el seu sentit si es pensa en això, el MockUp és el document visual de l'estil del producte, per això podem usar molts elements i crear una guia d'estil ràpid.

Una guia d'estil és simplement una recopilació formal de l'aparença del seu lloc perquè els dissenyadors i desenvolupadors tinguen una guia de referència ràpida i que ressalta els punts més rellevants del nostre disseny.

Les guies d'estil contenen informació de quin és la norma del disseny, grandàries de marges, les fonts que usem, les seues grandàries depenent de la seua posició, fons. Pel fet que aquestes són opcions que generalment incloem mentre creguem el mockup, la relació entre tots dos és fàcil de contrastar.

## Algunes coses que hem de tindre en compte.

Hi ha alguns errors que es poden cometre quan realitzem un disseny i que en crear el nostre mockup hem de tindre en compte;

- **Massa efectes i detalls**: Potser l'error més comú, cal tindre en compte els detalls que no agreguen valor al disseny i evitar-los, o els detalls que poden fer que el codi siga després realment difícil de crear. Una vora arredonida pot tindre una certa dificultat per a crear-lo mitjançant CSS en una web, però si a més hi ha un gradient de color, o una transparència mesclada amb altres elements poden fer que la fase de desenvolupament es complique innecessàriament i augmentar els costos .
- **No usar reixetes i no alinear correctament els elements**: Com comentàvem en l'apartat de wireframes, l'ús de les reixetes és una de les millors pràctiques que devem La nostra aplicació es veurà equilibrada i l'usuari no es perdrà amb la vista amb un munt d'elements «flotant» en la pantalla. Si hem creat el nostre wireframe i donem suport als nostres MockUp en ell, no hauríem de tindre problemes.
- **Si estàs realitzant una web, no realitzar una maqueta per a web responsive**. Hem de tindre en compte, com vam veure en la creació de wireframes responsive, que el nostre disseny ha d'ajustar-se a les diferents grandàries de pantalla, per tant
- **No usar un esquema de color**: Un dels aspectes més difícils del disseny per a molts dissenyadors, és la selecció del color. L'esquema de colors d'un lloc web o aplicació té un gran impacte en l'aspecte general de l'aplicació i per tant tindrà també un gran impacte en l'usuari. Hi ha una sèrie d'eines que ens poden ajudar a trobar la combinació de colors adequada per a un determinat projecte, molts d'aquests recursos els podem trobar de manera gratuïta en internet.

    Enumerarem algunes d'elles:

    - [Kuler](http://kuler.adobe.com/)
    - [Color Scheme Designer](http://colorschemedesigner.com/)
    - [Colour Lovers](http://www.colourlovers.com/)
    - [Pictaculous](http://www.pictaculous.com/)
    - [Color Spire](http://www.colorspire.com/)
    - [Daily Color Scheme](http://beta.dailycolorscheme.com/)
    - [Instant Color Schemes](http://www.gpeters.com/color/color-schemes.php)
    - [Color Explorer](http://www.colorexplorer.com/default.aspx)
    - [Color Rotat](http://www.colorotate.org/)
    - [Toucan](http://aviary.com/tools/toucan)
    - [Colour Grab](http://colourgrab.com/)
    - [Color Jack](http://www.colorjack.com/sphere/)

- **El client no entén el concepte de disseny en els primers moments**: Si el client no pot entendre el concepte de disseny en un parell de segons, és probable que tinguem un problema. Un disseny massa innovador o que trenca amb molts de «cànons» habituals en els costums dels usuaris a l'hora d'usar el tipus d'aplicació que estiguem desenvolupant, pot resultar molt creatiu, però potser poc funcional
- **Resulta difícil de llegir**: Hem d'assegurar-nos d'utilitzar un contrast alt entre els fons i les tipografies per a facilitar la lectura dels textos. En general, això significa un color fosc per a la tipografia sobre un fons molt clar. També, hem d'assegurar-nos que la grandària de la lletra és adequat.

## Eines per a realitzar MockUps

Existeixen moltes eines que ens ajuden a crear els nostres MockUps, podem usar qualsevol programa de dibuix, ja siga vectorial com a Il·lustrador o Inkscape, o programes més orientats al retoc d'imatges com photoshop o fireworks. Un dels més estesos és Photoshop, per al qual existeixen gran quantitat de recursos i tutorials. A més, existeixen altres eines específicament desenvolupades per al disseny d'aplicacions informàtiques o web, que permeten realitzar usant una sola aplicació, tot el procés, creació de wireframes, MockUps, i prototips que ampliarem en la secció d'eines per al prototípico.

Si volem desenvolupar el nostre MockUp mitjançant programes de dibuix vectorial o de retoc d'imatges podem trobar múltiples plantilles o «Toolkits» (caixes d'eines) plens d'elements per al disseny de la interfície d'usuari que poden estalviar molt de temps de creació de nous gràfics i que podrem importar en aquests programes. Aquests kits vénen amb botons prefabricats, controls de navegació, patrons de disseny d'interfície d'usuari, i altres elements d'interfície d'usuari que ens simplificaren el procés. La combinació adequada dels kits d'IU, plantilles, fonts i d'altres elements ens proporcionaren els materials adequats que modificarem segons resulte necessari.

![Exemple de MocKup](./images/mockups2.jpg)
 
Algunes webs on podem trobar aquest tipus de recursos són:

- [Freebiesbug](http://freebiesbug.com/)– excel·lent recurs d'elements d'interfície d'usuari i kits gratuïts per a Photoshop i Il·lustrador
- [com](http://designrfix.com/freebies/psd-mockup-templates) +de 60 MockUps gratuïts
- La web [com](http://www.smashingmagazine.com/professional-photoshop-techniques-tutorials/) té una sèrie d'interessants recursos i consells per a aquesta eina.
- En Uxpin.com podem trobar Kit [d'interfície de usuari](http://www.uxpin.com/ui-kit.html) i [iOS 8 Kit d'interfície d'usuari](http://www.uxpin.com/ios8-ui-kit.html) (funciona per a Photoshop i Sketch).
- [Línia 25](http://line25.com/articles/top-places-to-find-free-photoshop-ui-kits-online)– podem trobar una llista dels 35 llocs que ofereixen plantilles, patrons i kits d'interfície d'usuari per a Photoshop
- [com](http://speckyboy.com/2014/03/31/20-free-web-mobile-wireframe-templates/) Encara que és un recurs per a la creació de wireframes, val la pena tindre'l en compte si usarem una eina d'aquest tipus
- [com](http://robbiemanson.com/resources/960px-grid-templates/) de la mateixa forma que el recurs anterior, en aquest cas ens proporcionen plantilles per a descarregar que ens permeten crear reixetes per a dissenys 960×12 en Photoshop, il·lustrador, etc.
- [I ♥ wireframes](http://wireframes.tumblr.com/) Pàgina amb multitud de recursos per a wireframe i MockUps

Altres eines
- [placeit](https://placeit.net/) Web que et permet incloure la imatge de la teua mockup en diferents pantalles, mòbils, tauletes, etc., interessant per a presentacions

Anar a [Prototip](./prototipat.html)

[back](../../metiprot.html)

--------
> *Informació extreta de la web: https://mosaic.uoc.edu*
