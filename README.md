# Motivation
Dieses Projekt ist da um das Erstellen eines Maven Projekts für das Abschlussprojekt zu üben.
Hier werden die Fahrräder von Kunden verwaltet.
Dieses Projekt soll folgende Funktionalität anbieten:
- Hinzufügen eines Fahrrads in die FahrradVerwaltung
- Löschen eines Fahrrads aus der FahrradVerwaltung
- Abfragen aller Fahrräder aus der FahrradVerwaltung

[User-Story Kunden Registrieren]Als Fahrradmanager möchte ich, dass ein Kunde sich Registrieren muss, damit ich die möglichkeit habe die Registrierungsdaten automatisch zu verifizieren.
- Bei der Registrierung muss eine gültige E-Mail-Adresse und FahrradDaten angegeben werden.
- Es wird ein 6-stelliger Zahlencode an die angegebene E-Mail-Adresse verschickt
- Zahlencode muss zusammen mit der E-Mail-Adresse übergeben werden, damit das Fahrrad in die FahrradVerwaltung hinzugefügt wird
- Der Zahlencode verliert nach 24 Stunden seine Gültigkeit

Abbildung auf DDD Mustersprache und Klassen:
ApplicationService: FahrradVerwaltung
 Neue Methoden: registriere und verifiziere
ValueObjects: E-Mail-Adresse, KontaktDaten, VerifizierungsCode
Aggregate: RegistrierungsDaten, Fahrrad
Repository: RegistrierungsDatenRepository
DomaintEvent: VerifizierungsCodeVerschickt