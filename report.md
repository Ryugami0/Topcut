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


CAPITOLO 2
    DESIGN

        2.1 ARCHITETTURA

        L'architettura del software segue il pattern MVC.
        La parte della "view" è affidata all'interfaccia Panel, responsabile di mostrare a schermo tutti gli avvenimenti, e di catturare gli input dell'utente.
        Il model invece è affidato al'interfaccia GameLogic, la quale si occupa di gestire la logica di base del programma e di gestire le varie entità.
        Il gameloop è la sezione di programma che si occupa di aggiornare ciclicamente il programma ed è la principale connessione tra view e model.






        
        



