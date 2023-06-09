CAPITOLO 1
    ANALISI

        1.1 REQUISITI

        Il software "TowerDefenseGame" è un gioco 2D del genere tower defense, sulla falsa riga di "Age Of War 2".
        Lo scopo principale del gioco è quello di bloccare l'avanzata di una schiera di nemici, i quali non devono arrivare fino alla propria base, tramite lo schieramento di personaggi alleati.

        Requisiti funzionali:
        -Il giocatore dovrà essere in grado di generare degli alleati di diverse categorie che difenderanno la propria base dagli aggressori
        -I nemici avanzeranno fino a che non incontreranno un alleato, a quel punto quello dei due che perde despawnerà, mentre l'altro perderà dei punti salute
        -Il gioco progredisce ad ondate sempre più numerose e potenti
        -Si guadagnano monete necessarie allo spawn degli alleati sia con il passare del tempo sia con l'uccisione dei nemici
        -Se un nemico riesce ad arrivare fino alla base essa inizierà a perdere vita finchè un alleato non sconfiggerà il nemico in questione
        -Se i punti salute della base scendono a zero la partita finisce
        -Sarà possibile attivare una funzionalità speciale molto potente ma con un alto tempo di ricarica
        -Una volta finita la partita all'utente sarà possibile effettuare un salvataggio del proprio punteggio
        -Una classifica dei punteggi migliori può essere consultata dal menù iniziale

        1.2 ANALISI E MODELLO DEL DOMINIO

        L'entità TowerSingleton ricoprirà il ruolo principale rappresentando il giocatore e gestendo lo spawn delle MovingEntity. Esse saranno, come deducibile dal nome, delle entità mobili con statistiche predeterminate(attacco, velocità, vita e costo) e si divideranno in due tipi, amiche e nemiche, diverse tra loro. Ognuna delle "MovingEntity" avrà determinate differenze volte a caratterizzarle, come ad esempio, una maggiore vita per il Barbarian ma una velocità bassa.
        Ci sarà infine un'ultima entità amica, ovvero la Turret, che sarà fissa sopra la TowerSingleton e, al pari delle MovingEntity, presenterà un attacco, una vita, un costo e una velocità pari a zero.
        Le entità amiche e nemiche spawneranno ai lati opposti dello schermo e una volta entrate nel range di attacco, si scontreranno vicendevolmente, provocando danni fino alla morte di una delle due.
        AGGIUNGERE UML DISEGNATO SU CARTA (Francesco)

CAPITOLO 2
    DESIGN

        2.1 ARCHITETTURA

        Come architettura per il software è stato scelto l'MVC.
        La parte della "view" è affidata all'interfaccia Panel, responsabile di mostrare a schermo tutti gli avvenimenti e di catturare gli input dell'utente.
        Il model invece è affidato al'interfaccia GameLogic, la quale si occupa di gestire la logica di base del programma e le varie entità.
        Il gameloop invece è la sezione di programma che si occupa di aggiornare ciclicamente tutte le altre parti ed è la principale connessione tra view e model.
        Se si dovesse cambiare in blocco la libreria grafica non ci sarebbero grosse ripercussioni sul programma, idem per inserire nuovi "potenziamenti".
        Per aggiungere delle entità (in particolare per i nemici) invece andrebbe modificato l'algoritmo dello spawnmanager
        Di seguito è riportato uno schema UML del progetto:

        2.2 Petrassi-Design dettagliato

        Da suddivisione del progetto, stabilito dopo una discussione iniziale approfondita con i miei colleghi su come dividerci in maniera quanto più equidistribuita il progetto in questione, riporto quanto emerso in termini di risultati da me ottenuti e di problematicità riscontrate.

        Problema: Come gestire la musica nei vari pannelli? E gli effetti sonori?
        Questi problemi nascono dal fatto che ogni pannello presente deve avere una propria musica di accompagnamento che deve accompagnare il giocatore nelle varie fasi del gioco, oltre che per marcare la differenza tra le varie fasi di gioco. Troviamo, inoltre, anche gli effetti sonori che devono essere riprodotti in contemporanea alla musica senza interromperla o sovrastarla.

        INSERIRE SCHEMA UML

        Soluzione proposta: Inseriamo una classe Music che gestisce la musica in modo tale che ogni pannello quando viene creato, inserendo la stringa che fa riferimento al pannello nel metodo startMusic, può far partire la canzone corrispondente. E nel momento in cui viene generato un altro panello, dello stesso tipo o diverso, è possibile interrompere la musica, affinché il pannello successivo possa riprodurre la propria senza sovrapposizioni.
        Per quanto riguarda invece gli effetti sonori, per evitare problemi con la musica e per il funzionamento lievemente diverso che presentano, inseriamo una classe Sfx che genera quindi un suono che si sovrappone alla musica ma che può essere gestito indipendentemente.

