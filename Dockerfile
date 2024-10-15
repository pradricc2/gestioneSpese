# Step 1: Usa un'immagine base con WildFly 23
FROM jboss/wildfly:23.0.0.Final

# Set working directory
WORKDIR /opt/jboss/wildfly

# Copia il file .war della tua applicazione
COPY target/gestioneSpese.war /opt/jboss/wildfly/standalone/deployments/

# Crea la directory per il modulo PostgreSQL
RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main

# Copia il driver PostgreSQL e il file module.xml nella directory dei moduli
COPY lib/postgresql-42.7.4.jar /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/
COPY lib/org/postgresql/main/module.xml /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/

# Copia lo script CLI per configurare il datasource
COPY configure-datasource.cli /opt/jboss/wildfly/bin/

# Configura il datasource quando WildFly si avvia
RUN /opt/jboss/wildfly/bin/jboss-cli.sh --file=/opt/jboss/wildfly/bin/configure-datasource.cli

# Espone la porta 8080
EXPOSE 8080

# Avvia WildFly nel profilo standalone
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
