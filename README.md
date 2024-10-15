# Descrizione
Il progetto è un'applicazione Java basata su Maven che gestisce operazioni CRUD (Create, Read, Update, Delete) per redditi e spese. 
Utilizza JAX-RS per creare servizi RESTful e EJB per la logica di business.
L'applicazione implementa il backend, molto basico, di un POC il cui scopo è utilizzare dei container per far comunicare un front end in Angular con un back end in JakartaEE ed un db postgres
# Struttura del Progetto
- src/main/java: Contiene il codice sorgente dell'applicazione.
  - controller: Contiene i controller JAX-RS.
  - service: Contiene i servizi EJB.
  - dao: Contiene gli oggetti di accesso ai dati (DAO).
  - model: Contiene le entità JPA.
  - config: Contiene le configurazioni JAX-RS e CORS.
- src/main/resources: Contiene i file di configurazione.
- src/test/java: Contiene i test unitari.
- pom.xml: File di configurazione di Maven
- Dockerfile: File per la creazione dell'immagine Docker.
- configure-datasource.cli: File a supporto Dockerfile per la gestione del data source postgres