CAPITOLO 3
    SVILUPPO

        3.1 testing automatizzato
        
        Nel contesto del progetto towerdefense abbiamo scelto di sottoporre a test automatizzato tutte le entità appartenti alle classi MovingEntity, RangedEntity e Projectile attraverso la suite di test specifica JUnit 5.
        Abbiamo testato ogni metodo di ognuna delle superclassi elecante sopra per ogni caso specifico di implementazione ( MovingEntity: Barbarian, Knight, Goblin... ; RangedEntity: Archer, Turret ecc) attraverso l'utilizzo del metodo assertEquals() per confrontare il risultato dei test specifici con i valori attesi.


        3.3 Petrassi-Note di sviluppo

        Utilizzo della livreria ImageIO
        Attraverso l’implementazione della seguente funzione “ void updateSprite(String activity)”, collocata nella classe “movingentity” mi è stato possibile restituire il giusto percorso dove reperire lo sprite da riutilizzare in quel momento sulla data entità.
        https://github.com/FilippoBadioli/OOP22-towerdefense/blob/4a967e1b4d0411394034a6abb119a4d6deef0e38/app/src/main/java/towerDefense/entities/api/MovingEntity.java#LL73C5-L108C6

CAPITOLO 4
    COMMENTI FINALI

        4.1 Petrassi-Autovalutazione


        Nel fornire un’autovalutazione quanto più oggettiva possibile, ciò che ritengo necessario far emergere in primis, è l’insegnamento acquisito mediante lo svolgimento del lavoro in gruppo. 

        Da questo lavoro di gruppo traggo come risultato fondamentale l’aver compreso le difficoltà che sorgono nell’ambito della collaborazione, per quanto riguarda il riuscire a mettere insieme esigenze e modus operandi completamente distinti. Come in un puzzle, è stato necessario trovare ogni singolo pezzo che riuscisse a incastrarsi in una cornice coerente e continua, con l’eccezione che a mettere mano su ogni pezzo non vi sia stata un’unica persona. La costanza, il dialogo e l’ascolto hanno fatto in modo che seppur ogni singolo componente del gruppo abbia avuto un proprio principale compito nella progettazione, tutti gli altri vi abbiano in qualche modo messo mano e dunque preso parte, facendo si che il risultato fosse il più omogeneo auspicabile.
        Nonostante sia stata per me una delle primissime esperienze in un progetto di tale portata e complessità, ritengo di essermi impegnato nel mettere insieme le conoscenze acquisite lungo la durata dell’intero corso, ed insieme al background fornito dalle altre materie e alla mia curiosità di andare oltre l’insegnamento frontale, complessivamente mi ritengo soddisfatto del lavoro. 

        Essendo però questa una valutazione oggettiva, è necessario che faccia luce anche sui punti oscuri. Non posso ritenere che si tratti di una vera e propria dimostrazione di esser un capace progettista, ma è sicuramente un punto di partenza, dal quale solo l’esperienza e la continua dedizione riusciranno a mettere insieme quello che ho scoperto essere un mio forte interesse: la progettazione di videogiochi. 


GUIDA UTENTE

        All'avvio del gioco sarà possibile scegliere tra 3 menù: "Start Game", "Best Scores" e "Rules"
        Cliccando su "Start Same" il gioco comincerà, cliccando su "Best Scores" si aprirà un file contenente i punteggi migliori salvati mentre cliccando su "Rules" si aprirà una finestra con il regolamento del gioco (da cui è possibile tornare indietro con il pulsante "Back").
        Una volta cominciato il gioco inizieranno ad arrivare ondate di nemici, per poterli sconfiggere bisognerà evocare alleati e/o potenziamenti tramite i pulsanti trovati in cima alla finestra di gioco, al costo di monete di gioco.
        Attualmente le unità/potenziamenti presenti sono:
            -Barbaro: unità lenta, con molti punti salute e un discreto attacco
            -Cavaliere: unità veloce, con pochi punti salute ma molti danni
            -Arcere: unità veloce, con pochissimi punti salute ma molti danni e una gittata media
            -Torretta: cannone posto sulla cima della torre, è un'unità monouso con gittata molto ampia (se dei nemici arrivano alla torre colpiranno prima la torretta fino a distruggerla, poi la torre)
            -Potenziamento: chiamato "Double Allies" permetterà di evocare il doppio degli alleati al costo di uno solo per un certo lasso di tempo
        Una volta evocata un'unità bisognerà aspettare qualche secondo prima di poterne evocare un'altra
        Il potenziamento ha invece un tempo di ricarica molto più lungo
        La partita finirà quando i punti salute della torre scendono a zero oppure cliccando il pulsante "Surrender", a quel punto si verrà reindirizzati al menù di fine partita.
        Da qui si potrà salvare il proprio punteggio inserendo il proprio nome e poi cliccando "Save Score" e/o si potrà chiudere il gioco 







        
        



